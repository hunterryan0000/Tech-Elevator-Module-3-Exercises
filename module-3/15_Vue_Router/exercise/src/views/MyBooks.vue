<template> 
    <div>  
        <reading-list />   <!-- Vue component to list the products on the page -->
        <div id="nav">
            <router-link to="/addBook">Add Book to Reading List</router-link>
        </div> 
    </div>
</template>

<script>
 // The '@' is shorthand for the root folder for the app
 // So, below equals /src/components/ReadingList
import ReadingList from '@/components/ReadingList'
export default { 
components: { //List of Vue components
    ReadingList
    }
}
</script> 