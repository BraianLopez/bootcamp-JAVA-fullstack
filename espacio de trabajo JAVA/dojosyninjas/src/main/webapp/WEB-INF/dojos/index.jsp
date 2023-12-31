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
<title>DOJOS</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet"
	href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container">
		<h1>Bienvenido a Dojos y Ninjas</h1>


		<table class="table table-hover col-6">
			<thead>
				<tr>
					<th>Dojos Creados</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojos }" var="dojo">
				<tr>
					<td><a href="/dojo/${dojo.id }"><c:out
								value="${dojo.name }"></c:out></a></td>
				</tr>
				</c:forEach>

			</tbody>
		</table>

		<a class="btn btn-info my-4" href="/dojo/new">Registra un nuevo Dojo</a> 
			<a class="btn btn-info my-4" href="/ninja/new">Registra un nuevo Ninja</a>


	</div>
</body>
</html>