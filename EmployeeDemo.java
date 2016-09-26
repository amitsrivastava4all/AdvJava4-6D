import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Book { // implements Comparable<Book>{
	private String name;
	private double price;
	private String author;
	
	Book(String name , double price, String author){
		this.name = name;
		this.price = price;
		this.author = author;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof Book){
			Book book = (Book)o; // Downcasting
			if(this.name.equals(book.name) && 
					this.price==book.price && this.author.equals(book.author)){
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode(){
		return (int)price;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	//	@Override
//	public int compareTo(Book book){
//		return this.name.compareToIgnoreCase(book.name);
//	}
	@Override
	public String toString(){
		return "Name "+name+" Price "+price +" Author "+author+"\n";
	}
}
class SortByBookName implements Comparator<Book>{
	public int compare(Book one, Book two){
		return one.getName().compareToIgnoreCase(two.getName());
	}
}
public class EmployeeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SortByBookName bookCompare = new SortByBookName();
		//TreeSet<Book> bookSet = new TreeSet<>(bookCompare);
		//TreeSet<Book> bookSet = new TreeSet<>((one,two)
		//		->one.getName().compareToIgnoreCase(two.getName()));
		//Set<Book> bookSet = new HashSet<>(); // Upcasting
		HashSet<Book> bookSet = new HashSet<>();
		Book cBook1 = new Book("Let Us C",400,"Yashwant");
		Book cBook2 = new Book("Let Us C",400,"Yashwant");
		Book cBook3 = new Book("Complete Reference",500,"Herbert");
		Book cBook4 = new Book("Complete Reference",500,"Herbert");
		Book cBook5 = new Book("Head First",500,"Katheiy");
		
		bookSet.add(cBook1);
		bookSet.add(cBook2);
		bookSet.add(cBook3);
		bookSet.add(cBook4);
		bookSet.add(cBook5);
		System.out.println("Books are "+bookSet);

	}

}
