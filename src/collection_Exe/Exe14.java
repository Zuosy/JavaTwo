package collection_Exe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Exe14 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input:");
		String str = input.nextLine();
		input.close();
		String[] strs = proStr(str);
		Stack<Integer> stack = new Stack<>();
		Set<String> set = new HashSet<>();
		set.add("+");
		set.add("-");
		set.add("*");
		set.add("/");
		for(String s : strs) {
			if(set.contains(s)) {
				processStack(stack, s.charAt(0));
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		System.out.println("Result : " + stack.pop());
	}
	
	public static void processStack(Stack<Integer> stack, Character op) {
		Integer num2 = stack.pop();
		Integer num1 = stack.pop();
		Integer num3 = null;
		switch (op) {
		case '+':
			num3 = num1 + num2;
			break;
		case '-':
			num3 = num1 - num2;
			break;
		case '*':
			num3 = num1 * num2;
			break;
		case '/':
			num3 = num1 / num2;
			break;
		default:
			System.out.println("ERROR IN processStack.");
			break;
		}
		stack.push(num3);
	}
	
	public static String[] proStr(String str) {
		return str.split(" ");
	}
}
