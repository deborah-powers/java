<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erreur</title>
</head>
<body>
	<p>Il y a une erreur.</p>
	<h1><%= exception.getMessage() %></h1>
</body>
</html>