/*
axios 二次封裝
axios 二次封裝的目的：
1. 利用axios請求、響應攔截器功能
2. 請求攔截器，可以在請求頭中攜帶公共參數，for example: 公共參數
3. 響應攔截器，簡化sever response的data, and 處理http網路錯誤
 */

import axios from 'axios';
// import { ElMessage } from 'element-plus';

// using axios.create to create an instance of axios: it can set basic route, overtime
const request = axios.create({
    /*
    set basic route for request
    for example: the url of api is: /api/order/orderInfo/auth/getStatusList
    when set baseURL:'/api'
    we can just type /order/orderInfo/auth/getStatusList
     */
    baseURL: "/api",
    // overtime for example: 如果超出5秒，那就是request fail
    timeout: 5000
})

// request interceptor
request.interceptors.request.use((config) => {
    // config 是請求攔截器return 的注入對象（配置對象）
    // config 上最重要的事情是他有headers attribute, 可以透過request header with public parameter(請求頭攜帶公共參數）-token

    // public parameter in request header
    // config.headers.a = 1111;

    // console.log(config)
    return config;
});

// response interceptor
request.interceptors.response.use(
    // successfully response, generally simplify the data
    (response) => {
        // return 123;
        // : app component request test is : 123

        // console.log(response.data);
        return response;
    },
    // fail resonpse, address http error
    (error) => {
        /*
        unified address http error
        let status = error.response.status;
        return status;
        (for example: 404)

        switch(status){

            case 404:
                // error message
                ElMessage({
                type: 'error',
                message:error.message
                // message: '請求失敗 路徑錯誤'
                });
                break;
            case 500|501|502|503|504|505:
                ElMessage({
                type: 'error',
                message: 'server 掛掉'
                });
                break;
                }
         */
        return Promise.reject(new Error(error.message));
    });


export default request;
