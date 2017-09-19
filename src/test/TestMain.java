package test;

import generic.GenericStack;
import geometric.Circle;
import geometric.GeometricObject;
import geometric.Rectangle;

public class TestMain {
	public static void main(String[] args) {
		GenericStack<GeometricObject> stack = new GenericStack<>();
		stack.push(new Circle());
		stack.push(new Rectangle());
		
		System.out.println(stack);
	}
}
