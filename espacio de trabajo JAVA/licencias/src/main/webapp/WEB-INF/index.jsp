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
<title>Licencias</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="container">
		<h1>Bienvenido a la DB de licencias de conducir</h1>
		<a class="btn btn-success my-4" href="/persons/new">Registra un usuario</a>
		<a class="btn btn-success my-4"href="/licenses/new">Agrega una licencia</a>
		
		<table class="table table-striped table-success "  class="rounded">
			<thead>
				<tr>
					<th class="bg-success">Nombre</th>
					<th class="bg-success">Num de Licencia</th>
					<th class="bg-success">Fecha de expiracion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${infoUsuario}" var="persona">
					<tr>
						<td > <a href="/persons/${persona.id}"> ${persona.firstName} ${persona.lastName}</a></td>
						<td >${persona.getLicencia().getNumberComoString()}</td>
						<td>${persona.getLicencia().getExpirationDateFormat()}</td>
					</tr>
				</c:forEach>
			
			</tbody>
		</table>
	</div>
</body>
</html>