<template>
    <div style="height: calc(100vh - 140px);">
        <div style="width: 100%;margin-bottom: 0;text-align:center">
            <span style="font-weight: bold;font-size: 40px;">购物清单</span>
        </div>
        <el-divider></el-divider>
        <div style="overflow: auto;width:100%;height: 400px;padding-right:200px;margin-right: 160px">
            <div style="height:400px;margin-right: 1%">
                <el-row>
                    <el-col :span="3" v-for="(item) in tabledata" :key="item.brand" :offset="1" :xs="23" :sm="11"
                            :md="3" :lg="3">
                        <div style="margin-top:15px">
                            <el-card :body-style="{ padding: '0px'}" shadow="hover">
                                <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                                     class="image">
                                <div style="padding: 14px;">
                                    <span><el-button type="text"
                                                     style="color: black">{{item.goodsName}}</el-button></span><br>
                                    <div class="bottom">
                                        <div class="evaluate" style="font-size: 14px;line-height:20px;display: flex">
                                            <div style="width: 100%">
                                                <div>售价：{{item.goodsPrice}}元</div>
                                                <div>
                                                    购买数量：{{item.num}}
                                                    <el-input-number v-model="item.num" controls-position="right"
                                                                     @change="handleChange" :min="1"
                                                                     :max="9999"></el-input-number>
                                                </div>
                                                <div>简介：{{item.goodsDesc}}</div>
                                                <div>
                                                    <el-button type="danger" style="float: right">删除</el-button>
                                                </div>
                                                <div style="margin-top: 10px">合计：{{item.goodsPrice}}*{{item.num}}元</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </el-card>
                        </div>
                    </el-col>
                </el-row>
            </div>
        </div>
        <el-divider></el-divider>
        <div style="float: right;padding-right: 50px">
            <strong style="padding-right: 100px">总计：&nbsp;{{price}}元</strong>
            <el-button type="primary">立即购买</el-button>
        </div>
    </div>
</template>

<script>

    export default {
        name: "userShopping",
        data() {
            return {
                price: '52245',
                tabledata: [
                    {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    }, {
                        goodsName: '三星智能手机S10旗舰版全网通',
                        goodsPrice: '3130',
                        goodsAmount: '5',
                        goodsDesc: '旗舰版-全网通-4G-套餐一',
                        goodsAmountSP: '3130*5',
                        num: 1
                    },
                ]

            }
        },
        methods: {
            handleChange(value) {
                console.log(value);
            }
        }
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
