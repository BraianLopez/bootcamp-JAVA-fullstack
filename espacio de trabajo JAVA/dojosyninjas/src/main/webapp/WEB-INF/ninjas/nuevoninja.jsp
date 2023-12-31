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
<title>Nuevo Ninja</title>
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
		<h2>Nuevo Ninja</h2>
		<form:form action="/ninja/new" method="POST" modelAttribute="ninja">
			<div class="form-group">
				<form:label class="form-label" path="dojo">Dojo: </form:label>
				<form:select class="form-select" path="dojo">
					<c:forEach items="${dojos }" var="dojo">
						<form:option value="${dojo.id }">${dojo.name }</form:option>
					</c:forEach>

				</form:select>

			</div>
			<div class="form-group">
				<form:label class="form-label" path="firstName">Nombre </form:label>
				<form:errors class="text-danger" path="firstName" />
				<form:input class="form-control" path="firstName" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="lastName">Apellido</form:label>
				<form:errors class="text-danger" path="lastName" />
				<form:input class="form-control" path="lastName" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="age">Edad</form:label>
				<form:errors class="text-danger" path="age" />
				<form:input class="form-control" path="age" />
			</div>

			<button class="btn btn-info px-4" type="submit">Crear</button>
		</form:form>
			<a class="btn btn-info my-2  px-4" href="/">Inicio</a>
	</div>
</body>
</html>