<!DOCTYPE html>

<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<title>Votar un Tema</title>
</head>
<body>
	<c:set var="voteView" scope="request" value="${vote}" />
	<h3>JSF 2</h3>
	<p>IP: ${voteView.ip}</p>
	<form action="/Web/votacion/vote" method="POST">
		<br />
		<p>Pregunta a votar: </p>
		<select name="pregunta">
		<c:forEach items="${voteView.listaTemasObj}" var="tema">
			<option value="${tema.id}" />${tema.nombreTema} - ${tema.pregunta}</option>
		</c:forEach>	
		</select>
		<br />
		<p>Nivel de estudios: </p>
		<select name="nivelEstudios">
		<c:forEach items="${voteView.listaNivelEstudios}" var="nivel">
			<option value="${nivel}" />${nivel}</option>
		</c:forEach>	
		</select>
		<br />
		<p>Voto: </p>
		<select name="voto">
		<c:forEach items="${voteView.listaVotos}" var="voto">
			<option value="${voto}" />${voto}</option>
		</c:forEach>	
		</select>
		<br />
		<input  id="submit" value="submit" type="submit"/>
	</form>
</body>
</html>
