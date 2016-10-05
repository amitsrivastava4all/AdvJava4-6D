package com.bmpl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		if(userid.equals(password)){
			out.println("Welcome User "+userid);
		}
		else
		{
			out.println("Invalid Userid or Password ");
		}
		out.close();
	}

}
