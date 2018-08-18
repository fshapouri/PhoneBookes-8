package dao;

import model.entity.NumberEntity;

import java.sql.*;


public class NumberDao {

    private String dbURL = "jdbc:derby://localhost:1527/c:/derbyDB;create=true";
    private Connection cn=null;
    private Statement st= null;

    public void open() throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        cn= DriverManager.getConnection(dbURL);
        st=cn.createStatement();
    }

    public void insertNumber(NumberEntity numberEntity){
         try {
             open();
             String sql="INSERT INTO PHONENUMBER (NUMBERS, TYPES) VALUES (? ,?)" ;
             PreparedStatement pStmt= cn.prepareStatement(sql);
             pStmt.setString(1, numberEntity.getNumber());
             pStmt.setString(2, String.valueOf((numberEntity.getNumberType())));
             pStmt.executeUpdate();
             pStmt.close();

         }catch (Exception sqlExcept){
             if(sqlExcept.getMessage().equals("Table/View 'PHONENUMBER' does not exist.")){
                 try {
                     st.execute("CREATE TABLE PHONENUMBER (NUMBER_ID INTEGER NOT NULL primary key GENERATED ALWAYS AS IDENTITY (START WITH 1 , INCREMENT BY 1) " +
                     " , NUMBERS VARCHAR(255), TYPES VARCHAR(255))");

                     insertNumber(numberEntity);

                 }catch (SQLException e){
                     e.printStackTrace();

                 }
             }else {
                 sqlExcept.printStackTrace();
             }

         }

    }

    public void close() throws Exception{
        st.close();
        cn.close();
    }
}
