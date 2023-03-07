import Vue from "vue";
import VueRouter from "vue-router";
import AddOrder from "@/components/AddOrder";
import MyShop from "@/components/MyShop";
import MyOrder from "@/components/MyOrder";


Vue.use(VueRouter)
const vueRouter = new VueRouter({
    routes:[
        {path:'/AddOrder',component:AddOrder,name:'AddOrder'},
        {path:'/MyShop',component:MyShop,name:'MyShop'},
        {path:'/MyOrder',component:MyOrder,name:'MyOrder'},

    ]
});
export default vueRouter
