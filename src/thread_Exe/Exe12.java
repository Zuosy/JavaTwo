package thread_Exe;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exe12 {
	private static Random random = new Random();
	
	public static void main(String[] args) {
		double[] list = new double[9_000_000];
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < list.length; i++) {
			list[i] = random.nextDouble();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		startTime = System.currentTimeMillis();
		paralleAssignValues(list);
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
	}
	
	public static void paralleAssignValues(double[] list) {
		RecursiveAction task = new AccessTask(list);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
	}
	
	@SuppressWarnings("serial")
	private static class AccessTask extends RecursiveAction {
		static final int THRESHOLD = 10_000;
		private double[] list;
		private int low;
		private int high;
		
		public AccessTask(double[] list) {
			this.list = list;
			low = 0;
			high = list.length;
		}
		
		public AccessTask(double[] list, int low, int high) {
			this.list = list;
			this.low = low;
			this.high = high;
		}
		
		@Override
		protected void compute() {
			if((high - low) < THRESHOLD) {
				for(int i = low; i < high; i++) {
					list[i] = random.nextDouble();
				}
			} else {
				int mid = (low + high) / 2;
				RecursiveAction left = new AccessTask(list, low, mid);
				RecursiveAction right = new AccessTask(list, mid, high);
				left.fork();
				right.fork();
				//好像不需要join
//				left.invoke();
//				right.invoke();
			}
		}
	}
}
