<template>
    <div class="avatar">
        <img v-bind:src="getImgURL(avatarUuid)">
    </div>
</template>

<script>
    export default {
        name: 'bookImgContainer',
        props: {
            avatarUuid: String
        },
        methods: {
            getImgURL(imgFile) {
                let images = require.context("../assets/avatars", false, /\.png$/);
                return images("./" + imgFile + ".png");
            }
        }
}

</script>

<style scoped>
    .avatar {
        margin: 35px;
        flex-wrap: wrap;
        background: white;
        display: flex;
        flex-direction: column;
    }

    .avatar > img {
        width: 22em;
        height: 22em;
        box-shadow: 3px 2px 2px 1px black;
    }
</style>