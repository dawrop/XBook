<template>
    <div class="book">
        <img v-bind:src="getImgURL(coverUuid)">
    </div>
</template>

<script>
    export default {
        name: 'bookImgContainer',
        props: {
            coverUuid: String
        },
        methods: {
            getImgURL(imgFile) {
                let images = require.context("../assets/covers", false, /\.png$/);
                return images("./" + imgFile + ".png");
            }
        }
    }

</script>

<style scoped>
    .book {
        margin: 35px;
        flex-wrap: wrap;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .book > img {
        width: 15em;
        height: 22em;
        box-shadow: 3px 2px 2px 1px black;
    }   
</style>