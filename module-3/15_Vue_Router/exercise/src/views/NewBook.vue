<template>
    <div>
        <new-book-form /> <!-- Vue component to list the products on the page -->
    </div>
</template>

<script>
 // The '@' is shorthand for the root folder for the app
import NewBookForm from '@/components/NewBookForm.vue'
export default {
    components: { //List of Vue components
        NewBookForm
    }
}
</script>