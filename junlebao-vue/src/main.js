import Vue from 'vue'
import App from './App.vue'
import axios from "axios";

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from "@/store/store";
import router from "@/router/index";

axios.defaults.baseURL = 'http://47.243.129.90:8085'
// axios.defaults.baseURL = 'http://127.0.0.1:8085'
Vue.prototype.$http = axios
Vue.config.productionTip = false
Vue.use(ElementUI)
new Vue({
  render: h => h(App),
  router:router,
  store
}).$mount('#app')
