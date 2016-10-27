<%@tag import="java.text.NumberFormat"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@tag import="java.util.Locale"%>
<%@ attribute name="language" required="true" %>
<%@ attribute name="country" required="true" %>
<%@ attribute name="amount" type="java.lang.Double" required="true" %>
<%
Locale locale = new Locale(language,country);
NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
String formattedAmount = nf.format(amount);
%>
<%=formattedAmount %>
