// Original response data
export interface OriResponseData {
    code: number,
    message: string,
    ok: boolean
}

/*
API: HospitalApi
 */

// the key data in response data
export interface HospitalResData extends OriResponseData {
    data: {
        content: HospitalDetailArr,
        empty: boolean,
        first: boolean,
        last: boolean,
        number: number,
        numberOfElements: number,
        pageable: {
            offset: number,
            pageNumber: number,
            pageSize: number,
            paged: boolean,
            sort: {
                empty: boolean,
                sorted: boolean,
                unsorted: boolean
            },
            unpaged: boolean
        },
        size: number,
        sort: {
            sorted: boolean,
            unsorted: boolean,
            empty: boolean
        },
        totalElements: number,
        totoPages: number
    }
}

// the key content in key data
export type HospitalDetailArr = HospitalDetail[];

// The detail in key content
export interface HospitalDetail {
    id: string,
    createTime: string,
    updateTime: string,
    isDeleted: number,
    param: {
        hostypeString: string,
        fullAddress: string
    },
    hoscode: string,
    hosname: string,
    hostype: string,
    provinceCode: string,
    cityCode: string,
    districtCode: string,
    address: string,
    logoData: string,
    intro: string,
    route: string,
    status: number,
    bookingRule: {
        cycle: number,
        releaseTime: string,
        stopTime: string,
        quitDay: number,
        quitTime: string,
        rule: string[]
    }
};

/*
Api: HospitalLevelAndRegion
 */

export interface HospitalLevelAndRegion {
    id: number,
    createTime: string,
    updateTime: string,
    isDeleted: number,
    param: {},
    parentId: number,
    name: string,
    value: string,
    dictCode: string,
    hasChildren: boolean
}

export type HospitalLevelAndRegionArr = HospitalLevelAndRegion[];

export interface HospitalLevelAndRegionResData extends OriResponseData {
    data: HospitalLevelAndRegionArr
}