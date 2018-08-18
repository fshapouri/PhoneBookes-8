package model.service;

import dao.NumberDao;
import model.entity.NumberEntity;
import view.dto.NumberDto;

public class NumberService {

    NumberDao numberDao=new NumberDao();

    public void insertNumber(NumberDto numberDto){

        NumberEntity numberEntity=new NumberEntity();
        numberEntity.setNumber(numberDto.getNumber());
        numberEntity.setNumberType(numberDto.getNumberType());

        numberDao.insertNumber(numberEntity);


    }
}
