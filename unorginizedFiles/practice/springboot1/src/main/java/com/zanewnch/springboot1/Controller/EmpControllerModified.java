package com.zanewnch.springboot1.Controller;

import com.zanewnch.springboot1.pojo.Emp;
import com.zanewnch.springboot1.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
這一版是我自己寫的
只有替換掉換取xml 改成自己create arraylist
 */

@RestController
public class EmpControllerModified {

    @RequestMapping("/EmpTest")
    public Result address(){
//      Get data
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp("a",20,"nothing","1","1"));
        empList.add(new Emp("b",30,"nothing","0","1"));
        empList.add(new Emp("c",40,"nothing","0","0"));

//        address data
        empList.stream().forEach(emp ->{
            String gender = emp.getGender();
            if(gender == "1"){
                emp.setGender("Male");
            }else{
                emp.setGender("Female");
            }

            String job = emp.getJob();
            if(job == "0"){
                emp.setJob("Teacher");
            }else {
                emp.setJob("Student");
            }

        });

//        response data
        return Result.success(empList);

    }
}
