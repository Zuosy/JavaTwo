package thread_Exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe4 {
	private static Integer sum = 0;
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(1000);
		for(int i = 0; i < 1000; i++) {
			executor.execute(new AddTask());
		}
		executor.shutdown();
		while(!executor.isTerminated()){}
		System.out.println(sum);
	}
	
	//不同步
	private static class AddTask implements Runnable {
		@Override
		public void run() {
			sum++;
		}
	}
	
	//同步
//	private static class AddTask implements Runnable {
//		@Override
//		public void run() {
//			synchronized(sum) {
//				sum++;
//			}
//		}
//	}
}
