
let myVariable;
console.log( myVariable );
myVariable = 'stuff';
console.log( myVariable );

/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

// Calling the function above with different input parameters of different types
// printToConsole('Hello');
// printToConsole(42);
// printToConsole([1, 3, 5]);
// printToConsole({ name: 'Kyo', color: 'orange' });

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 * 
 * @returns {number} the result of multiplying firstParameter & secondParameter
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}

console.log( multiplyTogether(12, 3) );
console.log( multiplyTogether() );    // NaN (before we did code below), 0 after we did code below to set default values
console.log( multiplyTogether(42) );  // NaN (before we did code below), 0 after we did code below to set default values 
console.log( multiplyTogether('BTS', 'Army') ); // NaN

let result = multiplyTogether();

// Note you can't compare NaN with == === or other equality operators
// if ( result == NaN ) {
if ( isNaN(result) ) {
  console.log(`Sorry, you can't multiply things that aren't numbers.`)
} else {
  console.log(`Result of multiplyTogether() is ${result}.`);
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 * 
 * @returns {number} the result of multiplying firstParameter & secondParameter
 */
// Note that this function is "hoisted" so that it is in place before any other code is executed. 
// The calls to the function on lines 42-46, use this declaration which overrides the previous one on line 38.
function multiplyTogether(firstParameter = 0, secondParameter = 0) {
  return firstParameter * secondParameter;
}

// NOTE - You can't "overload" functions in JS to change the behavior in the same way that you can in Java... 
// The following over writes or "overrides" the previous declarations it doesn't "add" a new method for 3 inputs.
// function multiplyTogether(firstParameter = 0, secondParameter = 0, thirdParameter = 0) {
//   return firstParameter + secondParameter + thirdParameter;
// }
 


/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

// scopeTest();


// JS has a truthy / falsy concept that you don't really see in Java where you need strict boolean values
function booleanTruthyFun() {
  // Conditional statement in JS don't require strict "boolean" values. All things are truthy or falsy...

  // Undefined is falsy - not technically a boolean false BUT behaves like one
  let undefinedValue;

  if (undefinedValue) {
    console.log('Undefined value is truthy.');
  } else {
    console.log('Undefined value is falsy.')
  }

  let nanValue = NaN;

  if (nanValue) {
    console.log('nanValue value is truthy.');
  } else {
    console.log('nanValue value is falsy.')
  }

  let nullValue = null;

  if (nullValue) {
    console.log('nullValue value is truthy.');
  } else {
    console.log('nullValue value is falsy.')
  }

  let strValue = 'hello';

  if (strValue) {
    console.log('strValue value is truthy.');
  } else {
    console.log('strValue value is falsy.')
  }

  let positiveValue = 1;

  if (positiveValue) {
    console.log('positiveValue value is truthy.');
  } else {
    console.log('positiveValue value is falsy.')
  }

  let negativeValue = -1;

  if (negativeValue) {
    console.log('negativeValue value is truthy.');
  } else {
    console.log('negativeValue value is falsy.')
  }

}

booleanTruthyFun();


// TODO - talk about what happens if we call a string/array function on something that is not a String/Array...
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;

  if (listOfQuirks.length === 0) {
    listOfQuirks = [ 'They aren\'t quirky!' ]
  }
  return description + listOfQuirks.join(separator);
}

console.log( createSentenceFromUser('Mary', 47, ['like Moogles', 'like Kpop', 'She would eat only ice-cream, if that wouldn\'t kill her.' ]) );
console.log( createSentenceFromUser('Mary', 47) )

// What if I pass in something that is not an array for the listOfQuirks
// .join is not a function for a String, so this gives an error.
//console.log( createSentenceFromUser('Mary', 47, 'Likes Kpop') );

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
 function sumAllNumbers(numbersToSum) {
  let sum = 0;
  for (number of numbersToSum) {
    sum += number
  }
  return sum;
}



function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce( (total, number) => total + number, 0);
}

console.log( sumAllNumbers( [ 2, 3, 6 ] ) );
console.log( sumAllNumbers( [  ] ) );

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {

  let results = [];
  for ( let number of numbersToFilter ) {
    if ( number % 3 === 0 ) {
      results.push(number);
    }
  }

  return results;
}

// [ 2, 3, 6, 7, 9 ] => [3, 6, 9]
// results = [3, 6, 9]
// number = 9
console.log( allDivisibleByThree( [ 2, 3, 6, 7, 9 ] ) );
console.log( allDivisibleByThree( [ 2, 4, 14, 7, 19 ] ) );
console.log( allDivisibleByThree( [] ) );

// First attempt at using filter...
function allDivisibleByThree(numbersToFilter) {

  // Writing an anonymous function to decide if we keep the items...
  return numbersToFilter.filter( function (number) {
    if ( number % 3 === 0 ) {
      return true;
    }
  });
}

// Second attempt at using filter... removing redundant if check, just return result of boolean expression
function allDivisibleByThree(numbersToFilter) {

  // Writing an anonymous function to decide if we keep the items...
  return numbersToFilter.filter( function (number) {
      return ( number % 3 === 0 );
  });
}

// Third attempt at using filter... arrow function 
function allDivisibleByThree(numbersToFilter) {

  // Writing an anonymous function using an arrow function!
  // If there are no {} on the arrow function return is assumed
  // IF there is only one input parameter, then the () can come off too!
  return numbersToFilter.filter( number => number % 3 === 0 );
}