<template>
<!-- 主页列出所有课程 在选课时输入选课密码选课 -->
  <div class="home">
    <p>Home</p>
    <el-collapse 
      class="courses-list" 
      v-model="activeNames" 
      @change="handleChange" 
      accordion
    >
      <el-collapse-item 
        class="course-item"
        v-for="index in this.$store.state.allCourses" 
        :key="index['courseId']" 
        :title="index['courseName']"
        :name="index['courseId']"
      >
        <TakeCourse></TakeCourse>
      </el-collapse-item>
    </el-collapse>
    <el-button @click="getCourses">TEST</el-button>
  </div>
</template>

<script>
// @ is an alias to /src

import TakeCourse from '@/components/TakeCourse.vue'

export default {
  name: 'Home',
  components: {
    TakeCourse
  },
  data () {
    return {
      activeNames: '',
    }
  },
  methods: {
    getCourses(){
      console.log(this)
      this.$axios.get('http://localhost:8888/allCourses').then(res => {
        alert("请求成功，response=" + res.data);
        // data = res.data;
        console.log(res);
      });
    },
    handleChange(val) {
      console.log(val);
    }
  }
}
</script>

<style scoped>
.courses-list{
  width: 500px;
  margin:20px auto;
  background-color: #fff;
  padding: 20px 40px 20px 20px;
  border-radius: 5px;
  box-shadow: 0px 5px 10px #cccc;
}
.course-item{
  width: 500px;
}
</style>
