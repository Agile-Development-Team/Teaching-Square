<template>
  <div class="classInf">
<<<<<<< HEAD
    <el-form
      ref="joinForm"
      :inline="true" 
      class="demo-form-inline"
      :model="joinForm" 
      :rules="joinRules" 
    >
      <el-form-item label="选课" prop="code">
        <el-input 
          v-model="joinForm.code" 
          placeholder="请输入选课码" 
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="joinCourse('joinForm')">加入</el-button>
      </el-form-item>
    </el-form>
=======
>>>>>>> b240bfbbe8e65a4aba5924bba989ba1a35a3e8a8
    <el-row
      v-for="index in this.$store.state.courses"
      :key="index['courseId']"
    >
      <el-col>
        <el-button 
          @click="handleCourse(index['courseId'],index['courseName'],index['number'])" 
          class="course-btn"
          >{{index['courseId']}} {{index['courseName']}} {{index['number']}}
        </el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
  data(){
<<<<<<< HEAD
    // var validateCode = (rule, value, callback) => {
    //   if (value === '') {
    //     callback(new Error('请输入选课码'));
    //   } else {
    //     callback();
    //   }
    // };
    return{
      joinForm: {
        code: ''
      },
      joinRules: {
        code: [
          { required: true, trigger: 'change' }
        ]
      }
=======
    return{

>>>>>>> b240bfbbe8e65a4aba5924bba989ba1a35a3e8a8
    }
  },
  methods: {
    handleCourse(courseId, courseName, number){
      var course = {
        courseId: courseId,
        courseName: courseName,
        number: number
      }
      this.$store.commit("CHANGE_SELECTCOURSE", course);
      this.$router.replace('/studentcourse')
<<<<<<< HEAD
    },
    joinCourse(formName){
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
          // this.$router.replace('/student')
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },

=======
    }
>>>>>>> b240bfbbe8e65a4aba5924bba989ba1a35a3e8a8
  }
})
</script>

<style scoped>

</style>
