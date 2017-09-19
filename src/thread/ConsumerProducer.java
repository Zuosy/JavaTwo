package thread;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ConsumerProducer {
	private static Buffer buffer = new Buffer();//����
	
	public static void main(String[] args) {
		ExecutorService executor = 
				Executors.newFixedThreadPool(2);//�����߳�
		executor.execute(new ProducerTask());//������
		executor.execute(new ConsumerTask());//������
		executor.shutdown();
	}
	
	private static class ProducerTask implements Runnable {
		@Override
		public void run() {
			try{
				int i = 1;
				while(true) {
					System.out.println("Producer writes " + i);
					buffer.write(i++);
					Thread.sleep((int)(Math.random() * 4500));
				}
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static class ConsumerTask implements Runnable {
		@Override
		public void run() {
			try{
				while (true) {
					System.out.println("\t\t\tConsumer reads " + buffer.read());
					Thread.sleep((int)(Math.random() * 5000));
				}
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static class Buffer {
		private static final int CAPACITY = 1;//buffer size
		private LinkedList<Integer> queue =
				new LinkedList<>();
		
		private static Lock lock = new ReentrantLock();
		
		private static Condition notEmpty = lock.newCondition();//����������buffer����
		private static Condition notFull = lock.newCondition(); //����������buffer��������
		
		public void write(int value) {//������д
			lock.lock();
			try {
				while(queue.size() == CAPACITY) {
					System.out.println("Wait for notFull condition");
					notFull.await();//buffer���� �͵�һ�� �ȵ�notFull������
				}
				
				queue.offer(value);
				System.out.println(value + " in");//�������ע�� �����õ� ������
				notEmpty.signal();//��Ȼ�����ˣ��Ϳ��Ը��������� �����ˡ�
			} catch(InterruptedException ex){
				
			} finally {
				lock.unlock();
			}
		}
		
		public int read() {//�����߶�
			int value = 0;
			lock.lock();
			try {
				while (queue.isEmpty()) {
					System.out.println("\t\t\tWait for notEmpty condition");
					notEmpty.await(); //���� �͸����Լ���һ�£�����ˡ�
				}
				value = queue.remove();
				System.out.println(value + " out");//�������ע�� �����õ� ������
				notFull.signal();//������һ�� ���������� ���������ˡ�
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.unlock();
			}
			return value;
		}
	}
}
