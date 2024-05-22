package com.zanewnch.mybatismaven;

import com.zanewnch.mybatismaven.mapper.EmpMapper;
import com.zanewnch.mybatismaven.mapper.UserMapper;
import com.zanewnch.mybatismaven.model.Emp;
import com.zanewnch.mybatismaven.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
@SpringBootTest is used to declare the class is a test class, and it would auto create the IOC container
 */
@SpringBootTest
class MyBatisMavenApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    /*
    @Autowired is used to declare the variable is a bean, and it would auto inject the bean into the variable
     */
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();

        /*
        在sql table當中 一個row 就是一個object(User)
         */

        userList.stream()
                .forEach(user -> {
                    System.out.println(user);
                });
    }

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDeleteEmp() {
        int theNumberOfDeleteData = empMapper.delete(17);
        System.out.println(theNumberOfDeleteData);
    }

    @Test
    public void testInsertEmp() {
        Emp emp = new Emp();
        emp.setUsername("test");
        emp.setName("test");
        emp.setImage("test");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntryDate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
        //        after add @Options annotation, emp object would have id value
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdateEmp() {
        Emp emp = new Emp();
        emp.setId(10);
        emp.setUsername("test");
        emp.setName("test");
        emp.setImage("test");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntryDate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
    }

    @Test
    public void testSelectEmp() {
        Emp emp = empMapper.getById(10);
        System.out.println(emp);
    }

    @Test
    public void XMLSelectEmp() {
        List<Emp> empList = empMapper.XMLSelectEmp("張",null,null,null);
    empList.stream().forEach(emp -> {
        System.out.println(emp);
    });
    }

}
