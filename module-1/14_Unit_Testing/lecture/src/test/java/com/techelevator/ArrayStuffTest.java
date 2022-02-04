package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;

public class ArrayStuffTest {
    private ArrayStuff  arrayStuff;


    // Given an array of strings and a string value, return true if the
    // string value is found in the array, false otherwise.
    @Test
    public void findString_emptyArray_notFound() {
        ArrayStuff arrayStuff = new ArrayStuff();
        Assert.assertFalse("Testing with empty array expected failure (not found)",
                arrayStuff.findString(new String[0], "test"));
    }

    @Test
    public void findString_oneItemInArray_notFound() {
        ArrayStuff arrayStuff = new ArrayStuff();
        Assert.assertFalse("Testing with array of 1 item, but not the correct one",
                arrayStuff.findString(new String[]{"cat"}, "test"));
    }

    @Test
    public void findString_oneItemInArray_Found() {
        ArrayStuff arrayStuff = new ArrayStuff();
        Assert.assertFalse("Testing with array of 1 item, but the correct one",
                arrayStuff.findString(new String[]{"test"}, "test"));
    }
}
