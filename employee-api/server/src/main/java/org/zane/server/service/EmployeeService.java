package org.zane.server.service;

import org.zane.dto.EmployeeDto;
import org.zane.dto.LoginDto;
import org.zane.entity.Employee;
import org.zane.vo.EmployeePageVo;

import java.util.List;

public interface EmployeeService {

    Employee login(LoginDto loginDto);

    List<Employee> selectEmployee(EmployeeDto employeeDto);

    Employee insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(EmployeeDto employeeDto);

    EmployeePageVo selectEmployeesWithPagination(Integer pageNum, Integer pageSize);


}
