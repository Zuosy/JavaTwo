package generic_Exe;

public class Exe6 {
	
	public static void main(String[] args) {
		Integer[][] list = new Integer[2][2];
		list[0][0] = 1;
		list[0][1] = 2;
		list[1][0] = 10;
		list[1][1] = 3;
		System.out.println(max(list));
	}
	
	public static <E extends Comparable<E>> E max(E[][] list) {
		E max = list[0][0];
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list[i].length; j++) {
				if(max.compareTo(list[i][j]) < 0)
					max = list[i][j];
			}
		}
		return max;
	}
}
