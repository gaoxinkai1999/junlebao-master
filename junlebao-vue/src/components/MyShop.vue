<template>

  <div style="text-align: center">
    <el-table
        :data="a"
        style="width: 100%" max-height="400" height="400">
      <el-table-column
          prop="location"
          label="地区"
          align="center" sortable>
      </el-table-column>
      <el-table-column
          prop="name"
          label="商家名"
          align="center" sortable>
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          align="center">
        <template slot-scope="scope">
          <el-button @click="delShop(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-form label-position="right" label-width="80px" :model="shop" style="margin-top:10%" :rules="rules" ref="shop">
      <el-form-item label="地区" prop="location">
        <el-input v-model="shop.location" style="width: 50%" ></el-input>
      </el-form-item>
      <el-form-item label="商家名" prop="name">
        <el-input v-model="shop.name" style="width: 50%"></el-input>
      </el-form-item>
      <el-form-item >
        <el-button type="primary" round style="margin-top:5%" @click="submitForm('shop')">添加商家</el-button>
      </el-form-item>
    </el-form>




  </div>
</template>

<script>
export default {
  name: "MyShop",
  data() {
    return {
      a: [],
      shop:{
        name:'',
        location:''
      },
      rules: {
        name:{ required: true, message: '请输入商家名', trigger: 'blur' },
        location:{ required: true, message: '请输入地区', trigger: 'blur' },
      },
    }
  },
  methods: {
    delShop(row) {
      this.$confirm('此操作将永久删除该商家, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.post("/delShop",row);
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
        this.$forceUpdate()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    addShop() {
      this.$confirm('确认添加?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'info'
      }).then(() => {
        //检查是否重复
        let isDouble=false;
        for (const shop of this.a) {
          if (shop.name===this.shop.name){
            console.log("重复")
            isDouble=true;
          }
        }
        if (isDouble){
          this.$message({
            type: 'error',
            message: '该商家已存在,请勿重复添加'
          });
        }else {
          //发送请求
          this.$http.post("/addShop",this.shop);
          this.$message({
            type: 'success',
            message: '添加成功!'
          });
        }

        this.getShops()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消添加'
        });
      });
    },
    //规则校验
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.addShop()
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    getShops(){
      this.$http.post('/getShopsList').then(res=>{
        this.a=res.data
      })
    }
  },
  created(){
    console.log('加载shop数据')
    this.getShops()
  },
  updated(){
    this.getShops()
  }
}
</script>

<style scoped>

</style>
