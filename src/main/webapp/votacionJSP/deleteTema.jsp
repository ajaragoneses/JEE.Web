<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<title>Añadir Tema</title>
</head>
<body>
	<form action="/Web/votacion/deleteTema" method="POST">
		<p>Identificacion de autorizacion </p>
		<input type="text" name="code" />
		<br />
		
		<select name="tema">
		<c:forEach var="o" items="${deleteTema.listaTemas}">
			<option value="${o.id}" />${o.nombreTema} - ${o.pregunta}</option>
		</c:forEach>
		</select>
		<br />
		<c:if test="${deleteTema.mostrarMensajeError}">
			<p>El identificador de autorizacion no es valido</p>
		</c:if>	
		<c:if test="${deleteTema.mostrarMensajeBorrado}">
			<p>Elemento borrado correctamente</p>
		</c:if>	
		<br />
		<input id="submit" value="submit" type="submit"/>
	</form>
	<a href="/Web/votacion/home">Volver</a>
</h:body>
</html>