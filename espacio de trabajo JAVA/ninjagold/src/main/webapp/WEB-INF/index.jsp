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
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container p-2">
		<h1>Ninja Gold</h1>
		<h2>
			Your Gold: <span class="text-success"> <c:out value="${gold }"></c:out> </span>
		</h2>

		<div class="row">
			<div class="card col mx-2">
				<form action="/gold" method="post">
					<h2>Farm</h2>
					<p>(earms 10-20 gold)</p>
					<input type="hidden" name="lugar" value="farm" />
					<button type="submit" class="btn btn-info">Find gold!</button>
				</form>
			</div>
			<div class="card col mx-2">
				<form action="/gold" method="post">
					<h2>Cave</h2>
					<p>(earms 5-10 gold)</p>
					<input type="hidden" name="lugar" value="cave" />
					<button type="submit" class="btn btn-info">Find gold!</button>
				</form>
			</div>
			<div class="card col mx-2">
				<form action="/gold" method="post">
					<h2>House</h2>
					<p>(earms 2-5 gold)</p>
					<input type="hidden" name="lugar" value="house" />
					<button type="submit" class="btn btn-info">Find gold!</button>
				</form>
			</div>
			<div class="card col mx-2">
				<form action="/gold" method="post">
					<h2>Casino</h2>
					<p>(earms 0-50 gold)</p>
					<input type="hidden" name="lugar" value="casino" />
					<button type="submit" class="btn btn-info">Find gold!</button>
				</form>
			</div>
		</div>
		<h2 class="mt-9">Activities: </h2>
		<c:forEach items="${resultados }" var="resultado">
				<c:if test="${resultado.contains('aumentas') }">
					<p class="text-success"><c:out value="${resultado }"></c:out></p>
				</c:if>

				<c:if test="${resultado.contains('pierdes') }">
					<p class="text-danger"><c:out value="${resultado }"></c:out></p>
				</c:if>
			</c:forEach>
			<a class="btn btn-danger" href="/reset" role="button">RESET</a>
		
	</div>
</body>
</html>