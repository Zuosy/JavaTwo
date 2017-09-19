package generic_Exe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exe9 {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			list.add(random.nextInt(10));
		}
		System.out.println(list.toString());
		list = sort(list);
		System.out.println(list.toString());
	}
	
	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> 
		ArrayList<E> sort(ArrayList<E> list) {
		Object[] es =  list.toArray();
		Arrays.sort(es);
		ArrayList<E> temp = new ArrayList<>();
		for(int i = 0; i < es.length; i++) {
			temp.add((E)es[i]);
		}
		list = temp;
		return list;
	}
}
