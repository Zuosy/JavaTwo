package setAndMap_Exe;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exe2 {
	public static void main(String[] args) throws Exception {
		String name = "input.txt";
		File file = new File(name);
		Scanner input = new Scanner(file);
		Set<String> set = new TreeSet<>();
		for(;input.hasNext();) {
			set.add(input.next());
		}
		input.close();
		System.out.println(set);
	}
}
