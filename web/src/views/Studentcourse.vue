<template>
  <div>{{this.$store.state.selectCourse['courseName']}} {{this.$store.state.selectCourse['number']}}</div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
  setup() {
    
  },
})
</script>

<style scoped>

</style>
