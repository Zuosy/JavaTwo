package generic_Exe;

import java.util.ArrayList;
import java.util.Random;

public class Exe8 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			list.add(random.nextInt(10));
		}
		System.out.println(list.toString());
		shuffle(list);
		System.out.println(list.toString());
	}
	
	public static <E> void shuffle(ArrayList<E> list) {
		Random random = new Random();
		for(int i = 0; i < list.size(); i++) {
			//list[i]<-->list[random]
			int index = random.nextInt(list.size());
			E oldElement = list.set(i, list.get(index));
			list.set(index, oldElement);
		}
	}
}
