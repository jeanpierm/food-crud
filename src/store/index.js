import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    alimentSelected: {
      id: null,
      name: "",
      stock: null,
      price: null,
    },
  },
  mutations: {
    setEditForm({ alimentSelected }, aliment) {
      if (aliment) {
        alimentSelected.id = aliment.id;
        alimentSelected.name = aliment.name;
        alimentSelected.stock = aliment.stock;
        alimentSelected.price = aliment.price;
      } else {
        alimentSelected.id = null;
        alimentSelected.name = "";
        alimentSelected.stock = null;
        alimentSelected.price = null;
      }
    },
  },
  actions: {
    setEditForm({ commit }, payload) {
      commit("setEditForm", payload);
    },
  },
  modules: {},
});
