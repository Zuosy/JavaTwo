package collection_Exe;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Exe20 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input:");
		String string = input.nextLine();
		input.close();
		File direction = new File(string);
		System.out.println(direction.getAbsolutePath());
		System.out.println(getSize(direction) + "B");
	}
	
	public static long getSize(File direction) {
		long size = 0;
		Stack<File> stack = new Stack<>();
		for(stack.push(direction); !stack.isEmpty(); ) {
			File temp = stack.pop();
			if(temp.isFile()) {
				size += temp.length();
			} else {
				File[] files = temp.listFiles();
				for(File f : files) {
					stack.push(f);
				}
			}
		}
		return size;
	}
}
