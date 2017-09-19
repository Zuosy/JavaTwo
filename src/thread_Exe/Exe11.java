package thread_Exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe11 {
	private static Object object1 = new Object();
	private static Object object2 = new Object();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new Task1());
		executor.execute(new Task2());
		System.out.println("程序开始尿");
		executor.shutdown();
	}

	private static class Task1 implements Runnable {
		@Override
		public void run() {
			synchronized (object1) {
				//锁住object1不放 要object2
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				synchronized (object2) {

				}
			}
			System.out.println("Task1结束了");
		}
	}

	private static class Task2 implements Runnable {
		@Override
		public void run() {
			synchronized (object2) {
				//锁住object2 要object1
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				synchronized (object1) {

				}
			}
			System.out.println("Task2结束了");
		}
	}
}