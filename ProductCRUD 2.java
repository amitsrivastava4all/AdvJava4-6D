import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class ProductOperations{
	private ArrayList<Product> productList = new ArrayList<>();
	 void addNewProduct(int id , String name , double price){
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		productList.add(product);
		System.out.println("Record Added....");
		
	}
	 
	 boolean delete(int index){
		 return productList.remove(index)!=null?true:false;
	 }
	 
	 int search(int id, String name , double price){
		 
		 Product product = new Product();
		 product.setId(id);
			product.setName(name);
			product.setPrice(price);
			return productList.indexOf(product);
	 }
	 void sortByPrice(){
		 Collections.sort(productList); // In this case it call Comparable
	 }
	 void sortByName(){
		 //SortByName obj = new SortByName();
		 //Collections.sort(productList,obj);
//		 Collections.sort(productList,new Comparator<Product>() {
//			 @Override
//			 public int compare(Product one , Product two){
//				 return one.getName().compareTo(two.getName());
//			 }
//		 });
		 Collections.sort(productList
				 ,(one,two)-> one.getName().compareTo(two.getName()));
	 }
	 void sortById(){
		 SortById obj = new SortById();
		 Collections.sort(productList,obj);
	 }
	 void printProducts(){
		 if(productList.size()>0){
			 productList.forEach((product)->
			 System.out.println("Id "+product.getId()+" Name "
			 +product.getName()+" Price "+product.getPrice()));
		 }
	 }
}

public class ProductCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		ProductOperations operations = new ProductOperations();
		while(true){
		System.out.println("1. Add a New Product");
		System.out.println("2. Print Product");
		System.out.println("3. Search");
		System.out.println("4. Delete");
		System.out.println("5. Edit");
		System.out.println("6. Sort By Price");
		System.out.println("7. Sort By Name");
		System.out.println("8. Sort By Id");
		System.out.println("9. Count Products");
		System.out.println("10. Total Price of All Products");
		System.out.println("11. Exit");
		System.out.println("Enter the Choice ");
		int choice = scanner.nextInt();
		switch(choice){
		case 1 :
			System.out.println("enter the id");
			int id = scanner.nextInt();
			System.out.println("Enter the Name");
			String name = scanner.next();
			System.out.println("Enter the Price");
			double price = scanner.nextDouble();
			operations.addNewProduct(id, name, price);
			break;
		case 2:
			operations.printProducts();
			break;
		case 3:
			System.out.println("Enter the Id to Search");
			 id = scanner.nextInt();
			System.out.println("Enter the Name to Search");
			 name = scanner.next();
			
			System.out.println("Enter the Price to Search");
			 price = scanner.nextDouble();
			 if(operations.search(id, name, price)>=0){
				 System.out.println("Found...");
			 }
			 else
			 {
				 System.out.println("Not Found...");
			 }
		case 4:
			System.out.println("Enter the Id to Search");
			 id = scanner.nextInt();
			System.out.println("Enter the Name to Search");
			 name = scanner.next();
			
			System.out.println("Enter the Price to Search");
			 price = scanner.nextDouble();
			 int index = operations.search(id, name, price);
			 if(index>=0){
				if(operations.delete(index)){ 
					System.out.println("Product Deleted...");
				}
				else{
					System.out.println("Problem in Deletion..");
				}
			
			 }
			 else
			 {
				 System.out.println("Not Found, Can't Delete...");
			 }
		break;
		case 6:
			operations.sortByPrice();
			break;
		case 7:
			operations.sortByName();
			break;
		case 8 :
			operations.sortById();
			break;
		}
		}
	}

}
