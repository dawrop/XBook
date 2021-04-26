<template>
    <form class="form" v-on:submit.prevent="handleSubmit">

        <input type="text" v-model.trim="user.name" :class="{'is-invalid': user.name.$error, 'is-valid': !user.name.$invalid}" placeholder="Name">
        <div v-if="user.name.$error" class="invalid-feedback">
            <span v-if="!user.name.required">Name is required.</span>
            <span v-if="!user.name.minLength">Name is too short.</span>
        </div>
        
        <input type="text" v-model.trim="user.surname" :class="{'is-invalid': user.surname.$error, 'is-valid': !user.surname.$invalid}" placeholder="Surname">
        <div v-if="user.surname.$error" class="invalid-feedback">
            <span v-if="!user.surname.required">Surname is required.</span>
            <span v-if="!user.surname.minLength">Surname is too short.</span>
        </div>

        <input type="password" v-model.trim="user.password" :class="{'is-invalid': user.password.$error, 'is-valid': !user.password.$invalid}" placeholder="Password">
        <div v-if="user.password.$error" class="invalid-feedback">
            <span v-if="!user.password.required">Password is required.</span>
            <span v-if="!user.password.minLength">Password must have at least {{ user.password.$params.minLength.min }} characters.</span>
            <span v-if="!user.password.maxLength">Password cannot exceed {{ user.password.$params.maxLength.max }} characters.</span>
        </div>

        <input type="password" v-model.trim="user.repeatPassword" :class="{'is-invalid': user.repeatPassword.$error, 'is-valid': !user.repeatPassword.$invalid}" placeholder="Repeat password">
        <div v-if="user.repeatPassword.$error" class="invalid-feedback">
            <span v-if="!user.repeatPassword.required">Password is required.</span>
            <span v-if="!user.repeatPassword.minLength">Password must have at least {{ user.repeatPassword.$params.minLength.min }} characters.</span>
            <span v-if="!user.repeatPassword.maxLength">Password cannot exceed {{ user.repeatPassword.$params.maxLength.max }} characters.</span>
            <span v-if="!user.repeatPassword.sameAs && user.repeatPassword.minLength && user.repeatPassword.maxLength">Passwords don't match.</span>
        </div>

        <input type="email" v-model.trim="user.email" :class="{'is-invalid': user.email.$error, 'is-valid': !user.email.$invalid}" placeholder="Email">
        <div v-if="user.email.$error" class="invalid-feedback">
            <div v-if="!user.email.required">Email is required.</div>
            <div v-if="!user.email.email">Wrong form</div>
        </div>


        <button>SIGN UP</button>
        <p>
            Already have an account? <router-link to="/">Login here</router-link>
        </p>
        
    </form>
        
    
</template>

<script>
    import { required, email, minLength, maxLength, sameAs } from 'vuelidate/lib/validators'
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
        validations: {
            name: {required, minLength: minLength(3)},
            surname: {required, minLength: minLength(3)},
            password: {required, minLength: minLength(6), maxLength: maxLength(12)},
            repeatPassword: {required, minLength: minLength(6), maxLength: maxLength(12), sameAs: sameAs('password')},
            email: {required, email}
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
                // this.$v.validate().then(isValid => {
                //     if (isValid) {
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
                //     }
                // });
                this.$router.push('/')
            }
        }
    };
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