<template>
    <div style="width: 100%; height: calc(100vh - 140px);">
        <div style="width: 100%;margin-bottom: -50px;text-align:center">
            <span style="font-weight: bold;font-size: 40px;">商品货架</span>
        </div>
        <div style="float: right;width: 500px;margin: 20px">
            <el-input
                    placeholder="请输入内容"
                    prefix-icon="el-icon-search"
                    v-model="input"
                    style="margin: 5px;width: 100%">
            </el-input>
        </div>

        <el-table
                :data="tableData"
                style="width: 100%;height: 450px"
                max-height="450px">
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="商品图片" style="display: block">
                            <img :src="props.row.goodsImageUrl" style="height: 100px;width: 100px"/>
                        </el-form-item>
                        <el-form-item label="商品名称：">
                            <span>{{ props.row.goodsName }}</span>
                        </el-form-item>
                        <el-form-item label="商品品牌：">
                            <span>{{ props.row.goodsBrand }}</span>
                        </el-form-item>
                        <el-form-item label="商品描述：">
                            <span>{{ props.row.goodsDesc }}</span>
                        </el-form-item>
                        <el-form-item label="商品售价：">
                            <span>{{ props.row.goodsPrice }}元</span>
                        </el-form-item>

                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="序号"
                    width="100px"
                    type="index"
                    align="center"
                    show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                    label="商品名称"
                    width="300px"
                    prop="goodsName">
            </el-table-column>
            <el-table-column
                    label="商品品牌"
                    width="200px"
                    align="center"
                    prop="goodsBrand">
            </el-table-column>
            <el-table-column
                    label="商品售价"
                    width="180px"
                    align="center"
                    prop="goodsPrice">
            </el-table-column>
            <el-table-column
                    label="商品介绍"
                    prop="goodsDesc">
            </el-table-column>
            <el-table-column
                    label="操作"
                    fixed="right"
                    align="center"
                    width="200px">
                <template slot-scope="scope">
                    <el-button type="primary" size="small">加入购物清单</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div class="block">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page.sync="currentPage3"
                    :page-size="100"
                    layout="prev, pager, next, jumper"
                    :total="1000"
                    style="margin-top: 10px;text-align: center;">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "userGoods",
        data() {
            return {
                value1: true,
                input: '',
                tableData: [{
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                }, {
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                }, {
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                }, {
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                }, {
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                }, {
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                }, {
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                }, {
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                }, {
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                }, {
                    goodsBrand: '三星',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                },]
            }
        },
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleChange(value) {
                console.log(value);
            },
        }
    }
</script>

<style scoped>
    .demo-table-expand {
        font-size: 0;
    }

    .demo-table-expand label {
        width: 90px;
        color: #99a9bf;
    }

    .demo-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 50%;
    }
</style>
