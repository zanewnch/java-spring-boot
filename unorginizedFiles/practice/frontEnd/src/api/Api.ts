import axios from 'axios';
import type {Ref, ref} from "vue";
import {toRaw} from "vue";


export class GetApi {
    private request = axios.create(
        {
            baseURL: "/api",
            timeout: 5000
        }
    )

    constructor() {

        /*
        Set interceptors
         */
        this.request.interceptors.request.use((config) => {
                return config;
            }
        )
        this.request.interceptors.response.use(
            (response) => {
                return response;
            },
            (error) => {
                return Promise.reject(new Error(error.message));
            }
        )


    }

    public getRequest(){
        return this.request;
    }

    public async getCardInfo(
        pageNumRef: Ref, pageSizeRef: Ref, hospitalArrRef: Ref, hospitalTotalNumRef: Ref, hostype: string = '', districtCode: string = ''
    )
        : Promise<any> {

        let result: any = await this.request.get(`/hosp/hospital/${pageNumRef.value}/${pageSizeRef.value}?hostype=${hostype}&districtCode=${districtCode}`);

        if (result.data.code === 200) {
            hospitalArrRef.value = result.data.data.content;
            hospitalTotalNumRef.value = result.data.data.totalElements;
        }
        console.log(result);
    }

    public async getLevel(levelArrRef: Ref): Promise<any> {
        let result: any = await this.request.get(`/cmn/dict/findByDictCode/HosType`);
        if (result.status === 200) {
            levelArrRef.value = result.data.data;
        }
        console.log('The original result :')
        console.log(result);
        console.log('The relative Arr data :')
        console.log(levelArrRef.value);
        console.log(toRaw(levelArrRef.value[0]));

    }

    public async getRegion(regionArrRef: Ref): Promise<any> {
        let result: any = await this.request.get('/cmn/dict/findByDictCode/Beijin');
        if (result.status === 200) {
            regionArrRef.value = result.data.data;
        }
        console.log(result);

    }

    public async getHospitalName(hospitalName: string, callback: any) {
        let result: any = await this.request.get(`/hosp/hospital/findByHosname/${hospitalName}`)

        let showData =
            // result.data.data is an array
            /*
            this code snippet is turn original element in array into the object, each object has two keys: value and hosCode
             */
            result.data.data.map((item: any) => {
                return {
                    // The name of hospital
                    value: item.hosname,
                    // The encode of hospital
                    hosCode: item.hoscode,
                }
            });
        callback(showData);

        // return an array
        console.log(result.data.data);
    }

    public async getHospitalDetail(hoscode:string,store:any){
        let result:any = await this.request.get(`/hosp/hospital/${hoscode}`);
        if(result.status ===200){
            store = result.data.data;
        }

        console.log(result);
        console.log(store);
    }

}

