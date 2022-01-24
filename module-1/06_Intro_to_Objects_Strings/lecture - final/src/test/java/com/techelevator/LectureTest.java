package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LectureTest {

    Lecture lecture = new Lecture();

    @Test
    public void testIsPalindrome() {
        assertFalse("Testing 'hello' is false", lecture.isPalindrome("hello"));
        assertFalse("Testing 'woot' is false", lecture.isPalindrome("woot"));
        assertFalse("Testing 'woz' is false", lecture.isPalindrome("woz"));
        assertTrue("Testing 'wow' is true", lecture.isPalindrome("wow"));
        assertTrue("Testing 'noon' is true", lecture.isPalindrome("noon"));
        assertTrue("Testing 'madam' is true", lecture.isPalindrome("madam"));
        assertTrue("Testing 'racecar' is true", lecture.isPalindrome("racecar"));
        assertTrue("Testing 'step on no pets' is true",
                lecture.isPalindrome("step on no pets"));


        assertFalse("Testing '10200301' is false", lecture.isPalindrome("10200301"));
    }

    @Test
    public void testIsPalindrome_Challenge_IgnoreSpaces() {
        assertFalse("Testing 'hello' is false", lecture.isPalindrome("hello"));
        assertFalse("Testing 'woot' is false", lecture.isPalindrome("woot"));
        assertTrue("Ignore spaces", lecture.isPalindrome("taco cat"));
    }

    @Test
    public void testIsPalindrome_Challenge_IgnoreCapitalization() {
        assertFalse("Testing 'hello' is false", lecture.isPalindrome("hello"));
        assertFalse("Testing 'woot' is false", lecture.isPalindrome("woot"));
        assertTrue("Ignore capitalization", lecture.isPalindrome("Noon"));
        assertTrue("Ignore capitalization", lecture.isPalindrome("Racecar"));
    }

    @Test
    public void testIsPalindrome_Challenge_IgnoreCapitalizationAndSpaces() {
        assertFalse("Testing 'hello' is false", lecture.isPalindrome("hello"));
        assertFalse("Testing 'woot' is false", lecture.isPalindrome("woot"));
        assertTrue("Ignore capitalization & spaces", lecture.isPalindrome("Top Spot"));
    }

    @Test
    public void testIsPalindrome_Challenge_IgnorePunctuation() {
        assertFalse("Testing 'hello' is false", lecture.isPalindrome("hello"));
        assertFalse("Testing 'woot' is false", lecture.isPalindrome("woot"));
        assertTrue("Ignore punctuation - ?", lecture.isPalindrome("Was it a cat I saw?"));
        assertTrue("Ignore punctuation - , and ?", lecture.isPalindrome("I did, did I?"));
        assertTrue("Ignore punctuation - ' and .", lecture.isPalindrome("Don't nod."));
        assertTrue("Ignore punctuation - !", lecture.isPalindrome("Step on no pets!"));
    }
}
