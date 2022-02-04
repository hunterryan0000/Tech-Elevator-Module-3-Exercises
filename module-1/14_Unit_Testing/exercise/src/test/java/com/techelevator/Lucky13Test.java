package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;

public class Lucky13Test {
    @Test

    public void test_has_no_1_or_3(){
       Lucky13 lucky13Test = new Lucky13();

       int[] nums1 = {2, 4, 6, 8};
       int[] nums2 = {1, 2, 4, 8};
       int[] nums3 = {2, 3, 5, 7};
       int[] nums4 = {0, 9, -6};


        Assert.assertTrue(lucky13Test.getLucky(nums1));
        Assert.assertFalse(lucky13Test.getLucky(nums2));
        Assert.assertTrue(lucky13Test.getLucky(nums4));
        Assert.assertTrue("Should return error, false is correct", lucky13Test.getLucky(nums3));

    }
}
