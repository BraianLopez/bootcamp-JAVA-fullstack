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
<title>Idea</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet"
	href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container mx-auto justify-content-between">
		<h1>
		<br>
			<c:out value="${unaIdea.idea }"></c:out>
		</h1>
		<h3>Creado por: <c:out value="${unaIdea.creador.nombre}"></c:out> </h3>
		<h3>Personas que dieron like:  </h3>
		<div class="col-4	">
		<table class="table table-hover table-bordered rounded border-dark">
			<thead class="bg-success">
				<tr>
					<th>Nombre</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${unaIdea.likes }" var="likes">
			
			<tr>
						<td><c:out value="${likes.nombre} "></c:out></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
			<c:choose>
			<c:when test="${unaIdea.creador.id == usuario.id}">
				<div class="row mt-4">

						<a href="/ideas/${unaIdea.id}/edit">Edit Idea</a>
				</div>
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>


	</div>
</body>
</html>