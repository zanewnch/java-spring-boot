package exception;

public class practice1 {
	public static void main(String[] args) {
		int[] arr = null;
		try {
			int result = getMax(arr);
			System.out.println(result);
		} catch (RuntimeException e){
			e.printStackTrace();
		}
		
		
	}
	private static int getMax(int[] arr) throws NullPointerException, ArrayIndexOutOfBoundsException{
		// 主動丟出異常
		// throw
		if (arr == null){
			throw new NullPointerException();
		}else if(arr.length == 0){
			throw  new ArrayIndexOutOfBoundsException();
		}
		
		System.out.println("使用throw是為了增加code的強健性");
		// main
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > sum){
				sum = arr[i];
			}
		}
		return sum;
	}
}
