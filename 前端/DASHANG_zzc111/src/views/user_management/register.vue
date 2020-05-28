<template>
    <div class="register_container">
        <div>
            <div class="register_box">
                <!-- logo -->
                <div class="logo">
                    <img src="../../assets/images/logo/logo.jpg" alt=""/>
                </div>
                <!-- 注册表单 -->
                <div>
                    <el-form ref="registerFormRef" :model="registerForm" :rules="registerFormRules" label-width="90px"
                             class="register_form">
                        <el-form-item label="用户名:" prop="username">
                            <el-input v-model="registerForm.username" prefix-icon="el-icon-user"
                                      autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="密码:" prop="password">
                            <el-input v-model="registerForm.password" prefix-icon="el-icon-lock" type="password"
                                      autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="确认密码:" prop="checkPassword">
                            <el-input v-model="registerForm.checkPassword" prefix-icon="el-icon-lock" type="password"
                                      autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="用户类型:" prop="usertype">
                            <el-select v-model="registerForm.usertype" placeholder="请选择用户类型">
                                <el-option label="用户" value="ordinaryUser"></el-option>
                                <el-option label="物业" value="property "></el-option>
                                <el-option label="厂商" value="vendor"></el-option>
                            </el-select>
                        </el-form-item>

                        <el-form-item class="register_btn_area">
                            <el-button type="primary" round @click="register">注册</el-button>
                        </el-form-item>
                    </el-form>
                </div>
            </div>
        </div>
        <Footer></Footer>
    </div>
</template>

<script>
    import Footer from "../../components/Footer";

    export default {
        name: "register",
        components: {Footer},
        data() {
            // 检查密码格式
            var validatePassword = (rule, value, callback) => {
                var reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else if (!reg.test(this.registerForm.password)) {
                    callback(new Error('最少8个字符，至少一个大写字母、小写字母和数字'))
                } else {
                    callback();
                }
            };
            // 检查两次密码是否一致
            var validatePassword2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.registerForm.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                registerForm: {
                    username: '',
                    password: '',
                    usertype: '',
                },
                registerFormRules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 3, max: 10, message: '用户名长度为3到10个字符', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, validator: validatePassword, trigger: 'blur'}
                    ],
                    checkPassword: [
                        {required: true, validator: validatePassword2, trigger: 'blur'}
                    ],
                    usertype: [
                        {required: true, message: '请选择用户类型', trigger: 'change'}
                    ]
                }
            }
        },
        methods: {
            register() {
                // 注册逻辑代码
                this.$router.push({path: '/login'});
            }
        }
    }
</script>

<style scoped>
    .register_container {
        height: 100%;
        display: flex;
        flex-direction: column;
        /* background: url("../../assets/images/background/background.jpg") no-repeat center; */
        background-size: 100% 100%;
        /*position: absolute;*/
        /*background-color: #A0CFFF;*/
    }

    .register_box {
        width: 450px;
        height: 430px;
        background-color: #F5F5DC;
        border-radius: 5px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }

    .logo {
        height: 130px;
        width: 130px;
        border: solid 1px #eeeeee;
        border-radius: 50%;
        box-shadow: 0 0 10px #eeeeee;
        position: absolute;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    .logo img {
        height: 100%;
        width: 100%;
        border-radius: 50%;
    }

    .register_form {
        position: absolute;
        bottom: 20px;
        width: 100%;
        padding: 0 30px;
        box-sizing: border-box;
    }

    .register_btn_area button {
        width: 200px;
    }
</style>
