package methodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class practice1 {
	public static void main(String[] args) {
		/*
		create a list to store the string data
		collect data to array of student class
		using method reference
		 */
		List<String> list = new ArrayList<>();
		Collections.addAll(list,"David,15","Paul,20");
		// turn each element from string into student class
		student[] arr=
		list.stream().map(student::new).toArray(student[]::new);
		System.out.println(Arrays.toString(arr));
	}
}
class student{
	private String name;
	private int age;
	
	public student() {
	}
	
	public student(String name) {
		String[] arr = name.split(";");
		this.name = arr[0];
		this.age = Integer.parseInt(arr[1]);
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
	
	public String toString() {
		return "student{name = " + name + ", age = " + age + "}";
	}
}
