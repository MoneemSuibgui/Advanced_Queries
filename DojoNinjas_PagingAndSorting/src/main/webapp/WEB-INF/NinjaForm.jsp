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
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container col-6 p-5">
		<div class="card p-4 bg-secondary text-light">
			<div class="d-flex justify-content-between mb-4">
			<h1 class="mb-3">New Ninja :</h1>
			<div>
				<a href="/dojos/new" class="btn btn-dark">Create Dojo</a> 
				<a href="/dojos" class="btn btn-warning">Dashoboard</a>
			</div>
			
		</div>
			<form:form action="/create/ninja" method="post"
				modelAttribute="ninja">

				<form:label path="dojo" class="mb-2">Dojo : </form:label>

				<form:select path="dojo" class="mx-2 px-2">
					<c:forEach var="dojo" items="${dojos}">
						<form:option value="${dojo.id}">
							<c:out value="${dojo.name}" />
						</form:option>
					</c:forEach>
				</form:select>

				<p>
					<form:errors path="firstName" class="text-danger" />
				</p>
				<form:label path="firstName" class="mb-2">First Name :</form:label>
				<form:input path="firstName" class="form-control mb-3" />

				<p>
					<form:errors path="lastName" class="text-danger" />
				</p>
				<form:label path="lastName" class="mb-2">Last Name :</form:label>
				<form:input path="lastName" class="form-control mb-3" />

				<p>
					<form:errors path="age" class="text-danger" />
				</p>
				<form:label path="age" class="mb-2">Age :</form:label>
				<form:input path="age" class="form-control mb-3" type="number" />

				<input type="submit" value="Create" class="btn btn-primary" />
			</form:form>
		</div>

	</div>
</body>
</html>