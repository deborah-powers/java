<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Tell the JSP Page that please do not ignore Expression Language -->
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>formulaire</title>
</head>
<body>
	<h1>Coucou je suis la page d'accueil</h1>
	<!-- modelAttribute="user": cf CtlUser.inputUser
	action="/sendData" cf CtlUser.launchResult
	-->
	<form:form method="post" modelAttribute="user" action="/spring_1112_tdFormulaire/sendData">
		<form:label path="name">Nom</form:label><form:input path="name"/>
		<form:label path="email">Couriel</form:label><form:input path="email"/>
		<form:label path="age">Age</form:label><form:input path="age"/>
		<input type="submit" value="envoyer"/>
	</form:form>
</body>
</html>