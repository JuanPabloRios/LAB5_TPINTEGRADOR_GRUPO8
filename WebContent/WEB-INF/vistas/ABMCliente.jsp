<%@page import="java.util.ArrayList" %>
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario" %> 
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas" %>  
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Provincia" %>  
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Localidad" %>  
<%@page import="java.util.Map" %>  
<%@page import="java.util.HashMap" %>  
<%@page import="java.util.List" %>

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
								<input type="submit" title="Cuentas" value="Cuentas" class="button btnHeader"></input>
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
				Usuario cliente = new Usuario();
				if(request.getAttribute("cliente")!=null) {
					cliente = (Usuario)request.getAttribute("cliente"); 
				} %>
			<div class="content">
				<div class="tituloPaginaContainer">
					<div class="tituloPagina">ABM Cliente</div>  
					<% if(request.getAttribute("idUsuario")!=null) { %>
					<div class="botonPrincipalContainer">
						<form id="formDelete" method="post" action="eliminarCliente.html">
				  			<input class="button btnNuevoCliente" type="button" title="Eliminar cliente" value="Eliminar Cliente" id="delete_button"></input> 
				  			<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
				  			<input type="hidden" name="idUsuario" value="${idUsuario}" >
				  		</form>
				  	</div>
				  	<% } %> 
				</div>
				<div style="margin-bottom: 10px;">
				<% if(request.getAttribute("idUsuario")!=null) { %>
					<form id="formUpdate" method="post" action="editCliente.html" onsubmit="return validarForm();">
						<div id="datosPersonales">
							<div class="row">
								<div class="column">
							    	<label for="nombreCliente">Nombre:</label>
									<input type="text" id="nombreCliente" name="nombreCliente" value="${cliente.getNombre()}" pattern="[a-zA-Z]" required="required"></input>
							  	</div>
							  	<div class="column">
							    	<label for="apellidoCliente">Apellido:</label>
									<input type="text" id="apellidoCliente" name="apellidoCliente" value="${cliente.getApellido()}" pattern="[a-zA-Z]" required="required"></input>
							  	</div>
							</div>
							<div class="row">
								<div class="column"> 
									<label for="dniCliente">DNI:</label>
									<input type="number" id="dniCliente" name="dniCliente" value="${cliente.getDNI()}" pattern="[0-9]." min="1" max="999999999" required="required"></input>
							  	</div>
							  	<div class="column"> 
							  		<label for="fechaNacimientoCliente">Fecha de Nacimiento:</label>
									<input type="date" id="fechaNacimientoCliente" name="fechaNacimientoCliente" value="${cliente.getFecha_de_nacimiento()}" required="required"></input>
							  	</div>
							</div>
							<div class="row">
								<div class="column"> 
									<label for="sexoCliente">Genero:</label>
									<select name="sexoCliente" id="sexoCliente">
									  	<option value="M">Masculino</option>
									  	<option value="F">Femenino</option>
									  	<option value="O">Otros</option> 
									</select> 
							  	</div> 
							  	<div class="column">
							  		<label for="nacionalidadCliente">Nacionalidad:</label>
									<input type="text" id="nacionalidadCliente" name="nacionalidadCliente" value="${cliente.getNacionalidad()}" pattern="[a-zA-Z]" required="required"></input>
							  	</div>
							</div>
							<div class="row">
								<div class="column">
							    	<label for="nombreUsuario">Usuario:</label>
									<input type="text" id="nombreUsuario" name="nombreUsuario" value="${cliente.getUsuario()}" required="required"></input>
							  	</div>
							  	<div class="column">
							    	<label for="contrasenia">Contraseña:</label>
									<input type="text" id="contrasenia" name="contrasenia" value="${cliente.getContrasenia()}" required="required"></input>
							  	</div>
							</div>
						</div> 
						<div id="datosDomicilio">
							<div class="row">
								<div class="column"> 
									<label for="direccionCliente">Direccion:</label>
									<input type="text" id="direccionCliente" name="direccionCliente" value="${cliente.getDireccion()}" required="required"></input>
							  	</div>
							  	<div class="column"> 
							  		<label for="provinciaCliente">Provincia:</label>
									<select name="provinciaCliente" id="provinciaCliente" onchange="provChange(this)"> 
									</select> 
							  	</div>
							</div>
							<div class="row"> 
							  	<div class="column"> 
							  		<label for="localidadCliente">Localidad:</label>
									<select name="localidadCliente" id="localidadCliente"> 
									</select> 
							  	</div>
							</div>
						</div> 
						<div class="row">
							<div class="column"> 
							</div>
							<div class="column" style="display:flex; justify-content: flex-end;">
							<input type="button" class="button btnSave" id="update_button" title="Guardar" value="Guardar" style="margin-top:10px;"></input>
							</div> 
						</div>
						 <input type="hidden" name="idUsuario" value="${idUsuario}" >
						<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
					</form>
				<% }else{ %>
				<form id="formCreate" method="post" action="guardarCliente.html" onsubmit="return validarForm();">
						<div id="datosPersonales">
							<div class="row">
								<div class="column">
							    	<label for="nombreCliente">Nombre:</label>
									<input type="text" id="nombreCliente" name="nombreCliente" value="${cliente.getNombre()}" required="required"></input>
							  	</div>
							  	<div class="column">
							    	<label for="apellidoCliente">Apellido:</label>
									<input type="text" id="apellidoCliente" name="apellidoCliente" value="${cliente.getApellido()}" required="required"></input>
							  	</div>
							</div>
							<div class="row">
								<div class="column"> 
									<label for="dniCliente">DNI:</label>
									<input type="number" id="dniCliente" name="dniCliente" value="${cliente.getDNI()}" min="1" max="999999999" required="required"></input>
							  	</div>
							  	<div class="column"> 
							  		<label for="fechaNacimientoCliente">Fecha de Nacimiento:</label>
									<input type="date" id="fechaNacimientoCliente" name="fechaNacimientoCliente" value="${cliente.getFecha_de_nacimiento()}" required="required"></input>
							  	</div>
							</div>
							<div class="row">
								<div class="column"> 
									<label for="sexoCliente">Genero:</label>
									<select name="sexoCliente" id="sexoCliente">
									  	<option value="M">Masculino</option>
									  	<option value="F">Femenino</option>
									  	<option value="O">Otros</option> 
									</select> 
							  	</div> 
							  	<div class="column">
							  		<label for="nacionalidadCliente">Nacionalidad:</label>
									<input type="text" id="nacionalidadCliente" name="nacionalidadCliente" value="${cliente.getNacionalidad()}" required="required"></input>
							  	</div>
							</div>
							<div class="row">
								<div class="column">
							    	<label for="nombreUsuario">Usuario:</label>
									<input type="text" id="nombreUsuario" name="nombreUsuario" value="${cliente.getUsuario()}" required="required"></input>
							  	</div>
							  	<div class="column">
							    	<label for="contrasenia">Contraseña:</label>
									<input type="text" id="contrasenia" name="contrasenia" value="${cliente.getContrasenia()}" required="required"></input>
							  	</div>
							</div>
						</div> 
						<div id="datosDomicilio">
							<div class="row">
								<div class="column"> 
									<label for="direccionCliente">Direccion:</label>
									<input type="text" id="direccionCliente" name="direccionCliente" value="${cliente.getDireccion()}" required="required"></input>
							  	</div>
							  	<div class="column"> 
							  		<label for="provinciaCliente" >Provincia:</label>
									<select name="provinciaCliente" id="provinciaCliente" onchange="provChange(this)"> 
									</select> 
							  	</div>
							</div>
							<div class="row"> 
							  	<div class="column"> 
							  		<label for="localidadCliente">Localidad:</label>
									<select name="localidadCliente" id="localidadCliente"> 
									</select> 
							  	</div>
							</div>
						</div> 
						<div class="row">
							<div class="column"> 
							</div>
							<div class="column" style="display:flex; justify-content: flex-end;">
							<input type="button" class="button btnSave" id="create_button" title="Guardar" value="Guardar" style="margin-top:10px;"></input>
							</div> 
						</div>
						 
						<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
					</form>
				
				<% }%> 
				</div>
				<% if(request.getAttribute("idUsuario")!=null) { %>
				<div style="border: solid gray 1px; border-radius: 5px; padding:5px;" >
					<h4>Cuentas relacionadas</h4>
					<table id="tablaCuentas" class="table table-striped table-bordered" style="width:100%;">
						<thead>
						  <tr> 
						  	<th></th>
						    <th>Nro CUENTA</th>
						    <th>CBU</th>
						    <th>TIPO</th>
						    <th>SALDO</th>
						  </tr>
					 	</thead>
	       				<tbody> 
	       				<%  ArrayList<Cuentas> cuentasCliente = null; 
							if(request.getAttribute("listaCuentas")!=null) {
								cuentasCliente = (ArrayList<Cuentas>)request.getAttribute("listaCuentas");
							} 
							if(cuentasCliente!=null)
								for(Cuentas ci : cuentasCliente) { %>
							<tr> 
								<td>
									<form method="post" action="editarCuenta.html" onsubmit="$('#loading').show();">
							  			<input class="button" type="submit" value="Editar / Eliminar"></input>
							  			<input type="hidden" name="idUsuario" value="${idUsuario}" >
							  			<input type="hidden" name="idCuenta" value="<%=ci.getIdNroDeCuenta()%>" >
							  			<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
							  		</form>
								</td>
							    <td><%=ci.getIdNroDeCuenta()%></td>
							    <td><%=ci.getCBU()%></td>
							    <td><%=ci.getTipoCuenta().getDescripcion()%></td>
							    <td><%=ci.getSaldo()%></td>
						  	</tr> 
					   <%  } %> 
						</tbody>
					</table>
				</div>
				<% } %>
			</div>  
			<div class="footer"> 
	            <div>LAB5 UTN Grupo 8 2021</div> 
		    </div>
		    
		    <%if(request.getAttribute("informarError")!=null) { 
		    	//EN CASO DE ERROR AL CARGAR LA PAGINA INFORMAMOS DE EL MISMO
		    	String errorMessage = (String)request.getAttribute("mensajeError"); %>
	    		<script>$().toastmessage('showErrorToast', "<%=errorMessage%>");</script>
	    	<%} %>
	    </div>
	     <%if(request.getAttribute("cliente")!=null) { %>
			 <script type="text/javascript">
			 	$("#sexoCliente").val("<%=cliente.getSexo()%>");
			 </script>
		<% } %>
	    <% if(request.getAttribute("localidadesXProvincia")!=null) {
	    	Map<Provincia,List<Localidad>> localidadesXProvincia = (Map<Provincia,List<Localidad>>)request.getAttribute("localidadesXProvincia"); %>
    		<script type="text/javascript"> 
    			//MEDIANTE DISTINTOS METODOS DE JAVASCRIPT PRIMERO CARGAMOS LA LISTA DE PROVINCIAS
    			var selectedProvId = null;
    			var selectedLocId = null;
    			var selecttedLoc = null;
    		<% if(request.getAttribute("cliente")!=null) { %>  
    			selectedLocId = <%=cliente.getLocalidad().getIdLocalidad()%>
    		<% }%>
	    		var localidadesPorProv = {};
	    		
	    		<%for(Provincia prov : localidadesXProvincia.keySet()){%>
				   	var provincia = { nombre:"<%=prov.getNombre()%>", id : <%=prov.getIdProvincia()%> }; 
				   	var localidades = [];
				   	var selected = "";
				    <%for(Localidad loc : localidadesXProvincia.get(prov)){ %> 
				    	var localLit = { nombre: "<%=loc.getNombre()%>", id :<%=loc.getIdLocalidad()%>, provId : provincia.id  };
			    		localidades.push(localLit);
				    	if(selectedLocId && selectedLocId == localLit.id){
				    		selected = "selected";
				    		selectedProvId = provincia.id;
				    	} 
					<%}%>
				   	$('#provinciaCliente').append("<option "+selected+" value="+provincia.id+">"+provincia.nombre+"</option>");
				   	
					localidadesPorProv[<%=prov.getIdProvincia()%>] = localidades; 
					if(selected == "selected"){ 
						$("#provinciaCliente").val(<%=prov.getIdProvincia()%>)
						provChange($("#provinciaCliente")[0]);
					}
					selected = "";
				<%}%>
				//Y ANTE CUALQUIER CAMBIO DE LA LISTA DE PROVINCIAS MODIFICAMOS LA LISTA DE LOCALIDADES
				function provChange(element) {  
					$('#localidadCliente').find('option').remove().end();
					var localidades = localidadesPorProv[element.value];  
					for(var i = 0; i < localidades.length; i++){
						var selected = "";
					   	if(selectedLocId && selectedLocId == localidades[i].id){
					   		selected = "selected";
					   		selecttedLoc = localidades[i]; 
					   	}
						$('#localidadCliente').append("<option "+selected+" value="+localidades[i].id+">"+localidades[i].nombre+"</option>");
					}
				}
    		</script> 
	   <%}%>
	    <script type="text/javascript">
		    
	    	var letters = /^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$/;
	    	var numbers = /^[0-9]+$/;
	    	var fechas = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
	    	var contrasenia = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/;
	    	//USAMOS REGULAR EXPRESSIONS PARA VALIDAR EL FORMULARIO ANTES DE ENVIAR
	    	function validarForm(){ 
	    		if(!letters.test($('#nombreCliente').val()) || $('#nombreCliente').val() == undefined || $('#nombreCliente').val() == null || $('#nombreCliente').val().trim() == ""){ //
	    			$().toastmessage('showErrorToast', "Modifique el nombre, no puede estar vacio y solo puede contener letras");
	    			$('#loading').hide();
	    		    return false;
	    		} 
	    		if(!letters.test($('#apellidoCliente').val()) || $('#apellidoCliente').val() == undefined || $('#apellidoCliente').val() == null || $('#apellidoCliente').val().trim() == ""){ //
	    			$().toastmessage('showErrorToast', "Modifique el apellido, no puede estar vacio y solo puede contener letras");
	    			$('#loading').hide();
	    		    return false;
	    		}
	    		if(!numbers.test($('#dniCliente').val()) || $('#dniCliente').val() == undefined || $('#dniCliente').val() == null || $('#dniCliente').val().trim() == "" || $('#dniCliente').val() < 1 || $('#dniCliente').val() > 999999999){ //
	    			$().toastmessage('showErrorToast', "Modifique el DNI, no puede estar vacio y solo puede contener numeros del 1 al 999999999");
	    			$('#loading').hide();
	    		    return false;
	    		}
	    		
	    		if(!fechas.test($('#fechaNacimientoCliente').val()) || $('#fechaNacimientoCliente').val() == undefined || $('#fechaNacimientoCliente').val() == null || $('#fechaNacimientoCliente').val().trim() == "" ){ //
	    			$().toastmessage('showErrorToast', "Modifique la fecha de nacimiento, no puede estar vacia o incompleta");
	    			$('#loading').hide();
	    		    return false;
	    		}

	    		let fechaActual = new Date();
	    		let fechaNac = new Date($('#fechaNacimientoCliente').val());
	    		if(fechaNac > fechaActual ){
	    			$().toastmessage('showErrorToast', "Modifique la fecha de nacimiento, no puede ser mayor a hoy");
	    			$('#loading').hide();
	    		    return false;
	    		}
	    		
	    		if(!letters.test($('#nacionalidadCliente').val()) || $('#nacionalidadCliente').val() == undefined || $('#nacionalidadCliente').val() == null || $('#nacionalidadCliente').val().trim() == ""){ //
	    			$().toastmessage('showErrorToast', "Modifique la nacionalidad, no puede estar vacio y solo puede contener letras");
	    			$('#loading').hide();
	    		    return false;
	    		}
	    		
	    		if( $('#nombreUsuario').val() == undefined || $('#nombreUsuario').val() == null || $('#nombreUsuario').val().trim() == "" || $('#nombreUsuario').val().trim().length < 6){ //
	    			$().toastmessage('showErrorToast', "Modifique el nombre de usuario, no puede estar vacio y debe contener 6 caracteres como minimo");
	    			$('#loading').hide();
	    		    return false;
	    		} 
	    		
	    		if(!contrasenia.test($('#contrasenia').val()) || $('#contrasenia').val() == undefined || $('#contrasenia').val() == null || $('#contrasenia').val().trim() == "" || $('#contrasenia').val().trim().length < 8){ //
	    			$().toastmessage('showErrorToast', "Modifique la contraseña, no puede estar vacia y debe contener al menos 8 caracteres, al menos 1 letra mayuscula, al menos 1 letra minuscula y al menos un numero");
	    			$('#loading').hide();
	    		    return false;
	    		}
	    		
	    		if( $('#direccionCliente').val() == undefined || $('#direccionCliente').val() == null || $('#direccionCliente').val().trim() == "" || $('#direccionCliente').val().trim().length < 4){ //
	    			$().toastmessage('showErrorToast', "Modifique la direccion, no puede estar vacia y debe contener al menos 4 caracteres");
	    			$('#loading').hide();
	    		    return false;
	    		}
	    		
	    		if( $('#provinciaCliente').val() == undefined || $('#provinciaCliente').val() == null || $('#provinciaCliente').val().trim() == ""){ //
	    			$().toastmessage('showErrorToast', "Modifique la provincia, no puede estar vacia");
	    			$('#loading').hide();
	    		    return false;
	    		}
	    		
	    		if( $('#localidadCliente').val() == undefined || $('#localidadCliente').val() == null || $('#localidadCliente').val().trim() == ""){ //
	    			$().toastmessage('showErrorToast', "Modifique la localidad, no puede estar vacia");
	    			$('#loading').hide();
	    		    return false;
	    		}
	    		
	    		return true;
	    	}
	    	//USAMOS JQUERY DATATABLE PARA FORMATEAR EL ESTILO Y LA FUNCIONALIDAD DE PAGINADO Y BUSQUEDA DE LAS TABLAS
		    $(document).ready( function () {
		    	$('#loading').hide(); 
				provChange($("#provinciaCliente")[0]);
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
		    //USAMOS JQUERY PARA COMFIRMAR LAS ACCIONES QUE GENERAN CAMBIOS EN LA BASE DE DATOS
		    $(function() {
		    	   $("#delete_button").click(function(){
		    		   $.confirm({
		    			    title: 'Eliminar',
		    			    content: 'Realmente desea eliminar el usuario?',
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
		  //USAMOS JQUERY PARA COMFIRMAR LAS ACCIONES QUE GENERAN CAMBIOS EN LA BASE DE DATOS
		    $(function() {
		    	   $("#update_button").click(function(){
		    		   $.confirm({
		    			    title: 'Modificar',
		    			    content: 'Realmente desea modificar el usuario?',
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
		  //USAMOS JQUERY PARA COMFIRMAR LAS ACCIONES QUE GENERAN CAMBIOS EN LA BASE DE DATOS
		    $(function() {
		    	   $("#create_button").click(function(){
		    		   $.confirm({
		    			    title: 'Crear',
		    			    content: 'Realmente desea crear el usuario?',
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