<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" import="userList.DaoUser" import="userList.User" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<%
	DaoUser dao = new DaoUser();
	ArrayList<User> userList = dao.getAll();
%>
<body>
	<table>
		<caption>Liste des utilisateurs</caption>
		<tr>
			<th>prénom</th><th>nom</th><th></th>
		</tr>
	<% for (User user: userList){
		%><tr>
			<td><%= user.getPrenom() %></td><td><%= user.getNom() %></td>
		</tr><%}%>
	</table>
</body>
</html>