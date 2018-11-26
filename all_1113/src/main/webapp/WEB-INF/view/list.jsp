<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des utilisateurs</title>
</head>
<body>
	<h1>Liste des utilisateurs</h1>
	<table>
		<tr><th>Id</th><th>Prénom</th><th>Nom</th><th>Couriel</th><th>Login</th><th>Modifier</th><th>Supprimer</th></tr>
		<c:forEach items="${list}" var="user">
			<tr><td>${user.id}</td><td>${user.prenom}</td><td>${user.nom}</td><td>${user.email}</td><td>${user.login}</td><td><a href="">Modifier</a></td><td><a href="">Modifier</a></td></tr>
		</c:forEach>
	</table>
</body>
</html>