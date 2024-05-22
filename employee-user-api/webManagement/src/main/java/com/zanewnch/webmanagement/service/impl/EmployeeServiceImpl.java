package com.zanewnch.webmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zanewnch.webmanagement.mapper.EmployeeMapper;
import com.zanewnch.webmanagement.service.EmployeeService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.zanewnch.Employee;
import org.zanewnch.PageBean;

import java.time.LocalDateTime;
import java.util.List;

// the @Primary make this impl is the first option in the order of impl
@Primary
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeMapper.selectAllEmployees();
    }

    /*
    select with pageHelper, the sql console just needs to be "select * from employees"

    pageNum is the current page
    pageSize is the numbers of data rendered in single page
     */
    @Override
    public PageBean selectEmployeesWithPagination(Integer pageNum, Integer pageSize) {

        //        1. set the page parameters (with pageNum and PageSize
        PageHelper.startPage(pageNum, pageSize);

        //        2. run mappers, and need to turn the original data type List<Employee> to Page<Employee>, because needs to use the specific object methods
        Page<Employee> result = (Page<Employee>) employeeMapper.selectEmployeesWithPagination();



        //        3. encapsulate the pageBean object
        // the pageBean has two fields, the totalDataAmounts is the total amounts of data in the table
        // and the second field selectEmployees is List<Employee>

        //        getTotal:
        //        the total numbers of rows of data
        //        (with getTotal(), there is no necessary to use "select count(*) from employees")

        //        getResult:
        //        the List<Employee>
        return new PageBean<>(result.getTotal(),result.getResult());



    }



    @Override
    public List<Employee> selectEmployees(
            Integer id,
            String name,
            Integer number,
            Integer age,
            String gender,
            LocalDateTime createTime,
            LocalDateTime updateTime
    ){
        return employeeMapper.selectEmployees(id,name,number,age,gender,createTime,updateTime);
    }


}
