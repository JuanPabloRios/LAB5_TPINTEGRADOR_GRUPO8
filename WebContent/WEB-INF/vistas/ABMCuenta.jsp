
<%@page import="java.util.ArrayList" %>
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario" %> 
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="StyleSheet" type="text/css"> 
		<link href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="StyleSheet" type="text/css"> 
		<link href="estilos/AdministradorHome.css" rel="StyleSheet" type="text/css"> 
		<link href="estilos/ABMCliente.css" rel="StyleSheet" type="text/css">  
	</head>
	<body> 
		<div class="mainContainer"> 
			<div class="header">
				<div class="controlesUsuario">
					<div>Banking App</div>
					<div style="display:flex; flex-direction:row;"> 
						<form method="post" action="redirigirListadoCuentas.html">
							<input type="submit" title="Cuentas" value="Cuentas" class="button btnHeader"></input>
								<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
						</form>
						<form method="post" action="redirigirListadoClientes.html" style="margin-left:10px;">
							<input type="submit" title="Clientes" value="Clientes" class="button btnHeader"></input>
								<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
						</form>
					</div> 
				</div>
				<div class="controlesUsuario">
					<div>${nombreCuenta}</div>
					<div class="salirContainer">
						<form method="post" action="salir.html">
							<input type="submit" title="Salir" value="Salir" class="button btnHeader"></input>
						</form>
					</div>
				</div>
			</div> 
			<% 
				Cuentas cuenta = new Cuentas();
				if(request.getAttribute("cuenta")!=null) {
					cuenta = (Cuentas)request.getAttribute("cuenta"); 
				} %>
			<div class="content">
				<div class="tituloPaginaContainer">
					<div class="tituloPagina">ABM Cuenta</div>  
					<% if(request.getAttribute("idUsuario")!=null) { %>
					<div class="botonPrincipalContainer">
						<form method="post" action="eliminarCuenta.html">
				  			<input class="button btnNuevaCuenta" type="submit" title="Eliminar cuenta" value="Eliminar Cuenta"></input> 
				  			<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
				  			<input type="hidden" name="idUsuario" value="${idUsuario}" >
				  		</form>
				  	</div>
				  	<% } %> 
				</div>
				<div style="margin-bottom: 10px;">
					<form method="post" action="guardarCuenta.html" onsubmit="return error();">
						<div id="datosPersonales">
							
								<div class="column">
							    	<label for="nombreCliente">Cliente:</label>
									<input type="text" id="nombreCliente" name="nombreCliente" value="${cuenta.getUsuario()}" required="required">
							  	</div>
							<div class="row">
							  	<div class="column">
							  		<label for="numeroCuenta">Numero de cuenta:</label>
									<input type="text" id="numeroCuenta" name="numeroCuenta" value="${cuenta.getIdNroCuenta()}"></input>
							  	</div>
							  	<div class="column">
							  		<label for="fechaCuenta">Fecha de creacion:</label>
									<input type="text" id="fechaCuenta" name="fechaCuenta" value="${cuenta.getFechaCreacion()}"></input>
							  	</div>
							  	<div class="column">
							  		<label for="CBU">CBU:</label>
									<input type="text" id="CBU" name="CBU" value="${cuenta.getCBU()}"></input>
							  	</div>
								<div class="column"> 
									<label for="tipoCuenta">Tipo de Cuenta:</label>
									<select name="tipoCuenta" id="tipoCuenta">
									  	<option value="P">Caja Ahorro Pesos</option>
									  	<option value="D">Caja Ahorro Dolares</option>
									</select> 
							  	</div> 
							  	<div class="column">
							  		<label for="saldo">Saldo:</label>
									<input type="text" id="saldo" name="saldo" value="${cuenta.getSaldo()}"></input>
							  	</div>
							</div>
						</div> 
						<div class="row">
							<div class="column"> 
							</div>
							<div class="column" style="display:flex; justify-content: flex-end;"><input type="submit" class="button btnSave" title="Guardar" value="Guardar" style="margin-top:10px;"></input> </div> 
						</div>
						 
						<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
					</form>
				</div>
				
			</div>  
			<div class="footer"> 
	            <div>LAB5 UTN Grupo 8 2021</div> 
		    </div>
	    </div>

</body>
</html>