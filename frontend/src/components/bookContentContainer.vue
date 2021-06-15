<template>
    <div id="dimness">
        <div class="bookInfo">
            <div class="bookImg">
                <bookImgContainer :cover-uuid="cover"/>
            </div>
            <form class="bookContent">
                <a>Title: {{ title }}</a>
                <a>Description: {{ description }}</a>
                <a>Genre: {{ genre }}</a>
                <a>Author: {{ author }}</a>

                <button type="button" v-on:click.prevent="addToFav" v-on:click="closePopup">Add to favourites</button>
            </form>
            <span class="closebtn" v-on:click="closePopup" title="Close Popup">x</span>
        </div>
    </div>
</template>

<script>
import bookImgContainer from "@/components/bookImgContainer";
import {Api} from "@/apiHandler/apiHandler";
import Book from "@/models/book";

export default {
    name: "bookContentContainer",
    components: {
        bookImgContainer
    },
    data() {
        return {
            book: new Book(
                    this.id,
                    this.title,
                    this.description,
                    this.genre,
                    this.author,
                    this.cover)
        }
    },
    props: {
        id: Number,
        title: String,
        description: String,
        genre: String,
        author: String,
        cover: String,

    },
    methods: {
        addToFav() {
            Api.post('favourites', {id: this.$props.id})
        },
        closePopup(){
            this.$el.parentNode.removeChild(this.$el);
        }
    }
}
</script>

<style scoped>

#dimness {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: rgba(0, 0, 0, 0.5);

    display: block;
}
.bookInfo {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

    height: auto;
    width: 55em;
    background: #d3b300;
    align-self: center;


    display: flex;
    flex-direction: row;
    justify-content: space-evenly;

}

.bookImg {
    width: 50%;
    align-self: center;
}

.bookImg img {
    width: 25em;
    height: 40em;

    align-self: center;
    margin-left: 3em;
}

.bookContent {
    width: 50%;
    height: 90%;
    display: flex;
    flex-direction: column;
    margin: 2em;
}

.bookContent a {
    font-size: 1.5em;
    margin: 0.5em;
}

.bookContent button {
    background: #00000066 0% 0% no-repeat padding-box;
    border: 1px solid #707070;
    border-radius: 7px;

    width: 40%;
    border: none;
    color: white;
    margin: 0.5em;
    line-height: 2.5em;
    font-size: 1.25em;
    align-self: center;
}

.closebtn {
    position: absolute;
    top: -65px;
    right: -50px;
    font-size: 60px;
    cursor: pointer;
    color: white;
}
</style>