package collection_Exe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Exe8 {
	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<Integer> lottery��Ʊ = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			lottery��Ʊ.add(random.nextInt(100));
		}
		//Collections.sort(lottery��Ʊ);//��Ʊ
		
		ArrayList<Integer> input = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.println("С�������Ʊ����");
		for(int i = 0; i < 3; i++) {
			input.add(in.nextInt());
		}
		in.close();
		//Collections.sort(input);//���Ʊ
		
		System.out.println(lottery��Ʊ);
		System.out.println(input);
		
		int counter = 0;
		for(Iterator<Integer> i = lottery��Ʊ.iterator(); i.hasNext();) {
			if(input.contains(i.next())) {
				counter++;
			}
		}
		
		System.out.println(counter);
		
	}
}
