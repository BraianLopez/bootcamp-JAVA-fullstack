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
<title>APP</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<div class="container">

		<h1 class="text-center">
			Hola,
			<c:out value="${usuario.nombre }"></c:out>
		</h1>
		<div class="text-end">
			<a href="/logout">Cerrar sesion</a>
		</div>

		<hr>
		<h3>Ideas:</h3>
		<table class="table table-hover table-bordered rounded border-dark">
			<thead class="bg-success">
				<tr>
					<th>Idea</th>
					<th>creada por</th>
					<th>like</th>
					<th>accion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ideasUsuario }" var="idea">
					<tr>
						<td><a href=" /events/${idea.id}"> <c:out
									value="${idea.idea }"></c:out></a></td>

						
						<td><c:out value="${ideasUser.creadorador.nombre }"></c:out></td>


						<td><c:choose>
								<c:when test="${ideaUser.creadorador.id == usuario.id }">
									<a href="/events/${ideaUser.id}/edit"> Edit </a> |
									<form:form action="/events/${eventoUser.id}/delete"
										method="post">
										<input type="hidden" name="_method" value="delete" />
										<button class="btn btn-danger">Eliminar</button>
									</form:form>

								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${ eventoUser.asistentes.contains(usuario)}">
											<a href="/event/${eventoUser.id}/${usuario.id}/cancelar">
												Cancelar </a>
										</c:when>
										<c:otherwise>
											<a href="/event/${eventoUser.id}/${usuario.id}/unirse">
												Unirse </a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>

							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	<a href="/nuevo/idea">crear idea</a>
	
</body>
</html>