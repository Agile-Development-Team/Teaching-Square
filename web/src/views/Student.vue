<template>
  <div class="classInf">
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
    return{

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
    }
  }
})
</script>

<style scoped>

</style>
