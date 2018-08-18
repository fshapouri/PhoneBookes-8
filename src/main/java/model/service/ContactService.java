package model.service;
import dao.ContactDao;
import model.entity.ContactEntity;
import view.dto.ContactDto;

public class ContactService {
    private ContactDao contactDao=new ContactDao();

    public void insertContact(ContactDto contactDto){

        ContactEntity contactEntity=new ContactEntity();
        contactEntity.setFirstname(contactDto.getFirstname());
        contactEntity.setLastname(contactDto.getLastname());
        contactEntity.setNumberList(contactDto.getNumberList());

        contactDao.insertContact(contactEntity);
    }

}
