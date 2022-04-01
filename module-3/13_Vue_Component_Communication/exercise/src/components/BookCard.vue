<template>
  <div class="card" v-bind:class="{ read: book.read }">
      <!-- STEP 2 details of book (title(h2), img, followed by author(h3)) -->
    <h2 class="book-title"> {{book.title}} </h2>
        <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' 
        + book.isbn + '-M.jpg'" />
    <h3 class="book-author"> {{book.author}} </h3>
    <!-- STEP 3 button to toggle the read and unread status of a book -->
    <button v-on:click="toggleReadStatus" v-bind:click="book.read" 
    v-bind:class="[book.read?'mark-unread':'mark-read']">
    <!-- STEP 3 The button that sets the status to read must have a `mark-read` class, 
    and the button that sets the status to unread must have a `mark-unread` class. -->
        <a v-if="book.read">Mark Unread</a>  
        <a v-if="!book.read">Mark Read</a>
    </button>
  </div>
</template>

<script>
export default {
    name: 'book-card',
    // STEP 2 add props that takes a book
    props:["book"],
    // STEP 3 needed tp call FLIP_READ_STATUS from index/mutations
    // .commit is like .get
    methods:{
        toggleReadStatus() {
            this.$store.commit("FLIP_READ_STATUS",this.book);
        }
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>