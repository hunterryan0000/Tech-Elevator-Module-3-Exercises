package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {
    @Test

    public void test_whichever_is_largest_of_beg_and_end(){
        MaxEnd3 maxEnd3Test = new MaxEnd3();

        int[] nums1 = {1,2,3};
        int[] nums2 = {11,5,9};
        int[] nums3 = {1,20,2};

        Assert.assertArrayEquals(new int [] {3,3,3}, maxEnd3Test.makeArray(nums1));
        Assert.assertArrayEquals(new int [] {11,11,11}, maxEnd3Test.makeArray(nums2));
        Assert.assertArrayEquals(new int [] {2,2,2}, maxEnd3Test.makeArray(nums3));
        Assert.assertArrayEquals("Should return error {3,3,3} right answer", new int [] {2,2,2}, maxEnd3Test.makeArray(nums1));
    }
}
