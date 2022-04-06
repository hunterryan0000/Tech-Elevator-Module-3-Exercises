<template>
  <div class="topic-list">
    <div v-for="topic in topics" v-bind:key="topic.id" class="topic">
      <!-- Update the `TopicList` component to add links to the topic 
      name that go to the `Messages` route. -->
    <router-link v-bind:to="{name: 'Messages', params:{id:topic.id}}">
      {{ topic.title }}
    </router-link>
    </div>
  </div>
</template>

<script>

// Update the `TopicList` component to use the service object 
  // to load in the topic data, and assign it to the 
  // component's `topics` data property.
import topicsService from '@/services/TopicsServices';

export default {
  name: 'topic-list',
  data() {
    return {
      topics: []
    }
  },
  // Update the `TopicList` component to use the service object 
  // to load in the topic data, and assign it to the 
  // component's `topics` data property.
  created() {
    topicsService.getTopics().then(response => {
      this.topics = response.data;
    });
  }
}
</script>

<style>
.topic-list {
  padding: 20px 20px;
  margin: 0 auto;
  max-width: 600px;
}
.topic {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
}
.topic:last-child {
  border: 0px;
}
</style>