package multiTread.practice2;

public class threadTest {
	/*
	有一百個禮品兩人同時發送，當剩下的禮品小於10份的時候則不再送出
	利用multi-thread print tread name and 剩餘數量
	 */
	public static void main(String[] args) {
		// instantiate customized class with runnable
		// interface
		Runnable thread = new mythread();
		// instantiate Thread object
		Thread thread1 = new Thread(thread);
		Thread thread2 = new Thread(thread);
		thread1.setName("thread1");
		thread2.setName("thread2");
		thread1.start();
		thread2.start();
	}
}
