package model.service;

import dao.PhoneBookDao;
import model.entity.PhoneBookEntity;
import view.dto.PhoneBookDto;

public class PhoneBookService{
    PhoneBookDao pbDao=new PhoneBookDao();

    public void insertPhoneBook(PhoneBookDto phoneBookDto){

        PhoneBookEntity pbEntity=new PhoneBookEntity();
        pbEntity.setPhonebookName(phoneBookDto.getPhonebookName());
        pbEntity.setContactList(phoneBookDto.getcontactList());


        pbDao.insertPhoneBook(pbEntity);
    }



}
