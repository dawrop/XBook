<template>
    <div id="nav">
        <div id="myLinks">
            <a>
                <router-link to="/profile">
                    <font-awesome-icon icon="user-circle"/>
                </router-link>
            </a>
            <a>
                <router-link to="/home">
                    <font-awesome-icon icon="home"/>
                </router-link>
            </a>

            <a v-on:click="openSearch">
                <font-awesome-icon icon="search" />
            </a>
            <a>
                <font-awesome-icon icon="star" />
            </a>
            <a v-if="isAdmin">
                <router-link to="/addbook">
                    <font-awesome-icon icon="plus" />
                </router-link>

            </a>
            <a v-on:click.prevent="logOut">
                <font-awesome-icon icon="sign-out-alt" />
            </a>



        </div>
    </div>
</template>

<script>

export default {
    name: 'navigation',
    data() {
        return {
            search: ""
        }
    },
    props: {
        getSearch: Function
    },
    computed: {
        currentUser() {
            return this.$store.state.auth.user;
        },
        isAdmin() {
            return this.currentUser && this.currentUser.roles.includes("ROLE_ADMIN")
        }
    },
    methods: {
        logOut() {
            this.$store.dispatch('auth/logout');
            this.$router.push('/');
        },
        openSearch() {
            document.getElementById("myOverlay").style.display = "block";
        },

    }
}
</script>

<style scoped>
    #nav {
        min-width: 4em;
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        align-items: center;
        background: transparent linear-gradient(180deg, #000000 0%, #8a7500 200%) 0% 0% no-repeat padding-box;
    }

    #myLinks {
        display: flex;
        flex-direction: column;
        margin-top: 120px;
        align-items: center;
    }

    a {
        background: transparent;
        border: none;
        outline: none;
        color: white;
        font-size: 30px;
        cursor: pointer;
        margin-top: 30px;
    }

    a:hover{
        color: #777777;
    }

    @media only screen and (max-device-width: 420px) {
        #nav {
            height: auto;
            width: 100%;
            background: black;
            flex-direction: row;
        }

        #myLinks {
            margin: 0;
            padding: 2px;
            flex-direction: row;
            width: 100%;
            justify-content: space-evenly;
        }

        a {
            margin: 0px;
            padding: 5px;
            font-size: 30px;
        }
    }
</style>