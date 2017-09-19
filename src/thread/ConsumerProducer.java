package thread;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ConsumerProducer {
	private static Buffer buffer = new Buffer();//缓冲
	
	public static void main(String[] args) {
		ExecutorService executor = 
				Executors.newFixedThreadPool(2);//两个线程
		executor.execute(new ProducerTask());//生产者
		executor.execute(new ConsumerTask());//消费者
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
		
		private static Condition notEmpty = lock.newCondition();//告诉消费者buffer不空
		private static Condition notFull = lock.newCondition(); //告诉生产者buffer不是满的
		
		public void write(int value) {//生产者写
			lock.lock();
			try {
				while(queue.size() == CAPACITY) {
					System.out.println("Wait for notFull condition");
					notFull.await();//buffer满了 就等一等 等到notFull再生产
				}
				
				queue.offer(value);
				System.out.println(value + " in");//这个可以注释 测试用的 很有用
				notEmpty.signal();//既然生产了，就可以告诉消费者 消费了。
			} catch(InterruptedException ex){
				
			} finally {
				lock.unlock();
			}
		}
		
		public int read() {//消费者读
			int value = 0;
			lock.lock();
			try {
				while (queue.isEmpty()) {
					System.out.println("\t\t\tWait for notEmpty condition");
					notEmpty.await(); //空了 就告诉自己等一下，别吃了。
				}
				value = queue.remove();
				System.out.println(value + " out");//这个可以注释 测试用的 很有用
				notFull.signal();//消费了一个 告诉生产者 可以生产了。
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.unlock();
			}
			return value;
		}
	}
}
