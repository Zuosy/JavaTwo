package generic_Exe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Exe10 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			list.add(random.nextInt(10));
		}
		System.out.println(list.toString());
		System.out.println(max(list));
	}
	
	public static <E extends Comparable<E>> 
		E max(ArrayList<E> list) {
		E max = list.get(0);
		for(Iterator<E> i = list.iterator(); i.hasNext(); ) {
			E temp = i.next();
			if(temp.compareTo(max) > 0) {
				max = temp;
			}
		}
		return max;
	}
}
