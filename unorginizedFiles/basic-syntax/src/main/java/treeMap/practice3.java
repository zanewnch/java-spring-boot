package treeMap;

import java.util.*;

public class practice3 {
	/*
	統計string當中每一個英文字出現的次數
	並按照次數大到小輸出
	 */
	public static void main(String[] args) {
		String demo = "aababcabcdabcde";
		
		List<String> list = new ArrayList<>();
		
		Map<String,Integer> map =
				new TreeMap<>();
		for (int i = 0; i < demo.length(); i++) {
			list.add(String.valueOf(demo.charAt(i)));
		}
		for (String key : list) {
			if (map.containsKey(key)) {
				int value = map.get(key);
				value++;
				map.put(key, value);
			} else {
				map.put(key, 1);
			}
		}
		System.out.println(map);
		
	}
}

class basicSyntax{
	String test1 = "a";
	char test2 = 'a';
	boolean result =
			test1.equals(String.valueOf(test2));
		
	public void printResult(){
		System.out.println(result);
	};
}
