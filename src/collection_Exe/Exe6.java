package collection_Exe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Exe6 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Random random = new Random();
		for(int i = 0; i < 5000000; i++) {
			list.add(random.nextInt(100));
		}
		System.out.println("Iterator use " + iterator(list) + "ms");
		
		System.out.println("ForEach use " + forEach(list) + "ms");
	}
	
	public static long iterator(LinkedList<Integer> list) {
		long startTime = System.currentTimeMillis();
		Iterator<Integer> i = list.iterator();
		while(i.hasNext()){
			i.next();
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	public static long forEach(LinkedList<Integer> list) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
