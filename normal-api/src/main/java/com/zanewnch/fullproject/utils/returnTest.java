package com.zanewnch.fullproject.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class returnTest {
    private String name;
    private int age;

    public static returnTest getObject(String name, int age){
        return new returnTest(name, age);
    }
}
