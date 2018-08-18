package dao;

import model.entity.ContactEntity;
import view.dto.NumberDto;

import java.sql.*;

public class ContactDao {
    private  String drURL= "jdbc:derby://localhost:1527/c:/derbyDB;create=true";
    private  Connection cn=null;
    private  Statement st=null;

    private void open() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        cn = DriverManager.getConnection(drURL);
        st = cn.createStatement();
    }

    public void insertContact(ContactEntity contactEntity) {

        try {
            open();
            String sql= "INSERT INTO CONTACT (FIRSTNAME,LASTNAME) VALUES (?,?)";
            PreparedStatement pStmt= cn.prepareStatement(sql);
            pStmt.setString(1, contactEntity.getFirstname());
            pStmt.setString(2, contactEntity.getLastname());
            for (NumberDto numberDto:contactEntity.getNumberList()){
             pStmt.setString(1,numberDto.getNumber());
             pStmt.setString(2, String.valueOf(numberDto.getNumberType()));
            }
            pStmt.executeUpdate();
            pStmt.close();
        }catch (Exception sqlExcept) {
            if(sqlExcept.getMessage().equals("Table/View 'CONTACT' does not exist.")){

                try {
                    st.execute("CREATE TABLE CONTACT(CONTACT_ID INTEGER primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 )"+
                            ",FIRSTNAME VARCHAR(255), LASTNAME VARCHAR (255), FOREIGN KEY(NUMBER_ID) REFERENCES PHONENUMBER )");
                    insertContact(contactEntity);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }else {
                sqlExcept.printStackTrace();
            }

        }


    }

    private void close() throws Exception{
        st.close();
        cn.close();
    }
}
