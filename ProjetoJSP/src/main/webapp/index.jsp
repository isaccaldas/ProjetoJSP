<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletLogin"  method="post">
	<input type="hidden" value="<%= request.getParameter("url") %>"  name="url"> <!-- Captura a url do browser -->
		<table>
			<tr>
				<td><label>Login:</label> </td>
				<td><input name="_login" type="text"></td>
			</tr>
			
			<tr>
				<td> <label>Senha:</label></td>
				<td><input name="_senha" type="password"> </td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Logar"></td>
			</tr>
		</table>
	
		<h4>${msg} </h4>
	</form>

</body>
</html>