import {createRouter, createWebHistory} from 'vue-router'


// createRouter method, which use to create router instance, and manage all of router

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            name: "home",
            component: () => import('../views/HomeView.vue')
        },
        {
            path: "/hospital",
            name: "hospital",
            component: () => import("../views/HospitalView.vue"),
            children: [
                {
                    path: 'detail',
                    component: () => import('../components/Hospital/Detail.vue')
                },
                {
                    path: 'maintenance',
                    component: () => import('../components/Hospital/Maintenance.vue')
                },
                {
                    path: 'notification',
                    component: () => import('../components/Hospital/Notification.vue')
                },
                {
                    path: 'query',
                    component: () => import('../components/Hospital/Query.vue')
                },
                {
                    path: 'reservation',
                    component: () => import('../components/Hospital/Reservation.vue')
                }
            ]
        },
        {
            path:'/test',
            name: 'test',
            component: ()=> import('../views/test.vue')
        }
    ],
//     控制頁面滑動條 每次刷新頁面的時候都要重新置頂
    scrollBehavior() {
        return {
            left: 0,
            top: 0
        }
    }
});

export default router;

