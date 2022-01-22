import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    courses: [],
    selectCourse: {},
  },
  mutations: {
    CHANGE_COURSES(state, payload){
      state.courses = payload;
    },
    CHANGE_SELECTCOURSE(state, payload){
      state.selectCourse = payload;
    },
  },
  actions: {
  },
  modules: {
  }
})
