<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet"/> 
</head>
<body>
<%
// request, response, out , session, config, application , page (this), pageContext
// these all above objects are implicit objects
String userid = request.getParameter("userid");
String password = request.getParameter("pwd");
if(userid!=null && password!=null){
if(userid.trim().length()>0 && password.trim().length()>0){
	if(userid.equals(password)){
	response.sendRedirect("index.jsp");
}
else{
%>
<h2 class="well" style="color:red;">Invalid Userid or Password</h2>
<%
}
}
}
%>
<div class="container">
<h1>Login Form</h1>
<form action="login.jsp" method="post" class="form-horizontal">
  <div class="form-group">
    <label for="userid" class="col-sm-2 control-label">Userid</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="userid" name="userid" placeholder="Userid">
    </div>
  </div>
  <div class="form-group">
    <label for="pwd" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password">
    </div>
  </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Sign in</button>
    </div>
  </div>
</form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>