import java.util.Comparator;

class SortByName implements Comparator<Product>{
	@Override
	public int compare(Product one, Product two){
		//return one.getName().compareTo(two.getName()); // Asc Order
		//return two.getName().compareTo(one.getName()); // Desc Order
		return one.getName().compareToIgnoreCase(two.getName()); // Not in Ascii Order Dictionary Order Follow
	}
}

class SortById implements Comparator<Product>{
	@Override
	public int compare(Product one, Product two){
		return ((Integer)one.getId()).compareTo((Integer)two.getId());
	}
}


public class Product implements Comparable<Product> {
	private int id;
	private String name;
	private double price;
	
	@Override
	public int compareTo(Product product){
	//public int compareTo(Object object){
		//if(object instanceof Product){
			//Product product = (Product)object; // Downcasting
			return ((Double)this.price).compareTo((Double)product.price);
		//}
		//return 0;
	}
	
	@Override
	public boolean equals(Object o){
		boolean isFound = false;
		if(o instanceof Product){
			Product p = (Product)o; // Downcasting
			if(this.id==p.id && this.name.equals(p.name) && this.price==p.price){
				isFound = true;
				
			}
		}
		return isFound;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
