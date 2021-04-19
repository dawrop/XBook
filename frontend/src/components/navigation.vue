<template>
    <div id="nav">
        <div id="myLinks">
            <a>
                1
            </a>
            <a>
                2
            </a>
            <a>
                3
            </a>
            <a>
                4
            </a>
            <a>
                5
            </a>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'navigation'
    }
</script>

<style scoped>
    #nav {
        min-width: 4em;
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        align-items: center;
        background: transparent linear-gradient(180deg, #000000 0%, #8a7500 100%) 0% 0% no-repeat padding-box;
    }
    
    #myLinks {
        display: flex;
        flex-direction: column;
        margin-top: 120px;
        align-items: center;
    }

    a {
        background: transparent;
        border: none;
        outline: none;
        color: white;
        font-size: 1.5em;
        cursor: pointer;
        margin-top: 40px;
    }

    a:hover{
        color: #777777;
    }
</style>