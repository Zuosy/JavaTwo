package thread;

public class TaskThreadDemo {
	public static void main(String[] args) {
		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable print100 = new PrintNum(100);
		
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
//		thread1.setPriority(Thread.MIN_PRIORITY);
//		thread2.setPriority(Thread.MAX_PRIORITY);
//		thread3.setPriority(Thread.MAX_PRIORITY);
		//三个线程并发
		thread1.start();
		thread2.start();
		thread3.start();
		//顺序执行
//		print100.run();
//		printA.run();
//		printB.run();
//		System.out.println(thread1.getPriority());
		try{
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("\n" + thread1.getName());
		System.out.println(thread2.getName());
		System.out.println(thread3.getName());
	}
}
//打印字母的任务
class PrintChar implements Runnable {
	private char charToPrint;
	private int times;
	
	public PrintChar(char c, int t) {
		charToPrint = c;
		times = t;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < times; i++) {
			System.out.print(charToPrint);
		}
	}
	
	@Override
	public String toString() {
		return "PrintChar " + charToPrint;
	}
}
//打印1~n数字
class PrintNum implements Runnable {
	private int lastNum;
	
	public PrintNum(int n) {
		lastNum = n;
	}
	
	@Override
	public void run() {
//		Thread thread4 = new Thread(new PrintChar('c', 100));
//		thread4.start();
//		try {
			for (int i = 1; i <= lastNum; i++) {
				System.out.print(" " + i);
//				if (i == 1)
//					thread4.join();
					//Thread.sleep(1000L);
			}
//		} catch (InterruptedException ex) {
//		}
	}
	
	@Override
	public String toString() {
		return "PrintNum " + lastNum;
	}
}
