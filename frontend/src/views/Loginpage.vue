<template>
    <div id="Login">
        <img src="./../assets/xbook_logo.png">
        <loginContainer/>        
    </div>
</template>

<script>
    import loginContainer from "./../components/loginContainer.vue";

    export default {
        name: 'Login',
        components: {
            loginContainer
        }
            
    }
</script>

<style scoped>
    #Login {
        height: 100vh;
        display: flex;
        align-items: center;
        flex-wrap: wrap;
        justify-content: space-evenly;
  }
</style>