<template>
    <div style="width: 100%;height: calc(100vh - 140px);">
        <div style="width: 100%;margin-bottom: -50px;text-align:center">
            <span style="font-weight: bold;font-size: 40px;">采购管理</span>
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
                style="width: 100%;height: 400px"
                max-height="400px">
            <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="商品图片" style="display: block">
                            <img :src="props.row.goodsImageUrl" style="height: 100px;width: 100px"/>
                        </el-form-item>
                        <el-form-item label="商品名称：">
                            <span>{{ props.row.goodsName }}</span>
                        </el-form-item>
                        <el-form-item label="商品 ID：">
                            <span>{{ props.row.goodsId }}</span>
                        </el-form-item>
                        <el-form-item label="商品报价：">
                            <span>{{ props.row.goodsOffer }}</span>
                        </el-form-item>
                        <el-form-item label="报价厂商：">
                            <span>{{ props.row.vendorOffer }}</span>
                        </el-form-item>
                        <el-form-item label="厂商联系方式：">
                            <span>{{ props.row.telephonevendor }}</span>
                        </el-form-item>
                        <el-form-item label="商品描述：">
                            <span>{{ props.row.goodsDesc }}</span>
                        </el-form-item>
                        <el-form-item label="选择厂商：">
                            <el-select v-model="value" placeholder="请选择厂商">
                                <el-option-group
                                        v-for="group in options"
                                        :key="group.label"
                                        :label="group.label">
                                    <el-option
                                            v-for="item in group.options"
                                            :key="item.value"
                                            :label="item.label"
                                            :value="item.value">
                                    </el-option>
                                </el-option-group>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="采购数量：">
                            <el-input-number v-model="props.row.goodsPAmount" controls-position="right"
                                             @change="handleChange" :min="0" :max="100000"></el-input-number>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" style="margin-top: 20px">采购</el-button>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="商品 ID"
                    width="300px"
                    prop="goodsId">
            </el-table-column>
            <el-table-column
                    label="商品名称"
                    width="300px"
                    prop="goodsName">
            </el-table-column>
            <el-table-column
                    label="采购数量"
                    width="400px"
                    prop="goodsPAmount">
            </el-table-column>
            <el-table-column
                    label="采购日期"
                    prop="purchaseDate"
                    sortable
                    width="180"
                    column-key="purchaseDate"
                    :filters="[{text: '2019-05-01', value: '2019-05-01'},
                    {text: '2019-05-02', value: '2019-05-02'},
                    {text: '2019-05-03', value: '2019-05-03'},
                    {text: '2019-05-04', value: '2019-05-04'}]"
                    :filter-method="filterHandler">
            </el-table-column>
            <el-table-column
                    label="操作"
                    fixed="right"
                    align="center"
                    width="100px">
                <template slot-scope="scope">
                    <el-button type="primary" size="small">删除</el-button>
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
                    style="margin-top: 10px ;text-align: center">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "managerPurchase",
        data() {
            return {
                input: '',
                tableData: [{
                    goodsId: '12987122',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    vendorOffer: '上海嘉定三星电子厂',
                    goodsOffer: '2130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    telephonevendor: '13838384438',
                    goodsPAmount: '1233',
                    purchaseDate: '2019-5-1'
                }, {
                    goodsId: '12987122',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    vendorOffer: '上海嘉定三星电子厂',
                    goodsOffer: '2130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    telephonevendor: '13838384438',
                    goodsPAmount: '1233',
                    purchaseDate: '2019-5-1'
                }, {
                    goodsId: '12987122',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    vendorOffer: '上海嘉定三星电子厂',
                    goodsOffer: '2130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    telephonevendor: '13838384438',
                    goodsPAmount: '1233',
                    purchaseDate: '2019-5-1'
                }, {
                    goodsId: '12987122',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    vendorOffer: '上海嘉定三星电子厂',
                    goodsOffer: '2130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    telephonevendor: '13838384438',
                    goodsPAmount: '1233',
                    purchaseDate: '2019-5-1'
                }, {
                    goodsId: '12987122',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    vendorOffer: '上海嘉定三星电子厂',
                    goodsOffer: '2130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    telephonevendor: '13838384438',
                    goodsPAmount: '1233',
                    purchaseDate: '2019-5-1'
                }, {
                    goodsId: '12987122',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    vendorOffer: '上海嘉定三星电子厂',
                    goodsOffer: '2130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    telephonevendor: '13838384438',
                    goodsPAmount: '1233',
                    purchaseDate: '2019-5-1'
                }, {
                    goodsId: '12987122',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    vendorOffer: '上海嘉定三星电子厂',
                    goodsOffer: '2130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    telephonevendor: '13838384438',
                    goodsPAmount: '1233',
                    purchaseDate: '2019-5-1'
                }, {
                    goodsId: '12987122',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    vendorOffer: '上海嘉定三星电子厂',
                    goodsOffer: '2130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    telephonevendor: '13838384438',
                    goodsPAmount: '1233',
                    purchaseDate: '2019-5-1'
                }, {
                    goodsId: '12987122',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsImageUrl: 'http://pic1.zhimg.com/50/v2-ede9473ddcbd84fe7c1e363953ed7410_hd.jpg',
                    vendorOffer: '上海嘉定三星电子厂',
                    goodsOffer: '2130',
                    goodsDesc: '旗舰版-全网通-4G-套餐一',
                    telephonevendor: '13838384438',
                    goodsPAmount: '1233',
                    purchaseDate: '2019-5-1'
                }
                ],
                options: [{
                    label: '最低报价厂家',
                    options: [{
                        value: 'Shanghai',
                        label: '上海嘉定三星电子厂'
                    },
                    ]
                }, {
                    label: '供货厂家',
                    options: [{
                        value: 'Chengdu',
                        label: '成都三星电子厂'
                    }, {
                        value: 'Shenzhen',
                        label: '深圳三星电子厂'
                    }, {
                        value: 'Guangzhou',
                        label: '广州三星电子厂'
                    }, {
                        value: 'Dalian',
                        label: '大连三星电子厂'
                    }]
                }],
                value: '',
            }
        },
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleChange(value) {
                console.log(value);
            },
            filterHandler(value, row, column) {
                const property = column['property'];
                return row[property] === value;
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
