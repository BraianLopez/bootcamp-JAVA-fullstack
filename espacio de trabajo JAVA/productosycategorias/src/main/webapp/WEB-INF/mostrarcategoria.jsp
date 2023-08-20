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
<title>Categoria</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="container mx-auto col-6">
		<h1>${categoria.name }</h1>
		<div class="row">
		<div class="col-6">
			<table class="table table-success">
				<thead>
					<tr>
						<th>
							<h3>Productos</h3>
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${categoria.getProducts() }" var="producto">
				<tr>
				<td><a href="/product/${producto.id}"> <c:out value="${producto.name }"></c:out></a></td> 
				</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
			<div class="col-6">
			<form:form action="/aso/${categoria.id}" method="POST"
				modelAttribute="asociacion">
				<div class="form-group">
					<form:label class="form-label" path="category"> <h3> Asignar Producto:</h3> </form:label>
<!-- 					REVISAR SI EL PATH DEL FORM:LABEL DEBE SER PRODUCT O CATEGORY O SI ES INDISTINTO-->
					<form:input type="hidden" path="category" value="${producto.id }" />
					<form:select class="form-select" path="product">
						<c:forEach items="${productos }" var="prod">
							<form:option value="${prod.id }">${prod.name }</form:option>
						</c:forEach>

					</form:select>

				</div>
				<button class="btn btn-success mt-4">Asignar</button>
			</form:form>
			</div>
			<a href="/">Ir al inicio</a>
		</div>
	</div>
</body>
</html>