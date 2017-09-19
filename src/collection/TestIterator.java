package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestIterator {
	
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<>();
		collection.add("New York");
		collection.add("Atlanta");
		collection.add("Dallas");
		collection.add("Madison");
		
		Iterator<String> iterator = collection.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next().toUpperCase() + ", ");
		}
		System.out.println();
		
/*		for(Iterator<String> iterator = collection.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next().toUpperCase() + "   ");
		}*/
//		µü´úÆ÷remove()·½·¨²âÊÔ
		
		
/*		ArrayList<Integer> list = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			list.add(random.nextInt(10));
		}
		System.out.println(list.toString());
		Iterator<Integer> iterator = list.iterator();
		for(int i = 0; i < 5; i++) {
			System.out.print("|" + iterator.next() + "|");
		}
		System.out.println();
		iterator.remove();
		System.out.println(list.toString());*/
		
	}
}
