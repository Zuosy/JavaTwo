package generic_Exe;

import java.util.Arrays;
import java.util.Random;

public class Exe7 {
	
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] list = new Integer[10];
		for(int i = 0; i < list.length; i++) {
			list[i] = random.nextInt(10);
		}
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));
		System.out.println(binarySearch(list, 6));
	}
	
	public static <E extends Comparable<E>> 
		int binarySearch(E[] list, E key) {
		return binarySearch(list, key, 0, list.length);
	}
	
	public static <E extends Comparable<E>>
		int binarySearch(E[] list, E key, int low, int high) {
		if(low <= high) {
			int mid = (low + high) / 2;
			if(list[mid].compareTo(key) > 0) {
				return binarySearch(list, key, low, mid - 1);
			} else if(list[mid].compareTo(key) == 0) {
				return mid;
			} else {
				return binarySearch(list, key, mid + 1, high);
			}
			
		}else {
			return -1;
		}
	}
}
