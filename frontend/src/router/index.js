import Vue from 'vue'
import VueRouter from 'vue-router'
import routes from './routes'

Vue.use(VueRouter)

const router = new VueRouter({
    mode: 'history',
    routes
})

router.beforeEach((to, from, next) => {
   const publicPages = ['/', '/signup'];
   const authRequired = !publicPages.includes(to.path);
   const loggedIn = localStorage.getItem('user');

   if (authRequired && !loggedIn) {
       next('/');
   } else {
       next();
   }
});

export default router