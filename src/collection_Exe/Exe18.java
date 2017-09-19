package collection_Exe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exe18 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("Input :");
		String string = input.nextLine();
		input.close();
		File directory = new File(string);
		System.out.println(directory.getAbsolutePath());
		System.out.println(getSize(directory) + "B");
	}
	
	public static long getSize(File directory) throws FileNotFoundException {
		long size = 0;
		Queue<File> queue = new LinkedList<>();
		queue.add(directory);
		while (!queue.isEmpty()) {
			File temp = queue.remove();
			if(temp.isFile()) {
				size += temp.length();
			} else if(temp.isDirectory()) {
				File[] files = temp.listFiles();
				for(File f : files) {
					queue.add(f);
				}
			}
		}
		return size;
	}
}