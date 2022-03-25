# Number Game
Create a number guessing game.  The "game" will choose a number, and the player will try to guess it.

## Details

1. Create an index.html page using a standard HTML5 template. You should have:
  - Set the title to "Number Game".
  - Add an `h1` element to the `body` that says "Number Guessing Game".
  - Add a paragraph (`p` element) that says "I'm thinking of a number from 1 to 100. Try to guess it."

2. Add a CSS file and use a `link` element to add the CSS to your HTML page.  
  - Add basic styles to make the page look good.
  - You can do as little or as much as you want here.

3. Add a JavaScript file and use a `script` element to add the JS file to your HTML page. In the JS file:
  - define a function that will use a prompt to get a number from the player. Validate the number is between 1 and 100, asking again if it is not. When you have a good number, return it.
  - define a function that will choose and return a number.  For now, have it choose 42.
  - Write a function to play the game.  This function should:
    1. Choose a number
    2. Continue to prompt the player to guess a number until they choose the correct number
    3. When the player guess is incorrect, use an alert to tell them that was not correct and to either guess higher or lower next time.
    4. When the player guesses correctly, use an alert to tell them they have won the game.
  - When the DOM is ready, call the function to play the game.

4. Test
  - Open your page in the browser.  
  - You should see your styles reflected on the web page. If not, check your `link` tag.
  - Play the game.  Make sure to test guessing correctly and incorrectly different numbers of times to make sure that the game logic is correct.

## Extras
1. Update the function that chooses a number. Currently it should always return 42. Update it to select and return random number between 1 and 100.  (Use [Math.Random](https://www.w3schools.com/js/js_random.asp) to do this.)

2. Instead of using the prompt to get a number, add a form with a submit button to the page to allow the player to guess the number.

3. Write the messages telling the player if their guess was incorrect or correct to the page.
  - Keep a running record of all guesses on the page.
  - When the guess is correct, have the message appear in a different color such as green.

4. Add a reset button that will clear the page and select a new number for the player to guess.
  - Hide the reset button until the game has been won.  The reset button should not be visible while the player is guessing.
  - Once the game is won, hide the guess input form until the reset button has been pressed.

5. Add a message with a win counter to show how many times the player has won the game.