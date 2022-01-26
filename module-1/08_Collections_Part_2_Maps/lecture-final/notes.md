# Collections Part 2 - Maps!

Today we're going to focus in on a new member of Java Collections - Map.

A `Map` is a collection of key-value pairs that allows a value to be located quickly using its key. Each key must be unique, but values may be duplicated.

## Agenda / Topics

- High-level Java Collection Review  
- Review List/ArrayList  
- Collections class & Arrays class
    - convert array to a list: `Arrays.asList({2, 3, 5})`;`
    - add an array of values to a Collection: `Collections.addAll(targetCollection, array)`
- Check out some Sets - HashSet (unordered) & TreeSet (sorted)
- Working with Map


## Map Intro

A relatable real-life example is a vending machine. 
The *key* is something like `A5`, which gets you the *value* at that key, a bag of chips. 
Chips can be at other locations too, but nothing else can be at `A5`.

| key  | value        |
| ---- | ------------ |
| "A5" | "Chips"      |
| "A6" | "Chips"      |
| "A7" | "Candy bars" |

Declaring and initializing a `Map`
```
// Name is key, value is Jedi status
Map<String, Boolean> people = new HashMap<String, Boolean>();
```

Adding an item to a `Map` using the `put()` method.
Key must be unique, but values can be repeated.
```
people.put("Luke", true);
people.put("Yoda", true);
people.put("Leia", false);
```

The `put` method is also used to update or replace a key's value.
```
people.put("Leia", true);
```

This means it might be a good idea to see if a value exists first:
```
boolean isFound = people.containsKey("Han")
```

Alternately, you can just try to get a value & if it is not found, you'll get null
```
boolean isJedi = people.get("Han");  
```

What keys are in the Map?
```
// Why do you think this is a Set not a List?
Set<String> keys = people.keySet();
```

Remove something from a Map:
```
people.remove("Yoda");
```


### Looping over a Map


```
for (Map.Entry<String, Boolean> person : people.entrySet()) {
    // person.getValue() will return a boolean
    if (person.getValue()) {
        System.out.println(person.getKey() + " is a Jedi.");
    } else {
        System.out.println(person.getKey() + " is not a Jedi.");
    }
}
```


## References

Javadocs v11:
- [Collections Class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collections.html)
- [Arrays Class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html)
- [Set Interface](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html)
    -[HashSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html)
    -[TreeSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeSet.html)
- [List Interface](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html)
    - [ArrayList](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
    - [Stack](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Stack.html)
- [Queue Interface](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html)
    - [LinkedList (both List & Queue)](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html)
- [Map Interface](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html)
    -[HashMap](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html)
    - [TreeMap](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeMap.html)
