package com.zanewnch.fullproject.service;

import com.zanewnch.fullproject.model.Emp;
import com.zanewnch.fullproject.model.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * Select all data of employee.
     * only method of controller is return Result, the above are return List<entity>
     *
     * @return Return List of Emp
     */
    PageBean page(Integer page, Integer pageSize);

    PageBean pageHelper(Integer page, Integer pageSize);

    /*    declare a method which name is completedPageHelper,and it receives parameter as above following:
    Integer page,
    Integer pageSize,
    String name,
    Short gender,
    LocalDate begin,
    LocalDate end
    */
    PageBean completedPageHelper(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    List<Emp> selectAllEmp();

    void deleteEmp(Integer ids);

    void addEmp(Emp emp);


    Emp login(Emp emp);
}
