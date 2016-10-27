<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="bmpl" tagdir="/WEB-INF/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search JSP</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet"/> 
<bmpl:head/>
</head>
<body>

<div class="container">
DOB<bmpl:calendar txtName="dob" noofmonth="1"/>
<br>
<bmpl:calendar txtName="doj" noofmonth="3"/>
<bmpl:date language="hi" country="IN" />
<div class="row">
<div class="col-sm-12 col-md-12 col-lg-12">
<h1>Search Form</h1>
<form action="Controller" method="get" class="form-horizontal">
  <div class="form-group">
    <label for="searcg" class="col-sm-2 control-label">Search</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="search" name="search" placeholder="Type Price to Search ">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>Search</button>
    </div>
  </div>
  
  </form>
</div>
</div>
<c:if test="${itemlist.size() eq 0 }">
<div class="row">
<div class="col-sm-12 col-md-12 col-lg-12">
<div class="alert alert-danger" role="alert"><h1>No Record Found...</h1></div>
</div>
</div>
</c:if>
<c:if test="${itemlist.size() gt 0}">
<div class="row">
<div class="col-sm-12 col-md-12 col-lg-12">
<table class="table table-bordered table-striped table-responsive">
<tr><th>Id</th><th>Name</th><th>Desc</th><th>Price</th><th>Image</th></tr>
<c:forEach var="itemobj" items="${itemlist}">

<tr>
<td>${itemobj.id}</td><td>${itemobj.name}</td><td>${itemobj.desc}</td>
<td><bmpl:currency amount="${itemobj.price}" language="hi" country="IN"/></td>
<td><img src='${itemobj.imageURL}' class='img-responsive'></td> 
</tr>
</c:forEach>
</table>
</div>
</div>
</c:if>
</div>
</body>
</html>