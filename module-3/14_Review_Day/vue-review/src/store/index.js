import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        plantArray: [
            {
              name: 'Broccoli',
              count: 2,
              days: 4
            },
            {
              name: 'Leeks',
              count: 10,
              days: 7
            },
            {
              name: 'Onion',
              count: 20,
              days: 6
            },
            {
              name: 'Pumpkin',
              count: 6,
              days: 4
            },
          ]
    },
    mutations: {

    },
    actions: {

    },
    modules: {
        
    }
})