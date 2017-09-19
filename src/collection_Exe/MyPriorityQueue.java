package collection_Exe;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyPriorityQueue() {
		
	}
	
	@Override
	public Object clone() {
		MyPriorityQueue<E> p = new MyPriorityQueue<>();
		for(Iterator<E> i = this.iterator(); i.hasNext(); ) {
			p.add(i.next());
		}
		return p;
	}
	
	public static void main(String[] args) {
		MyPriorityQueue<String> queue1 = new MyPriorityQueue<>();
		queue1.add("A");
		queue1.add("B");
		queue1.add("C");
		queue1.add("H");
		queue1.add("Hello");
		queue1.add("Are");
		queue1.add("World");
		
//		for(Iterator<String> i = queue1.iterator(); i.hasNext(); ) {
//			System.out.println(queue1);
//			System.out.println(queue1.poll());
//		}
		
		
		@SuppressWarnings("unchecked")
		MyPriorityQueue<String> queue2 = (MyPriorityQueue<String>)queue1.clone();
		System.out.println(queue1);
		System.out.println(queue2);
		System.out.println(queue1 == queue2);
		
		queue1.poll();
		
		System.out.println(queue1);
		System.out.println(queue2);
	}
}
