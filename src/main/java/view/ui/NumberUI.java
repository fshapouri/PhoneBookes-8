package view.ui;

import view.dto.NumberType;
import model.service.NumberService;
import view.dto.NumberDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberUI {
    Scanner input= new Scanner(System.in);
    NumberDto numberDto=new NumberDto();
    NumberService numberService=new NumberService();

    public List<NumberDto> insertNumber(){
        List<NumberDto> numberList=new ArrayList<NumberDto>();

        System.out.println("How many number do you want add to list?");
        int count= input.nextInt();
        for (int i=1; i<= count ; i++) {
            System.out.println("number" + i + ":");
            System.out.print("please enter your number:");
            String number = input.next();
            System.out.println("please Enter number type of your number: \n 1) HOME 2) MOBILE 3) WORK 4) FAX 5) OTHER");
            int type = input.nextInt();
            NumberType numberType = null;
            switch (type) {
                case 1:
                    numberType = NumberType.HOME;
                    break;
                case 2:
                    numberType = NumberType.MOBILE;
                    break;
                case 3:
                    numberType = NumberType.FAX;
                    break;
                case 4:
                    numberType = NumberType.WORK;
                    break;
                case 5:
                    numberType = NumberType.OTHER;
                    break;
                default:
                    System.out.println("please enter valid type!!");
            }
            numberDto.setNumber(number);
            numberDto.setNumberType(numberType);
            numberList.add(numberDto);
            numberService.insertNumber(numberDto);
        }
        return numberList;
    }





}
