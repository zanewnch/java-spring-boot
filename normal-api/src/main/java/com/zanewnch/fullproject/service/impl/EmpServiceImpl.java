package com.zanewnch.fullproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zanewnch.fullproject.annotation.Log;
import com.zanewnch.fullproject.mapper.EmpMapper;
import com.zanewnch.fullproject.model.Emp;
import com.zanewnch.fullproject.model.PageBean;
import com.zanewnch.fullproject.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
If the class is spring component, then the method of class is not need to add static modifier, because the IOC container will auto-inject the dependency.
 */

@Service
public class EmpServiceImpl implements EmpService {
    /*
    step 1: add @Service
    step 2: add @Autowired (The next layer)
     */
    @Autowired
    private EmpMapper empMapper;


    @Log // for AOP
    @Override
    public List<Emp> selectAllEmp() {
       return  empMapper.selectAllEmp();
    }

    public PageBean page(Integer page, Integer pageSize) {

//        get total count of emp table
        Long total = empMapper.selectCountEmp();

//        get list of data of emp table

        Integer start = (page - 1) * pageSize;
        List<Emp> list = empMapper.selectByPageEmp(start, pageSize);

//        create PageBean object

        return new PageBean(total, list);
    }

    public PageBean pageHelper(Integer page, Integer pageSize) {

        /*
        Step1: 設置分頁參數

        The api of PageHelper
        page: page number
        pageSize: number of data per page.

        which is the key setting to let pageHelper work
         */
        PageHelper.startPage(page, pageSize);

        /*
        Step2: 執行查詢
         */
        List<Emp> list = empMapper.selectByPageHelper();
        Page<Emp> p = (Page<Emp>) list;

        /*
        Step3: encapsulate to  pageBean
         */
        return new PageBean(p.getTotal(), p.getResult());

    }

    /*
    I want to create a method named completedPageHelper of EmpServiceImpl, which receive parameter from completedPageHelper from controller, I have mentioned this function on above question. and the content of method are as following : 1. using pageHelper.startpage(page,pageSize)  2. create a variable empList with List<emp> type, which value with is empMapper.completedPageHelper(name,gender,begin,end) 3. create a vairable p with Page<Emp> type, which value is turn empList to Page data type. 4. create a variable named pageBean with PageBean data type, which value is new PageBean(p.getTotal,p.getResult)  5. return pageBean
     */
    @Override
    public PageBean completedPageHelper(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // Step 1: Use PageHelper to start pagination
        PageHelper.startPage(page, pageSize);

        // Step 2: Get employee list based on the provided parameters
        List<Emp> empList = empMapper.selectByCompletedPageHelper(name, gender, begin, end);

        // Step 3: Convert empList to Page<Emp> type
        Page<Emp> p = (Page<Emp>) empList;

        // Step 4: Create PageBean using p.getTotal and p.getResult
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        // Step 5: Return the created pageBean
        return pageBean;
    }

    @Override
    public void deleteEmp(Integer ids) {
        empMapper.deleteByIdEmp(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        /*
        pre-set the basic information of emp then pass to empMapper
         */
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insertEmp(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.selectLoginEmp(emp);
    }
}
