package com.zanewnch.springboot1.dao.impl;

import com.zanewnch.springboot1.dao.EmpDao;
import com.zanewnch.springboot1.pojo.Emp;
import com.zanewnch.springboot1.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp(){

        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
