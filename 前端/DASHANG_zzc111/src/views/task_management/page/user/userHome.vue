<template>
    <div class="userHome">
        <img :src="avatarURL" :alt="username"/>
        <div>
            <div>
                <div>用户名：</div>
                <div>E-mail：</div>
                <div>身份证号：</div>
                <div>联系电话：</div>
                <div>收货地址：</div>
                <div><el-button type="primary" icon="el-icon-edit" @click="toModifyInfo">设置</el-button></div>
            </div>
            <div>
                <div>{{this.$store.state.username}}</div>
                <div>{{this.$store.state.email}}</div>
                <div>{{this.$store.state.IDNumber}}</div>
                <div>{{this.$store.state.telephone}}</div>
                <div>{{this.$store.state.address}}</div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "userHome",
        data() {
            return {
                avatarURL: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',  // 登录成功后动态获取
                username: '一只鱼',  // 登录成功后动态获取
                IDNumber: '111102199999999999',
                email: '1235646231@qq.com',
                telephone: '13941893655',
                address: '辽宁省大连市中山区高尔基路48号'
            }
        },
        methods:{
            toModifyInfo(){
                this.$router.push('/modifyInfo')
            }
        }

    }
</script>

<style scoped>
    .userHome{
        height: calc(100vh - 140px);
        width: 100%;
        padding: 0;
        margin-top: -16px;
        margin-left: -22px;
        /* background-image: url("../../../../assets/images/background/background.jpg"); */
        position: fixed;
    }
    .userHome>img {
        width: 80px;
        height: 80px;
        border-radius: 50%;
        margin-left: 140px;
        margin-top: 90px;
    }
    .userHome>div {
        display: flex;
        font-size: 20px;
        padding-top: 140px;
        padding-left: 120px;
        margin-top: -60px;
        line-height: 40px;
        font-weight: bold;
    }
    .userHome>div>div:nth-child(1){
        width: 150px
    }
    .userHome>div>div:nth-child(1)>div:nth-last-child(1){
        margin-top: 100px
    }
</style>
