# OOP (Object Oriented Programing) & Inheritance


Sometimes we have objects in our code that are similar in some way, but differ in others. 
We might have to define books for our application but have different types of books, 
like novels, comic books, and self-help books. They can all fit on a bookshelf and 
all have page numbers, but novels don't have pictures and self-help books don't have 
story characters.

We could make these all separate classes, but then we have a lot of code duplication 
and that's a bad thing. Instead of doing that, we can use *inheritance* to reuse common
variables (properties) and methods (behaviors) between classes.

## Topics / Agenda

- Review Encapsulation
- Intro Inheritance
- Intro Polymorphism
- 3 Pillars of OOP: Encapsulation, Inheritance & Polymorphism
    - THIS WILL COME UP IN INTERVIEWS!!!
    - Make sure you can explain each of these in your own words.
    - Use an example to help clarify. 

## Inheritance

*Inheritance* enables a class to take on the properties and methods defined in another 
class. A subclass will inherit visible properties and methods from the superclass while 
adding members of its own.

Often this is expressed in one of 3 ways that all mean the same thing:
- superclass/subclass
- base/derived class
- parent/child class


The *superclass* or *parent* is the *base* class whose data and behaviors are being passed down.
The *subclass* or *child* is the *derived* class that inherits the data and behaviors.

### Access Modifiers

For more info, see the Java tutorial (https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
- public
- protected
- (no modifier) package private (Rarely if ever used)
- private 

## Overloading vs Overriding

Make sure you can speak to the difference between these two. 
This is also a really common interview question.

- overloading - different method signatures within a class. No inheritance required. 
    (Can overload a method from a parent, but not required to be an inherited method.)
- overriding - changing the behavior of an inherited method. Inheritance is required. 

## Polymorphis

