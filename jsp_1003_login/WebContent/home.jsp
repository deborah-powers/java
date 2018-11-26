<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="login.DbConnect" %>
<jsp:useBean id="user" class="login.User" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<%
	// récupérer les données du front
	String username = request.getParameter ("username");
	String password = request.getParameter ("password");
	session.setAttribute ("username", username);
	session.setAttribute ("password", password);
	// vérifier si l'utilisateur existe
	user = DbConnect.findUser (username, password);
	if (user ==null) response.sendRedirect ("login.jsp");
	else{
		%><p>Bonjour <%= user.getPrenom() %> <%= user.getNom() %></p><%
	}
%>
	<a href='login.jsp'>Revenir au début</a>
</body>
</html>