<template>
  <book-details /> <!-- Vue component to list the products on the page -->
</template>

<script> 
 // The '@' is shorthand for the root folder for the app 
 // So, below equals /src/components/BookDetails
import BookDetails from '@/components/BookDetails';
  export default { 
    components: {  //List of Vue components
        BookDetails
    }
  }
</script>