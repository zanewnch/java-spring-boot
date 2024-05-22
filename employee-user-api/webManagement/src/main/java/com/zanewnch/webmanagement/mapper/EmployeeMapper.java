package com.zanewnch.webmanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zanewnch.Employee;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    void insertDataEmployee(Employee employee);

    @Insert("insert into employees(name,number,age,gender,createTime,updateTime) values (#{name},#{number},#{age},#{gender},#{createTime},#{updateTime})")
    void insertDataEmployeeAnnotation(Employee employee);


    @Select("select * from employees")
    List<Employee> selectAllEmployees();

    //    with pageHelper, it just needs to be "select * from employees"
    @Select("select * from employees")
    List<Employee> selectEmployeesWithPagination();

    // but this method is not exactly used,because the pageHelper with getTotal() can directly get the total amounts of data in the data
    // return the total amounts of data in the table
    @Select("select count(*) from employees")
    Long totalDataAmounts();

    List<Employee> selectEmployees(
            Integer id,
            String name,
            Integer number,
            Integer age,
            String gender,
            LocalDateTime createTime,
            LocalDateTime updateTime
    );

    /*
    模糊查詢的寫法 success
     */

}
