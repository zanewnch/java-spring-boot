import {defineStore} from "pinia";
import request from "@/utils/Requests";

export const useSearchBarStore = defineStore('searchBarStore', {
    state: () => ({
        requestData: null,
        // the searchBarContent is dynamic change by search bar
        searchBarContent: ''
    }),
    actions: {
        // If queryString is an empty string, the request URL will still include the query parameter with an empty value, like this: url?queryString=.
        async getEmployeesBySearch(queryString: string): Promise<void> {
            try {
                const response = await request.get('/api/employees/search', {
                    params: {
                        // the first queryString is the parameterName, and the second queryString is the variable passing when method invoked
                        queryString: queryString
                    }
                });
                this.requestData = response.data;

                // console.log(this.requestData);

            } catch (error) {
                console.log("Error:", error)
            }
        }
    },
    getters: {}
})