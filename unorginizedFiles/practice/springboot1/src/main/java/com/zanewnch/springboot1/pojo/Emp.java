package com.zanewnch.springboot1.pojo;

public class Emp {
    private String name;
    private Integer age;
    private String image;
    private String gender;
    private String job;

    public Emp() {
    }

    public Emp(String name, Integer age, String image, String gender, String job) {
        this.name = name;
        this.age = age;
        this.image = image;
        this.gender = gender;
        this.job = job;
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
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    public String toString() {
        return "Emp{name = " + name + ", age = " + age + ", image = " + image + ", gender = " + gender + ", job = " + job + "}";
    }
}
