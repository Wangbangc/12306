<template>
  <el-table :data="manager"  style="width: 100%">
    <el-table-column prop="name" label="Date" width="180" />
    <el-table-column prop="password" label="Name" width="180" />
    <el-table-column prop="phone" label="Name" width="180" />
    <el-table-column prop="status" label="Address" />
  </el-table>
</template>
<script>
export default {

  data(){
    return{
      ma:{

      },
      manager:[

      ],



    }
  },
  created() {
    this.axios.get('http://localhost:8080/manager/test/1').then((resp) => {

     this.manager= resp.data.data;
      console.log(resp.data.data);


    })
  },
  methods: {}
}
</script>
