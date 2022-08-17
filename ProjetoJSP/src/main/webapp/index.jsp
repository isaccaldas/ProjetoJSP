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
		<table>
			<tr>
				<td><label>Nome:</label> </td>
				<td><input name="_nome" type="text"></td>
			</tr>
			
			<tr>
				<td> <label>Idade:</label></td>
				<td><input name="_senha" type="password"> </td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
	
		<h4>${msg} </h4>
	</form>

</body>
</html>