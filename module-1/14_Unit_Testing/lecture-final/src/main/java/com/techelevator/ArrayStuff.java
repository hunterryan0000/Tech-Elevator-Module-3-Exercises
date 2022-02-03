package com.techelevator;

public class ArrayStuff {

    // Default constructor will be added by Java Magic

    /** Given an array of strings and a string value, return true if the
     * string value is found in the array, false otherwise.
     */
    public boolean findString(String[] array, String value){
        if (array == null || array.length == 0){
            return false;
        }
        for (String item : array) {
            if (item == null) {
                if (value == null) {
                    return true;
                }
            } else if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int findStringPosition(String[] array, String value){
        return 0;
    }
}
