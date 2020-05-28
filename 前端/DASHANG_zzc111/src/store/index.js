import Vue from 'vue'
import Vuex from 'vuex'
import toastRegistry from '../views/mail_management/mail_com/toastindex'

Vue.use(Vuex);
Vue.use(toastRegistry);

const store=new Vuex.Store({
    state:{//全局变量
        username: 'userName-test',
        usertype: '',
        IDNumber: '111102199999999999',
        email: '7777@qq.com',
        telephone: '13941893655',
        address: '辽宁省大连市中山区高尔基路48号',
    },
    getters:{// store的计算属性
        getStateCount:function (state) {
            return state.usertype;
        }
    },
    mutations:{// 用于改变全局变量
        changeUsertype(state,Vtype){
            state.usertype=Vtype;
        },
        setUserName(state,data){
            state.username = data
        }
    },
    actions:{// 用于提交mutations
        changeUsertypeFun(context,Vtype){
            context.commit("changeUsertype",Vtype);
        },
        commitUserName({commit},data){
            commit('setUserName',data)
        }
    }
})

export default store
