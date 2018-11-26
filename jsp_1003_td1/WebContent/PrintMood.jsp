<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>double formulaire avec des jsp, page 3</title>
</head>
<%
	// récupérer les infos du front
	String humeur = request.getParameter ("va");
	String message = "Tant mieux";
	if (humeur.equals ("mal")) message = "T'en fait pas ça ira mieux demain";
	// récupérer les infos de la session
	String prenom = (String) session.getAttribute ("prenom");
	String nom = (String) session.getAttribute ("nom");
%>
<body>
	<h1><%= message %>, <%= prenom %> <%= nom %></h1>
	<a href='FormName.jsp'>Revenir au début</a>
	<button onclick='window.location.href="FormName.jsp"'>Revenir au début</button>
</body>
</html>