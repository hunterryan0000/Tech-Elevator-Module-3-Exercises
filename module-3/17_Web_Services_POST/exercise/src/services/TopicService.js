import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },

  get(id) {
    return http.get(`/topics/${id}`);
  },

// performs a `POST` request to the URL `/topics`, and returns a Promise.
  addTopic(topic) {
    return http.post(`/topics/`, topic);
  },                                        

// performs a `PUT` request to the URL `/topics/:id`, and returns a Promise.
  updateTopic(topic) {
    return http.put(`/topics/${ topic.id }`, topic)
  },

// performs a `DELETE` request to the URL `/topics/:id`, and returns a Promise.
  deleteTopic(topic) {
    return http.delete(`/topics/${ topic }`)
  }

}
