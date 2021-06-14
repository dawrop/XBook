<template>
    <div id='Home'>
        <navigation/>

        <main>
            <header>
                <div class="logo-homepage">
                    <img src="./../assets/xbook_logo.png">
                </div>
            </header>

            <section class="content" ref="content" />
        </main>
    </div>
    
</template>

<script>
    import navigation from "./../components/navigation.vue";
    import bookImgContainer from "./../components/bookImgContainer.vue";
    import Vue from "vue";
    import {Api} from "@/apiHandler/apiHandler";


    export default {
        name: 'Home',
        components: {
            navigation
        },
        data() {
            return {
                search: ""
            }
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
            getSearch(search) {
                this.search = search
            },
            searchResults(){
                let urlParams = new URLSearchParams();
                urlParams.append("genre", this.search)
                Api.get('books?' + urlParams.toString())
                        .then(response => response.data)
                        .then(bookList => {this.showBooks(bookList)})
            }
        },
        computed: {

        }

    }
</script>

<style scoped>
    @import "./../assets/styles/main.css";

</style>