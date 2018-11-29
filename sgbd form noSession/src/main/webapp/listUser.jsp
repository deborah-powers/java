<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 24/10/2018
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>liste des utilisateurs</title>
</head>
<body>
	<h1>Coucou je suis la liste des utilisateurs</h1>
	<h2>Infos de l'utilisateur</h2>
	<p>Je suis <s:property value="userConnected.prenom"/>, <s:property value="userConnected.role"/></p>
	<h2>Liste des utilisateurs</h2>
	<table>
		<tr>
			<th>Identifiant</th>
			<th>Civilité</th>
			<th>Prénom</th>
			<th>Description</th>
			<th>Rôle</th>
			<th>Mot de passe</th>
		</tr>
		<s:iterator value="userList">
			<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="civilite"/></td>
				<td><s:property value="prenom"/></td>
				<td><s:property value="description"/></td>
				<td><s:property value="role"/></td>
				<td><s:property value="mdp"/></td>
				<s:if test="%{userConnected.role.equals('admin')}">
					<td>
						<form action="login">
							<s:hidden name="action" value="delete" />
                            <s:hidden name="id" value="%{id}"/>
							<s:submit value="Supprimer" type="submit"/>
						</form>
					</td>
					<td>
                            <%--
						<s:url action="updateForm" var="upd">
							<s:param name="id">${id}</s:param>
						</s:url>
						<a href='${upd}'>Modifier</a>
							--%>
                        <form action="updateForm">
                            <s:hidden name="action" value="showUpdatePage" />
                            <s:hidden name="uhId" value="%{id}" />
                            <s:hidden name="ucId" value="%{userConnected.id}" />
                            <s:submit value="Modifier" type="submit"/>
                        </form>
					</td>
				</s:if>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
