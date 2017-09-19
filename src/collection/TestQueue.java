package collection;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.offer("Oklahoma");
		queue.offer("Indiana");
		queue.offer("Georgia");
		queue.offer("Texas");
		//这是把链表当成队列使用了。。。
		while(queue.size() > 0)
			System.out.print(queue.remove() + " ");
	}
}
