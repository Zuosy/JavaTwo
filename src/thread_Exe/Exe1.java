package thread_Exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("unused")
public class Exe1 {
	public static void main(String[] args) {
		Runnable printA = new PrintChar('A', 1000);
		Runnable printB = new PrintChar('B', 1000);
		Runnable printNum = new PrintNum(100);

		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(printNum);

		thread1.start();
		thread2.start();
		thread3.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
//		ExecutorService executor = Executors.newFixedThreadPool(3);
//		executor.execute(new PrintChar('A', 100));
//		executor.execute(new PrintChar('B', 100));
//		executor.execute(new PrintNum(100));
//		
//		executor.shutdown();
//		while(!executor.isTerminated()){
//		}
		System.out.println("\n≥Ã–ÚΩ· ¯ƒÚ");
	}

	private static class PrintChar implements Runnable {
		private char printCh;
		private int times;

		public PrintChar(char printCh, int times) {
			this.printCh = printCh;
			this.times = times;
		}

		@Override
		public void run() {
			for (int i = 0; i < times; i++) {
				System.out.print(printCh);
			}
		}
	}

	private static class PrintNum implements Runnable {
		private int number;

		public PrintNum(int number) {
			this.number = number;
		}

		@Override
		public void run() {
			for (int i = 0; i < number; i++) {
				System.out.print(i + " ");
			}
		}
	}
}
