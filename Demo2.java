import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List - Index Wise
		// ArrayList
		// LinkedList
		// Vector
		// 10 - Binary 1010
		String binary = Integer.toBinaryString(10);
		System.out.println("Binary is "+binary);
		//1010>>1  0101 = 5
		// 15 = 10 + 5
		// ArrayList is a ARRAY Internally
		// and we know array is fixed size
		// when array is filled then create a new array and copy 
		// the old list into the new and then delete the old and point
		// to the new
		
		//int newCapacity then = OldCapacity + (OldCapacity >> 1) 
		// ArrayList<> 1.7 Style in R.H.S
		ArrayList<Integer> list = new ArrayList<>(200); //10 elements capacity
		list.add(new Integer(10)); // [0] = 10
		// From Java 5 It provide AutoBoxing
		// Boxing - Convert Primitive into Object (Wrappers)
		// Following is the Boxing Code (Primitive is convert into Wrapper)
		// C for Create
		list.add(20); //[1]=20  // AutoBoxing
		list.add(30);
		list.add(130);
		list.add(230);
		list.add(430);
		list.add(0, 11111);
		list.add(2,44444);
		list.add(110);
		list.add(630);
		list.add(100);
		list.add(130);
		// Following is the UnBoxing Wrapper is converted into Primitive
		// AutoBoxing = Boxing + UnBoxing
		int x = list.get(0); // R For Read // AutoBoxing
		System.out.println(x);
		//list.add("amit");
		//String  name = (String)list.get(2);
		System.out.println();
		System.out.println(list);
		// CRUD Operations
		// C - Create
		// R - Read
		// U - Update
		// D - Delete
		list.set(0, 99999);
		System.out.println("After Update "+list);
		list.remove(0);
		System.out.println("After Remove "+list);
		//find
		if(list.contains(130)){
			System.out.println("Found....");
		}
		else
		{
			System.out.println("Not Found...");
		}
		int index= list.indexOf(130);
		
		if(index>=0){
			System.out.println("FOUND.... "+index);
			list.remove(index); 
		}
		else
		{
			System.out.println("Not FOUND....");
		}
		index = list.lastIndexOf(130);
		System.out.println("Last Index "+index);
		System.out.println("Sorting ....");
		Collections.sort(list);
		System.out.println(list);
		// Vector is Legacy Class
		// Vector all Methods are Synchronized
		// Vector has old methods and new ArrayList methods
		// When MultiThreading, INdex wise and Writing Operations then go for Vector
		Vector<Integer> vector = new Vector<>();
		vector.addElement(1000);
		vector.add(100);
		
		// Traverse 
		// Every Object when it is going to print it call toString
		System.out.println("Print :"+list.toString());
		int sum = 0;
		// 1st Way
		for(int i = 0 ; i<list.size(); i++){
			if(list.get(i)>100){
			sum = sum + list.get(i);
			}
			}
		System.out.println("Sum is "+sum);
		// 2nd Way Java 1.4
		// remove also + Forward Only
		Iterator<Integer> j = list.iterator();
		while(j.hasNext()){
			System.out.println(j.next());
			// i.remove();
			// get the current element and then move to the next element
		}
		// 3rd Way Java 1.4
		ListIterator<Integer> k = list.listIterator();
		while(k.hasNext()){
			System.out.println(k.next());
		}
		while(k.hasPrevious()){
			System.out.println(k.previous());
		}
		// 4th Way Enhance for Loop (Java 1.5)
		for(Integer y : list){
			System.out.println(y);
		}
		 
		// 5th Way ForEach function (Java 1.8)
		list.forEach((v)->System.out.println(v));
	}

}
