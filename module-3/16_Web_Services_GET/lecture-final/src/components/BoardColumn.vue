<template>
  <div class="board">
    <h2>{{ title }}</h2>
    <div class="cards">
      <board-card v-for="card in cards" v-bind:key="card.id"
          v-bind:card="card" v-bind:boardID="boardID" />
    </div>
  </div>
</template>

<script>
import BoardCard from '@/components/BoardCard'
export default {
  name: 'board-column',
  components: { BoardCard },
  props: ['title', 'cards', 'boardID']
};
</script>

<style scoped>
.board {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 0 20px 20px 20px;
}
</style>
