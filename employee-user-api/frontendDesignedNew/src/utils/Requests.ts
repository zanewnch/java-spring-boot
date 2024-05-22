// add axios interceptor

import axios from 'axios'
import CookieUtils from './CookieUtils'
import router from '@/router'




const request = axios.create({
  // basic and common request path
  //由於你使用了 Vite 的代理功能，這部分的設定會被代理的設定覆蓋。
  //
  // 在你的設定中：
  //
  // 當你進行一個對 /api 開頭的請求時，Vite 會將這個請求代理到 http://localhost:8080/api。在這種情況下，axios 的 baseURL 設定不會起作用，因為 Vite 代理已經將請求重新定向到新的地址。
  //
  // 如果你進行的請求不是以 /api 開頭的，那麼 axios 的 baseURL 設定就會起作用。例如，如果你做了這樣的請求 request.get("/otherpath")，那麼實際的請求URL將會是 http://localhost:8080/otherpath，在這種情況下，baseURL 是有效的。
  //
  // 總之，如果你的請求路徑是 /api 開頭的，那麼 Vite 的代理設定會起作用，並覆蓋 axios 的 baseURL。如果請求路徑不是 /api 開頭的，那麼 axios 的 baseURL 會被使用。
  //結論：以/api開頭的話，就會被vite代理奪走主控權，這邊interceptor的baseURL就沒有起作用
  baseURL: 'http://localhost:8080',
  // set the limit of request time, if it exceeds 5s, it would be regarded as a failure.
  timeout: 5000
})

request.interceptors.request.use((config) => {
  // the most important part of interceptor's config is header, which can pass
  // public parameter with request header, which like token.

  // 攜帶parameter in header
  // 當我一設定header.TOKEN 就被CORS擋住：
  // 當您進行跨域請求並嘗試設置一些特定的HTTP headers時，瀏覽器會先發送一個名為“預檢”(preflight)的請求。這個預檢請求是一個OPTIONS請求，用於檢查實際請求是否安全。
  //
  // 當您設置 config.headers.TOKEN，這將觸發瀏覽器發送預檢請求，因為這不是標準的跨域安全header。
  //
  // 為了讓這個請求成功，您的後端伺服器必須適當地回應這個預檢請求，並允許 TOKEN 這個header。這通常涉及到設置以下的HTTP headers：
  // config.headers.TOKEN = 'testToken';

  if (CookieUtils.getToken('jwtToken')) {
    config.headers.Token = CookieUtils.getToken('jwtToken')
  }

  // config is the object interceptor injected, which would add additional attribute to the request, so need to return it.

  // console.log(config); // it can show to additional attribute config provided
  return config
})

request.interceptors.response.use(
  (response) => {
    //     the main goal of response of interceptor is to simplify the response data

    // retrun 'interceptorTest';
    // return response.data;

    // using return response:
    // { "code": 1, "msg": "success", "data": [ { "id": 1, "name": "Carson Wuckert", "number": 373, "age": 49, "gender": "male", "createTime": [ 2023, 9, 11, 23, 58, 41 ], "updateTime": [ 2023, 9, 11, 23, 58, 41 ] }
    // which is the Result entity in backend

    // using return response.data:
    // [ { "id": 1, "name": "Carson Wuckert", "number": 373, "age": 49, "gender": "male", "createTime": [ 2023, 9, 11, 23, 58, 41 ], "updateTime": [ 2023, 9, 11, 23, 58, 41 ] }
    // which directly is the part of the exact data

    // 在interceptor console.log(response.data) 就可以直接看到response 的 data, 以後不必在每一個request method 後面都加console.log
    console.log(response.data)
    console.log(response.data.data)

    //
    switch (response.data.msg) {

      case 'TokenNotExisted':

        router.push('/signIn');
        break;

      case 'InvalidToken':

        router.push('/signIn')
        break;
    }

    return response
  },
  (error) => {
    // 雖然錯誤訊息應該是handled by backend

    // the error object like config, the axios injected, which with additional attribute.
    // console.log(error);
    // let status = error.response.status; // ex:404, 500, 202

    // switch (status){
    //     case 404:
    //         //     address request error
    //         return Promise.reject(new Error(error.message));
    //
    // }
    return Promise.reject(new Error(error.message))
  }
)

export default request
