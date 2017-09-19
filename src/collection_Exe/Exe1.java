package collection_Exe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exe1 {
	public static void main(String[] args) 
			throws IOException, FileNotFoundException {
		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		List<String> list = new ArrayList<>();
		while(input.hasNext()) {
			list.add(input.next());
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		input.close();
	}
}
