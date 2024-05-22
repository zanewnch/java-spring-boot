package com.zanewnch.mybatismaven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private short gender;
    private String image;
    private Short job;
    //    2023-07-31
    private LocalDate entryDate;
    private Integer deptId;
    /*    2023-07-31T12:34:56.789
    2. 字母 "T" 是一个字符常量，用于表示日期和时间之间的分隔符。在 ISO 8601 格式中，日期和时间之间使用 "T" 字符来分隔，例如：2023-07-31T12:34:56.789。

    所以，"T" 并不是具有特殊意义的符号，它只是用于标识日期和时间在字符串表示中的分界线。在输出的格式中，日期和时间之间的 "T" 只是用于分隔，没有其他特殊含义。
     */
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
