<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="ErreurPerso.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Division avec erreur</title>
</head>
<%
	double nbd = Math.random();
	nbd *=3;
	int nb= (int) nbd;
%>
<body>
	<p>Vous aurez une erreur en faisant une division par 0.</p>
	<p>Nombre: <%=nb%></p>
	<p>Résultat: <%= (int) 12/nb %>.</p>
</body>
</html>