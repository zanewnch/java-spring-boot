package multiTread.practice1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class myThread implements Runnable {
	/**
	 * 不求return的多線程寫法有兩個
	 * 一個是直接extends thread
	 * 一個是現在使用的runnable
	 * 因為runnable 是用interface比較彈性
	 * 所以我選擇使用runnable
	 */
	
	// create initial value of tickets
	static int tickets = 0;
	// create lock
	static Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		while (true){
			// 上鎖
			/*
			 * 上鎖的意義是：
			 * 因為cpu的thread是隨機分配
			 * 讓每個thread去搶
			 * 但我希望一個tread在執行的時候可以完成一組命令
			 * 才需要上鎖
			 * 直到命令執行完成後
			 * 才會解鎖
			 * 再讓所有的thread排隊
			 */
			lock.lock();
			// 獲取當前thread的object
			Thread thread = Thread.currentThread();
			try {
			 if (tickets==1000){
				 break;
			 }else{
				 // System.out.println(thread);//Thread[#21,Thread1,5,main]
				 Thread.sleep(1);
				 tickets ++;
				 System.out.println("The thread ID: "+ thread.threadId() +" Thread name: " + thread.getName()+
						 "; sales tickets: " + tickets);
			 }
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				// finally: 不管try-catch怎樣,finally都一定會被執行
				/*
				 * 解鎖:
				 * 讓其他tread也可以開始排隊
				 */
				lock.unlock();
			}
			}
	
	}
}
