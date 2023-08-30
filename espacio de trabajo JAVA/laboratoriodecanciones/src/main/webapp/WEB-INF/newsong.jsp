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
<title>Create a course</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

<body>


<div class=" container col-6">
<h1>Crea una nueva cancion</h1>
	<form:form action="/songs/new" method="POST" modelAttribute="song">

				<form:input type="hidden" path="creador" value="${usuario.id}" />
				
				<div class="form-group">
				<form:label class="form-label" path="titulo">titulo:  </form:label>
				<form:errors class="text-danger" path="titulo" />
				<form:input type="text" class="form-control" path="titulo" />
			</div>
				<div class="form-group">
				<form:label class="form-label" path="genero">genero:  </form:label>
				<form:errors class="text-danger" path="genero" />
				<form:input type="text" class="form-control" path="genero" />
			</div>
				<div class="form-group">
				<form:label class="form-label" path="letra">letra:  </form:label>
				<form:errors class="text-danger" path="letra" />
				<form:input type="text" class="form-control" path="letra" />
			</div>
				<input class="mt-3" type="submit" value="Crear cancion" />
			</form:form>
			<a href="/home" class="m-3">Atras</a>
		</div>

</body>
</html>