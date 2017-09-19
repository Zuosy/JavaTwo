package generic_Exe;

import java.util.Arrays;

import javax.xml.transform.Templates;

//GenericStack by array
public class Exe1<E> {
	private E[] arrays = (E[])new Object[10];
	private int size;
	
	public Exe1() {
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public E peek() {
		return arrays[size - 1];
	}
	
	public E pop() {
		return arrays[--size];
	}
	
	public void push(E o) {
		if(size >= arrays.length) {
			@SuppressWarnings("unchecked")
			E[] temp = (E[])new Object[arrays.length * 2];
			System.arraycopy(arrays, 0, temp, 0, arrays.length);
			arrays = temp;
		}
		arrays[size++] = o;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		return "Exe1 :" + Arrays.toString(arrays);
	}
}
