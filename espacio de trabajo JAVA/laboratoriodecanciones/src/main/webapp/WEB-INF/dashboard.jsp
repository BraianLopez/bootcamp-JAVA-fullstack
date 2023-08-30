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
<title>Project Manager Dashboard</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet"
	href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<div class="container mx-auto">

		<div class="row ">
			<div class="col">
				<h3>
					Hola
					<c:out value="${usuario.nombre }"></c:out>
				</h3>
			</div>
			<div class="col">
				<a class="flex" href="/logout"> Cerrar sesion</a>
			</div>
		</div>
		<h1>Todas las canciones</h1>

		<table class="table col-6">
			<thead>
				<tr>
					<th>Cancion</th>
					<th>Total Colaboraciones</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${canciones }" var="cancion">

					<tr>
						<td>
							<div class="column">
								<a href="/songs/${cancion.id}"> <c:out value="${cancion.titulo}"></c:out>
								</a>
								<p>
									Genero: </a>
									<c:out value="${cancion.genero }"></c:out>
								</p>

							</div>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

		<a href="/songs/new">Crear una cancion</a>
	</div>
</body>
</html>