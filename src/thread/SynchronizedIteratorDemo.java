package thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SynchronizedIteratorDemo {
	public static void main(String[] args) {
		Set<Integer> hashSet = Collections.synchronizedSet(new HashSet<Integer>());
		for(int i = 0; i < 10; i++)
			hashSet.add(i);
		System.out.println("---------华丽的分割线-----------");
		synchronized (hashSet) {
			for(Iterator<Integer> iterator = hashSet.iterator(); iterator.hasNext(); ) {
				System.out.println(iterator.next());
			}
		}
	}
}
