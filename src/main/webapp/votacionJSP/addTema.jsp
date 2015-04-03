<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<title>Añadir Tema</title>
</head>
<body>
	<form action="/Web/votacion/addTema" method="POST">
		<p>Categoría del tema </p>
		<input type="text" name="temaName" />
		<br />
		<p>Pregunta </p>
		<input type="text" name="pregunta" />
		<br />
		<input type="submit" id="submit" value="submit" />
	</form>
</body>
</html>
