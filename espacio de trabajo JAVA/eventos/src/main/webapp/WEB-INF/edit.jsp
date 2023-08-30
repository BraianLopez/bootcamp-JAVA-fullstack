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
<title>Editar evento</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet"
	href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container mx-auto col-4 ">
		<h1>
			<c:out value="${evento.nombre }"></c:out>
		</h1>
		<h3>Editar evento</h3>
		<form:form action="/events/${evento.id}/edit" method="POST"
			modelAttribute="evento">
			<input type="hidden" name="_method" value="put" />
			<form:input type="hidden" path="organizador" value="${usuario.id }" />
			<div class="form-group">
				<form:label class="form-label" path="nombre"
					value="${evento.nombre }">Nombre: </form:label>
				<form:input class="form-control" path="nombre" />
				<form:errors class="text-danger" path="nombre" />
			</div>

			<div class="form-group">
				<form:label class="form-label" path="ubicacion">Ubicacion: </form:label>
				<form:input class="form-control" path="ubicacion" />
				<form:errors class="text-danger" path="ubicacion" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="fecha">Fecha: </form:label>
				<form:input type="date" class="form-control" path="fecha" />
				<form:errors class="text-danger" path="fecha" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="provincia">Provincia: </form:label>
				<form:select path="provincia" type="text" class="form-select">
					<c:forEach items="${provincias }" var="provincia">
						<form:option value="${provincia }"></form:option>
					</c:forEach>
				</form:select>
			</div>
			<button class="btn btn-success mt-4">Editar Evento</button>
		</form:form>
	</div>
</body>
</html>