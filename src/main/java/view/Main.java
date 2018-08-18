package view;

import view.ui.ContactUI;
import view.ui.NumberUI;
import view.ui.PhoneBookUI;

public class Main {
    public static void main(String[] args) throws Exception {

        PhoneBookUI ui=new PhoneBookUI();
        ContactUI ui1= new ContactUI();
        NumberUI ui2=new NumberUI();

        ui.insertPhoneBook();
//        ui1.insertContact();
//        ui2.insertNumber();


    }
}
