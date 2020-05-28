import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Echarts from 'echarts'
import './plugins/element.js'
import './assets/css/global.css'

import axios from 'axios'
axios.defaults.baseURL = 'http://127.0.0.1:8888/api/private/v1/'
Vue.prototype.$http = axios;
Vue.prototype.$echarts=Echarts;
Vue.config.productionTip = false;

router.beforeEach((to, from, next) => {
  window.document.title = to.meta.title == undefined?'大商电器代理服务平台':to.meta.title
  if (to.meta.requireAuth) {
    let token = Cookies.get('access_token');
    let anonymous = Cookies.get('user_name');
    if (token) {

      next({
        path: '/login',
        query: {
          redirect: to.fullPath
        }
      })

    }
  }
  next();
})

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
