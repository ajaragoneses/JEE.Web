<!DOCTYPE html>

<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<title>Lista de Votaciones</title>
    <style>
	    tr {
		   border: 1px solid black;
		} 
    </style>

   </head>
   <body>

   	<h1>Lista de Votaciones</h1>
   	<table>
   		<tr>
   			<th>Tema</th>
   			<th>Pregunta</th>
   			<th>nº de votaciones</th>
   			<th>Votacion media</th>
   		</tr>
   		<tbody>
   		
   		<c:forEach var="o" items="${listVote.listaTemas}" >			
		  <tr>
			<td>${o.nombreTema}</td>
			<td>${o.pregunta}</td>
			<td>${o.listaVotos.size()}</td>
			<td>
			<ul>
				<c:forEach var="i" items="${o.mediaVotos()}" >
					<li>${i}</li>
				</c:forEach>
			</ul>
			</td>
		  </tr>
	    </c:forEach>
    		</tbody>
    	</table>
    </body>
</html>