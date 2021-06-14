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

            <div id="myOverlay" class="overlay">
                <span class="closebtn" v-on:click="closeSearch" title="Close Overlay">x</span>
                <div class="overlay-content">
                    <form>
                        <input type="text" v-model.trim="search" placeholder="Search.." name="search">
                        <button v-on:click="getSearch(search)">Search</button>
                    </form>
                </div>
            </div>

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
        closeSearch() {
            document.getElementById("myOverlay").style.display = "none";
        }
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

    .overlay {
        height: 100%;
        width: 100%;
        display: none;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
        background-color: rgb(0,0,0);
        background-color: rgba(0,0,0, 0.9);
    }

    .overlay-content {
        position: relative;
        top: 20%;
        width: 60%;
        text-align: center;

        margin-top: 30px;
        margin: auto;
    }

    .overlay .closebtn {
        position: absolute;
        top: 20px;
        right: 45px;
        font-size: 60px;
        cursor: pointer;
        color: white;
    }

    .overlay .closebtn:hover {
        color: #ccc;
    }

    .overlay input[type=text] {
        padding: 15px;
        font-size: 17px;
        border: none;
        float: left;
        width: 100%;
        background: white;
        align-self: center;
    }

    .overlay input[type=text]:hover {
        background: #f1f1f1;
    }

    .overlay button {
        float: left;
        width: 50%;
        padding: 15px;
        background: #ddd;
        font-size: 17px;
        color: black;
        border: none;
        cursor: pointer;
        align-self: center;
    }

    .overlay button:hover {
        background: #bbb;
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