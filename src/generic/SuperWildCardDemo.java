package generic;

public class SuperWildCardDemo {
	public static void main(String[] args) {
		GenericStack<String> stack1 = new GenericStack<>();
		GenericStack<Object> stack2 = new GenericStack<>();
		stack2.push("Java");
		stack2.push(2);
		stack1.push("Sun");
		
		GenericStack<Integer> stack3 = new GenericStack<>();
		
		add(stack3, stack2);
		AnyWildCardDemo.print(stack2);
		
	}
	
//	public static <T> void 
//			add(GenericStack<T> stack1, GenericStack<? super T> stack2) {
//	public static <T> void
//			add(GenericStack<T> stack1, GenericStack<T> stack2) {
	//这种继承的写法很容易出问题的。
	public static <T> void		
	add(GenericStack<? extends T> stack1, GenericStack<T> stack2) {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}
	
}
