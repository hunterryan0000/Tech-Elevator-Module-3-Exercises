package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    AnimalGroupName animalGroupNameTest = new AnimalGroupName();

    @Test
    //JUnit testing
    public void test_ifThe_animal_group_name_is_correctly_returned() {
        //Test method name

        Assert.assertEquals("unknown", animalGroupNameTest.getHerd("null"));
        Assert.assertEquals("unknown", animalGroupNameTest.getHerd(""));
        Assert.assertEquals("unknown", animalGroupNameTest.getHerd("cat"));
        Assert.assertEquals("unknown", animalGroupNameTest.getHerd("123"));
        Assert.assertEquals("unknown", animalGroupNameTest.getHerd("Diggidydog"));
        Assert.assertEquals("unknown", animalGroupNameTest.getHerd("Deere"));
        Assert.assertEquals("Crash", animalGroupNameTest.getHerd("rhino"));
        Assert.assertEquals("Crash", animalGroupNameTest.getHerd("rHiNO"));
        Assert.assertEquals("pat", animalGroupNameTest.getHerd("dog"));

        // Tested the animal name to retrieve the right animal class

    }
}
