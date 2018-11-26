<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<%
	String username = (String) session.getAttribute ("username");
	String password = (String) session.getAttribute ("password");
	if (username ==null) username ="";
	if (password ==null) password ="";
%>
<body>
	<form method='post' action='home.jsp'>
		<p>Identifiant</p><input type='text' name='username' value='<%= username %>'><br>
		<p>Mot de passe</p><input type='password' name='password' value='<%= password %>'><br>
		<input type='submit' value='envoyez'>
	</form>
</body>
</html>