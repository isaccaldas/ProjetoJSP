<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- CSS bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  
  <style type="text/css">
  	form {
	position: absolute;
	top:50%;
	left:40%;
	right:40%;
	border
	}
  
  </style>
  
  
  
<title>Insert title here</title>
</head>
<body>
	<div>
	<form action="ServletLogin"  method="post" class="border border-primary" >
	<input type="hidden" value="<%= request.getParameter("url") %>"  name="url"> <!-- Captura a url do browser -->
		<table>
			<tr class="mb-3">
				<td><label class="form-label">Login:</label> </td>
				<td><input class="form-control" name="_login" type="text" required="required"></td>
			</tr>
			
			<tr class="mb-3">
				<td> <label class="form-label">Senha:</label></td>
				<td><input class="form-control" name="_senha" type="password" required="required"> </td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Logar" class="btn btn-primary"></td>
			</tr>
		</table>
	
		
		
	</form>
		<div class="alert alert-danger" role="alert">
  		<h6>${msg} </h6>
		</div>
		
	</div>
  <!-- JS bootstrap -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous">
   
   
   
   
   </script>
  </body>
</body>
</html>