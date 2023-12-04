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
<title>WaterBnB</title>
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
		<div class="row">
			<div class="col text-end">
				<c:choose>
					<c:when test="${usuario != null }">
						<a href="/"> Home</a>  | 
						<a href="/logout"> Logout</a>
					</c:when>
					<c:otherwise>
						<a href="/guest/signin"> Sign in / Sign up</a>

					</c:otherwise>
				</c:choose>
			</div>


		</div>

		<div class="row">
			<div class="col-3">
				<p>
					<c:out value="${pool.direccion }"></c:out>
				</p>
				<p>
					<c:out value="${pool.descripcion}"></c:out>
				</p>

			</div>
			<div class="col-3">

				<p>
					Email:
					<c:out value="${pool.organizador.email}"></c:out>
				</p>
				<p>
					Name:
					<c:out value="${pool.organizador.nombre}"></c:out>
				</p>
				<p>
					Pool size:
					<c:out value="${pool.poolsize}"></c:out>
				</p>
				<p>
					Cost:
					<c:out value="${pool.costo}"></c:out>
				</p>

			</div>
		</div>

		<div class="row justify-content-between">
			<div class="col-1">
				<p>
					Reviews
					<c:out value="${pool.rating }"></c:out>
				</p>

			</div>
			<div class="col-1">
				<a href="/pools/${pool.id }/review"> Leave a review <c:out
						value="${pool.rating }"></c:out>
				</a>

			</div>


		</div>

		<div class="row">
			<c:forEach items="${pool.comentarios }" var="comentario">
				<div class="col-4">
					<p>
						<c:out value="${comentario.autor.nombre}">
						</c:out>
						<c:out value="${comentario.autor.apellido }">
						</c:out>

					</p>
					<p>
						Rating:
						<c:out value="${comentario.rating }"></c:out>
					</p>
					<p>
						Comment:
						<c:out value="${comentario.comentario }"></c:out>
					</p>

				</div>
				<hr>

			</c:forEach>

		</div>



	</div>
</body>
</html>