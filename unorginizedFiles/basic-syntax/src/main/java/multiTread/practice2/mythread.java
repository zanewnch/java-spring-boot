package multiTread.practice2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class mythread implements Runnable{
	int count = 100;
	// create lock
	static Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		while (true){
			lock.lock();
			Thread thread = Thread.currentThread();
			try {
				if (count == 10){
					break;
				}else{
				// 	main command
					Thread.sleep(30);
					count --;
					System.out.println("The thread ID: "+thread.threadId() + " the thread name: "+ thread.getName() + " ;the remaining quantity:" + count);
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
	}
}

