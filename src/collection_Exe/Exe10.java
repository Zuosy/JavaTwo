package collection_Exe;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Exe10 {
	public static void main(String[] args) {
		String[] str1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
		String[] str2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
		PriorityQueue<String> queue1 = new PriorityQueue<>();
		PriorityQueue<String> queue2 = new PriorityQueue<>();
		
		for(int i = 0; i < str1.length; i++)
			queue1.add(str1[i]);
		for(int i = 0; i < str2.length; i++)
			queue2.add(str2[i]);
		
		System.out.println(queue1);
		System.out.println(queue2);
		
		System.out.print("并集:");
		PriorityQueue<String> queue3 = new PriorityQueue<>(queue1);
		for(Iterator<String> i = queue2.iterator(); i.hasNext();) {
			String temp = i.next();
			if(!queue3.contains(temp)) {
				queue3.add(temp);
			}
		}
		System.out.println(queue3.toString());
		
		System.out.print("交集:");
		PriorityQueue<String> queue4 = new PriorityQueue<>();
		for(Iterator<String> i = queue1.iterator(); i.hasNext();) {
			String temp = i.next();
			if(queue2.contains(temp)) {
				queue4.add(temp);
			}
		}
		System.out.println(queue4.toString());
		
		System.out.print("差集:(A-B)");
		PriorityQueue<String> queue5 = new PriorityQueue<>(queue1);
		for(Iterator<String> i = queue2.iterator(); i.hasNext(); ) {
			String temp = i.next();
			if(queue1.contains(temp)){
				queue5.remove(temp);
			}
		}
		System.out.println(queue5.toString());
	}
}
