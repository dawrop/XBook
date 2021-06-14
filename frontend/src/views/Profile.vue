<template>
    <div id='Home'>
        <navigation/>

        <main>
            <header>
                <div class="logo-homepage">
                    <img src="./../assets/xbook_logo.png">
                </div>
            </header>

            <section class="content">

                <section class="userImg" ref="userImg" />

                <div class="userDetails">
                    <label>Name: {{ currentUser.name }}</label>
                    <label>Surname: {{ currentUser.surname }}</label>
                </div>

            </section>
        </main>

    </div>
</template>

<script>
import navigation from "./../components/navigation.vue";
import avatarContainer from "@/components/avatarContainer";
import {Api} from "@/apiHandler/apiHandler";
import Vue from "vue";

export default {
    name: "Profile",
    components: {
        navigation
    },
    computed: {
        currentUser() {
            return this.$store.state.auth.user;
        }
    },
    mounted() {
        Api.get()
                .then(response => response.data)
                .then(userData => this.showAvatar(userData))
    },
    methods: {
        showAvatar(userData){
            let avatarElement = new (Vue.extend(avatarContainer))();
            avatarElement.$props.avatarUuid = userData.avatar
            avatarElement.$mount()
            this.$refs.userImg.appendChild(avatarElement.$el)
        }
    }
}
</script>

<style scoped>
    @import "./../assets/styles/main.css";

    .userImg, .userDetails {

        width: 20em;
        display: flex;
        flex-direction: column;

        justify-content: center;
        padding: 20px;
    }

    .userDetails {
        background: #00000059 0% 0% no-repeat padding-box;
        box-shadow: 0px 6px 6px #00000029;
        border: 1px solid #707070;
        border-radius: 11px;
    }

    label {
        color: lightgrey;
        font-size: 30px;
    }


</style>