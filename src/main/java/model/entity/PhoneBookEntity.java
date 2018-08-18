package model.entity;


import view.dto.ContactDto;
import java.util.List;

public class PhoneBookEntity {

    private String phonebookName;
    private List<ContactDto> contactList;

    public PhoneBookEntity() {}

    public List<ContactDto> getContactList() {
        return contactList;}

    public void setContactList(List<ContactDto> contactList) {
        this.contactList = contactList;
    }

    public String getPhonebookName() {
        return phonebookName;
    }

    public void setPhonebookName(String phonebookName) {
        this.phonebookName = phonebookName;
    }

}
