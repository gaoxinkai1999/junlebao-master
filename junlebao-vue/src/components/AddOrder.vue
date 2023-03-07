<template>
  <div>
    <el-form :model="order" :rules="rules" ref="order" class="demo-ruleForm" label-position="right" >
      <h3>商家</h3>
      <el-form-item  prop="shop" >
        <el-cascader
            v-model="order.shop"
            :options="a"
            :props="props" style="margin-top:30px;" placeholder="选择商家">
        </el-cascader>
      </el-form-item>
      <h3>日期</h3>
      <el-form-item  prop="date" >
        <el-date-picker
            v-model="order.date"
            type="date"
            placeholder="选择日期" value-format="yyyy-MM-dd" :editable="false">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" round @click="submitForm('order')" style="margin-top:100px;">添加</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
export default {
  name: "AddOrder",
  data() {
    return {
      order: {
        shop: '',
        date: ''
      },
      rules: {
        shop:{ required: true, message: '请输入活动名称', trigger: 'blur' },
        date:{ required: true, message: '请输入活动名称', trigger: 'blur' },
      },
      props: {
        label: 'name',
        value: 'name',
        children: 'shops',
        emitPath: false
      },
      a: []

    }
  },
  methods: {
    //发送添加请求
    addOrder() {
      this.$http.post("/addOrder", this.order).then(res => {
        console.log(res)
      })
    },
    //规则校验
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
         this.open()
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    //确认是否添加
    open() {
      this.$confirm('确认操作?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'info'
      }).then(() => {

        this.addOrder()

        this.$message({
          type: 'success',
          message: '操作成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消操作'
        });
      });
    }

  },
  created() {
    console.log('加载级联选择数据')
    this.$http.post('/getLocationsCascader').then(res => {
      this.a = res.data
    })
  }
}
</script>

<style scoped>

*{
  text-align: center;
}

</style>
