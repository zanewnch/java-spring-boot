package com.OOP.array;

// 因為只是小測試 所以我把javabean,
// interface, testclass
// 都放在同一個file
public class division implements divisionInf {
	/**
	 * one array, calculate
	 * how many amount of
	 * elements can be
	 * divided by 3
	 */
	private int[] data;
	
	public division() {
	}
	
	public division(int[] data) {
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
		return "division{data = " + data + "}";
	}
	
	@Override
	public void calculate(int[] testData){
		int successfulAmount = 0;
		for (int i = 0; i < testData.length; i++) {
			if (testData[i] % 3 == 0) {
				successfulAmount += 1;
			}
			
		}
		System.out.println("the successfulamout is:"+ successfulAmount);
	
	}
	
}

interface divisionInf{
	void calculate(int[] data);
}

class divisionTest{
	public static void main(String[] args) {
		division number =
				new division();
		int[] testData = {1
				,2,3,4,5,6,
				7,8,9,10};
		number.setData(testData);
		number.calculate(number.getData());
	}
	
	
	
}

