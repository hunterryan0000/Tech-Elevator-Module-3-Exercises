# Intro to Objects in Java

WOOT! We're getting to objects!!! This lets us do all the cool stuff!!!

## Agenda/Topics

- Conceptual
    - What is an object?
    - Object vs Class
    - How are objects stored in memory Stack vs Heap
    - Value type vs Reference type
    - Equality
- Code/Practical
    - String class - Javadocs & calling methods
        - Pay attention to what methods *change* objects vs return new ones
        - Strings are immutable - all string methods return a new String vs modifying the string instance itself.
    - Equality with objects - `==` vs `.equals()`
    

## Object Basics 

<div class="definition note">
An <span>object</span> is an in-memory data structure that combines state and behavior into a usable and useful abstraction.
</div>

We don't technically write objects in our code. Objects only exist when our code is running because an object is an in-memory data structure. In order to make objects, we have to write classes.

<div class="definition note">
A <span>class</span> is a grouping of variables and methods in a source code file that we can generate objects out of.
</div>

- A class is a template or a blueprint for creating objects. It is like a cookie cutter. You use it to stamp out or create individual cookies. When finished each of those cookies (or object instances) can look very different, but they all start from the same cookie cutter or template.

Note: Late we'll learn how to create our own classes, but this will come later in the week.


## String Class

### Key String Methods

| method             | use    |
|--------------------|--------|
| length()           | Returns how many characters are in the string |
| substring()        | Returns a certain part of the string |
| indexOf()          | Returns the index of a search string |
| charAt()           | Returns the `char` from a specified index |
| contains()         | Returns `true` if the string contains the search string |
| equals()           | Returns `true` if the string matches another string exactly |
| equalsIgnoreCase() | Returns `true` if the string matches another string ignoring case |
| split()            | Splits the string into an array around matches of String or regex (regular expression). |
| strip()            | Returns a new string with all leading & trailing white space characters removed. |
| toUpperCase()      | Returns a new string with all characters converted to upper case. |
| toLowerCase()      | Returns a new string with all characters converted to lower case. |



### Is a String a Palindrome

A palindrome is the same letters forward and backwards:
- eve
- madam
- racecar
- step on no pets

Let's use String methods to write a method to determine if a string is a palindrome!