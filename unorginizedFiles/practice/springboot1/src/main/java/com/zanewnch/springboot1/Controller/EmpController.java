package com.zanewnch.springboot1.Controller;

import com.zanewnch.springboot1.pojo.Emp;
import com.zanewnch.springboot1.pojo.Result;
import com.zanewnch.springboot1.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
最原始的edtion
還沒有三層架構
也還沒有IOC
 */

@RestController
public class EmpController {

    @RequestMapping("/listEmp")
    public Result response(){

        //        Parse the xml file
        //        String XmlFile = Objects.requireNonNull(this.getClass().getClassLoader().getResource("emp.xml")).getFile();
        /*
        第一条语句使用了 Objects.requireNonNull() 进行了非空校验，
        确保获取到的资源路径不为 null，提高了代码的健壮性。而第二条语句没有进行非空校验，
        使用时需要注意资源路径是否为 null，可以根据实际情况决定是否需要进行非空校验。
         */

//        get path of xml
        String XmlFile = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        parse the xml
        List<Emp> empList = XmlParserUtils.parse(XmlFile,Emp.class);


        // address data
        empList.stream().forEach(emp ->{
                //处理 gender 1: 男, 2: 女
                String gender = emp.getGender();
                if("1".equals(gender)){
                    emp.setGender("男");
                }else if("2".equals(gender)){
                emp.setGender("女");
                }

                //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
                String job = emp.getJob();
                if("1".equals(job)){
                    emp.setJob("讲师");
                }else if("2".equals(job)){
                    emp.setJob("班主任");
                }else if("3".equals(job)){
                    emp.setJob("就业指导");
                }
        });

//        response
        return Result.success(empList);
    }
}
