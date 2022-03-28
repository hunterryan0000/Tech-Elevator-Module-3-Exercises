<template>
<div>
    <div class = "product-reviews">
        <h2>Product Review for {{name}}</h2>
        <p class="description"> {{description}} </p>
    </div>
</div>
</template>

<script>
export default {
    name: 'ProductReview',
    data() {
        return {
            name: 'Cigar Parties for Dummies',
            description: 'Host & plan the perfect party for all your squirelly friends.'
        }
    }

}
</script>

<style scoped>
div.product-reviews {
    background-color: aquamarine;
    margin: 1rem 0;
}
</style>