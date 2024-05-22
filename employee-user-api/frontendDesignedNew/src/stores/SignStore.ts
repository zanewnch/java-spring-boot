import { defineStore } from 'pinia'
import request from '@/utils/Requests'
import { toRaw } from 'vue'
import CookeiUtils from '../utils/CookieUtils';

export const useSignStore = defineStore('signStore', {
  state: (): {
    username: string
    password: string
    fetchData: Promise<void>
    isVisible: boolean
  } => ({
    username: '',
    password: '',
    fetchData: null,
    isVisible: false
  }),
  actions: {
    // for data security, the signin authentify should use post method(data in request body)
    // using toRaw to get the target of proxy(array)
    // 在js manipulate fetch data 就需要toRaw, 如果是在html 就可以直接用.attribute的形式
    async signInAuthenticate(username: string, password: string) {
      // request data for authentication
      const response = await request.post('/api/users/signIn', {
        username: username,
        password: password
      });

      // fetchData is jwtToken
      this.fetchData = response.data.data;

      // console.log(toRaw(this.fetchData));

      // determine the request whether is null, if null, set isVisible = true
      if (toRaw(this.fetchData) === null) {
        // isVissible is a boolean, this step is reverse the boolean value in order to control the display element
        this.isVisible = !this.isVisible
      } else {
        console.log(response.data)
        console.log('sign in successful')

        // 因為我sign in and sign up 要共用同一組state，所以我把他清空，也不知道這一步到底需不需要，但至少不會導致issue
        this.username = '';
        this.password = '';
        this.isVisible = false;

        // the response data only has token key, assign response data to cookie
        CookeiUtils.setToken('jwtToken',response.data.data.token);

        
      }

      // sign in successful, router change
    },
    async signUpAuthenticate(username: string, password: string) {
      // request data for authentication
      const response = await request.post('/api/users/signUp', {
        username: username,
        password: password
      });
      this.fetchData = response.data.data;

      // in this case, if response is null, it mean success; but if response the string, it mean failure;which is reverse to sign in method

      if (toRaw(this.fetchData) !== null) {
        
        this.isVisible = !this.isVisible
      } else {
        console.log('sign up successful')

        this.username = '';
        this.password = '';
        this.isVisible = false;
      }
    }
  },
  getters: {}
})
