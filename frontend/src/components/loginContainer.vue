<template>
    <form class="login" v-on:submit.prevent="handleSubmit">
        <input type="email" v-model.trim="$v.email.$model" :class="{'is-invalid': $v.email.$error, 'is-valid': !$v.email.$invalid}" placeholder="Email">
        <div v-if="$v.email.$error" class="invalid-feedback">
            <span v-if="!$v.email.required">Email is required.</span>
            <span v-if="!$v.email.email">Wrong form.</span>
        </div>
        

        <input type="password" v-model.trim="$v.password.$model" :class="{'is-invalid': $v.password.$error, 'is-valid': !$v.password.$invalid}" placeholder="Password">
        <div v-if="$v.password.$error" class="invalid-feedback">
            <span v-if="!$v.password.required">Password is required.</span>
            <span v-if="!$v.password.minLength">Password must have at least {{ $v.password.$params.minLength.min }} characters.</span>
            <span v-if="!$v.password.maxLength">Password cannot exceed {{ $v.password.$params.maxLength.max }} characters.</span>
        </div>

        <div class="btn">                   
<!--            <button><router-link to="/home">SIGN IN</router-link></button>-->
<!--            <button><router-link to="/signup">SIGN UP</router-link></button>-->
          <button>SIGN IN</button>
          <button>SIGN UP</button>
        </div>
    </form>
</template>

<script>
    import { required, email, minLength, maxLength } from 'vuelidate/lib/validators'
    import axios from "axios";

    export default {
        name: 'loginContainer',
        data() {
            return {
                password: '',
                email: ''
            }
        },
        validations: {
            password: {required, minLength: minLength(6), maxLength: maxLength(12)},
            email: {required, email}
        },
        methods: {
            async handleSubmit() {
                const response = await axios.post('login', {
                    email: this.email,
                    password: this.password
                });

                localStorage.setItem('token', response.data.token);
            }
        }
    }
</script>

<style scoped>
    .login {
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