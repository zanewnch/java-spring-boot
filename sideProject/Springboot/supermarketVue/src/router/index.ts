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
    }
  ]
})

export default router
