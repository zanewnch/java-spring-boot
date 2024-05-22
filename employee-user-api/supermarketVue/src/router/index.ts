import { createRouter, createWebHistory } from 'vue-router'



const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      // @ts-ignore
      component: () => import('../views/HomeView.vue')
    },
    {
      path: '/data',
      name: 'data',
      // @ts-ignore
      component: () => import('../views/DataView.vue')
    },
    {
      path: '/test',
      name: 'test',
        // @ts-ignore
      component: () => import('../views/tests/TestView.vue')
    },
    {
      path: '/login',
      name: 'login',
        // @ts-ignore
      component: () => import('../views/LoginView.vue')
    },
    {path:'/register',
      name:'register',
        // @ts-ignore
        component:()=>import('../views/RegisterView.vue')
    }

  ]
})

export default router
