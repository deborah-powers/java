<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 24/10/2018
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <h1>Loguez-vous</h1>
    <s:form action="login">
        <s:hidden name="action" value="getList" />
        <s:textfield name="prenom" label="Prénom"/>
        <s:textfield name="mdp" label="Mot de passe"/>
        <s:submit value="Envoyer"/>
        <s:reset value="Effacer"/>
    </s:form>
</body>
</html>
