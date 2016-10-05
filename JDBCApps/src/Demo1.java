import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Enter the Price to Search ");
		Scanner scanner = new Scanner(System.in);
		String price = scanner.nextLine();
		
		// Step -1 Load a Driver (Class)
		// oracle.jdbc.driver.OracleDriver  (Oracle Driver)
		// com.mysql.jdbc.Driver (MySQL Driver)
		
		// jdbc:oracle:thin:@IPAddress:1521:dbname
		// jdbc:mysql://hostname:port/dbname
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/inventorydb";
		String dbUserid = "root";
		String dbPassword = "amit";
		
		Class.forName(driverName);
		
		// Step -2 Create Connection
		Connection con = DriverManager.
				getConnection(dbURL,dbUserid,dbPassword);
		if(con!=null){
			System.out.println("Connection Created...");
		}
		// Step -3 Do DB Query and get the Query Result
		// PreparedStatement (1. Cache the Query and Prevent from SQLInjection)
		PreparedStatement pstmt = con.prepareStatement("select itemid, name "
				+ ",price from items where price>=?");
		pstmt.setDouble(1, Double.parseDouble(price));
		ResultSet rs = pstmt.executeQuery();
		//Statement stmt = con.createStatement();
		//ResultSet rs = stmt.executeQuery("select itemid,name,price "
		//		+ " from items where price>="+price);
		// Step -4 Traverse the ResultSet
		boolean isFound = false;
		while(rs.next()){
			isFound = true;
			System.out.println(rs.getInt("itemid")
					+" "+rs.getString("name")
					+" "+rs.getDouble("price"));
		}
		if(!isFound){
			System.out.println("No Record Found...");
		}
		// Step -5 Close all the open Resources
		rs.close();
		pstmt.close();
		con.close();

	}

}
