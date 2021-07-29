import { createStore } from 'vuex';

export default createStore({
  state: {
    drawer: false,
    links: [
      { title: 'Main', icon: 'mdi-view-dashboard', to: '/' },
      { title: 'hihi', icon: 'mdi-view-dashboard', to: '/hihi' },
      { title: 'data', icon: 'mdi-view-dashboard', to: '/data' },
    ]

  },
  getters: {
    getDrawer: state => state.drawer

  },
  mutations: {
    setDrawer(state, data) {
      console.log("mutations state >> ", state)
      console.log("mutations data >> ", data)
      state.drawer = data
    }

  },
  actions: {
    toggleDrawer({ commit }, value) {
      commit('setDrawer', value)
    }

  }
})
