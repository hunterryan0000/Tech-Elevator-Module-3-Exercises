const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add product name to the page title.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = name;
}

/**
 * Add product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * Display all of the reviews in the reviews array.
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {

    // Get rid of all the reviews (children of review-output) so that we don't get duplicates
    const target = document.getElementById('review-output');
    while (target.firstChild) {
        target.removeChild(target.firstChild);
    }
    
    // Add all the reviews to the page
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 * Add single review to the page.
 * 
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const target = document.getElementById('review-output');

  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerText = review.reviewer;
  tmpl.querySelector('h3').innerText = review.title;
  tmpl.querySelector('p').innerText = review.review;
  // there will always be 1 star because it is a part of the template
  // Clone & hold onto it. Then remove it, & re-add the appropriate number so it doesn't muck up the spacing!
  const imgTempl = tmpl.querySelector('img').cloneNode();
  tmpl.querySelector('img').remove();
  for (let i = 0; i < review.rating; ++i) {
    const img = imgTempl.cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  target.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

// Woot! First event handler! Yay!!! 
// We will wait until the DOM is ready before we call our functions to manipulate the DOM.
// Note we also moved our HTML <script> tag from the bottom of the page up to the <head> 
//  this allows our JS to download and load earlier. 

// When the DOM Content has Loaded, run the function
document.addEventListener('DOMContentLoaded', () => {

  // ALL the stuff here is code I want to run once only on page load.

  // *******************************************
  // Prepping the data for initial display:
  // *******************************************

  // Set the product reviews page title.
  setPageTitle();
  // Set the product reviews page description.
  setPageDescription();
  // Display all of the product reviews on our page.
  displayReviews();

  // *******************************************
  // Setting up event listeners on the page: 
  // *******************************************
  
  // Setup click event handler/listener to show the text input under the description
  let descriptionElement = document.querySelector('.description');
  descriptionElement.addEventListener('click', () => {
    // When someone clicks on the description text, call the toggleDescriptionEdit method.
    toggleDescriptionEdit(descriptionElement);
  });

  let descriptionTextBox = document.querySelector('#inputDesc');
  descriptionTextBox.addEventListener('keyup', (event) => {
    console.log('Checking keyup event...', event.key);
    // If the key pressed was enter - save the text
    if (event.key === "Enter") {
      exitDescriptionEdit(descriptionTextBox, true); 
    } else if (event.key === "Escape"){
      exitDescriptionEdit(descriptionTextBox, false);
    }
  });

  // Show the input form when the Add button is clicked by calling showHideForm
  let addButton = document.querySelector('#btnToggleForm');
  addButton.addEventListener('click', showHideForm);

  // Save the form data when the save button is clicked
  // *Can* one line this, but I think it's a little less informative when reading the code later
  document.querySelector('#btnSaveReview').addEventListener('click', (event) => {
    // because this is inside a form and a submit button, the default behavior is to refresh the page
    // We DO NOT want that, so we must prevent that default behavior
    event.preventDefault();
    saveReview();
  });

});

// Alternate way to do the same thing, BUT with a named function...
// function onDomReady() {
//   // Set the product reviews page title.
//   setPageTitle();
//   // Set the product reviews page description.
//   setPageDescription();
//   // Display all of the product reviews on our page.
//   displayReviews();
// }

// document.addEventListener('DOMContentLoaded', onDomReady);



/**
 * Hide the description and show the text box.
 *
 * @param {Element} desc the element containing the description
 */
function toggleDescriptionEdit(desc) {
  const textBox = desc.nextElementSibling;
  textBox.value = description;
  textBox.classList.remove('d-none');
  desc.classList.add('d-none');
  textBox.focus();
}

/**
 * Hide the text box and show the description.
 * If save is true, also set the description to the contents of the text box.
 *
 * @param {Element} textBox the input element containing the edited description
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;
  if (save) {
    description = textBox.value;
    desc.innerText = textBox.value;
  }
  textBox.classList.add('d-none');
  desc.classList.remove('d-none');
}

/**
 * Toggle visibility of the add review form.
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) {
    form.classList.remove('d-none'); // only remove one value from the class attribute
    btn.innerText = 'Hide Form';     // changing button text
    document.getElementById('name').focus();  // puts cursor in the 'name' input textbox
  } else {
    resetFormValues();
    form.classList.add('d-none'); // add one value to the class attribute, without removing any others
    btn.innerText = 'Add Review';
  }
}

/**
 * Reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * Save the review that was added using the add review form.
 */
function saveReview() {
  // Pretty please - when you write these functions, just check they get called with a console.log first
  // then you can write all the fun logic. 
  console.log('button clicked');

  // Now let's get the form data...
  // The text from the inputs are the value
  const name = document.getElementById('name').value;
  const title = document.getElementById('title').value;
  const rating = document.getElementById('rating').value;
  const review = document.getElementById('review').value;

  const newReviewObj = {
    reviewer: name,
    title: title,
    rating: rating,
    review: review
  }

  // Push into array of reviews 
  // This would be the place to do a POST request to the server if we had one...
  reviews.push(newReviewObj);

  // Show the reviews
  // This would be the place to do a GET request to the server to get fresh data (including our new review)
  displayReviews();

  // Clear the inputs & hide the form
  showHideForm();
}
