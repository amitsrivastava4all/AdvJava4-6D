package com.bmpl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.ims")
public class LogoutServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
//		if(session==null){
//			response.sendRedirect("login.html");
//		}
//		else
//		{
			
			response.setHeader("Cache-control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			session.removeAttribute("userinfo");
			session.invalidate();
			String driverValue = this.getServletConfig().getInitParameter("drivername");
			String email = this.getServletConfig().getServletContext().getInitParameter("email");
			PrintWriter out= response.getWriter();
			out.println("Logout SuccessFully ! "+driverValue+" "+email);
			out.close();
			//RequestDispatcher rd = request.getRequestDispatcher("headers");
			//rd.include(request, response);
		//}
	}

}
