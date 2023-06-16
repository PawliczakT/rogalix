import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from './components/Home.vue';
import Register from './components/Register.vue';
import Login from './components/Login.vue';

Vue.use(VueRouter);

const routes = [
  { path: '/home', component: Home },
  { path: '/register', component: Register },
  { path: '/login', component: Login },
];

const router = new VueRouter({
  mode: 'history',
  routes,
});

export default router;
