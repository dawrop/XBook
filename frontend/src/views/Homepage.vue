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
    #Home{
        display: flex;
        align-items: center;
        justify-content: flex-start;
        height: 100vh;
    }

    main {
        flex: 1;
        display: flex;
        flex-direction: column;
        height: 100%;
        width: 100%;
    }

    header {
        align-self: stretch;
    }

    .logo-homepage {
        margin-left: auto;
        text-align: right;
    }

    .logo-homepage > img {
        width: 15em;
        margin: 1.5em 1.5em;
    }

    .content {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        overflow: auto;
        justify-content: space-evenly;
    }

</style>