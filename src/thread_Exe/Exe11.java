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
		System.out.println("����ʼ��");
		executor.shutdown();
	}

	private static class Task1 implements Runnable {
		@Override
		public void run() {
			synchronized (object1) {
				//��סobject1���� Ҫobject2
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				synchronized (object2) {

				}
			}
			System.out.println("Task1������");
		}
	}

	private static class Task2 implements Runnable {
		@Override
		public void run() {
			synchronized (object2) {
				//��סobject2 Ҫobject1
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				synchronized (object1) {

				}
			}
			System.out.println("Task2������");
		}
	}
}