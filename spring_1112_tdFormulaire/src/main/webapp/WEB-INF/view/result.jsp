<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Tell the JSP Page that please do not ignore Expression Language -->
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>formulaire</title>
</head>
<body>
	<h1>Coucou je suis la page de résultats</h1>
	<form:form method="post" modelAttribute="user" action="/spring_1112_tdFormulaire/">
		<form:label path="name">Name : </form:label>${user.name}</br>
		<form:label path="email">E-mail :</form:label>${user.email}</br>
		<form:label path="age">Age : </form:label>${user.age}</br>
		<input type="submit" value="Revenir à la page d'accueil">
	</form:form>
</body>
</html>