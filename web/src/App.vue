<template>
  <NavBar/>
  <router-view></router-view>
</template>

<script>
import NavBar from '@/components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"


export default {

    components: { NavBar },
    setup() {
      // $.ajax({
      //   url: "http://127.0.0.1:3000/user/account/token/",
      //   type: "post",
      //   data: {
      //     username: 'yangfanou',
      //     password: '123456'
      //   },
      //   success(resp) {
      //     console.log(resp);
      //   },
      //   error(resp) {
      //     console.log(resp);
      //   }
      // })
      // $.ajax({
      //   url: "http://127.0.0.1:3000/user/account/info/",
      //   type: "get",
      //   headers: {
      //     Authorization:"Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMzI4NzY5OTc2M2Y0ZTdjOTVhODRjYWY4MDBjOTZkYSIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY2MjA5NTU1NCwiZXhwIjoxNjYzMzA1MTU0fQ.ouMTsWNhwr_SUyV3Ve8bnYwTRYJeSgZjkMr2lTHtniM"

      //   },
      //   success(resp) {
      //     console.log(resp);
      //   },
      //   error(resp) {
      //     console.log(resp);
      //   }
      // })
      
    }
}

</script>

<style>
body{
  background-image: url(@/assets/images/background.png);
  background-size: cover;
}
</style>
