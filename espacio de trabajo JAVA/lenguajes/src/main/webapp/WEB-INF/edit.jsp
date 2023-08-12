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
<title>Editar Lenguaje</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<a href="/languages" class="btn btn-success m-3">Dashboard</a>
<div class="container p-3 mb-2 bg-light text-center">
<h1 class="m-3 p-3">Editar Lenguaje</h1>
<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put">
    <div>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input class="form-control" path="name"/>
    </div>
    <div>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea class="form-control" path="creator"/>
    </div>
    <div>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input class="form-control" path="version"/>
    </div>    
    <input type="submit" value="Submit" class="btn btn-primary m-3"/>
</form:form>
</div>

</body>
</html>