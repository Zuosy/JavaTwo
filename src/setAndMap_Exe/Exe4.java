package setAndMap_Exe;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Exe4 {
	public static void main(String[] args) throws Exception {
		Map<Character, Integer> map = new TreeMap<>();
		Character[] chars = {'A', 'E', 'I', 'O', 'U'};
		for(int i = 0; i < chars.length; i++) {
			map.put(chars[i], 0);
		}
		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		String string = "";
		while(input.hasNextLine()) {
			string += input.nextLine();
		}
		input.close();
		char[] chs = string.toCharArray();
		for(Character c : chs) {
			Character temp = Character.toUpperCase(c);
			if(map.containsKey(temp)) {
				int value = map.get(temp) + 1;
				map.put(temp, value);
			}
		}
		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		for(Map.Entry<Character, Integer> entry : set) {
			if(entry.getValue() > 0) {
				System.out.println(entry.getKey() + ":\t" + entry.getValue());
			}
		}
	}
}
