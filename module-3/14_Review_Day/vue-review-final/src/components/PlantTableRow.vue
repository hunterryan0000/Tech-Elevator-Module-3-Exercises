<template>
    <tr>
        <td>{{plant.name}}</td>
        <td>{{plant.count}}</td>
        <td>{{plant.days}}</td>
    </tr>
</template>

<script>
export default {
    name: 'PlantTableRow',
    props: {
        plant: Object
    }
}
</script>

<style>

</style>