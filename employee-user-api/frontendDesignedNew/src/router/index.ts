import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      component: () => import('../views/HomeView.vue')
    },
    {
      path: '/test',
      name: 'test',
      component: () => import('../views/TestView.vue')
    },
    {
      path : '/employees',
      name: 'employees',
      component: () => import('../views/EmployeesView.vue'),
      children: [
        {
          // each equal to /employees/information, which would apply the component provided by EmployeesView.vue, and the router view is the following component
          path: 'information',
          component: () => import('../components/Employees/Information.vue')
        },
        {
          path: 'notification',
          component: () => import('../components/Employees/Notification.vue')
        },
        {
          path: 'reservation',
          component: () => import('../components/Employees/Reservation.vue')
        },
      ]
    },
    {
      path:'/signIn',
      name: 'signIn',
      component: () => import('../views/SignInView.vue')
    },
    {
      path:'/signUp',
      name: 'signUp',
      component: () => import('../views/SignUpView.vue')
    },
    {
      // redirect, when links to '/', auto redirect to '/home'
      path: '/',
      redirect: '/home'
    },
    {
      path: '/employees',
      redirect : '/employees/information'
    }
  ],
//   每次重新加載頁面的時候 scroll to the top
  scrollBehavior(){
    return{
      left:0,
      top:0
    }
  },
})

export default router;
