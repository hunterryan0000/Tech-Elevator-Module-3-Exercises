package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {
    @Test

    public void test_the_first_three_char_repetition(){
        FrontTimes frontTimesTest = new FrontTimes();

        Assert.assertEquals("Chocolate, 2", "ChoCho", frontTimesTest.generateString("Chocolate", 2));
        Assert.assertEquals("Chocolate, 3", "ChoChoCho", frontTimesTest.generateString("Chocolate", 3));
        Assert.assertEquals("Eye, 3", "EyeEyeEye", frontTimesTest.generateString("Eye", 3));
        Assert.assertEquals("Eye, 2", "EyeEye", frontTimesTest.generateString("Eye", 3));



    }
}
