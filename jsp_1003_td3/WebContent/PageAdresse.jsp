<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="adresse" class="exo.Adresse">
	<jsp:setProperty name="adresse" property="ville" value="Issy-les-Moulineaux" />
</jsp:useBean>
<jsp:setProperty name="adresse" property="rue" value="Marceau" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Adresse</title>
</head>
<%
	adresse.setNumero (2);
	String strAdresse = adresse.toString();
	out.println (strAdresse);
%>
<body>
</body>
</html>