package com.OOP.basic.variable;

public class variableCalculate {
	private int amount;


	public variableCalculate() {
	}

	public variableCalculate(int amount) {
		this.amount = amount;
	}

	/**
	 * 获取
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * 设置
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String toString() {
		return "variable{amount = " + amount + "}";
	}
}
