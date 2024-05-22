package org.zane.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
1. @TableName("employee") 指定table
2. @TableId(value = "id") 指定primary key(通常都是id)
3. @TableField("create_time") 指定table column name
這些annotation 都是mybatisPlus 提供的

mybatis 是透過指定table name 來知道要找哪一個table,
也可以透過約定的方式, 但約定的方式要記，我還是直接指定最安全
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@TableName("employee")
public class Employee implements Serializable {
    /*
    IdType.AUTO 代表id is auto increment
     */
//    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String phone;
    private String sex;
    private String idNumber;
    private Integer status;
//    @TableField("create_time")
    private LocalDateTime createTime;
//    @TableField("update_time")
    private LocalDateTime updateTime;
//    @TableField("create_user")
    private Integer createUser;
//    @TableField("update_user")
    private Integer updateUser;




    /*
    invoke mybatisPlus example:

    Employee result =  employeeMapper.selectById(1);

    System.out.println(result);
     */
}
