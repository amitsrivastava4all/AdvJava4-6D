package com.bmpl.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.common.dao.CommonDAO;
import com.bmpl.common.dao.CommonSQL;
import com.bmpl.users.dto.RightDTO;
import com.bmpl.users.dto.RoleDTO;
import com.bmpl.users.dto.UserDTO;

public class UserDAO {
	
	public UserDTO isUserExist(UserDTO userDTO) throws SQLException, ClassNotFoundException{
		ArrayList<UserDTO> userList= new ArrayList<UserDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		UserDTO userDTOObject = null;
		RoleDTO roleDTO = null;
		ArrayList<RightDTO> rightList = new ArrayList<RightDTO>();
		try
		{
			con= CommonDAO.getConnection();
			pstmt=con.prepareStatement(CommonSQL.USER_SQL);
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, userDTO.getPassword());
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(userDTOObject==null){
					userDTOObject= new UserDTO();
					userDTOObject.setUserid(rs.getString("userid"));
					userDTOObject.setUserName(rs.getString("username"));
					
				}
				if(roleDTO==null){
					roleDTO= new RoleDTO();
					roleDTO.setName("rolename");
					roleDTO.setDescr("roledescr");
				}
				RightDTO rightDTO = new RightDTO();
				rightDTO.setName(rs.getString("name"));
				rightDTO.setDescr(rs.getString("descr"));
				rightDTO.setUrl(rs.getString("screenname"));
				rightList.add(rightDTO);
			}
			if(userDTOObject!=null){
				if(roleDTO!=null){
					userDTOObject.setRoleDTO(roleDTO);
					if(rightList!=null && rightList.size()>0){
						roleDTO.setRightList(rightList);
					}
				}
			}
			System.out.println("DATA IS "+userDTOObject);
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
		return userDTOObject;
	}

}
