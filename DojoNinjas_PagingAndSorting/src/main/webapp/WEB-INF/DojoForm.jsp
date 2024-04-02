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
<title>New Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container col-6 p-5">
	<div class="mb-4">
		<a href="/pages" >Ninjas that belongs to dojos </a>
	</div>
		<div class="card  p-4 bg-info ">
			<div class="d-flex justify-content-between">
			<h1 class="mb-3">New Dojo :</h1>
			<div>
				<a href="/ninjas/new" class="btn btn-success">Create Ninja</a>
				<a href="/dojos" class="btn btn-warning">Dashoboard</a>
			</div>
			
		</div>
			<form:form action="/create/dojo" method="post" modelAttribute="dojo">
				<p>
					<form:errors path="name" class="text-danger" />
				</p>
				<form:label path="name" class="mb-2">Name :</form:label>
				<form:input path="name" class="form-control mb-3" />

				<input type="submit" value="Create" class="btn btn-primary" />
			</form:form>
		</div>

	</div>
</body>
</html>