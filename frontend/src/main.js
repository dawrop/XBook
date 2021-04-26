import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './axios'
import Vuelidate from 'vuelidate'
import store from './store'

import { library } from "@fortawesome/fontawesome-svg-core";
import { faUserCircle, faHome, faSignOutAlt, faSearch, faStar } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(faUserCircle, faHome, faSignOutAlt, faSearch, faStar)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false
Vue.use(Vuelidate);

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
