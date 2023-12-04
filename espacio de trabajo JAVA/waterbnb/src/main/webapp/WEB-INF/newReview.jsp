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
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="container">
		<div class="text-end">
			<a href="/"> Home</a> | <a href="/logout"> Logout</a>
		</div>

		<div class="col">
			<h1>
				Review of
				<c:out value="${pool.direccion }"></c:out>
			</h1>

			<form:form method="POST" action="/pools/${pool.id}/review"
				modelAttribute="newcomment">
				<form:input type="hidden" path="autor" value="${usuario.id}" />
				<form:input type="hidden" path="piscina" value="${pool.id}" />
				<div >
					<form:label path="comentario">Leave a comment:</form:label>
					<div class="col-10">
						<form:textarea type="text" path="comentario" class="form-control mb-3" />
					</div>
					<form:errors class="text-danger form-control" path="comentario" />
				</div>
				<div class="form-group row mb-3">
					<form:label path="rating" class="col-2 col-form-label">Rating</form:label>
					<div class="col-2">
						<form:select path="rating" class="form-select">
							<form:option value="0"> Select</form:option>
							<form:option value="1"> 1</form:option>
							<form:option value="2"> 2</form:option>
							<form:option value="3"> 3</form:option>
							<form:option value="4"> 4</form:option>
							<form:option value="5"> 5</form:option>
						</form:select>
						<form:errors class="text-danger form-control" path="rating" />

					</div>
				</div>

				<input type="submit" value="Submit Review" />
			</form:form>
		</div>



	</div>

</body>
</html>