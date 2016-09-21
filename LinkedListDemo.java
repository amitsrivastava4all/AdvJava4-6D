import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(10);
		linkedList.addFirst(1000);
		linkedList.add(1, 222);
		linkedList.addLast(121);
		System.out.println(linkedList);
		linkedList.removeLast();
		linkedList.removeFirst();
		linkedList.remove(0);
		System.out.println("After Remove "+linkedList);
		

	}

}
