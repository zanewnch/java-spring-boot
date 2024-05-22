import {defineStore} from "pinia";
import type {AxiosResponse} from "axios";
import type Result from "@/utils/Result";
import request from "@/utils/Request";

export const useRegisterStore = defineStore('register', {
    state: (): {
        username: string,
        password: string,
        registrationDate: Date,
        lastLoginDate: Date,
        userStatus: string,
    } => {
        return {
            username: "",
            password: "",
            registrationDate: new Date(),
            lastLoginDate: new Date(),
            userStatus: ""
        }
    },
    actions: {
        async register(username: string, password: string, registrationDate: Date, lastLoginDate: Date, userStatus: string): Promise<void> {

            // 1. Validate whether the username and password are empty, if empty, directly return
            // @ts-ignore
            if (this.isEmpty()){
                console.log("username or password can not be empty")
                return;
            }

            // 2. Send a request to the backend to register
            const res: AxiosResponse<Result<string>> = await request.post('/UsersupermarketSale/register', {
                username: username,
                password: password,
                registrationDate: registrationDate,
                lastLoginDate: lastLoginDate,
                userStatus: userStatus
            }, {
                headers: {'Content-Type': 'application/json'}
            }
            );
        },
    },
    getters: {
        isEmpty(): boolean {
            return this.username.length == 0 || this.password.length == 0;
        }

    }
});