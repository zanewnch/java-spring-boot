package com.zanewnch.fullproject.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/*
幫助我自己理解，因為3個method of this class are all static, so it can directly invoke this class without instantiation
 */

// object 是最上層的父類別，所以可以用來接收任何object
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
//    response code, 1: success, 0: fail
    private Integer code;
//    response message
    private String msg;
//    response data, using object data type to receive any data, because object is the top class
    private Object data;

//    without parameter, which mean the CUD(Create, Update, Delete) manipulation
    public static Result success(){
        return new Result(1,"success",null);
    }
//    with parameter, which mean R(Read) manipulation
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
//    invoke when error occur
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
