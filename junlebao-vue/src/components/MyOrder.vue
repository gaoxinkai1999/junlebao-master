<template>
  <div>
    <template>
      <el-table
          :data="a"
          style="width: 100%" max-height="600" height="600">
        <el-table-column
            prop="date"
            label="最远日期"
           style="width: 30%" align="center" sortable>
        </el-table-column>
        <el-table-column
            prop="time_space"
            label="距今天数"
            style="width: 20%" align="center" sortable>
        </el-table-column>
        <el-table-column
            prop="shop"
            label="店铺"
            style="width: 20%" align="center" sortable>
        </el-table-column>
        <el-table-column
            prop="location"
            label="地址" style="width: 20%" align="center" sortable>
        </el-table-column>
      </el-table>
    </template>
  </div>
</template>

<script>
export default {
  name: "MyOrder",
  data() {
    return {
      a: []

    }
  },
  created(){
    console.log('加载order数据')
    this.$http.post('/getOrders').then(res=>{
      this.a=res.data
    })
  }
}
</script>

<style scoped>
.el-table-column{
  /*align-content: center;*/
}
</style>
