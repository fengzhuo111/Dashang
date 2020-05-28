<template>
    <div id="dsHeader">
        <div class="header">
            <div class="header_left">
                <div><el-image :src="require('../../public/图标.png')" ></el-image></div>
                <span>大商电器代理服务平台</span>
            </div>
            <div class="header_right">
                <span>
                    <el-button type="text" @click="toMail" style="color: #ecf0f1; font-size: 20px;"><i class="el-icon-message"></i> 我的邮件</el-button>
                </span>
                <img :src="avatarURL" :alt="username"/>
                <el-dropdown>
                    <span id="el-dropdown-link">
                        {{this.$store.state.username}}
                        <i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item icon="el-icon-house">
                            <el-button @click="toHome" type="text">用户主页</el-button>
                        </el-dropdown-item>
                        <el-dropdown-item icon="el-icon-edit">
                            <el-button @click="toModifyInfo" type="text">设置</el-button>
                        </el-dropdown-item>
                        <el-dropdown-item icon="el-icon-switch-button">
                            <el-button @click="logout" type="text">注销</el-button>
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Header",
        data(){
            return{
                avatarURL: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',  // 登录成功后动态获取
                username: '一只鱼',  // 登录成功后动态获取
                }
        },
        methods: {
            toMail(){
                // window.sessionStorage.clear()
                this.$router.push('/mail')
            },
            toHome(){
                // window.sessionStorage.clear()
                this.$router.push('/home')
            },
            logout() {
                // 清空token
                window.sessionStorage.clear()
                this.$router.push('/login')
            },
            toModifyInfo(){
                this.$router.push('/modifyInfo')
            }
        }
    }
</script>

<style scoped>
    #dsHeader {
        width: 100%;
        height: 60px;
        background: #373f41;
    }

    .header {
        width: 100%;
        height: 60px;
        background: #373f41;
    }

    .header_left {
        width: 300px;
        height: 60px;
        background: #373f41;
        float: left;
    }

    .header_right {
        position: absolute;
        right: 0;
        height: 60px;
        background: #373f41;
        float: right;
    }

    .header_left > div {
        width: 60px;
        height: 50px;
        float: left;
        margin: 5px 0 5px;
        background: #373f41;
    }

    .header_left > span {
        float: right;
        line-height: 40px;
        font-weight: bold;
        font-size: 20px;
        color: #ffffff;
        margin: 10px 5px 10px;
    }

    .header_right > img {
        width: 45px;
        height: 45px;
        border-radius: 50%;
        margin: 8px 10px 5px 10px;
        float: left;
    }

    .header_right > span {
        margin: 9px 15px 10px;
        float: left;
    }

    #el-dropdown-link {
        cursor: pointer;
        color: #ecf0f1;
        font-size: 20px;
        margin: 18px 10px 10px;
        float: left;
    }
    .el-icon-arrow-down {
        font-size: 12px;
    }
</style>
