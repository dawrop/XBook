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
                <div class="userImg">
                    <img src="../assets/covers/lotr1-fellowship.gif">
                </div>
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

export default {
    name: "Profile",
    components: {
        navigation
    },
    computed: {
        currentUser() {
            return this.$store.state.auth.user;
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