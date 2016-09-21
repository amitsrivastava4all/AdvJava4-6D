
public class Product {
	private int id;
	private String name;
	private double price;
	
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
