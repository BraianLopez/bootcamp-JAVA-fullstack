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
<title>AQUI EL TITULO DE TU PLNATILLA</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="container mx-auto col-6">
		<h1>Contact info</h1>
		<form:form action="/contact/new" method="POST"
			modelAttribute="contactinfo">
			<div class="form-group">
			<form:label class="form-label" path="student">Student: </form:label>
				<form:select class="form-select" path="student">
					<c:forEach items="${estudiantes }" var="e">
						<form:option value="${e.id }">${e.firstName } ${e.lastName }</form:option>
					</c:forEach>

				</form:select>

			</div>
			<div class="form-group">
				<form:label class="form-label" path="address">Address: </form:label>
				<form:errors class="text-danger" path="address" />
				<form:input  class="form-control" path="address" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="city">City:</form:label>
				<form:errors class="text-danger" path="city" />
				<form:input class="form-control" path="city" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="state">State: </form:label>
				<form:errors class="text-danger" path="state" />
				<form:input  class="form-control" path="state" />
			</div>
			<button class="btn btn-success mt-4">Add contact info</button>
		</form:form>
		<a href="/" class="btn btn-success mt-4" role="button" data-bs-toggle="button">Go back</a>
	</div>
</body>
</html>