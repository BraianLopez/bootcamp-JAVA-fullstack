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
<title>Persona Info</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet"
	href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container mx-auto col-6">


		<table class="table table-success">
			<thead>
				<tr>
					<th class="bg-success"><c:out
							value="${infoUsuario.firstName} ${infoUsuario.lastName}" /></th>
							<th class="bg-success"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Numero de licencia:</td>
					<td><c:out value="${infoUsuario.getLicencia().getNumber()}" /></td>
				</tr>
				<tr>
					<td>Estado:</td>
					<td><c:out value="${infoUsuario.getLicencia().getState()}" /></td>
				</tr>
			</tbody>
		</table>
		<!-- 		<p> -->
		<!-- 			Number License: -->
		<%-- 			<c:out value="${infoUsuario.getLicencia().getNumber()}" /> --%>
		<!-- 		</p> -->
		<!-- 		<p> -->
		<!-- 			Estado: -->
		<%-- 			<c:out value="${infoUsuario.getLicencia().getState()}" /> --%>
		<!-- 		</p> -->
		<!-- 		<p> -->
		<!-- 			Fecha de Vencimiento: -->
		<%-- 			<c:out value="${infoUsuario.getLicencia().getExpirationDateFormat()}" /> --%>
		<!-- 		</p> -->
		<a href="/" class="btn btn-success mt-4" role="button"
			data-bs-toggle="button">Volver al inicio</a>

	</div>
</body>
</html>