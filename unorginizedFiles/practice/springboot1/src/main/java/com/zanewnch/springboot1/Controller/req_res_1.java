package com.zanewnch.springboot1.Controller;

import com.zanewnch.springboot1.response.responseOfficial;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;



// 別背 要多寫

@RestController
public class req_res_1 {
    /*
        實體參數 Entity Parameter:
        实体参数（Entity Parameter）是指将请求参数的值封装到一个实体类（Entity Class）的对象中进行传递和处理。

    */
    @RequestMapping("/reqres1")
    public responseOfficial Req_Res1(User user){
        System.out.println(user);
        return new responseOfficial(1,"success",user);
//        http://localhost:8080/reqres1?name=david&age=10&selfInf.gender=0&selfInf.height=000&selfInf.weight=111
//        user{name = david, age = 10}
    }

//    directly pass the parameter without assign it in class
    @RequestMapping("/reqres2")
    public String Req_Res2(String name, int age){
        System.out.println("The parameter of name is :" + name +" , and the age is :" + age);
        return "without binding value of parameter to class";

//        http://localhost:8080/reqres2?name=david&age=10
//        The parameter of name is :david , and the age is :10
    }

//    array parameter
    /*
    在Spring MVC中，对于基本类型的数组参数，框架会自动将请求中的参数值转换为相应的数组类型，无需使用@RequestParam注解进行显式绑定。
     */
    @RequestMapping("/reqres3")
    public String Req_Res3(int[] hobby){
        for (int number: hobby
             ) {
            System.out.println(number);
        }
        return "success";
        //        http://localhost:8080/reqres3?hobby=0&hobby=1&hobby=2
//        0 1 2
    }

//    collection
    @RequestMapping("/reqres4")
    public String Req_Res4(@RequestParam ArrayList<Integer> list){
        System.out.println(list);
        return "success";
        //        http://localhost:8080/reqres3?hobby=0&hobby=1&hobby=2
//        0 1 2
    }
//  date parameter
    @RequestMapping("/reqres5")
    public String Req_Res5(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime updateTime){
        System.out.println(updateTime);
        return "updateTime success";
//        http://localhost:8080/reqres5?updateTime=2022-12-02 10:03:05
    }

//    json parameter
    /*
    json key as class filed name
     */
    @RequestMapping("/reqres6")
    public String Req_Res6(@RequestBody User user){
        System.out.println(user);
        return "json parameter success";
    }

/*
    path parameter:
    the value of parameter will be a part of url path
    example: localhost:8080/path/10
    10 is the path parameter
 */
    @RequestMapping("/path/{id}/{name}")
    public String Req_Res7(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id + name);
        return "path parameter success";

//        localhost:8080/path/10/paul
//        id = 10
//        name = Paul
    }

}


class User{
    private String name;
    private int age;
    private selfInf selfinf;


    public User() {
    }

    public User(String name, int age, selfInf selfinf) {
        this.name = name;
        this.age = age;
        this.selfinf = selfinf;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return selfinf
     */
    public selfInf getSelfinf() {
        return selfinf;
    }

    /**
     * 设置
     * @param selfinf
     */
    public void setSelfinf(selfInf selfinf) {
        this.selfinf = selfinf;
    }

    public String toString() {
        return "User{name = " + name + ", age = " + age + ", selfinf = " + selfinf + "}";
    }
}

class selfInf{
    private int gender;
    private int height;
    private int weight;


    public selfInf() {
    }

    public selfInf(int gender, int height, int weight) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    /**
     * 获取
     * @return gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * 设置
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "selfInf{gender = " + gender + ", height = " + height + ", weight = " + weight + "}";
    }
}
