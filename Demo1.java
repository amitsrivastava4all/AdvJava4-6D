import java.util.TreeSet;

/*
 * I want to store list of songs (N) in all songs are in sorted order
 * and no duplicate song allowed
 */
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// (Dynamic) No Duplicate and Sorted
		TreeSet set = new TreeSet();
		set.add("Saturday Night");
		set.add("I like the Party");
		set.add("I like the Party");
		set.add("Saturday Night");
		System.out.println(set);
		

	}

}
