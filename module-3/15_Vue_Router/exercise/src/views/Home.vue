<template>
    <div>  
        <best-seller-list />  <!-- Vue component to list the products on the page -->
        <new-releases-list />
    </div>  
</template>

<script>
 // The '@' is shorthand for the root folder for the app
import BestSellerList from '@/components/BestSellerList'
import NewReleasesList from '@/components/NewReleasesList'
export default {
components: { //List of Vue components
    BestSellerList,
    NewReleasesList
    }
}
</script> 