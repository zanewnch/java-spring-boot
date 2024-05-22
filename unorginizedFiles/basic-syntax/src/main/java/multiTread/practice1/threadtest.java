package multiTread.practice1;

public class threadtest {
	/**
	 * 一共有1000張電影票，可以在兩個窗口領取，假設每次領取的時間為3000毫秒，
	 * 要求：請用多線程模擬賣票過程並打印剩餘電影票的數量
	 * @param args
	 */
	public static void main(String[] args) {
		myThread thread = new myThread();
		Thread thread1 = new Thread(thread);
		Thread thread2 = new Thread(thread);
		Thread thread3 = new Thread(thread);
		
		
		// name Thread
		thread1.setName("Thread1");
		thread2.setName("Thread2");
		thread3.setName("Thread3");
		
		// set priority for test
		thread2.setPriority(1);
		thread3.setPriority(3);
		
		// run thread1
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
