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
		<h1>
			Bienvenido
			<c:out value="${usuario.nombre }"></c:out>
		</h1>

		<div class="row justify-content-between">

			<div class="col-2">
				<p>Current Listings</p>
			</div>
			<div class="col-2">
				<a href="/logout">Logout</a> <a href="/">Search</a>
			</div>

		</div>
		<div class="row col-10">
			<table class="table table-hover border">
				<thead>
					<tr>
						<th>Adress</th>
						<th>Pool Size</th>
						<th>Cost per Night</th>
						<th>Details</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuario.piscinas }" var="p">
						<tr>
							<td><c:out value="${p.direccion }"></c:out></td>
							<td><c:out value="${p.poolsize }"></c:out></td>
							<td><c:out value="${p.costo }"></c:out></td>
							<td> <a href="#"> <c:out value="${p.rating }"></c:out> /5 - edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>




		<div class="row">
			<h2>New Listing</h2>
			<div class="col-6">
				<form:form action="/new/pool" method="POST" modelAttribute="newpool">
					<form:input type="hidden" path="organizador" value="${usuario.id }" />
					<div class="form-group">
						<form:label class="form-label" path="direccion">Adress: </form:label>
						<form:input class="form-control" path="direccion" />
						<form:errors class="text-danger" path="direccion" />
					</div>

					<div class="form-group">
						<form:label class="form-label" path="descripcion">Description: </form:label>
						<form:input class="form-control" path="descripcion" />
						<form:errors class="text-danger" path="descripcion" />
					</div>
					<div class="form-group">
						<form:label class="form-label" path="costo">Cost per Night: </form:label>
						<form:input type="number" class="form-control" path="costo" />
						<form:errors class="text-danger" path="costo" />
					</div>
					<div class="form-group">
						<form:label class="form-label" path="poolsize">Pool Size: </form:label>
						<form:select path="poolsize" type="text" class="form-select">
							<form:option value="small">Small</form:option>
							<form:option value="medium">Medium</form:option>
							<form:option value="large">Large</form:option>
						</form:select>
					</div>
					<button class="btn btn-outline-success mt-4">Add Listing!</button>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>