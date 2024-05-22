import '@/style/reset.scss'
import { createApp } from 'vue'
import App from './App.vue'
import TopComponent from './components/top/index.vue'
import BottomComponent from './components/bottom/index.vue'
// import vue router
import router from './router'
// import element-plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// import element-plus icon
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import pinia from './stores';
/*
    using createApp to create instance page
    and mount App to #app
    which equal to :

    const app = createApp(App);
    app.mount('#app');

 */

/*
    The project default syntax is:
    createApp(App).mount('#app');
    in order to fluent using other method,
    so it is a better way to use:
    const app = createApp(App);
 */

const app = createApp(App);

/*
教學video 是說在這邊要app.component() to load component, but I can directly import component in App.vue to be global component, it is not necessary to use app.component() here
 */
// app.component("TopComponent",TopComponent);
// app.component("BottomComponent",BottomComponent)

app.use(router);
app.use(ElementPlus);
app.use(pinia);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
};
app.mount('#app');

/*
完成到p.19  要做p.20
 */