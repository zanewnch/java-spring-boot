package com.OOP.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class traverseArray implements traverseInf {
	private int[] data;
	
	public traverseArray() {
	}
	
	public traverseArray(int[] data) {
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
		return "traverseArray{data = " + Arrays.toString(data) + "}";
	}
	
	// implement the interface
	// print出array的每一個element
	@Override
	public void traverse(int[] data){
		// for-each,
		// enhanced for
		// loop syntax
		for (int datum : data) {
			System.out.println(datum);
		}
		/*for (int i = 0; i
		 < data.length; i++) {
		 
			System.out.println(data[i]);
		}
		
		 */
		
	}
	
	Map<String,String> m = new HashMap<>();
	HashMap<String,String> mm= new HashMap<>();
	
	//  calculate sum of array
	public void travereSum(int[] data){
		int[] storeEle =
				new int[5];
		int storeSum = 0;
		for (int i = 0; i < data.length; i++) {
			storeEle[i] =
					data[i];
			
			storeSum += storeEle[i];
		}
		System.out.println(storeSum);
		
	}
	public int[] copyArray(int[] arr, int from, int to){
		
		int[] testArr =
				new int[to - from];
		for (int i = from; i < to; i++) {
			for (int j = 0; j < to - from; j++) {
				testArr[j]
						=
						arr[i];
			}
		}
		return testArr;
	}
}
