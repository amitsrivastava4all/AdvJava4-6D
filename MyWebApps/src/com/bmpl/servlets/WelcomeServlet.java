package com.bmpl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	int counter ;
	
	@Override
	public void init(){
		counter = 1;
		System.out.println("Init Call Only Once.... "+counter);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Welcome User "+counter);
		System.out.println("GET CALL "+counter);
		counter++;
		out.close();
	}

}
