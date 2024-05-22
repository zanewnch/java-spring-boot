package multiTread.practice3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class myThread implements Runnable{
	static int count = 0;
	Lock lock = new ReentrantLock();
	@Override
	public void run() {
		while (true){
			lock.lock();
			Thread thread = Thread.currentThread();
			try {
				if (count < 100){
					count++;
					if(count % 2 == 0){
						continue;
					}else {
						System.out.println(thread.threadId()+"  "+thread.getName()+"  "+count);
					}
				}else{
					break;
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
	}
}
