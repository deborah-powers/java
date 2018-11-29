<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 25/10/2018
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <h1>coucou je suis la page d'update</h1>
    <p>Je suis <s:property value="userConnected.prenom"/>, <s:property value="userConnected.role"/></p>
    <s:form action="update">
        <s:hidden name="action" value="update"/>
        <s:hidden name="userHandled.id" value="%{id}" />
        <s:textfield name="userHandled.prenom" label="Prénom"/>
        <s:textfield name="userHandled.civilite" label="Civilité"/>
        <s:textfield name="userHandled.pays" label="Pays"/>
        <s:textfield name="userHandled.description" label="Description"/>
        <s:textfield name="userHandled.mdp" label="Mot de passe"/>
        <s:textfield name="userHandled.role" label="Rôle"/>
        <s:radio list="#{'1': 'oui', '2': 'non'}" name="userHandled.inMailingList" label="Abonner au mailling"/>
        <s:submit value="Envoyer"/>
        <s:reset value="Effacer"/>
    </s:form>
</body>
</html>
