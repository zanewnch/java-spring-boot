package com.zanewnch.webmanagement.service;

import org.zanewnch.Employee;
import org.zanewnch.PageBean;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeService {
    List<Employee> selectAllEmployees();

    PageBean selectEmployeesWithPagination(Integer pageNum, Integer pageSize);



    List<Employee> selectEmployees(
            Integer id,
            String name,
            Integer number,
            Integer age,
            String gender,
            LocalDateTime createTime,
            LocalDateTime updateTime
    );


}
