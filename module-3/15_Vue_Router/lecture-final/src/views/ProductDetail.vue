<template>
  <div id="app" class="main">
    <h1>{{product.name}}</h1>
    <p class="description">{{product.description}}</p>
    <div class="actions">
      <router-link to="/">Back to Products</router-link>&nbsp;|
      <router-link v-bind:to="{name:'add-review', params: {id: product.id}}">Add Review</router-link>
    </div>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <review-list />
  </div>
</template>

<script>
import AverageSummary from '../components/AverageSummary.vue';
import ReviewList from '../components/ReviewList.vue';
import StarSummary from '../components/StarSummary.vue';

export default {
  components: { AverageSummary, StarSummary, ReviewList },
    created() {
        // When the component is created, do whatever is in this method.
        // This is a Vue life-cycle method. It must be called 'created'

        // Get the :id route parameter
        const productId = Number(this.$route.params.id);
        this.$store.commit('SET_ACTIVE_PRODUCT', productId);
    },
    computed: {
      product() {
        return this.$store.state.products.find( item => 
            item.id === this.$store.state.activeProduct );
      }
    }
}
</script>

<style>

</style>