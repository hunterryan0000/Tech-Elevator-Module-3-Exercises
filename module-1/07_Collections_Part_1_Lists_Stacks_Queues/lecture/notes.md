# Collections Intro with List

In this lesson we'll look at Java Collections, a way to store and manipulate a group of Objects.

We'll look at some other Collections tomorrow, but for today our focus is on Lists, specifically the ArrayList.

## Agenda/Topics

- Describe the purpose and use of the Java Collection classes
- Look at the Collections List Interface & the ArrayList class
    - Describe the differences between a List and an array
    - Discuss the different use-cases for a List vs an array
    - Understand the common API operations of a List and how to use them
- Use the for-each loop to iterate through a collection



## List vs Array

Arrays:
    - Hold items of the same type (primitive or object)
    - Fixed in size
        - Size set at creation
        - Can't add or remove item slots, but can change what a slot holds 
    - Items stored sequentially 
        - need to know index/position to access 
        - if index is not know, loop/iterate to find an item

List:
    - Hold items of the same type (primitive or object)
    - Flexible size, can add or remove items as needed (from anywhere)
    - Stored sequentially, can access by index
    - has additional built-in methods for useful tasks

In Java, it's important to be clear about Arrays vs Lists. Make sure to say `List` when you mean `List`, and array when you mean array. 

## List & ArrayList

List is an Interface. We'll talk more about what that means later on. For now you can think of it as a contract that itemizes all the operations which can be performed on any type of List - like adding, retrieving, updating, and deleting elements. The ArrayList is one class that fulfills the List contract. There are others, but we won't be spending time on those as they fit more specialized use cases.

### Create a new ArrayList

```
List<String> names = new ArrayList<String>();
names.add("Luke");
names.add("Leia");
names.add("Han");
```

### Size
No length method or property, use `size()` instead.

```
int length = names.size();
```

### Add/Remove items

```
names.add("C3P0");                        // adds to the end
names.add(0, "Chewbacca");                // adds at position 0 or the beginning 
String removed = names.remove(0);         // remove by position, returns back item
boolean isRemoved = names.remove("Luke"); // remove by value - depends on .equals()
```

### Find items

```
boolean isFound = names.contains("Luke");
int indexOf = names.indexOf("Han");
```



## For-each loops

Some things to note:

- For-each loops are convenience methods used to iterate through a collection.
- You can't modify the contents of a collection during iteration.
- For-each loops are only useful if you want to work with the elements, don't need the index, and want to go through each element one by one starting at the beginning of the collection.
- For-each loops can also be used with arrays.


```
List<String> names = new ArrayList<String>(Arrays.asList("Luke", "Leia", "Han"));
for(String name : names) {
    System.out.println("Character: " + name);
}
```