<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>double formulaire avec des jsp, page 1</title>
	<style type='text/css'>
		span {
			color: red;
			display: inline-block;
			width: 2cm;
		}
	</style>
</head>
<%-- récupérer les infos de la session --%>
<%
	String prenom = (String) session.getAttribute ("prenom");
	String nom = (String) session.getAttribute ("nom");
	if (prenom ==null) prenom = "Votre prénom";
	if (nom ==null) nom = "Votre nom";
%>
<body style='background-color:#FED;'>
	<form method='get' action='FormMood.jsp'>
		<span>Prenom</span><input type='text' name='prenom' value='<%= prenom %>'><br>
		<span>Nom</span><input type='text' name='nom' value='<%= nom %>'><br>
		<input type='submit' value='envoyez'>
	</form>
</body>
</html>