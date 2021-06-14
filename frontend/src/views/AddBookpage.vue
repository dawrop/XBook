<template>
    <div id="Home">
        <navigation/>
        <main>
            <header>
                <div class="logo-homepage">
                    <img src="./../assets/xbook_logo.png">
                </div>
            </header>

            <section class="content-add">
                <h1>Upload</h1>
                <form class="form" v-on:submit.prevent="handleSubmit">
                    <input name="title" v-model.trim="book.title" type="text" placeholder="Title">
                    <textarea name="description" v-model.trim="book.description" rows="5" placeholder="Description"></textarea>
                    <input name="genre" v-model.trim="book.genre" type="text" placeholder="Genre">
                    <input name="author" v-model.trim="book.author" type="text" placeholder="Author">
                    <input ref="cover" type="file" name="file">
                    <button type="submit">Send</button>
                </form>

            </section>
        </main>
    </div>

</template>

<script>
import navigation from "./../components/navigation.vue";
import Book from "@/models/book";
import authHeader from "@/services/auth-header";
import axios from "axios";
const API_URL = 'http://localhost:8080/';

export default {
    name: "AddBookpage",
    components: {
        navigation
    },
    data() {
        return {
            book: new Book('', '', '', '', '')
        }
    },
    methods: {
        sendCover() {
            let user = JSON.parse(localStorage.getItem('user'));
            let coverFile = this.$refs.cover.files[0];
            let reqBody = new FormData();
            reqBody.append("file", coverFile);
            fetch("http://localhost:8080/covers", {
                method: "post",
                body: reqBody,
                credentials: "omit",
                headers: {
                    'Authorization': 'Bearer ' + user.accessToken
                }
            }).then(response => {
                if (response.status === 200)
                    return response
                throw response.status
            })
                .then(response => response.json())
                .then(reqBody => {
                    this.book.cover = reqBody.message;
                    this.sendBookData()
                })
                .catch(console.error);
        },
        sendBookData(){
            axios.post(API_URL + 'books', {
                title: this.book.title,
                description: this.book.description,
                author: this.book.author,
                genre: this.book.genre,
                cover: this.book.cover
            }, { headers: authHeader() }).then(response => {
                console.log(response.data)
                this.$router.push('/')
            }).catch(console.error);
        },
        handleSubmit() {
            this.sendCover()

        }

    }
}
</script>

<style>
    @import "./../assets/styles/main.css";

    .content-add {
        display: flex;
        flex-direction: column;
        justify-content: center;
    }

    h1 {
        color: whitesmoke;
        font-size: 40px;
        text-decoration: underline darkgray;
        font-style: italic;
        font-family: fantasy;
        margin: 30px;
    }

    textarea {
        background-color: transparent;
        border: none;
        border-bottom: 1px solid black;
        padding: 0.5em;
        margin: 1em;
        width: auto;

        font-size: 1.5em;
        font-family: Arial;
    }

    form {
        display: flex;
        flex-direction: column;
        align-self: center;
    }

    .form ::placeholder {
        color: #bbbbbb;
    }

    .form input {
        border-bottom-color: black;
    }

    @media only screen and (max-device-width: 420px) {
        #Home {
            flex-direction: column;
            height: 101vh;
        }

        .logo-homepage {
            display: none;
        }

        .content-add {
            display: block;
            height: 94.5vh;
        }

        .content-add > form {
            height: 80vh;
        }
    }

</style>