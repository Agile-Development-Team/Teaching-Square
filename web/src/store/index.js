import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
<<<<<<< HEAD
    // 课程列表
    courses: [],
    // 选择进入详细课程界面的课程信息
    selectCourse: {},
    // 课件列表
    selectCoursewares: [
      {
        pptId: '',
        pptName: '教师尚未上传任何内容',
        publishedTime: '-',  
        content: '-'
      }
    ],
    // 作业列表
    selectHomeworks: [
      {
        homeworkId: '01',
        homeworkName: '教师尚未布置任何作业',
        deadline: '2022-1-23',  
        grade: '100分'
      },
    ],
    // 为1展示作业列表，为2展示具体作业内容
    showOneHomework: '1',
    // 具体作业内容
    selectedHomework: {
      homeworkId: '01',
      homeworkName: '教师尚未布置任何作业',
      deadline: '2022-1-23',  
      grade: '100分',
      description: '作业描述……',
      content: '作业内容……',
      status: '0', // 0作业不可提交，1作业可提交
      percentage: '5%',
    }
=======
    courses: [],
    selectCourse: {},
>>>>>>> b240bfbbe8e65a4aba5924bba989ba1a35a3e8a8
  },
  mutations: {
    CHANGE_COURSES(state, payload){
      state.courses = payload;
    },
    CHANGE_SELECTCOURSE(state, payload){
      state.selectCourse = payload;
    },
<<<<<<< HEAD
    CHANGE_SELLECTCOURSEWARES(state, payload){
      state.selectCoursewares = payload;
    },
    CHANGE_SHOWONEHOMEWORK(state, payload){
      state.showOneHomework = payload;
    },
    CHANGE_SELECTEDHOMEWORK(state, payload){
      state.selectedHomework = payload;
    },
=======
>>>>>>> b240bfbbe8e65a4aba5924bba989ba1a35a3e8a8
  },
  actions: {
  },
  modules: {
  }
})
