import java.util.TreeSet;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set is a Interface 
		// Implementation of Set is HashSet , LinkedHashSet and TreeSet
		// HashSet - Unorder and No Duplicate
		// LinkedHashSet - Order (Insertion order) and No Duplicate
		// TreeSet - Sorted and No Duplicate
		TreeSet<String> sets = new TreeSet<>();
		//LinkedHashSet<String> sets  = new LinkedHashSet<>();
		//HashSet<String> sets = new HashSet<>();
		sets.add("shyam");
		sets.add("ram");
		sets.add("ram");
		sets.add("mike");
		sets.add("shyam");
		sets.add("tom");
		sets.add("kim");
		sets.add("rim");
		sets.add("rim");
		System.out.println(sets);
		

	}

}
