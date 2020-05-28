<template>
    <div style="width: 100%;height: calc(100vh - 140px);">
        <div style="width: 100%;margin-bottom: -50px;text-align:center">
            <span style="font-weight: bold;font-size: 40px;">厂商管理</span>
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
                        <el-form-item label="厂商图片" style="display: block">
                            <img :src="props.row.vendorImageUrl" style="height: 100px;width: 100px"/>
                        </el-form-item>
                        <el-form-item label="厂商名称：">
                            <span>{{ props.row.vendorName }}</span>
                        </el-form-item>
                        <el-form-item label="厂商 ID：">
                            <span>{{ props.row.vendorId }}</span>
                        </el-form-item>
                        <el-form-item label="联系电话：">
                            <span>{{ props.row.vendorTelephone }}</span>
                        </el-form-item>
                        <el-form-item label="厂商地址：">
                            <span>{{ props.row.vendorAddress }}</span>
                        </el-form-item>
                        <el-form-item label="厂商介绍：" style="display: block">
                            <span>{{ props.row.vendorDesc }}</span>
                        </el-form-item>
                        <el-form-item label="厂商产品：" style="display: block">
                            <el-table
                                    :data="goodsTableData"
                                    stripe
                                    style="width: 1200px">
                                <el-table-column
                                        prop="goodsId"
                                        label="商品编号"
                                        width="200">
                                </el-table-column>
                                <el-table-column
                                        prop="goodsName"
                                        label="商品名称"
                                        width="400">
                                </el-table-column>
                                <el-table-column
                                        prop="goodsState"
                                        label="商品状态"
                                        width="200">
                                </el-table-column>
                                <el-table-column
                                        prop="goodsOffer"
                                        label="商品报价"
                                        width="200">
                                </el-table-column>
                                <el-table-column
                                        prop="goodsPrice"
                                        label="商品售价"
                                        align="center"
                                        width="200">
                                </el-table-column>
                            </el-table>
                        </el-form-item>
                        <el-form-item label="备注：">
                            <span>{{ props.row.vendorNotes }}</span>
                            <el-button type="text"><i class="el-icon-edit"></i></el-button>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column
                    label="厂商 ID"
                    width="200px"
                    prop="vendorId">
            </el-table-column>
            <el-table-column
                    label="厂商名称"
                    width="240px"
                    prop="vendorName">
            </el-table-column>
            <el-table-column
                    label="联系方式"
                    width="240px"
                    prop="vendorTelephone">
            </el-table-column>
            <el-table-column
                    label="厂商介绍"
                    width="400px"
                    prop="vendorDesc">
            </el-table-column>
            <el-table-column
                    label="厂商地址"
                    prop="vendorAddress">
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
                    style="margin-top: 10px; text-align: center">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "managervendor",
        data() {
            return {
                input: '',
                goodsTableData: [{
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsOffer: '2130',
                    goodsState: '上架'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsOffer: '2130',
                    goodsState: '上架'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsOffer: '2130',
                    goodsState: '上架'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsOffer: '2130',
                    goodsState: '上架'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsOffer: '2130',
                    goodsState: '上架'
                }, {
                    goodsId: '12312321',
                    goodsName: '三星智能手机S10旗舰版全网通',
                    goodsPrice: '3130',
                    goodsOffer: '2130',
                    goodsState: '上架'
                },],
                tableData: [{
                    vendorId: '12987122',
                    vendorName: '上海嘉定三星电子厂',
                    vendorTelephone: '13838384438',
                    vendorDesc: '工厂主要经营电子计算器，电子，电器配件的生产销售，建筑装潢材料，电子，电器元件，五金交电，金属材料（除贵金属）的销售。',
                    vendorAddress: '上海市嘉定区戬浜镇新联村市沟',
                    vendorNotes: '产品质量不错，交货及时。',
                }, {
                    vendorId: '12987122',
                    vendorName: '上海嘉定三星电子厂',
                    vendorTelephone: '13838384438',
                    vendorDesc: '工厂主要经营电子计算器，电子，电器配件的生产销售，建筑装潢材料，电子，电器元件，五金交电，金属材料（除贵金属）的销售。',
                    vendorAddress: '上海市嘉定区戬浜镇新联村市沟',
                    vendorNotes: '产品质量不错，交货及时。',
                }, {
                    vendorId: '12987122',
                    vendorName: '上海嘉定三星电子厂',
                    vendorTelephone: '13838384438',
                    vendorDesc: '工厂主要经营电子计算器，电子，电器配件的生产销售，建筑装潢材料，电子，电器元件，五金交电，金属材料（除贵金属）的销售。',
                    vendorAddress: '上海市嘉定区戬浜镇新联村市沟',
                    vendorNotes: '产品质量不错，交货及时。',
                }, {
                    vendorId: '12987122',
                    vendorName: '上海嘉定三星电子厂',
                    vendorTelephone: '13838384438',
                    vendorDesc: '工厂主要经营电子计算器，电子，电器配件的生产销售，建筑装潢材料，电子，电器元件，五金交电，金属材料（除贵金属）的销售。',
                    vendorAddress: '上海市嘉定区戬浜镇新联村市沟',
                    vendorNotes: '产品质量不错，交货及时。',
                }, {
                    vendorId: '12987122',
                    vendorName: '上海嘉定三星电子厂',
                    vendorTelephone: '13838384438',
                    vendorDesc: '工厂主要经营电子计算器，电子，电器配件的生产销售，建筑装潢材料，电子，电器元件，五金交电，金属材料（除贵金属）的销售。',
                    vendorAddress: '上海市嘉定区戬浜镇新联村市沟',
                    vendorNotes: '产品质量不错，交货及时。',
                }, {
                    vendorId: '12987122',
                    vendorName: '上海嘉定三星电子厂',
                    vendorTelephone: '13838384438',
                    vendorDesc: '工厂主要经营电子计算器，电子，电器配件的生产销售，建筑装潢材料，电子，电器元件，五金交电，金属材料（除贵金属）的销售。',
                    vendorAddress: '上海市嘉定区戬浜镇新联村市沟',
                    vendorNotes: '产品质量不错，交货及时。',
                },]
            }
        },
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
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
