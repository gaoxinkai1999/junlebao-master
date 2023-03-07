<template>
  <div >
    <h1 style="text-align: center">管理平台</h1>
    <el-menu  class="el-menu-demo" router mode="horizontal"  menu-trigger="click" :default-active="$route.path"  :modal-append-to-body=true>
      <el-menu-item index="/AddOrder">添加订单</el-menu-item>
      <el-menu-item index="/MyShop">商家管理</el-menu-item>
      <el-menu-item index="/MyOrder">日期管理</el-menu-item>

    </el-menu>
    <router-view></router-view>

<!--    <div class="block">-->
<!--      <span class="demonstration">默认 click 触发子菜单</span>-->
<!--      <el-cascader-->
<!--          v-model="value"-->
<!--          :options="demo"-->
<!--          :props="props"-->
<!--          @change="handleChange"></el-cascader>-->
<!--    </div>-->


  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      activeIndex:'1',

      demo: [
        {
          name: '姚村',
          children: [{
            name: '金虎'}],}
      ]

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
