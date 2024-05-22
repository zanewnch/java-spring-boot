package multiTread.practice4;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class myThread implements Runnable{
	
	private int first;
	private int second;
	private int third;
	public myThread(){
	};
	public myThread(int first,int second,int third){
		this.first = first;
		this.second = second;
		this.third = third;
	};
	static int state = 0;
	
	@Override
	public void run() {
		Lock lock = new ReentrantLock();
		lock.lock();
		Thread thread = Thread.currentThread();
		try {
			if (state == 0){
				state++;
				System.out.println(thread.getName()+" get" +
						":" +
						"  "+ first);
			}else if(state == 1){
				state++;
				System.out.println(thread.getName()+" get" +
						":" +
						"  "+ second);
			}else if(state == 2){
				state++;
				System.out.println(thread.getName()+" get" +
						":" +
						"  "+ third);
			}else if(state == 3){
				System.out.println(thread.getName()+" get" +
						": 0");
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
