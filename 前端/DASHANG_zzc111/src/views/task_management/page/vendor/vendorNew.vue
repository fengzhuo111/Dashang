<template>
    <div style="height: calc(100vh - 160px);">
        <div style="width: 100%;margin-bottom: 50px;text-align:center;padding-top:50px;">
            <span style="font-weight: bold;font-size: 40px;">注册商品</span>
        </div>
        <div style="width:500px;margin: 0 auto">
            <span style="font-size: 20px">商品名称：</span>
            <el-input v-model="input" placeholder="请输入商品名称" style="width:400px;"></el-input>
        </div>
        <div style="width:500px;margin: 0 auto">
            <span style="font-size: 20px">商品品牌：</span>
            <el-input v-model="input" placeholder="请输入商品名称" style="width:400px;"></el-input>
        </div>
        <div style="width:500px;margin: 0 auto">
            <span style="font-size: 20px">商品报价：</span>
            <el-input-number style="width:400px" v-model="num" controls-position="right" @change="handleChange" :min="1" :max="99999"></el-input-number>
        </div>
        <div style="width:500px;margin: 0 auto;padding-top: 10px">
            <el-button type="primary" style="margin-left: 0px">注册</el-button>
            <el-button type="primary" style="margin-left: 20px">重置</el-button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "venderNew",
        data() {
            return {
                input: '',
                num: 9999
                }
            },
        methods: {
            handleChange(value) {
                console.log(value);
            },

        },
    }
</script>

<style scoped>

</style>
