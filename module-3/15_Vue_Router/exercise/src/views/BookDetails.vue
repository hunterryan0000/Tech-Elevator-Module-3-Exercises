<template>
    <div id="app" class="main">
        <h1> {{ bookDetails.title }} </h1>
        <h1> {{ bookDetails.author }} </h1>
        <br>
        <img v-if="bookDetails.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + bookDetails.isbn + '-M.jpg'" />
        <br>
        <h3 v-if="bookDetails.read">I have read this book.</h3>
        <h3 v-if="!bookDetails.read">I have not read this book.</h3>
    </div>
</template>

<script>
export default {
    name: "book-details",
    computed: {
        bookDetails() {
            return this.$store.state.books.find((book) => {
                return book.isbn == this.$route.params.isbn
            });
        }
    }
}
</script>