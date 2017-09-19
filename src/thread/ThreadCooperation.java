package thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ThreadCooperation {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		System.out.println("Thread 1\t\tThread 2\t\tBalance");
		executor.execute(new DepositTask());//��Ǯ����
		executor.execute(new WithdrawTask());//ȡǮ����
		executor.shutdown();
	}
	
	public static class DepositTask implements Runnable {
		@Override
		public void run() {
			try{
				while(true) {
					account.deposit((int)(Math.random() * 10) + 1);
					//�������������ߵĻ������Ե������ٶȻ�������˵ġ�
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
				account.withdraw((int)(Math.random() * 10) + 1);//���ȡǮ
			}
		}
	}
	
	private static class Account {
		private static Lock lock = new ReentrantLock();//�� ûë��
		private static Condition newDeposit = lock.newCondition();
		private int balance = 0;//���
		
		public int getBalance() {
			return balance;
		}
		
		public void withdraw(int amount) {//ȡǮ
			lock.lock();
			//���õı��ϰ�� lock֮�� try...catch...finally�������
			try{
				if (balance < amount) {
					System.out.println("\t\t\tWait for a deposit.");
					newDeposit.await();//ûǮ�͵���
				}
				//������ʱ������һ�ʴ��ˣ�ȡǮ������ȴ���
				balance -= amount;
				System.out.println("\t\t\tWithdraw " + 
						amount + "\t\t" + getBalance());
				
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
		public void deposit(int amount) {//��Ǯ
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
	
	//���ź���д
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
