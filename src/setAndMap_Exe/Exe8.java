package setAndMap_Exe;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Exe8 {
	public static void main(String[] args) throws Exception {
		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		String string = "";
		while(input.hasNextLine()) {
			string += input.nextLine();
		}
		input.close();
		string = string.toLowerCase();
		String[] strs = string.split("[ ,;.:?\\'\\\"\\*/()\\[\\]{}\\\\+=*[^a-z]]");
		System.out.println(Arrays.toString(strs));
		
		Map<String, Integer> map = new TreeMap<>();
		for(int i = 0; i < strs.length; i++) {
			if(!strs[i].equals("") && strs[i]!=null) {
				String temp = strs[i];
				if(!map.containsKey(temp)) {
					map.put(temp, 1);
				} else {
					int value = map.get(temp) + 1;
					map.put(temp, value);
				}
			}
		}
		Set<Map.Entry<String, Integer>> setEnty = map.entrySet();
		for(Map.Entry<String, Integer> entry : setEnty) {
			System.out.println(entry);
		}
	}
}
