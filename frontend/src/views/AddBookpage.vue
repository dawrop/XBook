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
                    <input name="title" type="text" placeholder="Title">
                    <textarea name="description" rows="5" placeholder="Description"></textarea>
                    <input name="genre" type="text" placeholder="Genre">
                    <input name="author" type="text" placeholder="Author">
                    <input type="file" name="file">
                    <button type="submit">Send</button>
                </form>

            </section>
        </main>
    </div>

</template>

<script>
import navigation from "./../components/navigation.vue";

export default {
    name: "AddBookpage",
    components: {
        navigation
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
        color: #000000;
    }

    .form input {
        border-bottom-color: black;
    }

</style>