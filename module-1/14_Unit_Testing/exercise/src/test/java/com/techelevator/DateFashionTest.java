package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {
    @Test

    public void test_if_you_or_date_are_stylish_enough_for_table(){
        DateFashion dateFashionTest = new DateFashion();

        Assert.assertEquals(1, dateFashionTest.getATable(5,5));
        Assert.assertEquals(2, dateFashionTest.getATable(8,5));
        Assert.assertEquals(1, dateFashionTest.getATable(2, 8));

    }
}
