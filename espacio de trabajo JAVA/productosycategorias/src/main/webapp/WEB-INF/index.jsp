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
<title>Productos y categorias</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet"
	href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<h1 class="mx-auto col-9">Bienvenido a la base de datos de
		productos y categorias</h1>
	<div class="container mx-auto col-6">
		<a href="/products/new">Agregar producto</a> <a href="/categories/new">Agregar
			Categoria</a>
	</div>
	<div class="container mx-auto col-6">
		<table class="table table-success">
			<thead>
				<tr>
					<th>
						<h3>Todos Nuestros Productos</h3>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productos }" var="producto">
					<tr>
						<td><a href="/product/${producto.id}"><c:out
									value="${producto.name }"></c:out></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>