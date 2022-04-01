<template>
  <div class="book-container">
    <!-- STEP 1 add bookcard component for each book-->
    <book-card
      v-for="book in $store.state.books"
      v-bind:key="book.title"
      v-bind:book="book"/>
  </div>
</template>

<script>
// STEP 1 import bookcard and add bookcard component for each book
import BookCard from "./BookCard.vue";
export default {
    name: 'reading-list',
    components:{BookCard}
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>