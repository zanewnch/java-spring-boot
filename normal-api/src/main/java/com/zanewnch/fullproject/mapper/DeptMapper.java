package com.zanewnch.fullproject.mapper;

import com.zanewnch.fullproject.model.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/*
select
update
insert
delete
 */

@Mapper
public interface DeptMapper {
//    @Select("select * from dept")
    List<Dept> list();

    List<Dept> getAllDept();

    void deleteById(Integer id);

    void add(Dept dept);

    List<Dept> selectDept();
    List<Dept> selectEmp();
}
