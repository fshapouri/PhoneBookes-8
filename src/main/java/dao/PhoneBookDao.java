package dao;

import model.entity.PhoneBookEntity;
import view.dto.ContactDto;

import java.sql.*;

public class PhoneBookDao {

    private String dbURL = "jdbc:derby://localhost:1527/c:/derbyDB;create=true";
    private Connection cn = null;
    private Statement st = null;

    private void open() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        cn = DriverManager.getConnection(dbURL);
        st = cn.createStatement();
    }

    public void insertPhoneBook(PhoneBookEntity phoneBookEntity) {

        try {
            open();
            String sql= "INSERT INTO PHONEBOOK (PHONEBOOKNAME ) VALUES (?,?)";
            PreparedStatement pStmt = cn.prepareStatement(sql);
            pStmt.setString(1, phoneBookEntity.getPhonebookName());
            pStmt.executeUpdate();
            for (ContactDto cantactDto:phoneBookEntity.getContactList()) {
                pStmt.setString(1,cantactDto.getFirstname());
                pStmt.setString(2,cantactDto.getLastname());
            }
            pStmt.executeUpdate();
            pStmt.close();

        }catch (Exception sqlExcept) {

            if (sqlExcept.getMessage().equals("Table/View 'PHONEBOOK' does not exist.")) {

                try {
                    st.execute("CREATE TABLE PHONEBOOK (PHONEBOOK_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)"+
                            ",PHONEBOOKNAME VARCHAR(255),CONSTRAINT PRIMARY KEY (PHONEBOOK_ID), FOREIGN KEY(CONTACT_ID) REFERENCES CONTACT ))");
                    insertPhoneBook(phoneBookEntity);
                } catch (SQLException e) {
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




