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
<title>Editar Libro</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<h1>Editar Libro</h1>
	<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put" >
		<div  class= "mb-3">
			<form:label path="title">Title</form:label>
			<form:errors class="text-danger" path="title" />
			<form:input class="form-control" path="title" />
		</div>
		<div class= "mb-3">
			<form:label path="description">Description</form:label>
			<form:errors class="text-danger" path="description" />
			<form:textarea class="form-control" path="description" />
		</div>
		<div class= "mb-3">
			<form:label path="language">Language</form:label>
			<form:errors class="text-danger" path="language" />
			<form:input class="form-control" path="language" />
		</div>
		<div class= "mb-3">
			<form:label path="numberOfPages">Pages</form:label>
			<form:errors class="text-danger" path="numberOfPages" />
			<form:input class="form-control" type="number" path="numberOfPages" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>