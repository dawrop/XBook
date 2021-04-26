<template>
    <div class="login">
        <form class="login-form" v-on:submit.prevent="handleSubmit">
            <input type="email" v-model.trim="user.email" placeholder="Email">



            <input type="password" v-model.trim="user.password" placeholder="Password">


            <div class="btn">
                <button>SIGN IN</button>
            </div>
        </form>

        <button><router-link to="/signup">SIGN UP</router-link></button>

    </div>
</template>

<script>
    import { required, email, minLength, maxLength } from 'vuelidate/lib/validators'
    import User from '../models/user'

    export default {
        name: 'loginContainer',
        data() {
            return {
                user: new User('', ''),
                loading: false,
                message: ''
            }
        },
        computed: {
            loggedIn() {
                return this.$store.state.auth.status.loggedIn;
            }
        },
        created() {
            if (this.loggedIn) {
                this.$router.push('/home')
            }
        },
        validations: {
            password: {required, minLength: minLength(6), maxLength: maxLength(12)},
            email: {required, email}
        },
        methods: {
            handleSubmit() {
                this.loading = true;

                if (this.user.email && this.user.password) {
                    this.$store.dispatch('auth/login', this.user).then(
                            () => {
                                this.$router.push('/home');
                            },
                            error => {
                                this.loading = false;
                                this.message =
                                        (error.response && error.response.data) ||
                                        error.message ||
                                        error.toString();
                            }
                    );
                }
            }
        }
    }
</script>

<style scoped>
    .login {
        display: flex;
        flex-direction: column;
        align-items: center;

        background: #00000059 0% 0% no-repeat padding-box;
        box-shadow: 0px 6px 6px #00000029;
        border: 1px solid #707070;
        border-radius: 11px;
    }

    .login-form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: auto;
        height: auto;
        margin: 0;
    }

    input {
        background-color: transparent;
        border: none;
        border-bottom: 1px solid gray;
        padding: 0.5em;
        margin: 1em;
        width: 50%;
        font-size: 1.5em;
    }
    
    .btn {
        display: flex;
        flex-direction: row;
        align-self: stretch;
        justify-content: center;
    }

    button {
        background: #00000066 0% 0% no-repeat padding-box;
        border: 1px solid #707070;
        border-radius: 7px;


        border: none;
        color: white;
        margin: 0.5em;
        line-height: 2.5em;
        font-size: 1.25em;
    }
</style>