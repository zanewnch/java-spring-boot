package com.OOP.array.combinedTrain;

import java.util.Arrays;
import java.util.Random;

/*
寫到綜合練習6
綜合練習7還沒有寫
 */
public class combinedTrain2 {

	public void encode(){
		/*
		數字加密：
		數字長度不限
		加密規則
		先得到每位數，然後每位數都加上5，再對上10求餘數，最後將所有數字反轉，得到一串新的數字
        */
		Random random = new Random();
		int randomNum = random.nextInt(100000);
		String str = Integer.toHexString(randomNum);
		int[] arr = new int[str.length()];
		// String to int[]
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			arr[i] = Character.getNumericValue(c);
		}
		// calculate
		for (int i = 0; i < arr.length; i++) {
			arr[i] += 5;
			arr[i] = arr[i] % 10;
		}
		/*
		核心理念
		1. 雙指針法：一個設在起點，一個設在終點，逐漸往中間靠攏
		2. 使用臨時變量
		 */
		int tem = 0;
		int start = 0;
		// 因為要當索引使用
		int end = arr.length -1;
		while(start < end) {
			tem = arr[start];
			arr[start] = arr[end];
			arr[end] = tem;
			start ++;
			end --;
		}
		System.out.println(Arrays.toString(arr));
	}}

class combinedTrain2Test{
	public static void main(String[] args) {
		combinedTrain2 data = new combinedTrain2();
		data.encode();
		
	}
}
