<template> 
    <div class='my-books'>  
        <reading-list />   
        <div id="nav">
            <router-link to="/addBook">Add Book to Reading List</router-link>
        </div> 
    </div>
</template>

<script>
import ReadingList from '@/components/ReadingList'
export default {
components: {
    ReadingList
    }
}
</script>

<style scoped></style>  

