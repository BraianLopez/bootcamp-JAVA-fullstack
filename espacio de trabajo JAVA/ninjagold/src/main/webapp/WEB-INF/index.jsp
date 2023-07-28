<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!--esta linea solo se usa si tengo plantillas css -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container p-2">
		<h1>Ninja Gold</h1>
		<p>
			Your Gold: <span> </span>
		</p>

		<div class="row">
		<div class="card col mx-2">
			<form action="/gold" method="post">
				<h2>Farm</h2>
				<p>(earms 10-20 gold)</p>
				<input type="hidden" name="lugar" value="farm" />
				<button type="submit" class="btn btn-info">hola</button>
			</form>
		</div>
		<div class="card col mx-2">
			<form action="">
				<h2>Cave</h2>
				<p>(earms 5-10 gold)</p>
				<input type="hidden" name="lugar" value="farm" />
				<button type="submit" class="btn btn-info">hola</button>
			</form>
		</div>
		<div class="card col mx-2">
			<form action="">
				<h2>House</h2>
				<p>(earms 2-5 gold)</p>
				<input type="hidden" name="lugar" value="farm" />
				<button type="submit" class="btn btn-info">hola</button>
			</form>
		</div>
		<div class="card col mx-2">
			<form action="">
				<h2>Casino</h2>
				<p>(earms 0-50 gold)</p>
				<input type="hidden" name="lugar" value="farm" />
				<button type="submit" class="btn btn-info">hola</button>
			</form>
		</div>
	</div>
	</div>
</body>
</html>