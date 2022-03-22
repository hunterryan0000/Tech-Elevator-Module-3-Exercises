console.log("Good morning Java Purple!");

let name = 'Ryan';

//This is the old way to make variables. Don't use it!!!!
//var old_name = "Jamal";

//This does not give an error, but has the same issues as using var. Don't do it!!!
//new_name = "Mary the Great";

// Like a System.out.println() - can be useful for debugging
// and to see values not rendered in the browser
console.log('Good Morning, ' + name);

// Best practice for Strings in JS is to use single quotes
// But both work!
let message = "I can't do that";

// Making a function
function addTwo(number1, number2) {
    return number1 + number2;
}

console.log('Adding 3 and 5: ' + addTwo(3, 5))


// if/else is more or less the same BUT -- and ---
// Best practice is to use === which requires types to match as well as values
// -- will play with types to try and make it work

let one = 1;
let strOne = '1';

if (one == strOne) {
    console.log('They match!!!');
} else {
    console.log('Loose equality: They don\'t match!!!')
}

if (one === strOne) {
    console.log('Strict equality: They match!!!');
} else {
    console.log('Strict equality: They don\'t match!!!');
}

console.log('when is 1 + 1 not 2???', one + strOne);

// Objects

let cat = {
    name: 'Kyo',
    color: 'orange',
    age: 13,
    hello: sayHello, // sets hello to the function sayHello
}

// If you try to display an object as a string, you'll see [object Object] (not very helpful)
console.log('The cat is: ' + cat);

// Just like Java you can access properties using the . operator
console.log('The cat is: ' + cat.name)

//This ONLY applies to console.log statements, BUT you can use a coma to see "inside"
// This is super helpful for debugging.
console.log('The cat is: ', cat);

console.log(cat.hello);

// Expecting a parameter, but more given means it goes in as undefined.
cat.hello();

cat.hello('Brian');

function stringRepeat (string, number) {
    let temp = "";
    let array = [];
    for (let index = 0; index < number; index++) {
        temp = temp + string;
        array[index] = temp;
    }
    return array;
}

// string - 'ab'
//number - 3
// temp = '', 'ab', 'abab'