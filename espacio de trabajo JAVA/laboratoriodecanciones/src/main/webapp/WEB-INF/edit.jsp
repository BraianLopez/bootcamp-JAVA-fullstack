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
<title>Editar cancion</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class=" container mt-5 col-6">
	<h2>Agregar a <c:out value="${cancion.titulo }"></c:out></h2>
		<form:form action="/songs/${cancion.id}/edit" method="POST"
			modelAttribute="songEdit">
				<input type="hidden" name="_method" value="put" />
			<form:input type="hidden" path="creador" value="${usuario.id}" />

			<div class="form-group">
				<form:label class="form-label" path="titulo">Titulo:  </form:label>
				<form:errors class="text-danger" path="titulo" />
				<form:input type="text" class="form-control" path="titulo" value="${cancion.titulo}" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="genero">Genero:  </form:label>
				<form:errors class="text-danger" path="genero" />
				<form:input type="text" class="form-control" path="genero" value="${cancion.genero}" />
			</div>
			<div class="form-group">
				<form:label class="form-label" path="letra">Letra:  </form:label>
				<form:errors class="text-danger" path="letra" />
				<form:input type="text-area" class="form-control" path="letra" value="${cancion.letra}" />
			</div>
			<input class="mt-3" type="submit" value="Editar"/>
		</form:form>		
			<a href="/songs/${cancion.id }/delete">Eliminar</a>
		<a href="/home" class="m-3">cancelar</a>
	</div>
</body>
</html>