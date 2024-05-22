package stream;

import javax.naming.Name;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class practice1 {
	public static void main(String[] args) {
		/*
		Single-Row collection
		the most common use
		 */
		List<String> list1 = new ArrayList<>();
		Collections.addAll(list1,"David","Paul","Danny",
				"Ben","Allen","Cathy");
		// note
		Stream<String> stream1 = list1.stream();
		/*
		original syntax
		 */
		list1.stream()
				.filter(name -> name.startsWith("D") && name.contains("D"))
				.filter(name -> name.length() == 5)
				.forEach(System.out::println);
		/*
		better syntax
		 */
		stream1.filter(name -> name.startsWith("D") && name.length() == 3 && name.contains("D"))
				.forEach(System.out::println);
		/*
		method reference:
		forEach(s -> System.out.println(s));
		forEach(System.out::println);
		 */
		
		/*
		Double-Row Collection
		 */
		List<String> listKey = new ArrayList<>();
		Collections.addAll(listKey,"a","b","c");
		List<Integer> listValue = new ArrayList<>();
		Collections.addAll(listValue,1,2,3);
		
		Map<String,Integer> map = new HashMap<>();
		for (int i = 0; i < listKey.size(); i++) {
			map.put(listKey.get(i),listValue.get(i));
		}
		Set<Map.Entry<String,Integer>> entries =
				map.entrySet();
		List<String> listMapKey = new ArrayList<>();
		for (Map.Entry<String,Integer> entry: entries
		     ) {
			String key = entry.getKey();
			int value = entry.getValue();
			listMapKey.add(key);
		}
		listMapKey.stream()
				.forEach(System.out::println);
	// 	快速方法
		map.entrySet().forEach(System.out::println);
		
		
		/*
		Arrays
		 */
		int[] arr1 = new int[]{1,2,3};
		String[] arr2 = new String[]{"a","b","c"};
		Arrays.stream(arr1)
				.forEach(System.out::println);
		Arrays.stream(arr2)
				.forEach(System.out::println);
		
		/*
		零散數據
		 */
		Stream.of("abc",2,"d",4,5).forEach(n -> System.out.println(n));
		Stream.of(arr1).forEach(System.out::println);
	}
}
