<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>double formulaire avec des jsp, page 2</title>
</head>
<%
	String nom = request.getParameter ("nom");
	String prenom = request.getParameter ("prenom");
	session.setAttribute ("prenom", prenom);
	session.setAttribute ("nom", nom);
	Date today = new Date();
	String strToday = today.toString();
%>
<body>
	<h1>Bonjour <%= prenom %> <%= nom %></h1>
	<p>date: <%= strToday %></p>
	<form method='get' action='PrintMood.jsp'>
		<h2>Comment ça va ?</h2>
		<p>Bien</p><input type='radio' name='va' value='bien'>
		<p>Mal</p><input type='radio' name='va' value='mal'>
		<br><input type='submit' value='envoyez'>
	</form>
</body>
</html>