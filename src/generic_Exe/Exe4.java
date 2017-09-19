package generic_Exe;

public class Exe4 {
	
	public static void main(String[] args) {
		String[] strings = new String[5];
		strings[0] = "Hello";
		strings[1] = "World";
		strings[2] = "Zuosy";
		strings[3] = "Youzt";
		strings[4] = "XiaoMing";
		System.out.println(linearSearch(strings, "Zuosy"));
	}
	
	public static <E extends Comparable<E>> 
		int linearSearch(E[] list, E key) {
		int index = -1;
		for(int i = 0; i < list.length; i++) {
			if (list[i].compareTo(key) == 0) {
				index = i;
			}
		}
		return index;
	}
}
