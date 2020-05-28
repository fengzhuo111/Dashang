<template>
    <div class="homePage">
        <el-container>
    <!--  导航栏  -->
        <el-header class="homeHeader">
            <Header></Header>
        </el-header>
        <el-main class="homeMain">
            <div v-if="this.$store.state.usertype=='ordinaryUser'"><User></User></div>
            <div v-if="this.$store.state.usertype=='property'"><manager></manager></div>
            <div v-if="this.$store.state.usertype=='vendor'"><vender></vender></div>
        </el-main>
        <el-footer class="homeFooter">
            <Footer></Footer>
        </el-footer>
    </el-container>
    </div>
</template>

<script>
    import Header from "../../components/Header";
    import Footer from "../../components/Footer";
    import User from "./page/user";
    import Manager from "./page/manager";
    import Vender from "./page/vendor";

    export default {
        name: "home",
        components:{
            Vender,
            Manager,
            Header,
            Footer,
            User,
            // Manager,
            // Vender,
        },
        data(){
            return{
                usertype: '用户'
            }
        },
        methods: {
            saveNavState (activePath) {
                window.sessionStorage.setItem('activePath', activePath)
            }
        }
    }
</script>

<style scoped>
    .homePage{
        height: 100%;
        width: 100%;
        /*position: fixed;*/
    }
    .homeHeader{
        width: 100%;
        height: 100%;
        background-color: #373f41;
        /*display: flex;*/
        /*align-items: center;*/
    }

    .homeMain {
        height: 100%;
        width: 100%;
        padding: 0;

        /*position: relative;*/
        /*    margin-top:-20px;*/
        /*    margin-left:-20px;*/
        /*margin-right:-18px;*/
    }

    .homeFooter {
        height: 100%;
        width: 100%;
        background-color: #373f41;
        display: flex;
        position: absolute;
        bottom: 0;
        align-items: center;
    }
</style>
