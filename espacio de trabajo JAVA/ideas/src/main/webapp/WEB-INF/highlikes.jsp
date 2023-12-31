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
<title>Ideas</title>
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
			<div class="row">
			<h3>Ideas:</h3>
			<div class="text-end">
				<a href="/ideas/low">Low Likes</a> <a href="/ideas/high">High
					Likes</a>
			</div>
		</div>

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
				<c:forEach items="${likesHigh }" var="ideas">
					<tr>
						<td><a href="/ideas/${ideas.id}"> <c:out
									value="${ideas.idea }"></c:out></a></td>


						<td><c:out value="${ideas.creador.nombre }"></c:out></td>
						<td><c:out value="${ideas.likes.size() }"></c:out></td>
						<td><c:choose>
								<c:when test="${ideas.likes.contains(usuario)}">
									<a href="/ideas/${ideas.id }/${usuario.id }/dislike">dislike
									</a>
								</c:when>
								<c:otherwise>
									<a href="/ideas/${ideas.id }/${usuario.id }/like">like </a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="/nuevo/idea">crear idea</a>
	</div>
</body>
</html>