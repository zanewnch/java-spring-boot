package com.OOP.array;

import java.util.Arrays;
import java.util.Random;

public class changeArray implements changeInf{
// 	one array, if element
// 	is odd number, the
// 	value is 2 times; else
// 	if the element is even
// 	number, the value is
// 	1/2 times
	
	private int[] data;
	
	public changeArray() {
	}
	
	public changeArray(int[] data) {
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
		return "changeArray{data = " + data + "}";
	}
	
	// *2 or /2
	@Override
	public void change(int[] testdata){
		for (int i = 0; i < testdata.length; i++) {
			if (testdata[i] % 2 != 0){
				testdata[i] = testdata[i]*2;
			}else {
				testdata[i] = testdata[i] / 2;
			}
		}
		System.out.println(Arrays.toString(testdata));
	}
	
	// calculate the
	// maximum of all
	// elements in array
	@Override
	public void maximum(int[] testdata){
		
		int max = 0;
		for (int i = 0; i < testdata.length; i++) {
			if (testdata[i] > max){
				max =
						testdata[i];
			}
		}
		System.out.println(
				"the " +
						"maximum number is:" +max);
	}
	
	public int[] generateDynamicArr(){
		int[] arr =
				new int[10]; // [0,0,0....]
		Random random =
				new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] =
					random.nextInt(100); // generate the number between 0~99
		}
		return arr;
	}
	
	// sum
	public int arraySum(int[] data){
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			count += data[i];
		}
		return count;
	}
	// mean
	public int arrayMean(int[] data){
		return arraySum(data) / data.length;
	}
	
	public int arrayLowerMean(int[] data){
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if(data[i] < arrayMean(data)){
				count += 1;
			}
		}
		return count;
	}
	// 將element的順序前後對調
	public int[] reverse(int[] data){
		
		int start = 0;
		int end =
				data.length - 1;
		
		
		while(start <end){
			int temp =
					data[start];
			data[start] =
					data[end];
			data[end] = temp;
			start ++;
			end --;
		}
		return data;
	}
	// 將element 順序全部打亂
	public int[] shuffle(int[] data){
		Random r =
				new Random();
		
		for (int i = 0; i < data.length; i++) {
			int temp =
					data[i];
			int randomIndex =
					r.nextInt(data.length);
			data[i] =
					data[randomIndex];
			data[randomIndex] = temp;
		}
		return data;
	}
}

interface changeInf{
	void change(int[] data);
	void maximum(int[] data);
}

class changeTest{
	public static void main(String[] args) {
		changeArray number
				=
				new changeArray();
		int[] testData =
				new int[]{1,2
				,3,4,5,6,7,
				8,9,10};
		
		
		
		number.setData(testData);
		number.change(number.getData());
		number.maximum(number.getData());
		
		int[] dynamicArr =
				number.generateDynamicArr();
		System.out.println(
				"the sum " +
						"is" +
						":"+ number.arraySum(dynamicArr)+ "the mean is:"+number.arrayMean(dynamicArr)+"the amount of element which is lower than mean:"+number.arrayLowerMean(dynamicArr));
		System.out.println(Arrays.toString(number.reverse(number.getData())));
		System.out.println(Arrays.toString(number.shuffle(number.getData())));
	}
}
