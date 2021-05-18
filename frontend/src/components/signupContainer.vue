<template>
    <form class="form" v-on:submit.prevent="handleSubmit">

        <input type="text" v-model.trim="user.name" placeholder="Name">

        <input type="text" v-model.trim="user.surname" placeholder="Surname">

        <input type="password" v-model.trim="user.password" placeholder="Password">

        <input type="password" v-model.trim="user.repeatPassword" placeholder="Repeat password">

        <input type="email" v-model.trim="user.email" placeholder="Email">



        <button>SIGN UP</button>
        <p>
            Already have an account? <router-link to="/">Login here</router-link>
        </p>
        
    </form>
        
    
</template>

<script>

    import User from '../models/user'

    export default {
        name: 'signupContainer',
        data() {
            return {
                user: new User('', '', '', '', ''),
                submitted: false,
                successful: false,
                message: ''
            }
        },
        computed: {
            loggedIn() {
                return this.$store.state.auth.status.loggedIn;
            }
        },
        mounted() {
            if (this.loggedIn) {
                this.$router.push('/home')
            }
        },
        methods: {
            handleSubmit() {
                this.message = '';
                this.submitted = true;

                        this.$store.dispatch('auth/register', this.user).then(
                                data => {
                                    this.message = data.message;
                                    this.successful = true;
                                },
                                error => {
                                    this.message =
                                            (error.response && error.response.data) ||
                                            error.message ||
                                            error.toString();
                                    this.successful = false;
                                }
                        );

                this.$router.push('/')
            }
        }
    };
</script>

<style scoped>
    @import "./../assets/styles/button.css";
    @import "./../assets/styles/input.css";

    .form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: auto;
        height: auto;
        margin: 0;

        background: #00000059 0% 0% no-repeat padding-box;
        box-shadow: 0px 6px 6px #00000029;
        border: 1px solid #707070;
        border-radius: 11px;
    }


    


</style>