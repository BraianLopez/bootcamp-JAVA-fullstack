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
<title>Lenguajes</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet"
	href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<br>
	<br>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lang" items="${languages}">
					<tr>
						<td><a href="/languages/${lang.id}"><c:out
									value="${lang.name}"></c:out></a></td>
						<td><c:out value="${lang.creator}"></c:out></td>
						<td><c:out value="${lang.version}"></c:out></td>
						<td class="align-middle">
							<a href="/languages/${lang.id}/edit" class="d-inline">Editar</a>
							<form action="/languages/${lang.id}" method="post" class="d-inline">
								<input type="hidden" name="_method" value="delete"/>
								<input type="submit" class="btn btn-link mb-1" value="Borrar lenguaje"/>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> 
		<br>
		<form:form action="/languages" method="post" modelAttribute="language">
    <div class= "mb-3">
        <form:label path="name">Name</form:label>
        <form:errors path="name" message ="Por favor llena este campo"/>
        <form:input class="form-control" path="name"/>
    </div>
    <div class= "mb-3">
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea class="form-control"  path="creator"/>
    </div>
    <div class= "mb-3">
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input class="form-control"  path="version"/>
    </div>

    <input class="btn btn-success m-3" type="submit" value="Submit"/>
</form:form>
	</div>
</body>
</html>