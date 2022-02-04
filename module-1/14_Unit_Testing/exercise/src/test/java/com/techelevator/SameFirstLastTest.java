package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
    @Test

    public void test_if_first_and_last_char_are_equal(){
        SameFirstLast sameFirstLastTest = new SameFirstLast();

        int[] nums0 = {1,2,3,1};
        int[] nums1 = {1};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,1};
        int[] nums4 = {};

        Assert.assertTrue(sameFirstLastTest.isItTheSame(nums0));
        Assert.assertTrue("Returns true for nums1.length being 1 or more", sameFirstLastTest.isItTheSame(nums1));
        Assert.assertFalse(sameFirstLastTest.isItTheSame(nums2));
        Assert.assertTrue(sameFirstLastTest.isItTheSame(nums3));
        Assert.assertTrue("Should return error, answer is False", sameFirstLastTest.isItTheSame(nums4));
    }
}
