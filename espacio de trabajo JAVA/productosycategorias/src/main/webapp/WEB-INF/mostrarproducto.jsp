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
<title></title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container mx-auto col-6">
		<h1>${producto.name }</h1>
		<p>${producto.description }</p>
		<div class="row">
		<div class="col-6">
			<table class="table table-success">
				<thead>
					<tr>
						<th>
							<h3>Categorias</h3>
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${producto.getCategories() }" var="categoria">
				<tr>
				<td> <a href="/categories/${categoria.id}"> <c:out value="${categoria.name }"></c:out></a></td> 
				</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
			<div class="col-6">
			<form:form action="/aso/${producto.id}" method="POST"
				modelAttribute="asociacion">
				<div class="form-group">
					<form:label class="form-label" path="product"> <h3> Asignar Categoria:</h3> </form:label>
<!-- 					REVISAR SI EL PATH DEL FORM:LABEL DEBE SER PRODUCT O CATEGORY O SI ES INDISTINTO-->
					<form:input type="hidden" path="product" value="${producto.id }" />
					<form:select class="form-select" path="category">
						<c:forEach items="${categorias }" var="cat">
							<form:option value="${cat.id }">${cat.name }</form:option>
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