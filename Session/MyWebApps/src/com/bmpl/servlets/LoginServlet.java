package com.bmpl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bmpl.users.dao.UserDAO;
import com.bmpl.users.dto.UserDTO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);
		UserDAO userDAO = new UserDAO();
		try {
			UserDTO userDTOObject = userDAO.isUserExist(userDTO);
			if(userDTOObject!=null && userDTOObject.getUserName()!=null){
				// Create a New Session 
				HttpSession session = request.getSession(true);
//				HttpSession session = request.getSession();
//				if(session.isNew()){
//					
//				}
				session.setAttribute("userinfo", userDTOObject);
				response.sendRedirect("welcome?uname="+userDTOObject.getUserName()+"&role="+userDTOObject.getRoleDTO().getName());
				//out.println("Welcome "+userDTOObject.getUserName());
			}
			else{
			out.println("Invalid Userid or Password ");
			}
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(userid.equals(password)){
//			out.println("Welcome User "+userid);
//		}
//		else
//		{
//			out.println("Invalid Userid or Password ");
//		}
		out.close();
	}

}
