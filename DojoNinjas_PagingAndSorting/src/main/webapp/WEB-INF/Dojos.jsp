<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container col-6 mb-4 p-4">

		<div class="d-flex justify-content-between mb-4">
			<h1 class="mb-3">All Dojos :</h1>
			<div>
				<a href="/ninjas/new" class="btn btn-success">Create Ninja</a>
				<a href="/dojos/new" class="btn btn-dark">Create Dojo</a> 
			</div>
			
		</div>
		
		<div class="card bg-info p-4">
			<c:forEach var="dojo" items="${dojos}">
				<a href="/dojo/${dojo.id}"><c:out value="${dojo.name}" /></a>
			</c:forEach>
		</div>
		<h2 class="mt-4">All Dojos and Ninjas that related  :</h2>
		<table class="table table-border text-center mt-3">
			<tr class="bg-secondary text-light ">
				<th>Dojo ID</th>
				<th>Dojo Name</th>
				<th>Ninja fullName </th>
				<th>Ninja age</th>
			</tr>
				<c:forEach var="row" items="${tableDojosNinjas}">
					<tr>
						<th class="bg-dark text-light">${row[0].id}</th>
						<th class="bg-dark text-light">${row[0].name}</th>
						<th class="bg-warning text-dark">${row[1].firstName}</th>
						<th class="bg-warning text-dark">${row[1].lastName}</th>
					</tr>
				</c:forEach>
			<tr>
			
			</tr>
		</table>
		<div class="d-flex justify-content-end mb-4">
		<a href="/pages" >All Ninjas </a>
	</div>
	</div>
</body>
</html>