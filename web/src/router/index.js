import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register.vue')
  },
  {
    path: '/student',
    name: 'Student',
    component: () => import('../views/Student.vue')
  },
  {
    path: '/studentcourse',
    name: 'StudentCourse',
    component: () => import('../views/Studentcourse.vue')
  },
  {
    path:'/teacherhome',
    name:'TeacherHome',
    component:()=>import('../components/teacher/TeacherHome.vue')
  },
  {
    path:'/teacher',
    name:'Teacher',
    component:()=>import('../components/teacher/Teacher.vue'),
  },
  {
    path: '/:catchAll(.*)',
    name: '/404',
    component: () => import('../views/404.vue')
  },
 
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
