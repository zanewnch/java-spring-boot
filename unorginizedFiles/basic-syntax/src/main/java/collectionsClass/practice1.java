package collectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class practice1 {
	/*
	The collections
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		// addAll
		// 一次添加多個元素
		Collections.addAll(list,"a","b","c","d");
		System.out.println(list);
		// shuffle
		// 打亂list
		Collections.shuffle(list);
		System.out.println(list);
	}
}
