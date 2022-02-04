package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    @Test

    public void test_1_or_2_less_than_multiple_of_20() {

        Less20 less20Test = new Less20();

        Assert.assertTrue("Testing if 18 is 1 or 2 less than multiple of 20", less20Test.isLessThanMultipleOf20(18));
        Assert.assertTrue("Testing if 19 is 1 or 2 less than multiple of 20", less20Test.isLessThanMultipleOf20(19));
        Assert.assertFalse("Testing if 20 is 1 or 2 less than multiple of 20", less20Test.isLessThanMultipleOf20(20));
        Assert.assertFalse("Testing if 21 is 1 or 2 less than multiple of 20", less20Test.isLessThanMultipleOf20(21));
        Assert.assertFalse("Testing if 0 is 1 or 2 less than multiple of 20", less20Test.isLessThanMultipleOf20(0));
        Assert.assertTrue("Should ge an error for Testing if 100 is 1 or 2 less than multiple of 20", less20Test.isLessThanMultipleOf20(100));




    }


}
