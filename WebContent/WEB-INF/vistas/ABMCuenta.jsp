
<%@page import="java.util.ArrayList" %>
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario" %> 
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas" %>  
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.TiposDeCuentas" %>  

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
    	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 
    	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>  
		<script src="estilos/toast/javascript/jquery.toastmessage.js"></script>
		<link href="estilos/toast/resources/css/jquery.toastmessage.css" rel="StyleSheet" type="text/css"> 
	</head>
	<body>  
		<div id="loading" 
			style="position: fixed;
  				display: flex;
  				justify-content: center;
  				align-items: center;
  				width: 100%;
  				height: 100%;
				  top: 0;
				  left: 0;
				  opacity: 0.7;
				  background-color: #fff;
				  z-index: 99;">
		  <img id="loading-image" src="estilos/Ajux_loader.gif" alt="Loading..." />
		</div>
		<div class="mainContainer"> 
			<div class="header">
				<div class="controlesUsuario">
					<div>Banking App</div>
					<div style="display:flex; flex-direction:row;"> 
						<form method="post" action="redirigirListadoCuentas.html" onsubmit="$('#loading').show();">
							<input type="submit" title="Cuentas" value="Cuentas" class="button btnHeader" ></input>
								<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
						</form>
						<form method="post" action="redirigirListadoClientes.html" style="margin-left:10px;" onsubmit="$('#loading').show();">
							<input type="submit" title="Clientes" value="Clientes" class="button btnHeader"></input>
								<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
						</form>
					</div> 
				</div>
				<div class="controlesUsuario">
					<div>${nombreCuenta}</div>
					<div class="salirContainer">
						<form method="post" action="salir.html" onsubmit="$('#loading').show();">
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
						<form id="formDelete" method="post" action="eliminarCuenta.html">
				  			<input class="button btnNuevoCliente" type="button" title="Eliminar cuenta" value="Eliminar Cuenta" id="delete_button"></input> 
				  			<input type="hidden" name="idNroDeCuenta" value="${cuenta.getIdNroDeCuenta()}" > 
				  		</form>
				  	</div>
				  	<% } %> 
				</div>
				<div style="margin-bottom: 10px;">
				<% if(request.getAttribute("cuenta")!=null) { %>
					<form id="formUpdate" method="post" action="editCuenta.html" onsubmit="return validarForm();"> 
						<div class="row">
							<div class="column" > 
								<label for="asignarCliente">Cliente seleccionado:</label>
								<div style="display:flex; justify-content: space-between;">
									<div style="max-width:150px;">
										<input class="button btnNuevoCliente asignarCliente" id="asignarCliente" type="button" title="Asignar cliente" value="Asignar cliente"></input>   
					  				</div> 
					  				<div style="flex: 2; padding-left: 17px;"><input type="text" id="ususarioAsignadoLabel" value="${cuenta.getUsuario().getApellidoYNombre()}" disabled="true"></input></div>
								</div> 
						  	</div>  
						  	<div class="column">
						  		<label for="numeroCuenta">Numero de cuenta:</label>
								<input type="text" id="numeroCuenta2" name="numeroCuenta2" value="${cuenta.getIdNroDeCuenta()}" disabled="true"></input>
								<input type="hidden" id="numeroCuenta" name="numeroCuenta" value="${cuenta.getIdNroDeCuenta()}"></input>
						  	</div>
						</div>
						<div class="row">
						  	<div class="column">
						  		<label for="fechaCuenta">Fecha de creacion:</label>
								<input type="date" name="fechaCuenta" value="${cuenta.getFechaCreacion()}" disabled="true"></input>
								<input type="hidden" id="fechaCuenta" name="fechaCuenta" value="${cuenta.getFechaCreacion()}"></input>
						  	</div>
						  	<div class="column">
						  		<label for="CBU">CBU:</label>
								<input type="text" name="CBU" value="${cuenta.getCBU()}" disabled=true></input>
								<input type="hidden" id="CBU" name="CBU" value="${cuenta.getCBU()}"></input>
						  	</div> 
						</div>
						<div class="row">
							<div class="column"> 
								<label for="tipoCuenta">Tipo de Cuenta:</label>
								<select name="tipoCuenta" id="tipoCuenta">
								  	<option value="Caja de Ahorro en Pesos">Caja Ahorro Pesos</option>
								  	<option value="Caja de Ahorro en Dolares">Caja Ahorro Dolares</option>
								</select> 
						  	</div> 
						  	<div class="column">
						  		<label for="saldo">Saldo:</label> 
								<input type="number" id="saldo" name="saldo" value="${cuenta.getSaldo()}"></input> 
						  	</div>
						</div>  
						
						<div class="row">
							<div class="column"> 
						  	</div> 
						  	<div class="column" style="display:flex; justify-content: flex-end;">
						  		<input class="button btnSave" title="Guardar" value="Guardar" id="update_button" style="margin-top:10px;"></input>  
								<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
								<input id="idUserSelected" type="hidden" name="idUsuario" value="${cuenta.getUsuario().getIdusuario()}"></input>
						  	</div>
						</div> 
					</form>
					
					<% }else{ 
					
					String nuevoCBU = (String)request.getAttribute("newCBU");
					String apellidoYNombre = "";
					if(request.getAttribute("apellidoYNombre") != null){
						apellidoYNombre = (String)request.getAttribute("apellidoYNombre"); 
					}
					Integer idUsuarioAsignado = null;		 
					if(request.getAttribute("idUsuarioAsignado") != null){
						idUsuarioAsignado = (Integer)request.getAttribute("idUsuarioAsignado"); 
					}
					%>
					<form id="formCreate" method="post" action="guardarCuenta.html" onsubmit="return validarForm();"> 
						<div class="row">
							<div class="column" > 
								<label for="asignarCliente">Cliente seleccionado:</label>
								<div style="display:flex; justify-content: space-between;">
									<div style="max-width:150px;">
										<input class="button btnNuevoCliente asignarCliente" id="asignarCliente" type="button" title="Asignar cliente" value="Asignar cliente"></input>   
					  				</div> 
					  				<div style="flex: 2; padding-left: 17px;"><input type="text" id="ususarioAsignadoLabel" value="<%=apellidoYNombre%>" disabled="true"></input></div>
								</div> 
						  	</div>  
						  	<div class="column"> 
								<input type="hidden" id="numeroCuenta" name="numeroCuenta" value=""></input>
						  	</div>
						</div>
						<div class="row">
						  	<div class="column"> 
						  		<label for="CBU">CBU:</label>
								<input type="text" name="CBU" value="<%=nuevoCBU%>" disabled="true"></input>
								<input type="hidden" id="CBU" name="CBU" value="<%=nuevoCBU%>"></input> 
						  	</div>
						  	<div class="column">
						  		
						  	</div> 
						</div>

						<div class="row">
							<div class="column"> 
								<label for="tipoCuenta">Tipo de Cuenta:</label>
								<select name="tipoCuenta" id="tipoCuenta">

								  	<option value="Caja de Ahorro en Pesos">Caja Ahorro Pesos</option>
								  	<option value="Caja de Ahorro en Dolares">Caja Ahorro Dolares</option>
								  
								</select> 
						  	</div> 
						  	<div class="column">
						  		<label for="saldo">Saldo:</label> 
									<input type="number" id="saldo" name="saldo" value="10000" disabled="true"></input> 
						  	</div>
						</div>  
						
						<div class="row">
							<div class="column"> 
						  	</div> 
						  	<div class="column" style="display:flex; justify-content: flex-end;"> 
								<input id="idUserSelected" type="hidden" value="<%=idUsuarioAsignado%>" name="idUsuario"></input> 
						  		<input class="button btnSave" title="Guardar" value="Guardar" id="create_button" style="margin-top:10px;"></input>  
								<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input> 
						  	</div>
						</div> 
					</form>
					<% } %>  
				</div> 
			</div>  
		<div class="footer"> 
            <div>LAB5 UTN Grupo 8 2021</div> 
	    </div>  
	</div>  
	<div id="dialog" title="Seleccionar Cliente" style="display:none;">
        <h3>Clientes</h3> 
         <table id="tablaClientes" class="table table-striped table-bordered" style="width:100%">
            <thead>
              <tr>
                <th></th>
                <th>APELLIDO</th>
                <th>NOMBRE</th>
                <th>DNI</th>
                <th>DIRECCION</th>
              </tr>
             </thead> 
             <tbody> 
             </tbody>
        </table>
     </div> 
         <%if(request.getAttribute("informarError")!=null) { 
		    	//EN CASO DE ERROR AL CARGAR LA PAGINA INFORMAMOS DE EL MISMO
		    	String errorMessage = (String)request.getAttribute("mensajeError"); %>
	    		<script>
	    			$().toastmessage('showErrorToast', "<%=errorMessage%>"); 
        			$('#loading').hide();
        		</script>
	    	<%} %>
         <%if(request.getAttribute("cuenta")!=null) { %>
			 <script type="text/javascript">
			 	//Auto populamos la picklist the tipo de cuenta
			 	$("#tipoCuenta").val("<%=cuenta.getTipoCuenta().getDescripcion()%>");
			 </script>
		<% } %>
	    <script type="text/javascript"> 
    	var numbers = /^\d+\.?\d*$/; 
    	//USAMOS REGULAR EXPRESSIONS PARA VALIDAR EL FORMULARIO ANTES DE ENVIAR
    	function validarForm(){  
    		if(!numbers.test($('#saldo').val()) || $('#saldo').val() == undefined || $('#saldo').val() == null || $('#saldo').val().trim() == "" || $('#dniCliente').val() > 999999999){ //
    			$().toastmessage('showErrorToast', "Modifique el DNI, no puede estar vacio y solo puede contener numeros del 1 al 999999999");
    			$('#loading').hide();
    		    return false;
    		}  
    		
    		if( $('#idUserSelected').val() == undefined || $('#idUserSelected').val() == null || $('#idUserSelected').val() == 'null' || $('#idUserSelected').val().trim() == ""){ //
    			$().toastmessage('showErrorToast', "Debe seleccionar un usuario");
    			$('#loading').hide();
    		    return false;
    		} 
    		
    		return true;
    	}
    	
	    function seleccionerCliente(elemento){ 
	    	let idUsuario = elemento.dataset.usuarioid;
	    	let nombreUsuario = elemento.dataset.nombreusuario;
	    	let apellidoUsuario = elemento.dataset.apellidousuario;
	    	$("#ususarioAsignadoLabel").val(apellidoUsuario + ', ' + nombreUsuario);
	    	$("#idUserSelected").val(idUsuario); 
	    	$("#dialog").dialog("close");  
	    }
	    var table;
	    $(document).ready( function () {
	    	$('#loading').hide();
	    	table = $('#tablaClientes').DataTable({ 
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
	    
	    //USAMOS AJAX PARA TRAER LA LISTA DE USUARIOS PARA ASIGNAR LA CUENTA
	    $(function() {
	    	   $(".asignarCliente").click(function(){
	    		   $.ajax({ 
	    			    datatype  : "json",	
	    			    headers:{ 'Accept': "application/json", 'Content-Type': "application/json"},     
	    		        type: "GET",
	    		        url: "obtenerClientes.html", 
	    		        success: function(response)
	    		        { 
	    		        	let rows = JSON.parse(response); 
	    		        	for(let i = 0; i< rows.length; i++){
	    		        		let cliente = rows[i];
	    		        		let thisRow = [];
	    		        		thisRow.push('<input class="button" type="submit" data-usuarioid="'+cliente.idusuario+'" data-nombreusuario="'+cliente.nombre+'" data-apellidousuario="'+cliente.apellido+'" value="Seleccionar" onclick="seleccionerCliente(this)"></input>');
	    		        		thisRow.push(cliente.apellido);
	    		        		thisRow.push(cliente.nombre);
	    		        		thisRow.push(cliente.dni);
	    		        		thisRow.push(cliente.direccion); 
								table.row.add(thisRow).draw();
	    		        	} 
	    		        	$( function() {
	    		                $( "#dialog" ).dialog({ 
	    		                    modal: true,
	    		                    height: 500,
	    		                    width: 800,
	    		                    beforeClose: function( event, ui ) {
	    		                    	$("#tablaClientes > tbody").empty();
	    		                    }
	    		                });
	    		              } );
	    		        	
	    		        },
	    		        error: function(e)
	    		        {
	    		        	console.log(JSON.stringify(e));
	    		        }
	    		    });
	    	   });
	    	});
	    
	  //USAMOS JQUERY PARA COMFIRMAR LAS ACCIONES QUE GENERAN CAMBIOS EN LA BASE DE DATOS
	    $(function() {
	    	   $("#delete_button").click(function(){
	    		   $.confirm({
	    			    title: 'Eliminar',
	    			    content: 'Realmente desea eliminar la cuenta?',
	    			    buttons: {
	    			        confirm: {
	    			        	text:"Eliminar",
	    			        	action: function () {
	    			        		$('#loading').show();
	    			        		$('#formDelete').submit();
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
	    	   $("#update_button").click(function(){
	    		   $.confirm({
	    			    title: 'Modificar',
	    			    content: 'Realmente desea modificar la cuenta?',
	    			    buttons: {
	    			        confirm: {
	    			        	text:"Modificar",
	    			        	action: function () {
	    			        		$('#loading').show();
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
	    			        		$('#loading').show();
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