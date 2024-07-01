package org.zane.server.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.zane.AutoFillAspect;
import org.zane.JwtUtils;
import org.zane.Result;

import org.zane.dto.EmployeeDto;
import org.zane.dto.LoginDto;
import org.zane.entity.Employee;
import org.zane.server.service.EmployeeService;
import org.zane.vo.EmployeePageVo;
import org.zane.vo.LoginVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(tags = "Employee")
@RestController
@RequestMapping("/api/admin/employees")
public class employeeController {

    private final EmployeeService employeeService;


    @Autowired
    public employeeController(EmployeeService employeeService, AutoFillAspect AutoFill) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/login")
    public Result<LoginVo> login(
            @RequestBody LoginDto loginDto
    ) {

        // invoke service layer
        Employee result = employeeService.login(loginDto);

        /*
        check if the result is null
        因為帳號跟密碼分別會丟出不同exception, 所以不能直接用sql select where username and password 的結果來判斷, 因為null 會代表帳號會密碼其中一個異常 這樣不夠精細

        但其實好像也不用管，直接print 帳號or密碼錯誤就好
         */
        if (result == null) {


            //             throw new AccountNotFoundException("Account not found");
            //            throw new AccountNotFoundException("Account not found");

            return Result.error("username or password is wrong");

        } else if (result.getStatus() == 0) {
            /*
            如果status = 0 代表帳號被停用
            status = 1 代表帳號正常
             */
            return Result.error("Account is disabled");

        } else {

            /*
            如果帳號正常，就把密碼加密
            原先密碼是123456

            加密過後是：
            e10adc3949ba59abbe56e057f20f883e
             */
            String password = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());


            // generate jwt token
            Map<String, Object> claims = new HashMap<>();

            claims.put("username", loginDto.getUsername());

            String token = JwtUtils.generateJwt(claims);


            /*
            @builder 是代替基礎instantiate的方法
            原本的寫法會是：
            LoginVo loginVo = new LoginVo();
            loginVo.setToken(token);
             */
            LoginVo loginVo = LoginVo.builder()
                    .token(token)
                    .build();

            return Result.success(loginVo);
        }
    }

    /*
    CRUD:
    Create
    Read
    Update
    Delete
     */

    // with query string parameter
    @GetMapping
    public Result<List<Employee>> selectEmployee(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password) {

        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(id)
                .username(username)
                .password(password)
                .build();

        List<Employee> result = employeeService.selectEmployee(employeeDto);

        return Result.success(result);


    }

    @PostMapping
    public Result<Employee> insertEmployee(
            @RequestBody Employee employee
    ) {
        Employee result = employeeService.insertEmployee(employee);

        return Result.success(result);
    }


    @PutMapping
    public Result<String> updateEmployee(
            @RequestBody Employee employee
    ) {
        employeeService.updateEmployee(employee);

        return Result.success();
    }

    @DeleteMapping
    public Result<String> deleteEmployee(
            @RequestBody EmployeeDto employeeDto
    ) {
        employeeService.deleteEmployee(employeeDto);

        return Result.success();
    }


    //    pageNum 就是currentPage 當前頁數
    //    pageSize 就是單一分頁要顯示多少條數據
    @GetMapping(params = {"pageNum", "pageSize"})
    public Result<EmployeePageVo> selectEmployeesWithPagination(
            @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return Result.success(employeeService.selectEmployeesWithPagination(pageNum, pageSize));
    }
}
