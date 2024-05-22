package com.zanewnch.fullproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private int id;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job;
//    LocalDate (year, month, day)
//    date in sql (year-month-day)
//    LocalDateTime (year, month, day, hour, minute, second)
//    datetime in sql (year-month-day hour-minute-second)
    private LocalDate entryDate;
    private Short deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
