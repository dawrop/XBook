<template>
    <div class="book">
        <img src="./../assets/covers/theShining.jpg">
    </div>
</template>

<script>
    export default {
        name: 'bookImgContainer',
    }
</script>

<style scoped>
    .book {
        margin: 35px;
        flex-wrap: wrap;
        background: white;
        display: flex;
        flex-direction: column;
    }

    .book > img {
        width: 15em;
        height: 22em;
        box-shadow: 3px 2px 2px 1px black;
    }   
</style>