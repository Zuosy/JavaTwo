package thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ThreadCooperation {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		System.out.println("Thread 1\t\tThread 2\t\tBalance");
		executor.execute(new DepositTask());//存钱任务
		executor.execute(new WithdrawTask());//取钱任务
		executor.shutdown();
	}
	
	public static class DepositTask implements Runnable {
		@Override
		public void run() {
			try{
				while(true) {
					account.deposit((int)(Math.random() * 10) + 1);
					//如果不加这个休眠的话，电脑的运算速度会教你做人的。
					Thread.sleep(3000);
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static class WithdrawTask implements Runnable {
		@Override
		public void run() {
			while(true) {
				account.withdraw((int)(Math.random() * 10) + 1);//疯狂取钱
			}
		}
	}
	
	private static class Account {
		private static Lock lock = new ReentrantLock();//锁 没毛病
		private static Condition newDeposit = lock.newCondition();
		private int balance = 0;//余额
		
		public int getBalance() {
			return balance;
		}
		
		public void withdraw(int amount) {//取钱
			lock.lock();
			//良好的编程习惯 lock之后 try...catch...finally里面解锁
			try{
				if (balance < amount) {
					System.out.println("\t\t\tWait for a deposit.");
					newDeposit.await();//没钱就等着
				}
				//当余额不足时，等下一笔存款到账，取钱的任务等待。
				balance -= amount;
				System.out.println("\t\t\tWithdraw " + 
						amount + "\t\t" + getBalance());
				
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
		public void deposit(int amount) {//存钱
			lock.lock();
			try{
				balance += amount;
				System.out.println("Deposit " + 
						amount + "\t\t\t\t\t" + getBalance());
				
				//newDeposit.signalAll();
				newDeposit.signal();
			} catch (IllegalMonitorStateException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
	
	//用信号量写
	/*
	private static class Account {
		private static Semaphore semaphore = new Semaphore(1);
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			try{
				semaphore.acquire();
				int newBalance = balance + amount;
				
				Thread.sleep(5);
				balance = newBalance;
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				semaphore.release();
			}
		}
		
		public void withdraw(int amount) {
			try{
				semaphore.acquire();
				int newBalance = balance - amount;j
				
				Thread.sleep(5);
				balance = newBalance;
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				semaphore.release();
			}
		}
	}
	*/
}
