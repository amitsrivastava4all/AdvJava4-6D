<!-- this is page directive -->
<!--  directive give direction to the page
directive start with <%-- <%@ --%> this is jsp comment
1. directives are of 3 types
a) page directive - give direction to the page
b) include directive
c) taglib directive
 -->
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <%-- <% %> --%> this is called scriptlet
1. <%-- <%! %> --%>declerative scriptlet - to define member of a class
2. <%-- <% %> --%>scriptlet - to define the code and this code will go inside the servlet
3. <%-- <%= %> --%> expression - for output 
 -->
<%! int counter ; // become a  instance variable %>
<%
Date date = new Date();
DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		String formattedDate = df.format(date);

// this code will go inside the service method of a servlet
counter++;
%>
Formatted Date is <%=formattedDate %>
Current Date is <%=date %>
<h1>Counter is <%=counter %></h1>
</body>
</html>