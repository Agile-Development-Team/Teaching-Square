<template>
<<<<<<< HEAD
  <div class="student-course">
    <div class="title">
      {{this.$store.state.selectCourse['courseName']}} {{this.$store.state.selectCourse['number']}}
    </div>
    <el-tabs
      tab-position="left" 
      style="height: 400px;"
    >
      <el-tab-pane label="总览" :key="1">1</el-tab-pane>
      <el-tab-pane label="签到" :key="2">2</el-tab-pane>
      <el-tab-pane label="作业" :key="3"><Homework></Homework></el-tab-pane>
      <el-tab-pane label="资源" :key="4"><Courseware></Courseware></el-tab-pane>
      <el-tab-pane label="课堂小测" :key="5">5</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
// import { defineComponent } from '@vue/composition-api'
import Courseware from '@/components/Courseware.vue'
import Homework from '@/components/Homework.vue'
export default({
  
  components: {
    Courseware,
    Homework
  },
  data(){
    return{

    }
  },
=======
  <div>{{this.$store.state.selectCourse['courseName']}} {{this.$store.state.selectCourse['number']}}</div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
>>>>>>> b240bfbbe8e65a4aba5924bba989ba1a35a3e8a8
  setup() {
    
  },
})
</script>

<style scoped>
<<<<<<< HEAD
.title {
  font-size: 2rem;
  margin-top: 2rem;
  margin-bottom: 1rem;
  text-align: left;
  font-weight: bold;
  color: #1e61a3;
  
}
=======

>>>>>>> b240bfbbe8e65a4aba5924bba989ba1a35a3e8a8
</style>
