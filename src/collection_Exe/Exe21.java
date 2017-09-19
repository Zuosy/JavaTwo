package collection_Exe;

import java.util.Comparator;

import geometric.Circle;
import geometric.GeometricObject;
import geometric.Rectangle;

public class Exe21 {
	public static void main(String[] args) {
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), 
				new Circle(5.5), new Rectangle(2.4, 5),
				new Circle(0.5), new Rectangle(4, 65),
				new Circle(4.5), new Rectangle(4.4, 1),
				new Circle(6.5), new Rectangle(4, 5)};
		selectionSort(list, new collection.GeometricObjectComparator());
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getArea());
		}
	}
	
	public static <E> void 
		selectionSort(E[] list, Comparator<? super E> comparator) {
		E max;
		int maxIndex;
		
		for(int i = 0; i < list.length - 1; i++) {
			max = list[i];
			maxIndex = i;
			for(int j = i; j < list.length; j++) {
				if(comparator.compare(list[j], max) >= 1) {
					max = list[j];
					maxIndex = j;
				}
			}
			
			if(maxIndex != i) {
				list[maxIndex] = list[i];
				list[i] = max;
			}
		}
	}
}
