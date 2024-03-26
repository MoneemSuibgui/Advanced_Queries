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
<title>Advanced Queries</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="d-flex justify-content-center">
		<span id="top">
			 <a href="#q1">Query 1</a>
			 <a href="#q2">Query 2</a>
			 <a href="#q3">Query 3</a>
			 <a href="#q4">Query 4</a> 
			 <a href="#q5">Query 5</a>
			 <a href="#q6">Query 6</a> 
			 <a href="#q7">Query 7</a>
			 <a href="#q8">Query 8</a>
		</span>
	</div>
	<div class="container mt-5">
		<h1 id="q1" class="mt-5 mb-3">Query 1 :</h1>
		<a href="#top">Back to top</a>
		<table class="table table-border table-hover text-center mt-4">
			<tr class="bg-success text-light">
				<th>COUNTRY</th>
				<th>LANGUAGE</th>
				<th>PERCENTAGE</th>
			</tr>
			<c:forEach var="column" items="${countriesSpeaksSlovene}">
				<tr>
					<th><c:out value="${column[0]}" /></th>
					<th><c:out value="${column[1]}" /></th>
					<th><c:out value="${column[2]}" />%</th>
				</tr>
			</c:forEach>
		</table>
		getEachCountyAndNbrOfCities

		<h1 id="q2" class="mt-5 mb-3">Query 2 :</h1>
		<a href="#top">Back to top</a>
		<table class="table table-border table-hover text-center mt-4">
			<tr class="bg-success text-light">
				<th>COUNTRY</th>
				<th>CITIES</th>
			</tr>
			<c:forEach var="column" items="${getEachCountryAndNbrOfCities}">
				<tr>
					<th><c:out value="${column[0]}" /></th>
					<th><c:out value="${column[1]}" /></th>
				</tr>
			</c:forEach>
		</table>

		<h1 id="q3" class="mt-5 mb-3">Query 3 :</h1>
		<a href="#top">Back to top</a>

		<h1>Mexico Cities with population grater than 500000</h1>
		<table class="table table-border table-hover text-center mt-4">
			<tr class="bg-success text-light">
				<th>CITY</th>
				<th>POPULATION</th>
			</tr>
			<c:forEach var="column" items="${getMexicoCitiesAndPopulation}">
				<tr>
					<th><c:out value="${column[0]}" /></th>
					<th><c:out value="${column[1]}" /></th>
				</tr>
			</c:forEach>
		</table>

		<h1 id="q4" class="mt-5 mb-3">Query 4 :</h1>
		<a href="#top">Back to top</a>

		<h1>All languages and percentage for each country: Percentage
			grater than 89%(First language in the country)</h1>
		<table class="table table-border table-hover text-center mt-4">
			<tr class="bg-success text-light">
				<th>LANGUAGES</th>
				<th>PERCENTAGE</th>
			</tr>
			<c:forEach var="column"
				items="${getLanguageAndPercentageForEachCountry}">
				<tr>
					<th><c:out value="${column[0]}" /></th>
					<th><c:out value="${column[1]}" /></th>
				</tr>
			</c:forEach>
		</table>


		<h1 id="q5" class="mt-5 mb-3">Query 5 :</h1>
		<a href="#top">Back to top</a>

		<h1>All countries with Surface Area below 501 and Population
			greater than 100,000</h1>
		<table class="table table-border table-hover text-center mt-4">
			<tr class="bg-success text-light">
				<th>COUNTRY</th>
				<th>SRFACE_AREA</th>
				<th>POPULATION</th>
			</tr>
			<c:forEach var="column"
				items="${getCountriesWithPopulationAndSurfaceArea}">
				<tr>
					<th><c:out value="${column[0]}" /></th>
					<th><c:out value="${column[1]}" /></th>
					<th><c:out value="${column[2]}" /></th>
				</tr>
			</c:forEach>
		</table>

		<h1 id="q6" class="mt-5 mb-3">Query 6 :</h1>
		<a href="#top">Back to top</a>

		<h1>All countries with only Constitutional Monarchy with a
			surface area of more than 200 and a life expectancy greater than 75
			years</h1>
		<table class="table table-border table-hover text-center mt-4">
			<tr class="bg-success text-light">
				<th>COUNTRY</th>
				<th>SURFACE_AREA</th>
			</tr>
			<c:forEach var="column"
				items="${getCountriesWithConstitutionalMonarchy}">
				<tr>
					<th><c:out value="${column[0]}" /></th>
					<th><c:out value="${column[1]}" /></th>
				</tr>
			</c:forEach>
		</table>
		

		<h1 id="q7" class="mt-5 mb-3">Query 7 :</h1>
		<a href="#top">Back to top</a>

		<h1>All countries with only Constitutional Monarchy with a
			surface area of more than 200 and a life expectancy greater than 75
			years</h1>
		<table class="table table-border table-hover text-center mt-4">
			<tr class="bg-success text-light">
				<th>COUNTRY</th>
				<th>CITY</th>
				<th>POPULATION</th>
				<th>DISTRICT</th>
			</tr>
			<c:forEach var="column"
				items="${getCitiesOfArgentinaInsideBuenosAiresDistrict}">
				<tr>
					<th><c:out value="${column[0]}" /></th>
					<th><c:out value="${column[1]}" /></th>
					<th><c:out value="${column[2]}" /></th>
					<th><c:out value="${column[3]}" /></th>
				</tr>
			</c:forEach>
		</table>
		
		
		
		<h1 id="q8" class="mt-5 mb-3">Query 8 :</h1>
		<a href="#top">Back to top</a>

		<h1>Summarize the number of countries in each region</h1>
		<table class="table table-border table-hover text-center mt-4">
			<tr class="bg-success text-light">
				<th>REGION</th>
				<th>NUMBER OF COUNTRIES</th>
			</tr>
			<c:forEach var="column"
				items="${getNumberOfCountriesBelongsToEachRegion}">
				<tr>
					<th><c:out value="${column[0]}" /></th>
					<th><c:out value="${column[1]}" /></th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>