package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {

	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 100; i++) {
			executor.execute(new AddPennyTask());
		}

		executor.shutdown();

		while (!executor.isTerminated()) {
		}

		System.out.println("What is balance? " + account.getBalance());

		System.out.println((System.currentTimeMillis() - startTime) / 1000.0);
	}

	private static class AddPennyTask implements Runnable {
		@Override
		public void run() {
			// synchronized (account) {
			account.deposit(1);
			// }
		}
	}

	private static class Account {
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public synchronized void deposit(int amount) {
			int newBalance = balance + amount;

			try {
				Thread.sleep(50);
			} catch (InterruptedException ex) {
			}

			balance = newBalance;
		}
		// 同步语句格式
		// public void deposit(int amount) {
		// synchronized (this) {
		// int newBalance = balance + amount;
		//
		// try{
		// Thread.sleep(50);//只是让现成多睡一会
		// } catch(InterruptedException ex) {
		//
		// }
		//
		// balance = newBalance;
		// }
		// }
	}
}
