package com.zanewnch.springboot1.service.impl;

import com.zanewnch.springboot1.dao.EmpDao;
import com.zanewnch.springboot1.pojo.Emp;
import com.zanewnch.springboot1.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*
要切換instance 只要切換class上面的@Componet
假設我現在要使用 EmpServiceB
那我就把EmpServiceA 的@Component 註解掉
然後在 EmpServiceB 的class上加上@Component
 */
//@Component
@Service
public class EmpServiceB implements EmpService {

/*
因為EmpDaoA的method listEmp不是static,所以要先創建EmpDaoA 的instance 才可以使用 EmpDaoA 的method
 */
//    private EmpDao empdao = new EmpDaoA();
    @Autowired
    private EmpDao empdao;

    @Override
    public List<Emp> listEmp(){

//        get data
        List<Emp> empList = empdao.listEmp();

//        address data
        empList.stream().forEach(emp -> {
            //处理 gender 1: 男, 2: 女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("Male");
            }else if("2".equals(gender)){
                emp.setGender("Female");
            }

            //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("Teacher");
            }else if("2".equals(job)){
                emp.setJob("Manager");
            }else if("3".equals(job)){
                emp.setJob("Consultant");
            }
        });

        return empList;

    }



}
