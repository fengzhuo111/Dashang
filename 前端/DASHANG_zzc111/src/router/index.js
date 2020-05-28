import Vue from 'vue'
import VueRouter from 'vue-router'
import home from '../views/task_management/home.vue';
import login from '../views/user_management/login';
import register from '../views/user_management/register';
import registeP from '../views/vendor_management/registeP.vue';
import mail_main from "../views/mail_management/mail_main";
import modifyInfo from "../views/user_management/modifyInfo";
import userHome from "../views/task_management/page/user/userHome";
import brand_list from "../views/order_management/brand_list";
import commodity_list from "../views/order_management/commodity_list";
import order_list from "../views/order_management/order_list";
import shopping_cart from "../views/order_management/shopping_cart";
import purchase_task_list from "../views/order_management/purchase_task_list";
import purchase_task_unfinished_list from "../views/order_management/purchase_task_unfinished_list";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: '登录',
    component: login,
    meta:{
      title: "登录-大商电器代理服务平台"
    }
  },
  {
    path: '/purchase_task_list',
    name: 'purchase_task_list',
    component: purchase_task_list
  },
  {
    path: '/purchase_task_unfinished_list',
    name: 'purchase_task_unfinished_list',
    component: purchase_task_unfinished_list
  },
  {
    path: '/shopping_cart',
    name: '购物车',
    component: shopping_cart
  },
  {
    path: '/order_list',
    name: '订单列表',
    component: order_list
  },
  {
    path: '/commodity_list',
    name: '商品列表',
    component: commodity_list
  },
  {
    path: '/brand_list',
    name: '品牌列表',
    component: brand_list
  },
  {
    path: '/register',
    name: '注册',
    component: register,
    meta: {
      title: "注册-大商电器代理服务平台"
    }
  },
  {
    path: '/home',
    name: 'home',
    component: home,
  },
  {
    path: '/registeP',
    name: 'registeP',
    component: registeP
  },
  {
    path: '/mail',
    name: 'mail_main',
    component: mail_main
  },
  {
    path: '/modifyInfo',
    name: 'modifyInfo',
    component: modifyInfo,
    meta: {
      title: "修改信息-大商电器代理服务平台"
    }
  },
  {
    path: '/userHome',
    name: 'userHome',
    component: userHome
  }
]

const router = new VueRouter({
  routes
})

export default router
