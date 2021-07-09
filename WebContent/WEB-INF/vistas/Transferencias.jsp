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
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>  
		<script src="estilos/toast/javascript/jquery.toastmessage.js"></script>
		<link href="estilos/toast/resources/css/jquery.toastmessage.css" rel="StyleSheet" type="text/css">	
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
			<form id="formTransfer" method="post" action="transferenciaCuenta.html" onsubmit="return validarForm();"> 
				<div class="tituloPaginaContainer">
					<div class="tituloPagina">Realizar transferencia</div>   
				</div>
				<div class="row">
					<div class="column" >
						<label for="nombreClienteGet">${cliente.getNombre()}</label> <label for="apellidoClienteGet">${cliente.getApellido()}</label> 
						<div > 
							<label for="CuentaOrigen">Seleccionar Cuenta de origen </label>
							<select name="CuentaOrigen" id="CuentaOrigen" >
						<% 
							ArrayList<Cuentas> cuentasCliente = null;
						  
							if(request.getAttribute("cuentas")!=null)
							{
								cuentasCliente = (ArrayList<Cuentas>)request.getAttribute("cuentas");
							}		
						  %>
							
						<%  if(cuentasCliente!=null)
								for(Cuentas ci : cuentasCliente) { %> 
							    <option value="<%=ci.getIdNroDeCuenta()%>">Nro: <%=ci.getIdNroDeCuenta()%> CBU: <%=ci.getCBU()%>  Saldo:$ <%=ci.getSaldo() %> </option> 
					    <%  } %>

							</select> 
						</div>
					</div> 
					<div class="column" >
					</div> 
				</div>
				<div class="row">
					<div class="column" >
						<div > 
							<label for="CuentaDestino">Seleccionar cuenta de destino</label>
							<select name="CuentaDestino" id="CuentaDestino" onchange="checkTerceros(this)">
						<% 
							ArrayList<Cuentas> cuentasClient = null;
						  
							if(request.getAttribute("cuentas")!=null)
							{
								cuentasClient = (ArrayList<Cuentas>)request.getAttribute("cuentas");
							}		
						  %>
							
						<%  if(cuentasClient!=null)
								for(Cuentas ci : cuentasClient) { %>
	
							    <option value="<%=ci.getIdNroDeCuenta()%>">Nro: <%=ci.getIdNroDeCuenta()%> CBU: <%=ci.getCBU()%> Saldo:$ <%=ci.getSaldo() %> </option>
								
					    <%  } %>

								<option value="0">Otros por CBU</option>
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
							<input type="text" id="cbu" name="cbu" value="">
						</div>  
					</div> 
					<div class="column" >
					</div> 
				</div>
				<div class="row">
					<div class="column" >
						<label for="nombreCliente">Ingrese el monto a transferir:</label>
						<input type="number" id="Monto" name="Monto" value="" required="required" >
					</div> 
					<div class="column"style="display:flex; justify-content: flex-end;" >
						<div >
					  		<input class="button btnSave" title="Transferir" value="Transferir" id="transfer_button" style="margin-top:10px;"></input>  
							<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
							<input type="hidden" name="idUsuario" value="<%=cliente.getIdusuario()%>"> 
					  	</div>
					</div>
				</div>
				</form>
			</div>
			<div class="footer"> 
	            LAB5 UTN Grupo 8 2021 
		    </div>
	    </div>
   		<%if(request.getAttribute("informarError")!=null) { 
	    	String errorMessage = (String)request.getAttribute("mensajeError"); %>
    		<script>$().toastmessage('showErrorToast', "<%=errorMessage%>");</script>
    	<%} %>
	    
	    <script type="text/javascript">
	    	var porCBU = false;
	    	var numbers = /^[0-9]+$/;
	    	
	    	function validarForm(){ 
	    		if( !porCBU && $('#CuentaOrigen').val() == $('#CuentaDestino').val()){
	    			$().toastmessage('showErrorToast', "No se puede transferir a la misma cuenta.");
	    			return false;
	    		} 
	    		
	    		if(porCBU && !numbers.test($('#cbu').val()) || $('#cbu').val() == undefined || $('#cbu').val() == null || $('#cbu').val().trim() == ""){
	    			$().toastmessage('showErrorToast', "El CBU solo debe contener numeros y no puede estar vacio.");
	    			return false;
	    		} 
	    		
	    		if(porCBU && !validarCBU($('#cbu').val()+'')){
	    			$().toastmessage('showErrorToast', "El CBU ingresado no es valido");
	    			return false;
	    		}
	    		
	    		if( !numbers.test($('#Monto').val()) || $('#Monto').val() == undefined || $('#Monto').val() == null || $('#Monto').val().trim() == "" || $('#Monto').val() < 1 ){
	    			$().toastmessage('showErrorToast', "El monto debe ser como minimo 1 y solo debe contener numeros");
	    			return false;
	    		}
	    		
	    		
	    		return true;
	    	}
	    	

			function checkTerceros(element){ 
				if(element.value == '0'){
					$('#cbuContainer').show();
					porCBU = true;
				} else {
					$('#cbuContainer').hide();
					porCBU = false;
				}
			}
	    	
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
		    

		    $(function() {
		    	   $("#transfer_button").click(function(){
		    		   $.confirm({
		    			    title: 'Transferir',
		    			    content: 'Realmente desea realizar la transferencia?',
		    			    buttons: {
		    			        confirm: {
		    			        	text:"transferir",
		    			        	action: function () {
		    			        		$('#formTransfer').submit();
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
		    
		    	
		    	function validarLargoCBU(cbu) {
		    	  if (cbu.length != 22) { return false }
		    		return true
		    	}

		    	function validarCodigoBanco(codigo) {
			    	 if (codigo.length != 8) { return false }
			    	 var banco = codigo.substr(0,3)
			    	 var digitoVerificador1 = codigo[3]
			    	 var sucursal = codigo.substr(4,3)
			    	 var digitoVerificador2 = codigo[7]
	
			    	 var suma = banco[0] * 7 + banco[1] * 1 + banco[2] * 3 + digitoVerificador1 * 9 + sucursal[0] * 7 + sucursal[1] * 1 + sucursal[2] * 3
	
			    	 var diferencia = (10 - suma % 10) 
						console.log('digitoVerificador2 ' + digitoVerificador2);
						console.log('diferencia ' + diferencia);
			    	 return diferencia == digitoVerificador2
		    	}

		    	function validarCuenta(cuenta) {
			    	 if (cuenta.length != 14) { return false }
			    	 var digitoVerificador = cuenta[13]
			    	 var suma = cuenta[0] * 3 + cuenta[1] * 9 + cuenta[2] * 7 + cuenta[3] * 1 + cuenta[4] * 3 + cuenta[5] * 9 + cuenta[6] * 7 + cuenta[7] * 1 + cuenta[8] * 3 + cuenta[9] * 9 + cuenta[10] * 7 + cuenta[11] * 1 + cuenta[12] * 3
			    	 var diferencia = (10 - suma % 10)
						console.log('digitoVerificador ' + digitoVerificador);
						console.log('diferencia ' + diferencia);
			    	 return diferencia == digitoVerificador
		    	}

		    	function validarCBU(cbu) {
		    		console.log(validarLargoCBU(cbu));
		    		console.log(validarCodigoBanco(cbu.substr(0,8)));
		    		console.log(validarCuenta(cbu.substr(8,14)));
		    		
		    	 	return validarLargoCBU(cbu) && validarCodigoBanco(cbu.substr(0,8)) && validarCuenta(cbu.substr(8,14))
		    	}
		   </script>
	</body>
</html>