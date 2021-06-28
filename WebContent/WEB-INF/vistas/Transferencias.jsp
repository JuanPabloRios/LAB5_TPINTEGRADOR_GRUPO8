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
			<form id="formTransfer" method="post" action="transferenciaCuenta.html"> 
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
	
							    <option value="<%=ci.getIdNroDeCuenta()%>">Nro. De Cuenta: <%=ci.getIdNroDeCuenta()%> CBU: <%=ci.getCBU()%></option>

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
	
							    <option value="<%=ci.getIdNroDeCuenta()%>">Nro. De Cuenta: <%=ci.getIdNroDeCuenta()%> CBU: <%=ci.getCBU()%></option>
								
					    <%  } %>

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
							<input type="text" id="cbu" name="cbu" value="" minlength="22" maxlength="22" onkeypress="return validateCBU(event);" >
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

						<input type="number" id="Monto" name="Monto" value="" required="required" onkeypress="return validate(this,event);"> 

					</div> 
					<div class="column"style="display:flex; justify-content: flex-end;" >
						<div >
					  		<input class="button btnSave" title="Transferir" value="Transferir" id="transfer_button" style="margin-top:10px;"></input>  
							<input type="hidden" name="nombreCuenta" value="${nombreCuenta}"></input>
					  	</div>
					</div> 
				
				</div>
				</form>
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
		    	
		    	function validateCBU(evt){
    

    var code = (evt.which) ? evt.which : evt.keyCode;
    
    if(code==8) {
      return true;
    } else if(code>=48 && code<=57) { 
      return true;
    } else{ 
      return false;
    }
}
		    	
		    	
		   </script>
	</body>
</html>