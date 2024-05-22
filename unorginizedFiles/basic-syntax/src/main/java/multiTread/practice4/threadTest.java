package multiTread.practice4;

import java.util.Random;

public class threadTest {
	/*
	100元，分成3個包，現在有五個人去搶
	紅包是共享數據 5人是五個thread
	其中有兩個人會沒搶到
	 */
	/*
	key solution:
	只要加上一個state value就好
	然後前面三個有錢的紅包直接用parameter的方式傳入
	base on state value to determine
	 */
	public static void main(String[] args) {
		// create random number
		Random random = new Random();
		int first = random.nextInt(98)+1;// the bonus can
		// not be 0
		int second = random.nextInt(100 - first - 1) + 1;
		// if the first number is the maximum:98, in
		// order to ensure other two number is not 0, so
		// need to (100 - first - 1)
		int third = 100 - first - second;
		
		Runnable thread = new myThread(first,second,third);
		Thread thread1 = new Thread(thread);
		Thread thread2 = new Thread(thread);
		Thread thread3 = new Thread(thread);
		Thread thread4 = new Thread(thread);
		Thread thread5 = new Thread(thread);
		
		thread1.setName("thread1");
		thread2.setName("thread2");
		thread3.setName("thread3");
		thread4.setName("thread4");
		thread5.setName("thread5");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
