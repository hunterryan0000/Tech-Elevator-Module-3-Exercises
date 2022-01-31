package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class DebuggerPractice {
    public static void main(String[] args) {

        //Sum only the even numbers
        int [] number = {3, 5 ,8, 32, 95};
        int total = 0;
        for (int current: number) {
           if (current % 2 == 0) {
               total = total + current;
           }
    }
        System.out.printf("Total is %s. \n", total);


        List<Integer> numberList = new ArrayList<>();
        numberList.add(98);
        numberList.add(43);
        numberList.add(21);

        if (numberList.contains(42)){
            System.out.println("Woot! we found 42 cheaaaaaaaaaaaa!");
        }
    }
}
