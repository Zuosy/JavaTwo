package generic_Exe;

public class Exe1TestMain {
	public static void main(String[] args) {
		Exe1<String> stack = new Exe1<>();
		stack.push("HelloWorld");
		stack.push("Shiro");
		stack.push("Windows");
		System.out.println(stack.toString());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.push("GouDan");
		System.out.println(stack.toString());
	}
}
