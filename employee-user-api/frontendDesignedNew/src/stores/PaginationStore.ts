import {
    defineStore,
} from 'pinia';
import request from "@/utils/Requests";

export const usePaginationStore = defineStore('paginationStore', {
        state: () => ({
                pageNum: 1,
                pageSize: 10,
                requestData: null
            }),
        actions: {
            async getEmployeesByPage() {
                try {
                    const response = await request.get('/api/employees', {
                        params: {
                            pageNum: this.pageNum,
                            pageSize: this.pageSize
                        }
                    });
                    this.requestData = response.data;
                    console.log(response.data)
                }catch (error){
                    console.log("Error fetching employee data:",error)
                }
            }
        },
        getters: {}

    }
)