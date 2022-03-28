<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">

    <!-- Use our new component -->
    <!-- Attributes here are used to set props in the component -->
    <ProductReview title="Cigar Party for Dummies" />

  </div>
</template>

<script>
// These imports bring in code from other files 
// (import comes from using Webpack)
import ProductReview from './components/ProductReview.vue'

// Export is what makes stuff available to import
export default {
  name: 'App',
  // Need to list here all the components used in this component template
  components: {
    ProductReview
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
