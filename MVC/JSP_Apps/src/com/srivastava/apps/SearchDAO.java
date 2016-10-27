package com.srivastava.apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchDAO {
	
	private Connection getConnection() throws SQLException, ClassNotFoundException{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		Class.forName(rb.getString("drivername"));
		Connection con = DriverManager.getConnection(rb.getString("dburl")
				,rb.getString("userid"),rb.getString("password"));
		return con;
	}
	
	public ArrayList<ItemDTO> searchByPrice(double price) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		ArrayList<ItemDTO> itemList = new ArrayList<>();
		try{
			con = this.getConnection();
			pstmt = con.prepareStatement("select id , name,descr, price,imageurl from item where price>=?");
			pstmt.setDouble(1, price);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ItemDTO itemDTO =new ItemDTO();
				itemDTO.setId(rs.getInt("id"));
				itemDTO.setName(rs.getString("name"));
				itemDTO.setDesc(rs.getString("descr"));
				itemDTO.setPrice(rs.getDouble("price"));
				itemDTO.setImageURL(rs.getString("imageurl"));
				itemList.add(itemDTO);
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return itemList;
		
	}

}
