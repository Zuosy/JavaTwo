package thread_Exe;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Exe15 {
	public static void main(String[] args) {
		Random random = new Random();
		double[] list = new double[9_000_000];
		for(int i = 0; i < list.length; i++)
			list[i] = random.nextDouble();
		double sum = 0;
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < list.length; i++)
			sum += list[i];
		long endTime = System.currentTimeMillis();
		System.out.println("串行SUM:" + sum + "\t\tTIME:" + 
				(endTime - startTime));
		
		//并发能快吗？
		startTime = System.currentTimeMillis();
		sum = paralleSum(list);
		endTime = System.currentTimeMillis();
		System.out.println("并发SUM:" + sum + "\t\tTIME:" + 
				(endTime - startTime));
	}
	public static double paralleSum(double[] list) {
		RecursiveTask<Double> task = new SumTask(list);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(task);
	}
	
	@SuppressWarnings("serial")
	private static class SumTask extends RecursiveTask<Double> {
		static final int THRESHOLD = 2_250_000;
		private double[] list;
		private int low;
		private int high;
		
		public SumTask(double[] list) {
			this.list = list;
			low = 0;
			high = list.length;
		}
		
		public SumTask(double[] list, int low, int high) {
			this.list = list;
			this.low = low;
			this.high = high;
		}
		
		@Override
		protected Double compute() {
			if((high - low) < THRESHOLD) {
				double sum = 0;
				for(int i = low; i < high; i++)
					sum += list[i];
				return sum;
			} else {
				int mid = (low + high) / 2;
				RecursiveTask<Double> left = new SumTask(list, low, mid);
				RecursiveTask<Double> right = new SumTask(list, mid, high);
				left.fork();
				right.fork();
				return left.join() + right.join();
			}
		}
	}
}