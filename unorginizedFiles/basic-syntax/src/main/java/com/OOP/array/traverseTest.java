package com.OOP.array;

import java.util.Arrays;

public class traverseTest {
	/**
	 * one array, traverse
	 * and print all elements,
	 * and calculate the
	 * sum of elements
	 * @param args
	 */
	public static void main(String[] args) {
		traverseArray number = new traverseArray();
		
		int[] testarr =
				new int[]{1
						,2,
						3,4
						,5};
		
		number.setData(testarr);
		number.traverse(number.getData());
		number.travereSum(number.getData());
		System.out.println(Arrays.toString(number.copyArray(number.getData(),2,4)));
	}
}
