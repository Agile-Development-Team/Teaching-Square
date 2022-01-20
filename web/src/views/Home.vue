<template>
  <div class="home">
    <p>Home</p>
    <el-row>
      <el-button @click="hanldeTeacher" type="primary">我是教师</el-button>
      <el-button @click="hanldeStudent" type="success">我是学生</el-button>
    </el-row>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'Home',
  components: {
  },
  data () {
    return {
    }
  },
  methods: {
    hanldeTeacher () {
      this.$router.replace('/login')
    },
    hanldeStudent () {
      this.$router.replace('/login')
    }
  }
}
</script>
