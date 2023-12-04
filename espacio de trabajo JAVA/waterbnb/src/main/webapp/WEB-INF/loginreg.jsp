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
	<div class="row mx-auto">


		<div class="container mx-auto col-4 ">
			<h2>Registrarse</h2>
			<div>
				<form:errors class="text-danger" path="user.*" />
			</div>
			<form:form action="/registration" method="POST" modelAttribute="user">
				<div class="form-group">
					<form:label class="form-label" path="nombre">Nombre: </form:label>
					<form:input class="form-control" path="nombre" />

				</div>
				<div class="form-group">
					<form:label class="form-label" path="apellido">Apellido: </form:label>
					<form:input class="form-control" path="apellido" />

				</div>
				<div class="form-group">
					<form:label class="form-label" path="email">Email: </form:label>
					<form:input class="form-control" path="email" />

				</div>

				<div class="form-group">
					<form:label class="form-label" path="password">Clave: </form:label>
					<form:password class="form-control" path="password" />
				</div>
				<div class="form-group">
					<form:label class="form-label" path="passwordConfirmation">Confirme su clave:</form:label>
					<form:password class="form-control" path="passwordConfirmation" />
				</div>

				<div class="form-group row mb-3 justify-content-end">
					<form:label path="rol">Rol:</form:label>
					<form:select path="rol" type="text" class="form-control">

						<form:option value="0"> Select</form:option>
						<form:option value="1"> Host</form:option>
						<form:option value="2">Guest</form:option>

					</form:select>


				</div>



				<button class="btn btn-outline-success mt-4">Registrarme</button>
			</form:form>
			<p class="text-success">
				<c:out value="${registro}"></c:out>
			</p>
		</div>
		<div class="container mx-auto col-4">
			<h2>Iniciar Sesion</h2>
			<div>
				<form:errors class="text-danger" path="login.*" />
			</div>
			<form:form action="/login" method="POST" modelAttribute="login">
				<div class="form-group">
					<form:label class="form-label" path="email">Email: </form:label>
					<form:input class="form-control" path="email" />

				</div>
				<div class="form-group">
					<form:label class="form-label" path="password">Clave: </form:label>
					<form:password class="form-control" path="password" />
				</div>
				<button class="btn btn-outline-success mt-4">Iniciar Sesion</button>
			</form:form>
		</div>
	</div>
</body>
</html>