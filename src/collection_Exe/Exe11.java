package collection_Exe;

import java.util.Scanner;
import java.util.Stack;

public class Exe11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input:");
		String str = input.nextLine();
		input.close();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '{' ||
			   str.charAt(i) == '(' ||
			   str.charAt(i) == '[') 
				stack.push(str.charAt(i));
			else if(str.charAt(i) == ')' ||
					str.charAt(i) == ']' ||
					str.charAt(i) == '}') {
				if(!stack.isEmpty()){
					char temp = stack.pop();
					if((temp == '(' && str.charAt(i) == ')') || 
					   (temp == '[' && str.charAt(i) == ']') || 
					   (temp == '{' && str.charAt(i) == '}')){
						continue;
					}else{
						System.out.println("Error!!!");
						System.exit(0);
					}
				}
			}
		}
		if(stack.isEmpty())
			System.out.println("Æ¥ÅäÕýÈ·");
		else
			System.out.println("Error");
		System.exit(0);
	}
}
