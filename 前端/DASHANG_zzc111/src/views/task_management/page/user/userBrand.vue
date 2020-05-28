<template>
    <div style="height: calc(100vh - 140px);">
        <div style="width: 100%;margin-bottom: 0;text-align:center">
            <span style="font-weight: bold;font-size: 40px;">品牌展示</span>
        </div>
        <div style="float: right;width: 500px;margin-top: -30px">
            <el-input
                    placeholder="请输入内容"
                    prefix-icon="el-icon-search"
                    v-model="input"
                    style="margin: 5px;width: 100%">
            </el-input>
        </div>
        <el-divider></el-divider>
        <div style="overflow: auto;width:100%;height: 450px;padding-right:200px;margin-right: 160px">
            <div style="height:450px;margin-right: 1%">
                <el-row>
                    <el-col :span="3" v-for="(item) in tabledata" :key="item.brand" :offset="1">
                        <div style="margin-top:15px">
                            <el-card :body-style="{ padding: '0px'}" shadow="hover">
                                <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                                     class="image">
                                <div style="padding: 14px;">
                                    <span><el-button type="text"
                                                     style="color: black">{{item.brand}}</el-button></span><br>
                                    <div class="bottom">
                                        <div class="evaluate" style="font-size: 14px;margin-top: 2px">
                                            <strong>评价：</strong>
                                            <el-rate
                                                    v-model="item.value"
                                                    disabled
                                                    show-score
                                                    text-color="#ff9900"
                                                    score-template="{value}"
                                                    style="display: inline;">
                                            </el-rate>
                                        </div>
                                    </div>
                                </div>
                            </el-card>
                        </div>
                    </el-col>
                </el-row>
            </div>
        </div>
    </div>
</template>

<script>

    export default {
        name: "userBrand",
        data() {
            return {
                tabledata: [
                    {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    }, {
                        brand: '三星',
                        value: '3.7'
                    },
                ]

            }
        },
        methods: {}
    }
</script>

<style scoped>
    .evaluate {
        font-size: 13px;
        color: #999;
    }

    .bottom {
        margin-top: 13px;
        line-height: 12px;
    }

    .image {
        width: 100%;
        display: block;
    }
</style>
