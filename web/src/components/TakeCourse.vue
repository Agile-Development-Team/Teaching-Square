<template>
  <div>
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
          placeholder="请输入选课密码" 
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="joinCourse('joinForm')">加入</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
    data(){
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

  },
})
</script>

<style scoped>

</style>
