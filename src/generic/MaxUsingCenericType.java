package generic;

public class MaxUsingCenericType {
	public static <E extends Comparable<E>> E max(E o1, E o2) {
		return o1.compareTo(o2)>0 ? o1 : o2;
	}
	
	public static void main(String[] args) {
//		System.out.println(max("233", new Integer(3)));
	}
}
