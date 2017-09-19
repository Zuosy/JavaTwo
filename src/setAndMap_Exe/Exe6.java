package setAndMap_Exe;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Exe6 {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new TreeMap<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Input:");
		Integer temp = 0;
		while((temp = input.nextInt()) != 0) {
			if(map.containsKey(temp)) {
				int value = map.get(temp) + 1;
				map.put(temp, value);
			} else {
				map.put(temp, 1);
			}
		}
		input.close();
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		int maxValue = 0;
		for(Map.Entry<Integer, Integer> entry : set) {
			if(entry.getValue() > maxValue)
				maxValue = entry.getValue();
		}
		//不管了还是再遍历一遍吧
		for(Map.Entry<Integer, Integer> entry : set) {
			if(entry.getValue() == maxValue)
				System.out.println(entry.getKey() + ":\t" + entry.getValue());
		}
	}
}
