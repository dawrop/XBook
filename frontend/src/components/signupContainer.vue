<template>
    <form class="form" v-on:submit.prevent="handleSubmit">

        <input type="text" v-model.trim="$v.name.$model" :class="{'is-invalid': $v.name.$error, 'is-valid': !$v.name.$invalid}" placeholder="Name">
        <div v-if="$v.name.$error" class="invalid-feedback">
            <span v-if="!$v.name.required">Name is required.</span>
            <span v-if="!$v.name.minLength">Name is too short.</span>
        </div>
        
        <input type="text" v-model.trim="$v.surname.$model" :class="{'is-invalid': $v.surname.$error, 'is-valid': !$v.surname.$invalid}" placeholder="Surname">
        <div v-if="$v.surname.$error" class="invalid-feedback">
            <span v-if="!$v.surname.required">Surname is required.</span>
            <span v-if="!$v.surname.minLength">Surname is too short.</span>
        </div>
        
        <input type="password" v-model.trim="$v.password.$model" :class="{'is-invalid': $v.password.$error, 'is-valid': !$v.password.$invalid}" placeholder="Password">
        <div v-if="$v.password.$error" class="invalid-feedback">
            <span v-if="!$v.password.required">Password is required.</span>
            <span v-if="!$v.password.minLength">Password must have at least {{ $v.password.$params.minLength.min }} characters.</span>
            <span v-if="!$v.password.maxLength">Password cannot exceed {{ $v.password.$params.maxLength.max }} characters.</span>
        </div>
            
        <input type="password" v-model.trim="$v.repeatPassword.$model" :class="{'is-invalid': $v.repeatPassword.$error, 'is-valid': !$v.repeatPassword.$invalid}" placeholder="Repeat password">
        <div v-if="$v.repeatPassword.$error" class="invalid-feedback">
            <span v-if="!$v.repeatPassword.required">Password is required.</span>
            <span v-if="!$v.repeatPassword.minLength">Password must have at least {{ $v.repeatPassword.$params.minLength.min }} characters.</span>
            <span v-if="!$v.repeatPassword.maxLength">Password cannot exceed {{ $v.repeatPassword.$params.maxLength.max }} characters.</span>
            <span v-if="!$v.repeatPassword.sameAs && $v.repeatPassword.minLength && $v.repeatPassword.maxLength">Passwords don't match.</span>
        </div>
           
        <input type="email" v-model.trim="$v.email.$model" :class="{'is-invalid': $v.email.$error, 'is-valid': !$v.email.$invalid}" placeholder="Email">
        <div v-if="$v.email.$error" class="invalid-feedback">
            <div v-if="!$v.email.required">Email is required.</div>
            <div v-if="!$v.email.email">Wrong form</div>
        </div>                
            
        
        <button>SIGN UP</button>
        <p>
            Already have an account? <router-link to="/">Login here</router-link>
        </p>
        
    </form>
        
    
</template>

<script>
    import { required, email, minLength, maxLength, sameAs } from 'vuelidate/lib/validators'
    import axios from 'axios'

    export default {
        name: 'signupContainer',
        data() {
            return {
                name: '',
                surname: '',
                password: '',
                repeatPassword: '',
                email: ''
            }
        },
        validations: {
            name: {required, minLength: minLength(3)},
            surname: {required, minLength: minLength(3)},
            password: {required, minLength: minLength(6), maxLength: maxLength(12)},
            repeatPassword: {required, minLength: minLength(6), maxLength: maxLength(12), sameAs: sameAs('password')},
            email: {required, email}
        },
        methods: {
            async handleSubmit() {
              const response = await axios.post('signup', {
                name: this.name,
                surname: this.surname,
                password: this.password,
                repeatPassword: this.repeatPassword,
                email: this.email
              });

              console.log(response);
              this.$router.push('/');
            }


        }
    }
</script>

<style scoped>
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

    input {
        background-color: transparent;
        border: none;
        border-bottom: 1px solid gray;
        padding: 0.5em;
        margin: 1em;
        width: 60%;
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