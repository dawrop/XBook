<template>
    <div id='Home'>
        <navigation/>

        <main>
            <header>
                <div class="logo-homepage">
                    <img src="./../assets/xbook_logo.png">
                </div>

            </header>

            <section id="content" ref="content" />

            <div id="myOverlay" class="overlay">
                <span class="closebtn" v-on:click="closeSearch" title="Close Overlay">x</span>
                <div class="overlay-content">
                    <form class="myOver">
                        <input type="search" ref="search" placeholder="Search..." name="search">
                        <button type="button" v-on:click.prevent="searchResults" v-on:click="closeSearch">Search</button>
                    </form>
                </div>
            </div>

        </main>
    </div>

</template>

<script>
    import navigation from "./../components/navigation.vue";
    import bookImgContainer from "./../components/bookImgContainer.vue";
    import Vue from "vue";
    import { Api } from "@/apiHandler/apiHandler";

    export default {
        name: 'Home',
        components: {
            navigation,
        },
        mounted() {
            Api.get('books')
                    .then(response => response.data)
                    .then(bookList => {this.showBooks(bookList)})
        },
        methods: {
            showBooks(bookList){
                for (let bookData of bookList) {
                    let bookElement = new (Vue.extend(bookImgContainer))();
                    bookElement.$props.coverUuid = bookData.cover
                    bookElement.$mount()
                    this.$refs.content.appendChild(bookElement.$el)
                    // bookElement.$el.addEventListener("click", evt => {
                    //
                    // })
                }
            },

            searchResults(){
                const node = document.getElementById("content")
                while (node.firstChild) {
                    node.removeChild(node.lastChild)
                }

                let urlParams = new URLSearchParams();
                urlParams.append("title", this.$refs.search.value)

                Api.get('books?' + urlParams.toString())
                        .then(response => response.data)
                        .then(bookList => {this.showBooks(bookList)})
            },
            closeSearch() {
                document.getElementById("myOverlay").style.display = "none";
            }
        },
        computed: {
            // filteredList() {
            //     return this.booksList.filter(post => {
            //
            //
            //
            //     })
            // }
        }

    }
</script>

<style scoped>
    @import "./../assets/styles/main.css";

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

    .myOver input[type=text] {
        padding: 15px;
        font-size: 17px;
        border: none;
        float: left;
        width: 100%;
        background: white;
        align-self: center;
    }

    .myOver input[type=text]:hover {
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
</style>