package setAndMap;

import java.util.Set;
import java.util.TreeSet;

import collection.GeometricObjectComparator;
import geometric.Circle;
import geometric.GeometricObject;
import geometric.Rectangle;

public class TestTreeSetWithComparator {
	public static void main(String[] args) {
		Set<GeometricObject> set =
				new TreeSet<>(new GeometricObjectComparator());
		set.add(new Rectangle(4, 5));
		set.add(new Circle(40));
		set.add(new Circle(40));
		set.add(new Rectangle(4, 1));
		
		System.out.println("A sorted set of geometric objects");
		for(GeometricObject element : set)
			System.out.println("area = " + element.getArea());
	}
}
