<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formateo fechas (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formulario form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<br>
<br>
<div class="container mx-auto col-6">
<h1>All Students</h1>
<table class="table  table-success" >
			<thead>
				<tr>
					<th class="bg-success">Name</th>
					<th class="bg-success">Age</th>
					<th class="bg-success">Address</th>
					<th class="bg-success">City</th>
					<th class="bg-success">State</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="student">
					<tr>
						<td >${student.firstName} ${student.lastName}</td>
						<td >${student.getAge()}</td>
						<td>${student.getContactInfo().getAddress()}</td>
						<td>${student.getContactInfo().getCity()}</td>
						<td>${student.getContactInfo().getState()}</td>
					</tr>
				</c:forEach>
			
			</tbody>
		</table>
		<a href="/students/new" class="btn btn-success mt-4" role="button" data-bs-toggle="button">New Student</a>
		<a href="/contact/new" class="btn btn-success mt-4" role="button" data-bs-toggle="button">Asign Contact Info</a>
		</div>
</body>
</html>