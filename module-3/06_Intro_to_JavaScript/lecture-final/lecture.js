console.log("Good morning Java Purple!");


// Use let to declare ALL of your variable - ALWAYS!
// Notice no type is needed - dynamically typed language
let name = 'Mary';

// This is the old way to make variables. DON'T USE IT!!!
//var old_name = "Masha";

// This does not give an error, but has the same issues as using var. DON'T DO IT!!!
//new_name = 'Mary the Great';

// Like a System.out.println() - can be useful for debugging 
//   and to see values not rendered in the browser
console.log('Good morning, ' + name);

// Best practice for Strings in JS is to use single quotes
// BUT both work!
let message = "I can't do that";

// Making a function - no return type & no types on the inputs
// No access modifiers in JS
function addTwo(number1, number2) {
    return number1 + number2;
}

function multiplyTwo(number1, number2) {
    return number1 * number2;
}

console.log('Adding 3 and 5: ' + addTwo(3, 5));
console.log('Adding me and you: ' + addTwo('me', 'you'));

console.log('Multiply 3 and 5: ' + multiplyTwo(3, 5));

// JavaScript doesn't give an error if it can avoid it. This gives NaN for Not A Number.
console.log('Multiply me and you: ' + multiplyTwo('me', 'you'));
console.log('Multiply me and 3: ' + multiplyTwo('me', 3));

// No type on JS variables
name = 12345;
console.log('Name is: ', name);

// Variables can be used to hold a function!!!
name = multiplyTwo;
console.log('Name is: ', name);


// if/else is more or less the same BUT == and ===
// Best practice is to use === which requires types to match as well as values
// == will play with types to try and make it work 
let one = 1;
let strOne = '1';

// Allows type conversion
if (one == strOne) {
    console.log('Loose equality: They match!!!');
} else {
    console.log('Loose equality: They don\'t match!!!');
}

if (one === strOne) {
    console.log('Strict equality: They match!!!');
} else {
    console.log('Strict equality: They don\'t match!!!');
}

console.log('When is 1 + 1 not 2???', one + strOne);

function sayHello(toWhom) {
    console.log('Hello, ' + toWhom + '!!! Meow.');
    // This function has no return, so the return value is undefined
}

// Objects
// Object literal - notice that the syntax is a lot like JSON!!!
let cat = {
    name: 'Kyo',
    color: 'orange',
    age: 13,
    hello: sayHello, // sets hello to the function sayHello
    // hello: sayHello('Brian') - this would set hello to the output of calling the function,
    // hello: function (toWhom) {
    //     console.log('Hello, ' + toWhom + '!!! Meow.');
    //     // This function has no return, so the return value is undefined
    // }
}

// If you try to display an object as a string, you'll see [object Object] (not very helpful)
console.log('The cat is: ' + cat);

// Just like Java you can access properties using the . operator
console.log('The cat is: ' + cat.name);

// This ONLY applies to console.log statements, BUT you can use a comma to see "inside"
// This is super helpful for debugging.
console.log('The cat is: ', cat);

console.log(cat.hello);

// Expecting a parameter, but none given means it goes in as undefined.
cat.hello();

cat.hello('Brian');

// can add properties to objects at will...
// maybe I wanna rename my cat, but I have some fat fingers...
// Make a typo here and JS won't yell at you. It just makes a new property
cat.mame = 'Abby';
console.log(cat);

// You can make classes in JS
// Older JS has object constructor function, but new class syntax is nicer

class Cat {

    // unlike Java, your constructor is called 'constructor' not the class name
    constructor(name, color, age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
}

const abby = new Cat('Abby', 'brown', 14);
let fred = new Cat('Fred', 'beige', 12);

console.log('Abby:', abby);
console.log('Fred:', fred);
console.log('Kyo:', cat);

// Can't do this because Abby is a CONST
// abby = fred;

// Can still change the properties inside the object
abby.name = 'Fred';
console.log(abby);

// String literals! One of my favorite things in JS!!!
// uses back ticks - key above Tab
let strLiteralMessage = `Hello ${abby.name}. Nice to see you today. I'm ${cat.name}.`;
console.log(strLiteralMessage);

// Arrays in JS are more like List in Java
let numbers = [1, 5, 34, 90, 42];
console.log(numbers);

// Because arrays are not type restricted, can put strings in the numbers array
numbers.push('Hello');
numbers.pop();
numbers.push('Crazy String');
numbers = numbers.concat([2, 4, 6, 8]);
console.log(numbers);

console.log('Regular for loop');
for (let index = 0; index < numbers.length; index++) {
    const currentNumber = numbers[index];
    console.log(currentNumber);
}

console.log('Java for-each loop is JS for-of loop');
for (let currentNumber of numbers) {
    console.log(currentNumber);
}


// Write me a function that takes 2 inputs - a string and a number
//  it should return back an array that has the 'number' of items in it
//  each item should progressively repeat the string.
// ('ab', 3) => [ 'ab', 'abab', 'ababab' ]

function stringRepeater(string, number) {
    let temp = '';
    let array = [];
    for (let index = 1; index <= number; index++) {
        temp = temp + string;
        //array[index] = temp;
        array.push(temp);
    }
    return array;
}

function stringRepeater2(string, number) {
    let array = [];
    for (let index = 1; index <= number; index++) {
        array.push( string.repeat(index) );
    }
    return array;
}

// string = 'ab'
// number = 3
// temp = '', 'ab', 'abab', 'ababab'
// array = [], ['ab', 'abab', 'ababab']
// index = 0, 1, 2, 3

console.log(stringRepeater('ab', 3));








