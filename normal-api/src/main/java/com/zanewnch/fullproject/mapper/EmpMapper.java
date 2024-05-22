package com.zanewnch.fullproject.mapper;

import com.zanewnch.fullproject.model.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/*
select
update
insert
delete
 */

// mybatis is generally used for database manipulation, without creating table; so if I want to  create table, I should use other framework, like hibernate, or directly create table in mysql console
@Mapper
public interface EmpMapper {
    //    all sql console is used xml file
    List<Emp> selectAllEmp();


    /*
    如果是select count(*) 那return data type 就會是number, 可以用Long, Integer and Short
     */
    Long selectCountEmp();

    /**
     * Select data of employee with pagination limit.
     *
     * @param start    The start index of sql limit.
     * @param pageSize The page size of sql limit.
     * @return List<Emp>
     */
    List<Emp> selectByPageEmp(Integer start, Integer pageSize);

    /**
     * With using pageHelper dependency, the sql console just need to write the easy statement and without any parameter og limit:
     * select * from emp
     */
    List<Emp> selectByPageHelper();

    List<Emp> selectByCompletedPageHelper(String name, Short gender, LocalDate begin, LocalDate end);

    void deleteByIdEmp(Integer ids);

    void insertEmp(Emp emp);

    Emp selectLoginEmp(Emp emp);
}
