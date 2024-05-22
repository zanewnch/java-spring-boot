package com.OOP.basic.variable;

public class variableCalculateTest {
	public static void main(String[] args) {
		variableCalculate data = new variableCalculate();

	// 	first step
		data.setAmount(1);
		int result = data.getAmount();
		System.out.println("amount:"+result);

	// 	second
		data.setAmount(1+2-1);
		result = data.getAmount();

	// 	third
		data.setAmount(1+2-1+2-1);
		result = data.getAmount();

	// 	the four step
		data.setAmount(1+2-1+2-1-1);
		result = data.getAmount();
		System.out.println("amout"+result);

	}
}
