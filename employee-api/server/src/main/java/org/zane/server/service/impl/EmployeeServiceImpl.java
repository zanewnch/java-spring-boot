package org.zane.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.zane.ThreadLocalUtils;
import org.zane.dto.EmployeeDto;
import org.zane.dto.LoginDto;
import org.zane.entity.Employee;
import org.zane.server.mapper.EmployeeMapper;
import org.zane.server.service.EmployeeService;
import org.zane.vo.EmployeePageVo;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper, RedisTemplate<String, Object> redisTemplate) {
        this.employeeMapper = employeeMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Employee login(LoginDto loginDto) {
        return employeeMapper.login(loginDto);
    }

    @Override
    public List<Employee> selectEmployee(EmployeeDto employeeDto) {
        // TODO: 測試redis是否正常work
        // redis data named employees_id

        // detect whether cache data exists
        List<Employee> redisData = (List<Employee>) redisTemplate.opsForValue().get("employees_" + employeeDto.getId());

        if (redisData != null && !redisData.isEmpty()) {
            return redisData;
        } else {
            List<Employee> data = employeeMapper.selectEmployee(employeeDto);

            redisTemplate.opsForValue().set("employees_" + employeeDto.getId(), data);

            return data;
        }
    }

    // 最終存在redis keyName is employeesCache::employee.id
    @CachePut(cacheNames = "employeesCache", key = "#result.id")  // key = "#result.id" (result the is return value of this method)
    @Override
    public Employee insertEmployee(Employee employee) {

        Employee employees = new Employee();


        /*
        copy properties from employeeDto to employee.

        BeanUtils.copyProperties(Source, target)
         */
        BeanUtils.copyProperties(employee, employees);

        /*
        set value
         */
//        employee.setStatus(1);
//        employee.setCreateTime(LocalDateTime.now());
//        employee.setUpdateTime(LocalDateTime.now());
        /*
        在database當中的create_user nad update_user 我不知道是代表什麼意思，但是我assign this column with generate JWT token 時設置claim 的usernameValue, 也就是Zane
         */
        employees.setCreateUser(ThreadLocalUtils.getCurrentValue());
        employees.setCreateUser(ThreadLocalUtils.getCurrentValue());

        employeeMapper.insertEmployee(employees);

        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {

        Employee employees = new Employee();

        BeanUtils.copyProperties(employee, employees);
//        employees.setUpdateTime(LocalDateTime.now());

        employeeMapper.updateEmployee(employees);
    }

    @CacheEvict(cacheNames = "employeesCache", key = "#employeeDto.id")
    @Override
    public void deleteEmployee(EmployeeDto employeeDto) {
        employeeMapper.deleteEmployee(employeeDto);

        // 只刪除單條cache
        redisTemplate.delete
                ("employees_" + employeeDto.getId());
    }

    @Cacheable(cacheNames = "employeesCache", key = "#pageNum + '_' + #pageSize")
    @Override
    public EmployeePageVo selectEmployeesWithPagination(Integer pageNum, Integer pageSize) {
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
        return new EmployeePageVo(result.getTotal(), result.getResult());

    }




}
