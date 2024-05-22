import {
    defineStore,
} from 'pinia';
import axios from "axios";


export const useTestStore = defineStore('testStore', {

    // getter and action都是屬於method,但getter 不會改變states 然後actions 會改變states

    state: () => ({
        count: 0,
        responseData: Promise.resolve(null),
        department: ["IT","Marketing","Administration"],
        departmentModel: "aaa"
    }),
    getters:{

    },
    actions: {
        increment() {
            this.count++;
        },
        decrement() {
            this.count--;
        },
        getCount(): Number {
            return this.count;
        },
        getRequestTest(): void {
            //
            const apiUrl = 'api/users';
            this.responseData = axios.get(apiUrl).then(response => {
                console.log('GET Response:', response.data.data[0].id);
                return response.data
            }).catch(error => {
                console.error('GET Error:', error);
            });
        },
        setDepartmentModel(departmentModel: any){
            this.departmentModel = departmentModel;
        }
    }}
)
