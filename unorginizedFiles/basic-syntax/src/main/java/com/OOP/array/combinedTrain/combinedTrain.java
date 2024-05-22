package com.OOP.array.combinedTrain;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class combinedTrain {
	private int[] data;
	
	public combinedTrain() {
	}
	
	public combinedTrain(int[] data) {
		this.data = data;
	}
	
	/**
	 * 获取
	 * @return data
	 */
	public int[] getData() {
		return data;
	}
	
	/**
	 * 设置
	 * @param data
	 */
	public void setData(int[] data) {
		this.data = data;
	}
	
	public String toString() {
		return "combinedTrain{data = " + data + "}";
	}
	
	/*
	賣飛機票
	根據淡旺季 頭等艙與經濟艙收費
	計算出機票價格
	旺季(5~10) 頭等艙9折 經濟艙8.6折
	淡季(11~4) 頭等艙7折 經濟艙6.5折
	 */
	public double airplanePrice(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(
				"Please " +
						"enter the price of airplane ticket");
		double price =
				scanner.nextInt();
		System.out.println(
				"Please " +
						"enter the month you want to fly");
		int month =
				scanner.nextInt();
		System.out.println(
				"Please " +
						"choose First class or Economy Class,First class enter 1, and Economy class enter 2");
		int level =
				scanner.nextInt();
		
		double monthLevelLowWeight = 0;
		double monthLevelHighWeight = 0;
		
		if(4 < month && month < 11){
			monthLevelLowWeight = 0.9;
			monthLevelHighWeight = 0.86;
		}else{
			monthLevelLowWeight = 0.7;
			monthLevelHighWeight = 0.65;
		}
		
		if(level == 1 && 4< month && month < 11 ){
			price =
					price * monthLevelHighWeight;
		
		}
		return price;
		
		
		
	}
	// 找質數
	// 只需要traverse
	// 2~平方根就好，平方根之後的數字可以根據平方根之前的數字去相乘
	public boolean isPrime(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 1){
				return false;
			}else{
				for (int j =
				     2; j < Math.sqrt(arr[i]); j++) {
					if (arr[i] % j ==0){
						return false;
					}
				}
			}
		}
		// 如果element 都不滿足以上條件，那就是質數
		return true;
		
	}
	/*
	產生隨機的驗證碼
	1. 長度為5
	2. 前四位是大寫字母會小寫字母
	3. 最後一位是數字
	 */
	public void verificationCode(){
		Random random =
				new Random();
		// generate the
		// random number
		// between 0 ~ 25
		
		
		char[] letterArr = new char[5];
		char randomLetter;
		for (int i = 0; i < 4; i++) {
			
			int randomNumber =
					random.nextInt(26);
			// random
			// .nextBoolean
			// 隨機產生true or
			// flase
			// 用if else配合 random.nextBoolean的意義就是隨機選擇大小寫
			if(random.nextBoolean()){
				// 產生大寫字母
				randomLetter = (char)('A' + randomNumber);
			}else{
				// 產生小寫字母
				randomLetter = (char)('a'+ randomNumber);
			}
			letterArr[i] = randomLetter;
		}
		// 因為ASC2 字符0 對應的十進制編碼值是48
		char randomArrNumberChar =
				(char)(48 + random.nextInt(10));
		letterArr[4] = randomArrNumberChar;
		System.out.println(letterArr);
		
		
	}
	
	/*
	6個評審評分
	扣掉最高分
	扣掉最低分
	 */
	
	public void judgePoint() {
		// create random point array
		Random random = new Random();
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			int data = random.nextInt(101);
			arr[i] = data;
		}
		//  delete max and min value
		// 	find max value
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			} else {
				continue;
			}
		}
		// find min value
		int min = max;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			} else {
				continue;
			}
		}
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != max || arr[i] != min) {
				count++;
			}
		}
		int[] filterArray = new int[count];
		for (int i = 0; i < arr.length; i++) {
			
			
			if (arr[i] != max || arr[i] != min) {
				for (int j = 0; j < filterArray.length; j++) {
					filterArray[j] = arr[i];
				}
			}
		}
		
		System.out.println(Arrays.toString(filterArray));
	}
}
	
	/**
	 * chatgpt 給的正確解法：
	 *
	 * public void judgePoint() {
	 *     // 创建随机评分数组
	 *     Random random = new Random();
	 *     int[] arr = new int[6];
	 *     for (int i = 0; i < arr.length; i++) {
	 *         int data = random.nextInt(101);
	 *         arr[i] = data;
	 *     }
	 *
	 *     // 找到最大值和最小值
	 *     int max = arr[0];
	 *     int min = arr[0];
	 *     for (int i = 1; i < arr.length; i++) {
	 *         if (arr[i] > max) {
	 *             max = arr[i];
	 *         }
	 *         if (arr[i] < min) {
	 *             min = arr[i];
	 *         }
	 *     }
	 *
	 *     // 计算筛选后数组的长度
	 *     int count = arr.length - 2;
	 *     int[] filterArray = new int[count];
	 *     int index = 0;
	 *     for (int i = 0; i < arr.length; i++) {
	 *         if (arr[i] != max && arr[i] != min) {
	 *             filterArray[index] = arr[i];
	 *             index++;
	 *         }
	 *     }
	 *
	 *     System.out.println(Arrays.toString(filterArray));
	 * }
	 */

class combinedTrainTest{
	public static void main(String[] args) {
		combinedTrain data
				=
				new combinedTrain();
		// data.airplanePrice();
		
		data.verificationCode();
		data.judgePoint();
	}
}
