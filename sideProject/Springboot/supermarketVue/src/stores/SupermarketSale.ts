import {defineStore} from 'pinia'
import request from "../utils/Request";


export const useSuperMarketSaleStore = defineStore('superMarketSale',  {
    state:() =>{
        return {
            requestData: null
        }
    },
    getters:{
        getRequestData():any{
            return this.requestData
        },

        setRequestData(data:any):void{
            this.requestData = data
        }

    },
    actions:{
        async read(){
            try{
                const res = await request.get('/superMarketSale',{
                    params:{
                    }
                })

                this.requestData = res.data;
            }catch (e){
                console.log(e)
            }
        }
    }


})