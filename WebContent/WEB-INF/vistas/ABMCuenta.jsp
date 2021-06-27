
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
					<% if(request.getAttribute("cuenta")!=null) { %>
					<div class="botonPrincipalContainer">
						<form method="post" action="eliminarCuenta.html">
				  			<input class="button btnNuevoCliente" type="submit" title="Eliminar cuenta" value="Eliminar Cuenta"></input> 
				  			<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
				  			<input type="hidden" name="idUsuario" value="${idUsuario}" >
				  		</form>
				  	</div>
				  	<% } %> 
				</div>
				<div style="margin-bottom: 10px;">
				<% if(request.getAttribute("cuenta")!=null) { %>
					<form id="formUpdate" method="post" action="editarCuenta.html" onsubmit="return error();"> 
						<div class="row">
							<div class="column" > 
								<div style="display:flex; justify-content: left;">
									<div style="max-width:150px;">
										<input class="button btnNuevoCliente" id="asignarCliente" type="button" title="Asignar cliente" value="Asignar cliente"></input>  
					  					<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" > 
					  				</div> 
								</div> 
						  	</div>  
						  	<div class="column">
						  		<label for="numeroCuenta">Numero de cuenta:</label>
								<input type="text" id="numeroCuenta" name="numeroCuenta" value="${cuenta.getIdNroDeCuenta()}" disabled="true"></input>
						  	</div>
						</div>
						<div class="row">
						  	<div class="column">
						  		<label for="fechaCuenta">Fecha de creacion:</label>
								<input type="text" id="fechaCuenta" name="fechaCuenta" value="${cuenta.getFechaCreacion()}" disabled="true"></input>
						  	</div>
						  	<div class="column">
						  		<label for="CBU">CBU:</label>
								<input type="text" id="CBU" name="CBU" value="${cuenta.getCBU()}" disabled=true></input>
						  	</div> 
						</div>
						<div class="row">
							<div class="column"> 
								<label for="tipoCuenta">Tipo de Cuenta:</label>
								<select name="tipoCuenta" id="tipoCuenta">
								  	<option value="P">Caja Ahorro Pesos</option>
								  	<option value="D">Caja Ahorro Dolares</option>
								</select> 
						  	</div> 
						  	<div class="column">
						  		<label for="saldo">Saldo:</label>
						  		<%if(request.getAttribute("cuenta")==null) { %>
									<input type="text" id="saldo" name="saldo" value="${cuenta.getSaldo()}" disabled="true"></input>
								<% } %>
								<%if(request.getAttribute("cuenta")!=null) { %>
									<input type="text" id="saldo" name="saldo" value="${cuenta.getSaldo()}"></input>
								<% } %>
						  	</div>
						</div>  
						
						<div class="row">
							<div class="column"> 
						  	</div> 
						  	<div class="column" style="display:flex; justify-content: flex-end;">
						  		<input type="submit" class="button btnSave" title="Guardar" value="Guardar" id="update_button" style="margin-top:10px;"></input>  
								<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
						  	</div>
						</div> 
					</form>
					
					<% }else{ %>
					<form id="formCreate" method="post" action="guardarCuenta.html" onsubmit="return error();"> 
						<div class="row">
							<div class="column" > 
								<div style="display:flex; justify-content: left;">
									<div style="max-width:150px;">
										<input class="button btnNuevoCliente" id="asignarCliente" type="button" title="Asignar cliente" value="Asignar cliente"></input>  
					  					<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" > 
					  				</div> 
								</div> 
						  	</div>  
						  	<div class="column">
						  		<label for="numeroCuenta">Numero de cuenta:</label>
								<input type="text" id="numeroCuenta" name="numeroCuenta" value="${cuenta.getIdNroDeCuenta()}" disabled="true"></input>
						  	</div>
						</div>
						<div class="row">
						  	<div class="column">
						  		<label for="fechaCuenta">Fecha de creacion:</label>
								<input type="text" id="fechaCuenta" name="fechaCuenta" value="${cuenta.getFechaCreacion()}" disabled="true"></input>
						  	</div>
						  	<div class="column">
						  		<label for="CBU">CBU:</label>
								<input type="text" id="CBU" name="CBU" value="${cuenta.getCBU()}" disabled=true></input>
						  	</div> 
						</div>
						<div class="row">
							<div class="column"> 
								<label for="tipoCuenta">Tipo de Cuenta:</label>
								<select name="tipoCuenta" id="tipoCuenta">
								  	<option value="P">Caja Ahorro Pesos</option>
								  	<option value="D">Caja Ahorro Dolares</option>
								</select> 
						  	</div> 
						  	<div class="column">
						  		<label for="saldo">Saldo:</label>
						  		<%if(request.getAttribute("cuenta")==null) { %>
									<input type="text" id="saldo" name="saldo" value="${cuenta.getSaldo()}" disabled="true"></input>
								<% } %>
								<%if(request.getAttribute("cuenta")!=null) { %>
									<input type="text" id="saldo" name="saldo" value="${cuenta.getSaldo()}"></input>
								<% } %>
						  	</div>
						</div>  
						
						<div class="row">
							<div class="column"> 
						  	</div> 
						  	<div class="column" style="display:flex; justify-content: flex-end;">
						  		<input type="submit" class="button btnSave" title="Guardar" value="Guardar" id="create_button" style="margin-top:10px;"></input>  
								<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
								<input type="hidden" name="idCuenta" value="${cuenta.getIdNroDeCuenta()}"></input>
								
						  	</div>
						</div> 
					</form>
					<% } %> 
					<form id="formAsignarCliente" method="post" action="buscarCliente.html">
						<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
					</form>
				</div>
				
			</div>  
		<div class="footer"> 
            <div>LAB5 UTN Grupo 8 2021</div> 
	    </div> 
	    <script type="text/javascript">
	    $(function() {
	    	   $("#asignarCliente").click(function(){
	    		   $("#formAsignarCliente").submit();
	    	   });
	    	});
	    
	    $(function() {
	    	   $("#update_button").click(function(){
	    		   $.confirm({
	    			    title: 'Crear',
	    			    content: 'Realmente desea modificar la cuenta?',
	    			    buttons: {
	    			        confirm: {
	    			        	text:"Crear",
	    			        	action: function () {
	    			        		$('#formUpdate').submit();
	    			        	}
	    			        },
	    			        cancel: {
	    			        	text:"Cancelar",
	    			        	action:function () {}
	    			        }
	    			    }
	    			    
	    			});
	    	   });
	    	});
	    
	    $(function() {
	    	   $("#create_button").click(function(){
	    		   $.confirm({
	    			    title: 'Crear',
	    			    content: 'Realmente desea crear la cuenta?',
	    			    buttons: {
	    			        confirm: {
	    			        	text:"Crear",
	    			        	action: function () {
	    			        		$('#formCreate').submit();
	    			        	}
	    			        },
	    			        cancel: {
	    			        	text:"Cancelar",
	    			        	action:function () {}
	    			        }
	    			    }
	    			    
	    			});
	    	   });
	    	});
	    
	    </script>

</body>
</html>