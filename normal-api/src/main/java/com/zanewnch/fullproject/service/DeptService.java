package com.zanewnch.fullproject.service;

import com.zanewnch.fullproject.model.Dept;

import java.util.List;

public interface DeptService {
    /**
     * Select all data of department
     * @return
     * Return List of Dept
     */
    List<Dept> list();

    void delete(Integer id);

    /*
    一開始會不知道 service layer 要receive which parameter,
    但只要想controller layer pass which parameter, then service layer just receive it
     */
    void add(Dept dept);

    List<Dept> transactionalTest();
}
