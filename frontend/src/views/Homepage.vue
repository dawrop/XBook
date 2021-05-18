<template>
    <div id='Home'>
        <navigation/>

        <main>
            <header>
                <div class="logo-homepage">
                    <img src="./../assets/xbook_logo.png">
                </div>
            </header>

            <section class="content">
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                <bookImgContainer/>
                
            </section>
        </main>
        
    </div>
    
</template>

<script>
    import navigation from "./../components/navigation.vue";
    import bookImgContainer from "./../components/bookImgContainer.vue";

    export default {
        name: 'Home',
        components: {
            navigation,
            bookImgContainer
        }

    }
</script>

<style scoped>
    @import "./../assets/styles/main.css";

</style>