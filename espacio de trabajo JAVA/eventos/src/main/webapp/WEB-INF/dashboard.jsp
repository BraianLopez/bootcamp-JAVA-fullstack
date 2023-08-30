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
<title>Dashboard</title>
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
		<div class="text-end">
			<a href="/logout"> Cerrar sesion</a>
		</div>
		<hr>
		<h3>Eventos dentro de tu provincia:</h3>
		<hr>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Evento</th>
					<th>Fecha</th>
					<th>Locacion</th>
					<th>Provincia</th>
					<th>Creador</th>
					<th>Accion/Estado</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${eventosProvinciaUser }" var="eventoEnProv">

					<tr>
						<td><c:out value="${eventoEnProv.nombre}"></c:out></td>
						<td><fmt:formatDate value="${eventoEnProv.fecha}"
								pattern="MMMM dd, yyy" var="fechaFormateada" /> <c:out
								value="${fechaFormateada }"></c:out></td>
						<td><c:out value="${eventoEnProv.ubicacion}"></c:out></td>
						<td><c:out value="${eventoEnProv.provincia}"></c:out></td>
						<td><c:out value="${eventoEnProv.organizador.nombre}"></c:out>
						</td>
						<td><c:choose>
								<c:when test="${eventoEnProv.organizador.id == usuario.id }">
									<a href="/events/${eventoEnProv.id }/edit">Editar</a> |
									
					<form:form action="/events/${eventoEnProv.id}/delete" method="post">
										<input type="hidden" name="_method" value="delete" />
										<button>eliminar</button>
									</form:form>

								</c:when> 		
								<c:otherwise>
								<c:choose>
									<c:when test="${eventoEnProv.asistentes.contains(usuario)}">
										<a href="/events/${eventoEnProv.id }/${usuario.id }/cancelar">Cancelar
										</a> |
								</c:when>
									<c:otherwise>
										<a href="/events/${eventoEnProv.id }/${usuario.id }/unirse">Unirse
										</a>
									</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<h3>Eventos en otras provincias:</h3>
		<hr>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Evento</th>
					<th>Fecha</th>
					<th>Locacion</th>
					<th>Provincia</th>
					<th>Creador</th>
					<th>Accion/Estado</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${eventosNoProvinciaUser }" var="eventoNoProv">

					<tr>
						<td><c:out value="${eventoNoProv.nombre}"></c:out></td>

						<fmt:formatDate value="${eventoNoProv.fecha}"
							pattern="MMMM dd, yyy" var="fechaFormateada" />
						<td><c:out value="${fechaFormateada }"></c:out></td>
						<td><c:out value="${eventoNoProv.ubicacion}"></c:out></td>
						<td><c:out value="${eventoNoProv.provincia}"></c:out></td>
						<td><c:out value="${eventoNoProv.organizador.nombre}"></c:out>
						</td>
						<td><c:choose>
								<c:when test="${eventoNoProv.organizador.id == usuario.id }">
									<a href="/events/${eventoNoProv.id }/edit">Editar</a> |
									<form:form action="/events/${eventoNoProv.id}/delete"
										method="post">
										<input type="hidden" name="_method" value="delete" />
										<button>eliminar</button>
									</form:form>
								</c:when>
								<c:otherwise>
								<c:choose>
									<c:when test="${eventoNoProv.asistentes.contains(usuario) }">
										<a href="/events/${eventoNoProv.id }/${usuario.id }/cancelar">Cancelar
										</a> 
								</c:when>
									<c:otherwise>
										<a href="/events/${eventoNoProv.id }/${usuario.id }/unirse">Unirse
										</a>
									</c:otherwise>
								</c:choose>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container mx-auto col-4 ">
			<h2>Crear evento</h2>

			<form:form action="/nuevo/evento" method="POST"
				modelAttribute="evento">
				<form:input type="hidden" path="organizador" value="${usuario.id }" />
				<div class="form-group">
					<form:label class="form-label" path="nombre">Nombre: </form:label>
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
				<button class="btn btn-success mt-4">Crear Evento</button>
			</form:form>
		</div>
	</div>
</body>
</html>