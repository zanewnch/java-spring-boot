package com.zanewnch.mybatismaven.mapper;

import com.zanewnch.mybatismaven.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
/*
@Mapper is used to mark an interface as a mapper interface, and the @MapperScan is used to scan the mapper interface.

When running, it would auto generate the implementation of the mapper interface, and the implementation is a proxy object.(with IOC container)

*/
public interface UserMapper {
    /*
    interface is generally used to declare the method but not field for a class
     */




    /*
    1.
    @Select is used to declare the sql statement.
    and user is the name of table

    2.
    When generics is User, which mean each row of the table is a User object

    3. 選取整個sql console code, 按右鍵 選擇
    show context action
    然後選擇
    inject language or reference
    選擇
    mysql
    就可以讓compiler 知道這是sql console code 而不只是一般的string, 會給出 syntax highlight or prompt

     */
    @Select("select * from user")
    public List<User> list();

    /*
    sql @mapper 不需要create instance
    然後我那時候有疑問 list() 這個method 並沒有method content, invoke list() 要做什麼？
    答案是： @Select() 裡面的content(which put sql console code) 就是 list() 的method content
     */

}
