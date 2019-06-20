import Vue from "vue";
import Vuex from "vuex";
import { mutations } from "./store/mutations";
import { actions } from "./store/actions";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    projects: []
  },
  mutations: {
    ...mutations
  },
  actions: {
    ...actions
  }
});
