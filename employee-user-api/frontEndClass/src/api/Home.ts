// 統一管理api
import request from '../utils/request'
import type {HospitalLevelAndRegionResData, HospitalResData, OriResponseData} from "@/api/type";

enum API{
    // get hospital detail data
    HospitalApi = '/hosp/hospital/',
//     get level and region of hospital
    HospitalLevelAndRegion = '/cmn/dict/findByDictCode/'
}

export const reqHospital = (page:number, limit:number) => {
    // request.get<any,HospitalResData>(API.HospitalApi + `${page}/${limit}`)
    request.get(API.HospitalApi+`${page}/${limit}`);
    console.log(API.HospitalApi+`${page}/${limit}`)
}

export const reqHospitalLevelAndRegion = (dictCode:string)=> {
    request.get<any,HospitalLevelAndRegionResData>(API.HospitalLevelAndRegion + `${dictCode}`);
}

