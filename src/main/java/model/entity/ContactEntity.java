package model.entity;

import view.dto.NumberDto;

import java.util.List;

public class ContactEntity {

    private String firstname;
    private String lastname;
    private List<NumberDto> numberList;

    public ContactEntity(String firstname, String lastname, List<NumberDto> numberList) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberList = numberList;
    }

    public ContactEntity() {}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public List<NumberDto> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<NumberDto> numberList) {
        this.numberList = numberList;
    }



}
