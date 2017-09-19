package thread_Exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe8 {

	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		System.out.println("Thread1\t\tThread2\t\tBalance");
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
	}

	private static class DepositTask implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					account.deposit((int) (Math.random() * 10));
					Thread.sleep(1000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static class WithdrawTask implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					account.withdraw((int) (Math.random() * 10));
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static class Account {
		private int balance;

		public void deposit(int amount) {
			synchronized (this) {
				balance += amount;
				System.out.println("存入:" + amount + "\t\t\t\t" + balance);
				super.notifyAll();
			}
		}

		public void withdraw(int amount) throws InterruptedException {
			synchronized (this) {
				while (balance < amount) {
					System.out.println("\t\t没钱");
					super.wait();
				}
				balance -= amount;
				System.out.println("\t\t取出:" + amount + "\t\t" + balance);
			}
		}
	}
}
