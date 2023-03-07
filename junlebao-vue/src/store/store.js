// 初始化一个vuex的实例（数据仓库） 导出即可
import Vuex from 'vuex'
import Vue from 'vue'
// 使用安装
Vue.use(Vuex)
// 初始化
const store = new Vuex.Store({
// 配置（state|mutations|actions）
    state:{
        teams:[]
    },
    mutations:{
        add(state,team){
            state.teams.push(team)
        },

    },
    actions:{}
})
export default store
