package com.mbmosman.whiteboard;

import java.util.ArrayList;

public class Challenge1 {
    public static void main(String[] args) {
        System.out.println("Testing with 'ab', 3: " + print(stringRepeater("ab", 3)));
        System.out.println("Testing with 'ab', 0: " + print(stringRepeater("ab", 0)));
        System.out.println("Testing with 'ab', 1: " + print(stringRepeater("ab", 1)));
    }

    public static String[] stringRepeater(String input, int number) {
        String temp = "";
        String[] output = new String[number];

        for (int i=0; i<number; i++) {
            temp = temp + input;
            output[i] = temp;
        }
        return output;
    }

    public static String print(String[] array) {
        String temp = "[";
        for (int i=0; i<array.length; i++) {
            if (i>0){
                temp = temp + "," + array[i];
            } else {
                temp = temp + array[i];
            }
        }
        temp = temp + "]";
        return temp;
    }
}
