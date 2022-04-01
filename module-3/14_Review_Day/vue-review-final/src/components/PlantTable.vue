<template>
  <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Count</th>
            <th>Days to Germinate</th>
        </tr>
        </thead>
        <tbody>
            <!-- We moved data to the Vuex store, so accessing from $store 
                 (`this` is not needed w/ vue directives) -->
        <PlantTableRow v-for="item in $store.state.plantArray" v-bind:plant="item" v-bind:key="item.id" />
        </tbody>
    </table>
</template>

<script>
import PlantTableRow from '@/components/PlantTableRow';
export default {
    name: "PlantTable",
    components: {
        PlantTableRow
    },
    // Moved data to the Vuex store, don't need the prop anymore
    // props: {
    //     plants: Array
    // }
}
</script>

<style>

</style>