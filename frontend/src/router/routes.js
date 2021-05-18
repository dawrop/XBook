import Login from '../views/Loginpage.vue'
import SignUp from '../views/SignUppage.vue'
import Home from '../views/Homepage.vue'
import Profile from "@/views/Profile"
import AddBook from  '../views/AddBookpage'

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
  },
  {
    path: '/profile',
    name: 'Profile',
    component: Profile
  },
  {
    path: '/addbook',
    name: 'AddBook',
    component: AddBook
  }
]

export default routes