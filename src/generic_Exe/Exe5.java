package generic_Exe;

public class Exe5 {
	
	public static void main(String[] args) {
		Integer[] arrays = new Integer[6];
		arrays[0] = 1;
		arrays[1] = 2;
		arrays[2] = 20;
		arrays[3] = 3;
		arrays[5] = 33;
		arrays[4] = 3;
		System.out.println(max(arrays));
	}
	
	public static <E extends Comparable<E>> E max(E[] list) {
		E max = list[0];
		for(int i = 1; i < list.length; i++) {
			if(max.compareTo(list[i]) < 0) {
				max = list[i];
			}
		}
		return max;
	}
}
