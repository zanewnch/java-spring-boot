import { defineStore } from 'pinia';
import {GetApi} from "@/api/Api";
import {toRaw} from "vue";
const getApi = new GetApi();

const useDetailStore = defineStore('Detail',{
    state:()=>{
        return{
            hospitalInfo:{}
        }
    },
    actions:{
        async getHospital(hoscode:string){
            // getApi.getHospitalDetail(hoscode,this.hospitalInfo);
            // console.log(this.hospitalInfo)
            let result:any = await getApi.getRequest().get(`/hosp/hospital/${hoscode}`);
            this.hospitalInfo = result.data.data;
            console.log(this.hospitalInfo)
        }
    },
    getters:{

    }
});
export default useDetailStore;