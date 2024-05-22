import {defineStore} from "pinia";
import type {AxiosResponse} from "axios";
import type Result from "@/utils/Result";
import request from "@/utils/Request";


export const useLoginStore = defineStore('login', {
    state: (): {
        username: string,
        password: string
    } => {
        return {
            username: "",
            password: ""
        }
    },
    actions: {
        async login(username: string, password: string): Promise<void> {
            try {

                // 1. Validate whether the username and password are empty, if empty, directly return

                // @ts-ignore
                if (this.isEmpty()) {
                    console.log("username or password can not be empty")
                    return;
                }

                // 2. Send a request to the backend to login
                const res: AxiosResponse<Result<string>> = await request.post('/UsersupermarketSale/login', {

                        username: username,
                        password: password
                    },
                    {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    });

                console.log(res);
            } catch (e) {
                console.log(e);
            }
        }
    },
    getters: {
        /**
         * @description: Validate whether the username and password are empty
         * @return {boolean}
         * @date: 2021/5/30 16:47
         * @param
         */
        isEmpty(): boolean {
            return this.username.length == 0 || this.password.length == 0;

        }
    }

})