package thread_Exe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe9 {
	private static Set<Integer> hashSet = Collections.synchronizedSet(new HashSet<Integer>());

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new InsertTask());
		executor.execute(new AccessTask());
		executor.shutdown();
	}

	private static class InsertTask implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					hashSet.add((int) (Math.random() * 100));
					Thread.sleep(1000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static class AccessTask implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					synchronized (hashSet) {//不加同步就会报出你喜欢的异常
						for (Iterator<Integer> i = hashSet.iterator(); i.hasNext();) {
							System.out.print(i.next() + " ");
						}
					}
					System.out.println();
					Thread.sleep(1000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
