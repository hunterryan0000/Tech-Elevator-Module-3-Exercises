<template>
  <div class="form">
      <form class="new-book-form" v-on:submit.prevent="addNewBook">
        <div class="title">
            <label for="title">Title</label>
                <input class="title-input" id="title" 
               type="text" v-model="newBook.title"/></div>
        <div class="author">
            <label for="author">Author</label>
                <input class="author-input" id="author" 
               type="text" v-model="newBook.author"/></div>
        <div class="isbn">
            <label for="isbn">ISBN</label>
                <input class="isbn-input" id="isbn"
               type="text" v-model="newBook.isbn"/></div>
        <input type="submit" value="Save"/>
  </div>
</template>

<script>
export default {
    name:"add-book",
    data() {
        return {
            newBook:{
                read:false
            }
        }
    },
    methods:{
    addNewBook() {
      this.$store.commit("ADD_BOOK", 
      this.newBook)
      this.resetForm();
    },
    resetForm() {
      this.showForm = false;
      this.newBook = {};
        }
    }
}
</script>

<style>
form {
  display: flex;
  align-items: center;
}
</style>