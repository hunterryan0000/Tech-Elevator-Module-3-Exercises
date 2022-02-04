package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {
    @Test

    public void test_if_string_returns_every_other_char(){
        StringBits stringBitsTest = new StringBits();

        Assert.assertEquals("mynameisryan", stringBitsTest.getBits("mmyynnaammeeiissrryyaann"));
        Assert.assertEquals("Hello", stringBitsTest.getBits("Heeololeo"));

        Assert.assertEquals("Error case sensitive", "hello", stringBitsTest.getBits("Heeololeo"));





    }
}
