import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.bmpl.dao.common.DBConstants.ITEM_INSERT_SQL;

import com.bmpl.dao.common.CommonDAO;

public class InsertDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
		 con = CommonDAO.getInstance().getConnection();
		 pstmt  = con.prepareStatement(ITEM_INSERT_SQL);
		 pstmt.setInt(1, 1009);
		 pstmt.setString(2, "Shoes");
		 pstmt.setDouble(3, 3333);
		 int recordAdded = pstmt.executeUpdate();
		 if(recordAdded>0){
			 System.out.println("Record Added...");
		 }
		 else
		 {
			 System.out.println("Error in Record Addition...");
		 }
//		if(con!=null){
//			System.out.println("Connection Created...");
//		}
		}
		finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
			con.close();
			}
		}
		

	}

}
