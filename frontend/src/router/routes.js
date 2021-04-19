import Login from '../views/Loginpage.vue'
import SignUp from '../views/SignUppage.vue'
import Home from '../views/Homepage.vue'

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/home',
    name: 'Home',
    component: Home
  }
]

export default routes