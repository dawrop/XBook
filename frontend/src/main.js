import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './axios'
import store from './store'

import { library } from "@fortawesome/fontawesome-svg-core";
import { faUserCircle, faHome, faSignOutAlt, faSearch, faStar, faPlus } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(faUserCircle, faHome, faSignOutAlt, faSearch, faStar, faPlus)
Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
