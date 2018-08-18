package view.ui;

import model.service.PhoneBookService;
import view.dto.ContactDto;
import view.dto.PhoneBookDto;

import java.util.List;
import java.util.Scanner;

public class PhoneBookUI {
    Scanner input = new Scanner(System.in);
    PhoneBookDto pbDto = new PhoneBookDto();
    PhoneBookService pbService =new PhoneBookService();
    ContactUI contactUI=new ContactUI();

    public void insertPhoneBook(){

        System.out.print("please Enter name of your phonebook:");
        String phoneBookName=input.next();

        List<ContactDto> contactList = contactUI.insertContact();
        pbDto.setPhonebookName(phoneBookName);
        pbDto.setcontactList(contactList);
        pbService.insertPhoneBook(pbDto);

    }

}
