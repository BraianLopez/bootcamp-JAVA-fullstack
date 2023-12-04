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
<h1>Create a new course</h1>
	<form:form action="/courses/new" method="POST" modelAttribute="curso">

<%-- 				<form:input type="hidden" path="creador" value="${usuario.id}" /> --%>
				
				<div class="form-group">
				<form:label class="form-label" path="curso">name:  </form:label>
				<form:errors class="text-danger" path="curso" />
				<form:input  class="form-control" path="curso" />
			</div>
				<div class="form-group">
				<form:label class="form-label" path="instructor">instructor:  </form:label>
				<form:errors class="text-danger" path="instructor" />
				<form:input type="text" class="form-control" path="instructor" />
			</div>
				<div class="form-group">
				<form:label class="form-label" path="capacidad">Capacity:  </form:label>
				<form:errors class="text-danger" path="capacidad" />
				<form:input type="number" class="form-control" path="capacidad" />
			</div>
				<input class="mt-3" type="submit" value="Create" />
			</form:form>
		</div>

</body>
</html>