# Working with DOM & Events - Color Swap
Create an application that will add, swap, and delete color blocks from the web page.

## Requirements

1. Create a `button` element. You may do this in JavaScript, or write it directly in the HTML code. Have the button text read "Add Color Block".

2. Using JavaScript, append a `div` element when you click the button. This `div` should contain:

    - Text that shows how many times the "Add" button was clicked. 
    - A "Delete" button which should remove its parent `div` from the DOM when clicked.

3. Add a CSS file. 
    - All the `div` elements created must have a width of `350px`, `margin` of `1rem` and `padding` of `0.5rem`. 
    - Within the `div` there must be `1rem` of space between the text showing the count & the delete button.
    - All the `div` elements created must also initially have a red background-color.

4. Clicking on a `div` element must toggle the background-color between Red and Green.
    - A red block will become green on click.
    - A green block will become red on click.

## Challenge 

Use only *one* event listener to handle both the background color toggle AND the delete for all of the `div` on the page.