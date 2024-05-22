import {
    defineStore,
} from 'pinia';
import request from "@/utils/Requests";




export const useEmployeeStore = defineStore('employeeStore', {
    state: () => ({
        employeeStatic: {
            "department": ['Information Technology', 'Marketing', 'Financial', 'Administration'],
            "age": ["20~30","30~40","50~60"],
            "gender": ["male","female"]

        },
        requestData: null,
        department: '',
        age: '',
        gender: '',
        activeDepartment: '',
        activeAge: '',
        activeGender:'',
        employeeNumber:null
    }),
    getters:{},
    actions: {

        async SelectEmployeeAll(){
            try{
                const response = await request.get('/api/employees/all');
                this.requestData = response.data;
                // console.log(this.requestData);
            }catch (error){
                console.log("error...:",error);
            }
        },
        async selectEmployeeByNumber(){
            try{
                const response = await request.get('/api/employees',{
                    params:{
                        number: this.employeeNumber
                    }
                });
                this.requestData = response.data;
                console.log(this.requestData);
            }catch (error){
                console.log('error...',error);
            }
        },
        setDepartment(department:string){
            this.department = department;
            this.activeDepartment= department;
        },
        setAge(age:string){
            this.age = age;
            this.activeAge = age
        },
        setGender(gender:string){
            this.gender = gender;
            this.activeGender=gender;
        },
        setDepartmentInactive(){
            this.activeDepartment = '';
        },
        setAgeInactive(){
            this.activeAge = '';
        },
        setGenderInactive(){
            this.activeGender = '';
        }


    }
}
)
