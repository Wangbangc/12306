import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/login/index.vue'
import TicketSearch from '../views/ticket-search/index.vue'
import Userinfo from '../views/user-info/index.vue'
import OrderList from '../views/order-list/index.vue'

import Team from '../views/team/index.vue'
 const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
     {
         path: '/team',
         name: 'team',
         component: Team,

     },

     {
       path: '/orderList',
       name: 'orderList'  ,
         component: OrderList,
     },
     {
       path: '/userinfo',
       name: 'userinfo',
       component: Userinfo,
     },
     {
         path: '/login',
         name: 'login',
         component: Login,

     }
     ,{path: '/ticketSearch',
     name: 'ticketSearch',
         component: TicketSearch,
     },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
