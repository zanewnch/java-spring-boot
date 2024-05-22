package multiTread.practice3;

import multiTread.practice3.myThread;

public class threadTest {
	/*
		use 2 multi-thread to get all number between
		1~100, and print the odd number(not even)
	 */
	public static void main(String[] args) {
		Runnable thread = new myThread();
		Thread thread1 = new Thread(thread);
		Thread thread2 = new Thread(thread);
		thread1.setName("thread1");
		thread2.setName("thread2");
		thread1.start();
		thread2.start();
	}
}
