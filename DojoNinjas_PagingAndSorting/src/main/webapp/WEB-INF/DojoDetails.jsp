<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojo Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
   <div class="container  mb-4 p-4">
   <div class="d-flex justify-content-between mb-4">
			<h1 class="mb-3"><c:out value="${dojo.name}"/> Ninjas</h1>
			<div>
				<a href="/ninjas/new" class="btn btn-success">Create Ninja</a>
				<a href="/dojos/new" class="btn btn-dark">Create Dojo</a> 
				<a href="/dojos" class="btn btn-warning">Dashoboard</a>
			</div>
			
		</div>
   		
   		<table class="table table-bordered table-striped table-hover">
   			<tr>
   				<th>First Name </th>
   				<th>Last Name </th>
   				<th>Age</th>
   			</tr>
   			<c:forEach var="ninja" items="${dojo.ninjas}">
   				<tr>
   					<th><c:out value="${ninja.firstName}"/></th>
   					<th><c:out value="${ninja.lastName}" /></th>
   					<th><c:out value="${ninja.age }"/></th>
   				</tr>
   			</c:forEach>
   		</table>
   </div>
</body>
</html>