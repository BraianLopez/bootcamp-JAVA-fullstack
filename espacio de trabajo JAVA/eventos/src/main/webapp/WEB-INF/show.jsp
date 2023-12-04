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
<title>Evento</title>
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
		<h1>
			<c:out value="${evento.nombre }"></c:out>
		</h1>
		<h3>Creado por: <c:out value="${evento.organizador.nombre}"></c:out> </h3>
		<fmt:formatDate value="${evento.fecha}"
							pattern="MMMM dd, yyy" var="fechaFormateada" />
		<h3>Fecha: <c:out value="${fechaFormateada}"></c:out> </h3>
		<h3>Ubicacion: <c:out value="${evento.ubicacion}  ${evento.provincia}"></c:out> </h3>
		<h3>Personas que asistirán:  </h3>
		
		<table class="table table-hover ">
			<thead>
				<tr>
					<th>Invitado</th>
					<th>Ciudad</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${evento.asistentes }" var="asistente">
			
			<tr>
						<td><c:out value="${asistente.nombre} ${asistente.apellido}"></c:out></td>
						<td><c:out value="${asistente.ubicacion}"></c:out></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
	</div>
</body>
</html>