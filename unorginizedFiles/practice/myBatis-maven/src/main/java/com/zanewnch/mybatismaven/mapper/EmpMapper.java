package com.zanewnch.mybatismaven.mapper;

import com.zanewnch.mybatismaven.model.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //    參數佔位符 #{} in mybatis
//    只要使用 #{} 就會是預編譯 sql statement, 可以避免sql injection 的問題
//    ${} 是直接拼接 還是會有sql injection 的問題  基本上不會用
    @Delete("delete from emp where id = ${id}")
    public int delete(Integer id);
    /*
    return type 是 int, 代表刪除了幾筆資料
     */

    /*
    #{} :
    ==>  Preparing: delete from emp where id = ?
    ==> Parameters: 17(Integer)
    <==    Updates: 0

    使用的是parameters 形式，電腦會先把sql statement 預編譯，然後再把parameters 塞進去，這樣就不會有sql injection 的問題

    ${} :
    ==>  Preparing: delete from emp where id = 17
    ==> Parameters:
    <==    Updates: 0

    這個是沒有parameters 還是直接把value of variable 直接拼接到sql statement 裡面,所以會有sql injection 的問題
     */
    /*
    @options :
    拿到insert data 的id value, 並且把id value assign to emp object 的id field
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username,name,gender,image,job,entrydate,dept_id,create_time,update_time)" + "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

//    更新員工data
    @Update("update emp set username = #{username},name = #{name}, gender = #{gender}, image = #{image}, job =  #{job}, entrydate= {entrydate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

    /*
    if filed name of entity class are equal to columns name of mysql table, mybatis framework would auto map the field and column; so in other hand, if the field name are not equal to column name, we should use @Result annotation to map the field and column, or directly change the column name of mysql table to map the field name in java entity class

    Solution: 直接把columns name 也改成跟java filed name 一樣就好

    complement: the syntax of @Results
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "username", column = "username"),
        @Result(property = "email", column = "email")
    })


     */
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    /*
    concat method: 拼接string
     */
    @Select("select * from emp where name like concat('%',#{name},'%') and gender= #{gender} and entrydate between #{begin} and #{end}")
    public Emp conditionSelect(String name, Short gender, LocalDate begin, LocalDate end);

    public List<Emp> XMLSelectEmp(String name, Short gender, LocalDate begin, LocalDate end);

    public void XMLUpdateEmp(Emp emp);

    public void XMLForEachEmp(List<Integer> ids);
}


