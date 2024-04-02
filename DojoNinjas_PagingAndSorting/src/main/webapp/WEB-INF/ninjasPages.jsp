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
	   <c:forEach begin="1" var="index" end="${totalpages}">
			<a href="/pages/${index}">${index}</a>
	   </c:forEach>
   </div>

	<table class="table table-border table-hover">
		<tr>
			<th>Dojo Name</th>
			<th>Ninja First Name</th>
			<th>Ninja Last Name</th>
		</tr>
		<!--  // we have to call the .content method to actually get the ninjas inside the Page iterable-->
		<c:forEach var="ninja" items="${ninjas.content}">
			<tr>
				<th><c:out value="${ninja.dojo.name}"/></th>
				<th><c:out value="${ninja.firstName}"/></th>
				<th><c:out value="${ninja.lastName}"/></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>