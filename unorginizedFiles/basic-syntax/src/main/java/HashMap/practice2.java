package HashMap;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
/*
超級重要：
重複創建instance的方法：
student2[] students = new student2[80];
for (int i = 0; i < 80; i++) {
			students[i] = new student2(1,1);
			System.out.println(students[i]);
		}
 */

public class practice2 {
	/*
	某班級有80個學生，現在要校外旅行，班長提供四個景點(A,B,C,D)
	，每個學生只能選擇一個景點，請統計出哪個景點想去的人數最多
	 */
	public static void main(String[] args) {
		
		// create 80 instance
		student2[] students = new student2[80];
		// System.out.println(Arrays.toString(students));
		// [null]
		
		// create hashmap
		Map<student2, Integer[]> demo = new HashMap<>();
		
		Random random = new Random();
		
		/*
		assign value to students and add value to hashmap
		 */
		for (int i = 0; i < students.length; i++) {
			students[i] = new student2(i,random.nextInt(4));
			// System.out.println(students[i]); // student2{
			// id = 67, space = 1,
			// data = [Ljava.lang.Integer;@2e5d6d97}
			
			// 	put data in hashmap
			// because the property is not static, so I
			// should
			// use s1.getData() not student2.getData()
			demo.put(students[i],students[i].getData());
		}
		// print data
		Set<Map.Entry<student2,Integer[]>> set =
				demo.entrySet();
		List<Integer> list = new ArrayList<>();
		for (Map.Entry<student2,Integer[]> data: set
		     ) {
			student2 key = data.getKey();
			Integer[] value = data.getValue();
			System.out.println(key);
			System.out.println(Arrays.toString(value));
			
			/*
			goal:判斷在space當中哪一個number出現最多次
			所以在這將hashmap當中的data extract to arraylist
		    */
			list.add(value[1]);
		};
		
		/*
		計算哪一個出現最多次
		這邊沒看懂 是直接抄chatgpt
		反正可以動
		應該不難理解
		 */
		int maxFrequency = 0;
		int mostFrequencyNum = 0;
		for (int num: list
		     ) {
			int frequency = Collections.frequency(list,num);
			if(frequency > maxFrequency){
				maxFrequency = frequency;
				mostFrequencyNum = num;
			}
		}
		System.out.println("The final answer is: "+ mostFrequencyNum);
		
		
		/*
		教學影片給的解法：hashmap的用途
		key:value = space : count
		 */
		/*
		解題邏輯：
		創一個hashmap
		創一個arraylist
		用random 隨機分配abcd 到arraylist
		然後判斷：
		如果hashmap key 有abcd其一，該key's value + 1;
		如果hashmap key 沒有abcd其一，代表abcd還沒有被add to hashmap,
		所以hashmap.put("abcd",1)
		 */
		Map<String,Integer> hashmap = new HashMap<>();
		String[] arr = new String[]{"a","b","c","d"};
		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < 80; i++) {
			int randomValue = random.nextInt(4);
			stringList.add(arr[randomValue]);
			
			// arraylist 要用.get(index) 才可以
			// 不可以直接寫arraylist[i]
			if (hashmap.containsKey(stringList.get(i))){
				int mapValue = hashmap.get(stringList.get(i));
				mapValue ++;
				hashmap.put(stringList.get(i),mapValue);
			}else{
				hashmap.put(stringList.get(i),1);
			}
		}
		System.out.println(hashmap);
	// 	求最大值
	// 	原本寫的笨方法
	// 	int[] compareValue = new int[]{hashmap.get("a"),
	// 			hashmap.get("b"),hashmap.get("c"),
	// 			hashmap.get("d")};
	// 	int maxNumber = 0;
	// 	for (int n: compareValue
	// 	     ) {
	// 		if (n > maxNumber){
	// 			maxNumber = n;
	// 		}else{
	// 			continue;
	// 		}
	// 	}
		
		Set<Map.Entry<String,Integer>> theSet =
				hashmap.entrySet();
		int maxNumber = 0;
		for (Map.Entry<String,Integer> entry : theSet
		     ) {
			String key = entry.getKey();
			int value = entry.getValue();
			
			if (value > maxNumber){
				maxNumber = value;
			}
		}
		System.out.println(maxNumber);
		for (Map.Entry<String,Integer> entry : theSet
		) {
			if(maxNumber == entry.getValue()){
				System.out.println(entry.getKey());
			}
		}
		
		
		
		
	}
}
class student2{
	private Integer id;
	private Integer space;
	// private static Integer[] data = new Integer[]{id,space};
	/*
	如果我在這邊就assign value, 會因為id and space are static, so
	their default value is null
	when I print the data, It will show [null,null]
	so I should assign data in constructor function
	 */
	private Integer[] data;
	
	public student2() {
	}
	
	public student2(Integer id, Integer space) {
		/*
		why use this.id:
		the property is not-static, which mean different
		instance has different property value,so I should
		 use this.property;
		if the property is static, which mean all
		instance use the same property value, so I should
		 use classname.property;
		 */
		this.id = id;
		this.space = space;
		/*
		assign value here in order to avoid [null,null]
		 */
		this.data = new Integer[]{id,space};
	}
	
	/**
	 * 获取
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * 设置
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 获取
	 * @return space
	 */
	public Integer getSpace() {
		return space;
	}
	
	/**
	 * 设置
	 * @param space
	 */
	public void setSpace(Integer space) {
		this.space = space;
	}
	
	/**
	 * 获取
	 * @return data
	 */
	public Integer[] getData() {
		return data;
	}
	
	/**
	 * 设置
	 * @param data
	 */
	public void setData(Integer[] data) {
		this.data = data;
	}
	
	public String toString() {
		return "student2{id = " + id + ", space = " + space + ", data = " + data + "}";
	}
}
