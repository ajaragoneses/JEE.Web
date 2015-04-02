<!DOCTYPE html>

<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<title>Votar un Tema</title>
</head>
<body>
	<c:set var="voteView" scope="request" value="${voteView}" />
	<h3>JSF 2</h3>
	<p>IP: ${voteView.ip}</p>
	<form>
<%-- 		<selectOneMenu id="tema" value="${voteView.tema}"> --%>
<%-- 			<selectItems value="${voteView.listaTemasString}" /> --%>
<!-- 		</selectOneMenu> -->
<!-- 		<br /> -->
<!-- 		<select id="pregunta"> -->
<%-- 		<c:forEach items="${voteView.listaPreguntas}" var="tema"> --%>
<!-- 			<option value="tema.pregunta" /></option> -->
<%-- 		</c:forEach>	 --%>
<!-- 		</select> -->
		
<!-- 		<br /> -->
<%-- 		<selectOneMenu id="voto" value="${voteView.voto}" rendered="${voteView.temaElegido}"> --%>
<%-- 			<selectItems value="${voteView.listaVotos}" /> --%>
<!-- 		</selectOneMenu> -->
		
<!-- 		<br /> -->
<%-- 		<selectOneMenu id="nivelEstudios" value="${voteView.nivelEstudios}" rendered="${voteView.temaElegido}"> --%>
<%-- 			<selectItems value="${voteView.listaNivelEstudios}" /> --%>
<!-- 		</selectOneMenu> -->
<!-- 		<br /> -->
		<commandButton id="submit" value="submit" type="submit"
			 action="${voteView.process()}" />
	</form>
</body>
</html>
