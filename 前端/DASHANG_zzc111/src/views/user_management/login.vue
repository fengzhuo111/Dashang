<template>
    <div class="login_container">
        <div>
            <div class="login_box">
                <!-- logo -->
                <div class="logo">
                    <img src="../../assets/images/logo/logo.jpg" alt=""/>
                </div>
                <!-- 登录表单 -->
                <div>
                    <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" label-width="90px"
                             class="login_form">
                        <el-form-item label="用户名:" prop="username">
                            <el-input v-model="loginForm.username" prefix-icon="el-icon-user"
                                      autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="密码:" prop="password">
                            <el-input v-model="loginForm.password" prefix-icon="el-icon-lock" type="password"
                                      autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="用户类型:" prop="usertype">
                            <el-select v-model="loginForm.usertype" placeholder="请选择用户类型" @change="selectChange">
                                <!-- 使用1表示用户 2表示物业 3表示厂商 -->
                                <el-option label="用户" value="1"></el-option>
                                <el-option label="物业" value="2"></el-option>
                                <el-option label="厂商" value="3"></el-option>
                            </el-select>
                        </el-form-item>

                        <div class="registerLink">
                            <el-link href="#/register">没有账号？立即注册</el-link>
                        </div>

                        <el-form-item class="login_btn_area">
                            <el-button type="primary" round @click="login">登录</el-button>
                        </el-form-item>
                    </el-form>
                </div>
            </div>
        </div>
        <Footer></Footer>
    </div>
</template>

<script>
    import Footer from '../../components/Footer'

    export default {
        name: "Login",
        components: {Footer},
        data() {
            var validatePassword = (rule, value, callback) => {
                var reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else if (!reg.test(this.loginForm.password)) {
                    callback(new Error('最少8个字符，至少一个大写字母、小写字母和数字'))
                } else {
                    callback();
                }
            };
            return {
                Vtype: '123',
                loginForm: {
                    username: '',
                    password: '',
                    usertype: '',
                },

                loginFormRules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 3, max: 10, message: '用户名长度为3到10个字符', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, validator: validatePassword, trigger: 'blur'}
                    ],
                    usertype: [
                        {required: true, message: '请选择用户类型', trigger: 'change'}
                    ]
                }
            }
        },
        methods: {
            login() {
                // 登录的逻辑代码

                this.$router.push('/home')
            },
            selectChange(Vtype) {
                // this.Vtype=Vtype;
                this.$store.dispatch("changeUsertypeFun", Vtype);
            }
        }
    }
</script>

<style scoped>
    .login_container {
        height: 100%;
        width: 100%;
        display: flex;
        flex-direction: column;
        /* background: url("../../assets/images/background/background.jpg") no-repeat center; */
        background-size: 100% 100%;
    }

    .login_box {
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

    .login_form {
        position: absolute;
        bottom: 20px;
        width: 100%;
        padding: 0 30px;
        box-sizing: border-box;
    }

    .registerLink {
        display: flex;
        justify-content: center;
        margin-bottom: 20px;
    }

    .login_btn_area button {
        width: 200px;
    }
</style>
