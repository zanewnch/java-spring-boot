package treeMap;

import java.util.Map;
import java.util.TreeMap;

public class practice2 {
	/*
	按照id大小進行排序
	 */
	
	/*
	Using comparable interface to create treemap
	because student is user-defined class,
	which is not appropriate to use comparator(to
	troublesome)
	 */
	public static void main(String[] args) {
		student s1 = new student("David",3);
		student s2 = new student("Paul",45);
		student s3 = new student("Ben",33);
		
		Map<student,Integer> treemap = new TreeMap<>();
		treemap.put(s1,s1.getId());
		treemap.put(s2,s2.getId());
		treemap.put(s3,s3.getId());
		System.out.println(treemap);
		
	}
}

class student implements Comparable<student>{
	private String name;
	private int id;
	private student o;
	
	public student() {
	}
	
	public student(String name, int id) {
		this.name = name;
		this.id = id;
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
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 设置
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "student{name = " + name + ", id = " + id + "}";
	}
	
	// 這邊的邏輯要再看一下
	@Override
	public int compareTo(student o) {
		
		// return value:
		int i = this.getId() - o.getId();
		i = i == 0 ? this.getName().compareTo(o.getName())
				: i;
		return i;
	}
}