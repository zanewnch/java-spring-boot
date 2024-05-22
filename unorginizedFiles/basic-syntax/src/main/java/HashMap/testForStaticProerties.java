package HashMap;

public class testForStaticProerties {
	public static void main(String[] args) {
		person demo = new person();
		person demo2 = new person();
		demo.setAge(10);
		
		int value = demo2.getAge();
		System.out.println(value);
	}
	
	
}

class person{
	private int age;
	
	
	public person() {
	}
	
	public person(int age) {
		this.age = age;
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
		return "person{age = " + age + "}";
	}
}
