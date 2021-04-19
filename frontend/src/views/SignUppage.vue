<template>
    <div id="SignUp">
        <img src="./../assets/xbook_logo.png">
        <signupContainer/>
    </div>
</template>

<script>
    import signupContainer from "./../components/signupContainer.vue";

    export default {
        name: 'SignUp',
        components: {
            signupContainer
        }
            
    }
</script>

<style scoped>
    #SignUp {
        height: 100vh;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
        overflow: auto;
        justify-content: space-evenly;
  }
</style>