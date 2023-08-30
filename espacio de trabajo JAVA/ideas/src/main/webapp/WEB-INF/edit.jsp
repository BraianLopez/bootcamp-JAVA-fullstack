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
<title>Editar idea</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="col-6">
	<h2> <c:out value="${idea.idea }"></c:out></h2>
		<form:form action="/ideas/${idIdea}/edit" method="POST"
			modelAttribute="ideas">
			<input type="hidden" name="_method" value="put" />
			<form:input type="hidden" path="creador" value="${usuario.id}" />

			<div class="form-group">
				<form:label class="form-label" path="idea">Content:  </form:label>
				<form:errors class="text-danger" path="idea" />
				<form:input type="text" class="form-control" path="idea" value="${idea.idea}" />
			</div>
			<input type="submit" value="Editar" />
		</form:form>
		<a href="/songs/${idea.id }/delete">Eliminar</a>
		<a href="/ideas" class="m-3">cancelar</a>
	</div>
</body>
</html>