package view.ui;

import model.service.ContactService;
import view.dto.ContactDto;
import view.dto.NumberDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactUI {

    Scanner input= new Scanner(System.in);
    ContactDto contactDto=new ContactDto();
    ContactService contactService=new ContactService();
    NumberUI numberUI=new NumberUI();

    public List<ContactDto> insertContact(){

        List<ContactDto> contactList = new ArrayList<ContactDto>();

        System.out.print("How many contact do you want add to list?");
        int count= input.nextInt();

        for (int i=1; i<=count ; i++){
            System.out.println("cotact" +i+ ":");
            System.out.print("Enter FirstName please:");
            String firstname=input.next();
            System.out.print("Enter LastName please:");
            String lastname= input.next();

            contactDto.setFirstname(firstname);
            contactDto.setLastname(lastname);
            List<NumberDto> numberDtoList = numberUI.insertNumber();
            contactDto.setNumberList(numberDtoList);
            contactList.add(contactDto);

        }
        contactService.insertContact(contactDto);
         return contactList;
    }
}
