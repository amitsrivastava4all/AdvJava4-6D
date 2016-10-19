package com.bmpl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bmpl.common.utils.ConfigReader;
import com.bmpl.users.dto.RightDTO;
import com.bmpl.users.dto.UserDTO;
@WebServlet( 
urlPatterns={"/welcome.ims"}, 
initParams={ @WebInitParam(name="drivername", value="com.mysql.jdbc.Driver")}) 
public class WelcomeServlet extends HttpServlet {
//	int counter ;
//	
//	@Override
//	public void init(){
//		counter = 1;
//		System.out.println("Init Call Only Once.... "+counter);
//	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// Get the existing session
		HttpSession session = request.getSession(false);
//		if(session==null){
//			response.sendRedirect("login.html");
//		}
//		else
//		{
			// Get Cookie
			String color="cyan";
			Cookie cookies[] = request.getCookies();
			if(cookies!=null && cookies.length>0)
			{
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("mycolor")){
						color = cookie.getValue();
						break;
					}
				}
			}
			
			// include is basically embed the code of headers servlet into Welcome servlet
			//int x = 900/0;
			response.setHeader("Cache-control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			UserDTO userDTO = (UserDTO)session.getAttribute("userinfo");
			System.out.println(userDTO);
			String navBarDesign = "<nav class='navbar navbar-default'> "
					+ "<div class='container-fluid'>"
					+ " <!-- Brand and toggle get grouped for better mobile display -->"
					+ " <div class='navbar-header'> "
					+ "<button type='button' class='navbar-toggle collapsed' "
					+ "data-toggle='collapse'"
					+ " data-target='#bs-example-navbar-collapse-1' "
					+ "aria-expanded='false'> <span class='sr-only'>"
					+ "Toggle navigation</span> <span class='icon-bar'></span> "
					+ "<span class='icon-bar'></span> <span class='icon-bar'></span> "
					+ "</button> <a class='navbar-brand' href='#'>"+ConfigReader.getCompanyName()+"</a> </div> "
					+ "<!-- Collect the nav links, forms, and other content for toggling -->"
					+ " <div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>"
					+ " <ul class='nav navbar-nav'> "
					+ "<li class='active'><a href='#'>Home <span class='sr-only'>(current)</span>"
					+ "</a></li> ";
					String links = "";
					if(userDTO!=null && userDTO.getRoleDTO()!=null && userDTO.getRoleDTO().getRightList()!=null && userDTO.getRoleDTO().getRightList().size()>0){
					for(RightDTO rightDTO: userDTO.getRoleDTO().getRightList()){
						links +=  "<li><a href='"+rightDTO.getUrl()+"'>"+rightDTO.getName()+"</a></li>   ";
					}
					}
					String navEndSection =  " </ul> </li> </ul> </div>"
					+ "<!-- /.navbar-collapse --> </div><!-- /.container-fluid --> </nav>";
					navBarDesign = navBarDesign + links + navEndSection;
			response.setContentType("text/html");
			out.println("<html><head>");
//			out.println(" <meta http-equiv='X-UA-Compatible' content='IE=edge'> "
//					+" <meta name='viewport' content='width=device-width, initial-scale=1'> "
//					+" <link rel='stylesheet' href='css/bootstrap.min.css' /> "
//					+" <link rel='stylesheet' href='css/roboto.css' /> "
//					+" <link rel='stylesheet' href='css/custom.css' />");
//			out.println("<script   src='https://code.jquery.com/jquery-2.2.4.min.js'   integrity='sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44='   crossorigin='anonymous'></script>");
//			out.println("<script src='js/bootstrap.min.js'></script>");
//			out.println("</head>");
			out.println("<body bgcolor='"+color+"'>");
			out.println("<h1>HELLO</h1>");
			out.println("</body>");
			out.println("<div class='container'>");
		RequestDispatcher rd = request.getRequestDispatcher("headers");
			rd.include(request, response);
			out.println(navBarDesign);
			String driverValue = this.getServletConfig().getInitParameter("drivername");
			String email = this.getServletConfig().getServletContext().getInitParameter("email");
			out.println("Welcome "+userDTO.getUserName()+" Driver Name "+driverValue +" EMail is "+email
			+" ROLE "+userDTO.getRoleDTO().getName()+"<br> Logged In User "+SessionCountListener.getCount());
			String urlWithSession = response.encodeURL("logout.ims");
			out.println("<form action='"+urlWithSession+"' method='post'><button class='btn btn-danger' type='submit'>Logout</button>");
			out.println("<br><br><br><br><br><br><br><br><br><br><br><br>");
			 rd = request.getRequestDispatcher("footer");
			rd.include(request,response);
			out.println("</body>");
			out.println("</html>");
			//RequestDispatcher rd = request.getRequestDispatcher("headers");
			//rd.include(request, response);
		//}
		//String userName = request.getParameter("uname");
		//String roleName = request.getParameter("role");
		//out.println("Welcome User "+userName+" Role "+roleName);
		
		//System.out.println("GET CALL "+counter);
		//counter++;
		out.close();
	}

}
