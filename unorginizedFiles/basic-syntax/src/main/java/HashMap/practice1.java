package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

// main class
public class practice1 {
	/*
	create a hashmap, key is student name and value is id.
	store 3 key-value pairs elements and traverse it.
	condition: if student are same name or same age, the
	system need to determine they to be the same object.
	 */
	/*
	The key point:
	如果hashmap的key是customized class, 那該customized class
	need to re-write hashCode() and equal();
	 */
	public static void main(String[] args) {
		Map<student, Integer> demo = new HashMap<>();
		
	// 	create student
		student s1 = new student("David",1);
		student s2 = new student("Ben",2);
		student s3 = new student("Paul",3);
		student s4 = new student("David",4);
		
		demo.put(s1,s1.getId());
		demo.put(s2,s2.getId());
		demo.put(s3,s3.getId());
		/*
		再次寫入同樣的key,會覆蓋該key之value
		 */
		demo.put(s4,s4.getId());
	// 	traverse
	// 	method 1:
		// return a set of
		// keys contained in this map
	Set<student> keys = demo.keySet();
		for (student key: keys) {
			System.out.println(key.getClass());
			System.out.println(key); // the key's type is
			// student
			System.out.println(String.valueOf(key));
			/*
			String.valueOf: accept any type to be
			parameter, and return the Sting
			
			hashMap.get(key): accept key to be parameter,
			 and return the value of the key
			 */
			String value = String.valueOf(demo.get(key));
			System.out.println(value);
			
			/*
			conclusion:
			Set<student> s = demo.keySet();
			for (student s: keys
			     ) {
				String variablename=
						String.valueOf(demo.get(key));
				System.out.println(variablename);
			}
			 */
		}
	
	// 	method 2:
	// 	this method is most convenient
	Set<Map.Entry<student,Integer>> entries =
			demo.entrySet();
		for (Map.Entry<student,Integer> entry: entries
		     ) {
			student key = entry.getKey();
			Integer value = entry.getValue();
		}
	// 	method 3:
		
		
		
	};
}
// test class
class student{
	private String name;
	private Integer id;
	
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
	
	/*
	when using hashmap,
	if putting customized class into key, must have to
	add equal() and hashCode()
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass())
			return false;
		student student = (student) o;
		return id == student.id && Objects.equals(name, student.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, id);
	}
	
}
