<template>
  <div>
    <el-row class="subTitle">
      <el-col :span=12 >标题</el-col>
      <el-col :span=4>发布时间</el-col>
      <el-col :span=4>内容</el-col>
      <el-col :span=4>操作</el-col>
    </el-row>
    <el-row
      v-for="index in this.$store.state.selectCoursewares"
      :key="index['pptId']"
    >
      <el-col :span=12>{{index['pptName']}}</el-col>
      <el-col :span=4>{{index['publishedTime']}}</el-col>
      <el-col :span=4>{{index['content']}}</el-col>
      <el-col :span=4>
        <el-button @click="handleCourseware(index['pptId'])">下载</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
  data(){
    return {
    }
  },
  methods: {
      handleCourseware(pptId){
        console.log(pptId)
      },
  },
  setup() {
    
  },
})
</script>

<style scoped>
.subTitle{
  font-size: 20px;
  margin-top: 10px;
  margin-bottom: 10px;
  font-weight: bold;
  color: #47505a;
}
</style>
