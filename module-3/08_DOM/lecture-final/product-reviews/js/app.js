const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  const titleSpan = pageTitle.querySelector('.name');

  // Alternate ways to do the same thing - about as efficient, as they all select based on ID
  // const titleSpan = document.querySelector('#page-title > .name'); // more specific... may be better or worse depending on situation
  // const titleSpan = document.querySelector('#page-title .name');   // this is not direct parent/child so looser

  // These don't use an ID, so while they "work" the are technically less efficient
  // const titleSpan = document.querySelector('h2 .name');
  // const titleSpan = document.querySelector('h2 > .name');
  
  titleSpan.innerText = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector("#main p.description").innerText = description; // slightly more specific, both these examples are fine
  // document.querySelector("#main .description").innerText = description;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {
  const mainDiv = document.getElementById('main');

  if (reviews.length > 0) {
    document.getElementById('no-reviews').remove();
  }
  for( const item of reviews ){
    const reviewDiv = createReview(item);
    mainDiv.appendChild(reviewDiv);
  }
}

function createReview(reviewObject){
  const reviewDiv = document.createElement('div');
  reviewDiv.setAttribute('class', 'review');
  addReviewer(reviewDiv, reviewObject.reviewer);
  addRating(reviewDiv,reviewObject.rating);
  addTitle(reviewDiv, reviewObject.title);
  addReviewText(reviewDiv, reviewObject.review)
  return reviewDiv;
}

/**
 * I will create a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const h4Reviewer = document.createElement('h4');
  h4Reviewer.innerText = name;
  parent.appendChild(h4Reviewer);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  const ratingDiv = document.createElement('div');
  ratingDiv.setAttribute('class', 'rating');
  for (let count = 0; count < numberOfStars; count++) {
    const starImg = document.createElement('img');
    starImg.setAttribute('src', 'img/star.png');
    starImg.setAttribute('alt', 'rating star');
    starImg.setAttribute('class', 'ratingStar');
    ratingDiv.appendChild(starImg);
  }
  parent.appendChild(ratingDiv);
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const h3Title = document.createElement('h3');
  h3Title.innerText = title;
  parent.appendChild(h3Title);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReviewText(parent, review) {
  const element = document.createElement('p');
  element.innerText = review;
  parent.appendChild(element);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();


// Just for fun - added a div that is hidden using the .hide class in the index.html
// Let's use JS to make it show up!
document.querySelector('.hide').removeAttribute('class');