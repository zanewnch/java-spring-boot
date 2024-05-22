package exception;

import java.util.Scanner;

public class practice2 {
	/*
	key in a person's name and age,
	name's length must in 0~5
	age's range must in 18~35
	if extend the range, need to throw exception and key in
	again
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person demo = new Person();
		
		/*
		while(true) 就會無條件一直重複執行
		所以要直到setName success
		才會跳到break
		才會stop while loop
		 */
		while (true) {
			try {
				System.out.println("Please enter the person's " +
						"name");
				String name = scanner.nextLine();
				demo.setName(name);
				/*
				如果demo.setName有完成
				那就會break
				如果出現異常 就會到catch那邊
				 */
				break;
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			
		}
		while (true){
			try {
				System.out.println("Please enter the person's age");
				String age = scanner.nextLine();
				int intAge = Integer.parseInt(age);
				demo.setAge(intAge);
				break;
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		
		
		
	}
}

class Person{
	private String name;
	private int age;
	
	
	public Person() {
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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
		if (name.length() > 5){
			throw new RuntimeException();
		}else {
			this.name = name;
		}
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
		if (age <18 | age < 35){
			throw new AgeFormatException();
		}else{
			this.age = age;
		}
		
	}
	
	public String toString() {
		return "person{name = " + name + ", age = " + age + "}";
	}
}

class AgeFormatException extends RuntimeException{
	/*
	自定義異常的用意只是為了提醒具體需要檢查的內容
	 */
	public AgeFormatException() {
	}
	
	public AgeFormatException(String message) {
		super(message);
	}
}
