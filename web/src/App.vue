<template>
<div>name: {{ name }}</div>
<div>grade: {{grade}}</div>
</template>

<script>
import $ from 'jquery';
import { ref } from 'vue';

export default {
  name: "App",
  setup: () => {
    let name = ref("");
    let grade = ref("");
    $.ajax({
      url:"http://localhost:3000/pk/getInfo/",
      type:"get",
      success: resp => {
        name.value = resp.name;
        grade.value = resp.grade;
      }
    });
    return {
      name,
      grade
    }
  }
}

</script>

<style>
body{
  background-image: url(@/assets/background.png);
  background-size: cover;
}
</style>
