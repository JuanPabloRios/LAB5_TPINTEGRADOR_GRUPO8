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
			<% 
				Usuario cliente = new Usuario();
				if(request.getAttribute("cliente")!=null) {
					cliente = (Usuario)request.getAttribute("cliente"); 
				} %>
		<div class="mainContainer"> 
			<div class="header">
				<div class="controlesUsuario">
					<div>Banking App</div>
					<div style="display:flex; flex-direction:row;"> 
						<form method="post" action="irAClienteHome.html">
							<input type="submit" title="Home" value="Home" class="button btnHeader"></input>
							<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
							<input type="hidden" name="idUsuario" value="<%=cliente.getIdusuario()%>" >
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
			<div class="content">
				<div class="tituloPaginaContainer">
					<div class="tituloPagina">Realizar transferencia</div>   
				</div>
				<div class="row">
					<div class="column" >
						<label for="nombreClienteGet">${cliente.getNombre()}</label> <label for="apellidoClienteGet">${cliente.getApellido()}</label> 
						<div > 
							<label for="CuentaOrigen">Seleccionar Cuenta de origen </label>
							<select name="CuentaOrigen" id="CuentaOrigen" >
							  	<option value="0">Seleccione cuenta de origen</option>
								<option value="1">Nro Cuenta 1 y CBU</option>
								<option value="2">Nro Cuenta 2 y CBU</option>
								<option value="3">Nro Cuenta 3 y CBU</option>
							</select> 
						</div>
					</div> 
					<div class="column" >
					</div> 
				</div>
				<div class="row">
					<div class="column" >
						<div > 
							<label for="CuentaOrigen">Seleccionar cuenta de destino</label>
							<select name="CuentaOrigen" id="CuentaOrigen" onchange="checkTerceros(this)">
							  	<option value="0">Seleccione cuenta de destino</option>
								<option value="1">Nro Cuenta 1 y CBU</option>
								<option value="2">Nro Cuenta 2 y CBU</option>
								<option value="3">Nro Cuenta 3 y CBU</option>
								<option value="Otros">Cuentas de terceros por CBU</option>
							</select> 
						</div> 
					</div> 
					<div class="column" >
					</div> 
				</div>
				<div class="row">
					<div class="column" >
						<div id="cbuContainer" style="display:none;">
							<label for="cbu">Ingrese el CBU de la cuenta destino:</label> 
							<input type="number" id="cbu" name="cbu" value="" required="required">
						</div>
						<script>
							function checkTerceros(element){
								console.log(element.value);
								if(element.value == 'Otros'){
									$('#cbuContainer').show();
								} else {
									$('#cbuContainer').hide();
								}
							}
						</script> 
					</div> 
					<div class="column" >
					</div> 
				</div>
				<div class="row">
					<div class="column" >
						<label for="nombreCliente">Ingrese el monto a transferir:</label>  
						<input type="text" id="Monto" name="Monto" value="" required="required" onkeypress="return validate(this,event);"/> 
					</div> 
					<div class="column"style="display:flex; justify-content: flex-end;" >
						<div >
					  		<input type="submit" class="button btnSave" title="Transferir" value="Transferir" style="margin-top:10px;"></input>  
							<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
					  	</div>
					</div> 
				</div>
			</div>
			<div class="footer"> 
	            LAB5 UTN Grupo 8 2021 
		    </div>
	    </div>
	    <script type="text/javascript">
		    $(document).ready( function () {
		        $('#tablaCuentas').DataTable({
		        	"searching": false,
		        	"paging": false,
		        	"language": {
		                "lengthMenu": "Mostrar _MENU_ por pagina",
		                "zeroRecords": "No hay resultados",
		                "info": "Pagina _PAGE_ de _PAGES_",
		                "infoEmpty": "No hay registros para mostrar",
		                "infoFiltered": "( filtrados de un total de _MAX_)",
		                "search":"Buscar: ",
		                "paginate": {
		                    "first":      "Primera",
		                    "last":       "Ultima",
		                    "next":       "Siguiente",
		                    "previous":   "Anterior"
		                },
		                "aria": {
		                    "sortAscending":  ": Activar para ordenar de manera ascendente",
		                    "sortDescending": ": Activar para ordenar de manera descendente"
		                }
		            }
		        });
		    } );
		    
		    
		    function validate(el, evt) {
		    	   var charCode = (evt.which) ? evt.which : event.keyCode
		    	    if (charCode != 45 && charCode != 8 && (charCode != 46) && (charCode < 48 || charCode > 57))
		    	        return false;
		    	    if (charCode == 46) {
		    	        if ((el.value) && (el.value.indexOf('.') >= 0))
		    	            return false;
		    	        else
		    	            return true;
		    	    }
		    	    return true;
		    	    var charCode = (evt.which) ? evt.which : event.keyCode;
		    	    var number = evt.value.split('.');
		    	    if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
		    	        return false;
		    	    }
		    	};
		    </script>
		  </head>

	</body>
</html>