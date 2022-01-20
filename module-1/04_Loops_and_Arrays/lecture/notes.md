# Logical Branching

## Topics

- Pre-Reading & Quiz Expectations
- Assignment Submission 

- Review
    - if/else & ternary operator
    - && and ||
    - methods - return type & parameters 

- Introduction to Arrays
    - lecture code **1** to **5**.
- Blocks & variable scope
    - lecture code **6** to **8**
- Shorthand assignment operators
    - lecture code **7** to **8**
- For loops
    - increment/decrement or prefix/postfix operators (++x, x++)
    
    - lecture code **9** to **12**
- Breakpoints & Debugging 


## Arrays

Declare & initialize empty:
`int[] scores = new int[10];`

Declare & initialize with values:
`int[] scores = new int[] { 75, 96, 80, 98, 84};`

Get length: 
`int numberOfScores = scores.length;`

Get a value from array by index:
`int firstScore = scores[0];`

Remember indexes start at 0 not 1!

## Loops

The most common for-loop structure that you will see is a for-loop that runs over every element in an array. This is a good one to memorize:

``` java
    int[] scores = new int[] { 75, 96, 80, 98, 84};
    for(int i = 0; i < scores.length; i++) {
        ...
    }
```


## Increment/decrement or prefix/postfix operators

When using the prefix operator `++x`, the expression increments the value of the variable and then returns the (modified/incremented) value. 

When using the postfix operator `x++`, the expression returns the *current value* of the variable and then increments it.</div>

<div class="caution note">
Don't use these operators, except in loops or in lines by themselves. They are dangerous and cause unforeseen *side effects*. (Those can be common sources of bugs.)
</div>


## Shorthand assignment operators

There is a common shorthand for adding to or subtracting from a value.
```
x += n; // equivalent to x = x + n
x -= n; // equivalent to x = x - n
``` 


## Breakpoints and Debugging

<div class="definition note">A <span>breakpoint</span> is a marker in our IDE (not a part of our code) that indicates our program should pause execution when it reaches a set location before continuing.</div>

When debugging code, it is best to:

* Locate the breakpoint at the start of the code that you want to validate
* Make a single change, then test. Repeat.
* Read any error messages that show up
* Explain your code step by step to another person


### Additional Resources

- Additional Practice Problems
    - [Conditionals](https://codingbat.com/java/Logic-1)
    - [Basic arrays (no loops)](https://codingbat.com/java/Array-1)
    - [Arrays & Loops](https://codingbat.com/java/Array-2)
    - Want more? Try problems from the following sites:
        - [CodeWars](https://www.codewars.com/)
        - [Edabit](https://edabit.com/)
- [Wikipedia Software Bug](https://en.wikipedia.org/wiki/Software_bug)