package org.zane.server.mapper;


import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CachePut;
import org.zane.dto.EmployeeDto;
import org.zane.dto.LoginDto;
import org.zane.entity.Employee;
import org.zane.enumeration.OperationType;

import java.util.List;

/*
generics type 要選entity for database
 */

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where username = #{username} and password = #{password}")
    Employee login(LoginDto loginDto);

    List<Employee> selectEmployee(EmployeeDto employeeDto);

    /*
    with @Options, it can auto assign value of inserted data's id to the original entity passed in method
     */
    @org.zane.annotation.AutoFill(value = OperationType.INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertEmployee(Employee employee);

    @org.zane.annotation.AutoFill(value = OperationType.UPDATE)
    void updateEmployee(Employee employee);

    void deleteEmployee(EmployeeDto employeeDto);

    //    with pageHelper, it just needs to be "select * from employees"
    @Select("select * from employee")
    List<Employee> selectEmployeesWithPagination();



}
