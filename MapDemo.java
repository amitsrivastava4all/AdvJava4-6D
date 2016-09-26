import java.util.ArrayList;
import java.util.HashMap;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> phoneMap = new HashMap<>();
		phoneMap.put("mike",2222);
		phoneMap.put("amit", 2222);
		phoneMap.put("ram", 3333);
		phoneMap.put("ram", 8888);
		phoneMap.put("shyam", 2121);
		
		System.out.println(phoneMap);
		System.out.println(phoneMap.get("ram"));
		System.out.println(phoneMap.remove("ram"));
		
		HashMap<String,ArrayList<Integer>> multiPhone= new HashMap<>();
		ArrayList<Integer> phones = new ArrayList<>();
		phones.add(1000);
		phones.add(2000);
		phones.add(3000);
		multiPhone.put("amit",phones);
		System.out.println(multiPhone);
		System.out.println("Pick 2nd Phone "+multiPhone.get("amit").get(1));

	}

}
