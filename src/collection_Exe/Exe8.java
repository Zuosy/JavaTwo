package collection_Exe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Exe8 {
	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<Integer> lottery²ÊÆ± = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			lottery²ÊÆ±.add(random.nextInt(100));
		}
		//Collections.sort(lottery²ÊÆ±);//²ÊÆ±
		
		ArrayList<Integer> input = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.println("Ð¡»ï×ÓÂò²ÊÆ±²»£¿");
		for(int i = 0; i < 3; i++) {
			input.add(in.nextInt());
		}
		in.close();
		//Collections.sort(input);//Âò²ÊÆ±
		
		System.out.println(lottery²ÊÆ±);
		System.out.println(input);
		
		int counter = 0;
		for(Iterator<Integer> i = lottery²ÊÆ±.iterator(); i.hasNext();) {
			if(input.contains(i.next())) {
				counter++;
			}
		}
		
		System.out.println(counter);
		
	}
}
