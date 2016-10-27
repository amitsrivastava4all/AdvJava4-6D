<%@tag import="java.util.Locale"%>
<%@tag import="java.text.DateFormat"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag import="java.util.Date" %>
<%@ attribute name="language" required="true" %>
<%@ attribute name="country" required="true" %>
<%
Locale locale = new Locale(language,country);
Date date = new Date();
DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locale);
String formattedDate = df.format(date);
%>
<strong style="color:red"><%=formattedDate %></strong>
