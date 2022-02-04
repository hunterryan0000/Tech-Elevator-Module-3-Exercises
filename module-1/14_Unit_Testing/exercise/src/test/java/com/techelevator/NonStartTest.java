package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
    @Test

    public void test_remove_first_2char_concat_words(){

        NonStart nonStartTest = new NonStart();

        Assert.assertEquals("Hello, There", "ellohere", nonStartTest.getPartialString("Hello", "There"));
        Assert.assertEquals("RRight, AAnswer", "RightAnswer", nonStartTest.getPartialString("RRight", "AAnswer"));
        Assert.assertEquals("Should get an error for HHello, There", "Hellohere", nonStartTest.getPartialString("HHello", "There"));




    }





}
