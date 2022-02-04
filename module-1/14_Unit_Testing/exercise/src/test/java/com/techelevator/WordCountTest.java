package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    @Test
    public void test_the_count_array_of_strings(){
        WordCount wordCountTest = new WordCount();

        String[] testWordCount = {"ba", "ba", "black", "sheep"};

        Map<String, Integer> i = new HashMap<>();
        i.put("black",1);
        i.put("sheep",1);
        i.put("ba",2);

        Assert.assertEquals(i, wordCountTest.getCount(testWordCount));







    }
}
