import axios from 'axios';

// Service Object
const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

//  Calls the URL /topics
  getTopics() {
//  Returns the promise
    return http.get('/topics');
  },

//   Add a new method to the service object that pulls information
  getMessages(topicId) {
// returns a Promise
    return http.get(`/topics/${topicId}`);
    }
  }