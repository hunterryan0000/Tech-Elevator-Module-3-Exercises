<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <div v-else>
      <h1>{{card.title}}</h1>
      <p>{{card.description}}</p>
    </div>
  </div>
</template>

<script>
import boardService from '@/services/BoardService'

export default {
  name: "card-detail",
  data() {
    return {
      isLoading: true,
      card: {}
    }
  },
  created() {
    
    boardService.getCard(this.$route.params.boardID, this.$route.params.cardID)
      .then( foundCard => {
        // Not using response.data here because in the service there is a 2nd
        // Promise being used that will return specifically 1 card.
        this.card = foundCard;
        this.isLoading = false;
      })
  }
};
</script>
