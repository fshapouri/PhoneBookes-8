package model.entity;
import view.dto.NumberType;
public class NumberEntity {

    private String number;
    private NumberType numberType;

    public NumberEntity(String number, NumberType numberType) {
        this.number = number;
        this.numberType = numberType;
    }

    public NumberEntity() {}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(NumberType numberType) {
        this.numberType = numberType;
    }


}
