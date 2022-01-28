package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class DebuggerPractice {
    public static void main(String[] args) {
        // sum only the even numbers
        int[] numbers = {3, 5, 8 , 32, 95};
        int total = 0;
        for (int current : numbers) {
            if (current % 2 == 0) {
                total = total + current;
            }
        }
        System.out.printf("Total is %d.\n", total);

        List<Integer> numberList = new ArrayList<>();
        numberList.add(98);
        numberList.add(43);
        numberList.add(21);

        if (numberList.contains(42)) {
            System.out.println("Woot! We found 42");
        }
    }
}
