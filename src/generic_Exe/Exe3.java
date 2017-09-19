package generic_Exe;

import java.util.ArrayList;
import java.util.Iterator;

public class Exe3 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		System.out.println(list.toString());
		list = removeDuplicates(list);
		System.out.println(list.toString());
	}
	
	public static <E> ArrayList<E> 
		removeDuplicates(ArrayList<E> list) {
		ArrayList<E> result = new ArrayList<>();
		
		for(Iterator<E> i = list.iterator(); i.hasNext();) {
			E e = i.next();
			if(!result.contains(e)) {
				result.add(e);
			}
		}
		return result;
	}
}
