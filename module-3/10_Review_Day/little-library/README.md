# Little Library
Create an application that tracks books in a small personal library. 


## MVP Requirements

### Store some books:
- Create an array which will be used to (locally) save the books in the library. 
- Each book will have properties for: title, author first & last name, category, & published date. 
- All properties are required except the published date.
- Add 5 book objects to the array for starting data. Some should have a published date and others should not.


### Display the books:
- In your HTML file, add a section to the page to display the books.
- Give it a heading "All Books".
- Below this should be a sentence showing the total number of books in the library. For example the message might initially say, "The library has 5 books." 
- Next we will display the detailed information for each book. You may do this in either a table or some sort of grid/card layout. 


### Add book:
- Add a new section with a heading "Add New Book" above the section for "All Books". 
- Add an input form with a 'Save' button to collect information on the books: title, author first & last name, category, & published date. 
- All data inputs are required except the published date. 
- When the form is submitted: 
    - Create a new book object and add it to the array of books.  
    - Refresh the display of books on the DOM.  
    - Clear the form input fields
- Update the informational message with the total book count.




## Challenge Requirements 

### Toggle the form display:
- On initial page load, hide the form to add a book. 
- Instead, show a button to "Add a Book". When this button is clicked show the form & hide the button.
- When the "Save" button is clicked, the form should again be hidden. 
- Add a "Cancel" button to the form as well. This should both hide the form and clear the form inputs.


### Delete a book:
- Add a "Delete" button to the display of each book. 
- When the delete button is clicked:
    - Remove the book from the DOM & the array of books
    - Update the book count in the message at the top of the page. 


### Update a book:
- Add a "Checkout" button to the display of each book.
- When the "Checkout" button is clicked:
    - Add an "onLoan" property to the book object. Set its value to `true`.
    - Update the display of the book to have a button saying "Returned". 
- When the "Returned" button is clicked:
    - Set the "onLoan" property to `false`.
    - Update the display of the book to again show a "Checkout" button.