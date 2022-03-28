<template>
<div>
  <div class="product-reviews">
      <h2>Product Review for {{ title }}</h2>
      <p class="description"> {{ description }}</p>

      <!-- What if we want a subset of data - Computed properties help with this! Woot! -->
      <div class="well-display">
          <div class="well">
              <span class="amount">
                  {{ averageRating }}
              </span>
              Average Rating
          </div>
          <div class="well">
              <span class="amount">
                  {{ numberOfOneStartReviews }}
              </span>
               1 Star Review
          </div>
          
          <div class="well">
              <span class="amount">
                  <!-- Data from vue plugged in here... -->
              </span>
               2 Star Review
          </div>
          
          <div class="well">
              <span class="amount">
                  <!-- Data from vue plugged in here... -->
              </span>
               3 Star Review
          </div>
          
          <div class="well">
              <span class="amount">
                  <!-- Data from vue plugged in here... -->
              </span>
               4 Star Review
          </div>
          
          <div class="well">
              <span class="amount">
                  <!-- Data from vue plugged in here... -->
              </span>
               5 Star Review
          </div>
      </div>

      <!-- v-for is like as JS for-of loop -->
      <div class="review" v-for="review of reviews" v-bind:key="review.id">
          <h4>{{ review.reviewer }}</h4>
          <div class="rating">
              <img src="../assets/star.png" v-for="n in review.rating" v-bind:key="n" alt="star" class="ratingStar" />
          </div>
          <h3> {{ review.title }}</h3>
          <p>{{ review.review }}</p>
      </div>
  </div>
  </div>
</template>

<script>
export default {
    name: 'ProductReview',
    // IMPORTANT, data is a function
    data() {
        // It MUST return an object
        return {  
            // Get the name from outside the component - App.vue
            //name: 'Cigar Parties for Dummies',

            // This is 'local' data, within this component
            description: 'Host & plan the perfect party for all your squirrelly friends.',
            reviews: [
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
            ]
        }
    },
    computed: {
        averageRating() {
            let totalReviewScore = this.reviews.reduce( (currentSum, review) => currentSum + review.rating, 0);
            return totalReviewScore / this.reviews.length;
        },
        numberOfOneStartReviews() {
            return this.reviews.reduce( (currentCount, review) => currentCount + (review.rating === 1), 0 )
        }
    },
    // These are 'props'. They come from outside the component.
    props: {
        title: String
    }
}
</script>

<style scoped>
div.product-reviews {
    margin: 1rem 0;
}

div.well-display {
    display: flex;
    justify-content: space-around;
}

div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
}

div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}

div.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
}

div.review div.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
}

div.review div.rating img {
    height: 100%;
}

div.review p {
    margin: 20px;
}

div.review h3 {
    display: inline-block;
}

div.review h4 {
    font-size: 1rem;
}
</style>