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
    import axios from "axios";
    import Vue from "vue";

    export default {
        name: 'Home',
        components: {
            navigation
        },
        mounted() {
            axios
                .get('http://localhost:8080/books')
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
                }
            }
        }

    }
</script>

<style scoped>
    @import "./../assets/styles/main.css";

</style>