package collection_Exe;

import java.util.*;

public class Exe16 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input :");
		String string = input.nextLine();
		input.close();
		ArrayList<String> strs =  new ArrayList<>(Arrays.asList(string.split(" ")));
		processBracket(strs);
		//String[] strs = string.split(" ");
		Set<String> set = new HashSet<>();
		set.add("+");
		set.add("-");
		set.add("*");
		set.add("/");
		set.add("(");
		set.add(")");
		Stack<String> stack = new Stack<>();
		Stack<String> operator = new Stack<>();
		for(String str : strs) {
			if(!set.contains(str)) {
				stack.push(str);
			} else {
				switch (str) {
				case "+":
				case "-":
					if(!operator.isEmpty() && 
					   !operator.peek().equals("(")) {
						stack.push(operator.pop());
					}
					operator.push(str);
					break;
				case "*":
				case "/":
					if(!operator.isEmpty() &&
					   (operator.peek().equals("*") || 
	 				    operator.peek().equals("/"))) {
						stack.push(operator.pop());
					}
					operator.push(str);
					break;
				case "(":
					operator.push(str);
					break;
				case ")":
					while (!operator.peek().equals("(")) {
						stack.push(operator.pop());
					}
					operator.pop();
					break;
				default:
					System.out.println("Error");
					break;
				}
			}
		}
		while(!operator.isEmpty()) {
			stack.push(operator.pop());
		}
		System.out.println(stack.toString());
	}
	//这个处理可以没有
	public static void processBracket(ArrayList<String> strs) {
		for(int i = 0; i < strs.size()-1; i++) {
			if(strs.get(i).equals("(") || strs.get(i+1).equals("-")) {
				strs.add(i+1, "0");
				i++;
				//strs.add(i++, "0");
			}
		}
	}
}
