package generic;

import java.util.ArrayList;

public class GenericStack<E> {
	private ArrayList<E> list = new ArrayList<>();
	
	public GenericStack() {
		
	}
	
	public int getSize() {
		return list.size();
	}
	
	public E peek() {
		return list.get(list.size() - 1);
	}
	
	public E pop() {
		/*E o = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return o;*/
		return list.remove(list.size() - 1);
	}
	
	public void push(E o) {
		list.add(o);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	@Override
	public String toString() {
		return "stack: " + list.toString();
	}
	
}
