package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayStuffTest {

    private ArrayStuff instance;

    @Before
    public void setup() {
        instance = new ArrayStuff();
    }

    @Test
    public void findString_emptyArray_notFound(){
        // We're doing this everytime, so moving into setup() with @Before
        // ArrayStuff arrayStuff = new ArrayStuff();
        Assert.assertFalse("Testing with empty array expected false (not found).",
                instance.findString(new String[0], "test"));
    }

    @Test
    public void findString_oneItemInArray_notFound(){
        Assert.assertFalse("Testing with array of 1 item, but not the correct one",
                instance.findString( new String[] {"cat"}, "test"));
    }

    @Test
    public void findString_oneItemInArray_found(){
        Assert.assertTrue("Testing with array of 1 item, it is the correct one",
                instance.findString( new String[] {"test"}, "test"));
    }

    @Test
    public void findString_nullArray_notFound(){
        Assert.assertFalse("Testing with null for array, should get not found",
                instance.findString(null, "test"));
    }

    @Test
    public void findString_stringArray_nullValue(){
        // null value, should match a null value in the array
        Assert.assertTrue("Testing with string array that contains a null value & a null value to match",
                instance.findString(new String[] {"blah", null, "foo", "bar"}, null));

        // If a test has multiple asserts, note that the test will stop as soon as an assert fails. You don't get messages
        // from any potential failures after the first one.
        // Leaving this here to show that you *CAN* have multiple asserts in a single test method
        // BUT if they are testing different things, multiple test methods is really a better practice
        Assert.assertFalse("Testing with string array that does not contain a null value & a null value to match",
                instance.findString(new String[] {"blah", "snarf", "foo", "bar"}, null));
    }

    @Test
    public void findString_longStringArray_stringValue_found() {
        Assert.assertTrue("Testing with string array that contains a null value & a null value to match",
                instance.findString(new String[] {"blah", "foo", "test", "bar"}, "test"));
    }

    @Test
    public void findStringPosition_stringArray_validValue_found() {
        Assert.assertEquals("Testing with string array, value should be found",
                0, instance.findStringPosition(new String[] {"blah", "foo", "test", "bar"}, "blah"));

        Assert.assertEquals("Testing with string array, value should be found",
                1, instance.findStringPosition(new String[] {"blah", "foo", "test", "bar"}, "foo"));
    }
}
