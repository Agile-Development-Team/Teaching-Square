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
    <!-- <el-button @click="getCourses">TEST</el-button> -->
    <Footer />
  </div>
</template>

<script>
// @ is an alias to /src

import TakeCourse from '@/components/TakeCourse.vue'
import Footer from "@/components/Footer";
export default {
  name: 'Home',
  components: {
    TakeCourse,
    Footer
  },
  data () {
    return {
      activeNames: '',
    }
  },
  mounted:function () {
    this.getCourses();
  },
  methods: {
    getCourses(){
      console.log(this)
      this.$axios.get('http://localhost:8888/course').then(res => {
        // data = res.data;
        var allCourses=[]
        for(var course in res.data){
          console.log(res.data[course]['courseId'])
          allCourses.push({
            courseId: res.data[course]['courseId'],
            courseName: res.data[course]['courseName'],
            teacherName: res.data[course]['teacherName']
          })
        }
        this.$store.commit("CHANGE_ALLCOURSES", allCourses);
        console.log(res);
      });
    },
    handleChange(val) {
      this.$store.commit("CHANGE_CHOOSECOURSEID", val);
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
