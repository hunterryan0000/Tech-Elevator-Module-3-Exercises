<template>
  <div id="app">
    <!-- If a prop is just a string, you can setup directly like this... -->
    <AppHeader gardenName="The Purple Garden" />
    <main>
      <section>
        <h2>Add a Plant</h2>
        <form v-on:submit.prevent="addNewPlant">
          <div>
            <label for="plant-name">Name:</label>
            <input id="plant-name" type="text" v-model="newPlant.name" />
          </div>
          <div>
            <label for="plant-count">How many will you grow:</label>
            <input id="plant-count" type="number" min="0" v-model="newPlant.count" />
          </div>
          <div>
            <label for="plant-germinate">Number of days for seed to germinate:</label>
            <input id="plant-germinate" type="number" min="0" v-model="newPlant.days" />
          </div>
          <input type="submit" value="Save" />
        </form>
      </section>
      <section>
        <h2>Plants to Grow</h2>
        <!-- If your prop is more complex, like an object/array, bind it -->
        <!-- <PlantTable v-bind:plants="plantArray" /> -->
        <!-- Now that we moved the data to the store, we don't need to pass it as props -->
        <PlantTable />
      </section>
    </main>
    <footer>
      <p>&copy; 2022 January NLR Java Purple Class</p>
    </footer>
  </div>
</template>

<script>
import AppHeader from '@/components/AppHeader';
import PlantTable from '@/components/PlantTable';

export default {
  name: 'App',

  components: {
    AppHeader,
    PlantTable
  },

  methods: {
    addNewPlant(){
      // Add the new plant (from data) to the plantArray (also in data)
      this.$store.state.plantArray.push(this.newPlant);
      this.newPlant = {}
    }
  },

  // Data function must return an object
  // This object has properties for the component
  // These are only visible within the component (encapsulation)
  data() {
    return {
      gardenName: '',
      // OK to not set the properties in the object right away...
      // JS will add properties as you set them
      newPlant: {},
      // Note, moved plantArray into the Vuex store
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
