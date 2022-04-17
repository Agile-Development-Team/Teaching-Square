import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // 数据库中存在的所有课程
    allCourses: [],
    // 用户是否登录
    isUp: false,
    // 登录用户的账号
    number: '',
    // 用户身份，1为学生，2为教师
    identity: 0,
    // 选课的课程ID
    chooseCourseId: 0,
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
      status: '0', // 0作业未提交，1作业已提交
      percentage: '5%',
    }
  },
  mutations: {
    CHANGE_ALLCOURSES(state, payload){
      state.allCourses = payload;
    },
    CHANGE_ISUP(state, payload){
      state.isUp = payload;
    },
    CHANGE_NUMBER(state, payload){
      state.number = payload;
    },
    CHANGE_IDENTITY(state, payload){
      state.identity = payload;
    },
    CHANGE_CHOOSECOURSEID(state, payload){
      state.chooseCourseId = payload;
    },
    CHANGE_COURSES(state, payload){
      state.courses = payload;
    },
    CHANGE_SELECTCOURSE(state, payload){
      state.selectCourse = payload;
    },
    CHANGE_SELLECTCOURSEWARES(state, payload){
      state.selectCoursewares = payload;
    },
    CHANGE_SELECTHOMEWORKS(state, payload){
      state.selectHomeworks = payload;
    },
    CHANGE_SHOWONEHOMEWORK(state, payload){
      state.showOneHomework = payload;
    },
    CHANGE_SELECTEDHOMEWORK(state, payload){
      state.selectedHomework = payload;
    },
    CLEAR(state){
      state.isUp=false;
      state.number='';
      state.identity=0;
      state.chooseCourseId=0;
      state.courses=[];
      state.selectCourse={};
      state.selectCoursewares=[];
      // 为1展示作业列表，为2展示具体作业内容
      state.showOneHomework='1'; 
    }
  },
  actions: {
  },
  modules: {
  }
})
