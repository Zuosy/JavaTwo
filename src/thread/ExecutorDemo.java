package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;;

public class ExecutorDemo {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = 
				Executors.newFixedThreadPool(3);
//				Executors.newCachedThreadPool();
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintNum(100));
//		executor.execute(new PrintChar('A', 10));
		
		executor.shutdown();
		
		while(true) {
			Thread.sleep(1000);
			if(executor.isTerminated()) {
				System.out.println("所有任务都完成了");
				break;
			}
		}
	}
}
