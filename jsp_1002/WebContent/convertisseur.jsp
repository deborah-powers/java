<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Convertisseur franc-euro</title>
</head>
<body>
	<%
	String devise = request.getParameter ("devise");
	String strMontant = request.getParameter ("montant");
	double montant = Double.parseDouble (strMontant);
	double result =0;
	if (devise.equals ("euro")) result = montant / 6.56;
	else if (devise.equals ("franc")) result = montant * 6.56;
	%>
	<p>résultat: <%=result%></p>
</body>
</html>