<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bienvenido</title> 
		<link href="estilos/login.css" rel="StyleSheet" type="text/css"> 
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script> 
	</head> 
	<body>
		<div class="mainContainer">
		
			<div class="header"><div> Banking App </div></div> 
			
			<div class="content">
				<div class="login-form">
					<form action="redirigirLogin.html" method="post">
						<div class="title" >
							<h2>Banking App</h2>
							<h4>Ingresar</h4>
						</div>
						<div class="form-group">
							<input type="text" name="txtUsuario" placeholder="Usuario" required="required" autocomplete="off">
						</div>
						<div class="form-group">
							<input type="password" name="txtClave" placeholder="Clave" required="required">
						</div>
						<div class="form-group">
							<input type="submit" class="button" value="Ingresar" name="btnIngresar"> 
						</div> 
						<%if(request.getAttribute("errorDeUsuario")!=null)
						{%>
							 <div class="alert">Usuario y/o clave incorrecto</div> 
						<%} %>
						
					</form> 
				</div> 
			</div> 
			
			<div class="footer"> 
	            <div>LAB5 UTN Grupo 8 2021</div> 
		    </div>
	    </div>
	</body>
</html>