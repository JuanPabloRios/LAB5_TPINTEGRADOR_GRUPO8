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
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>  
		<script src="estilos/toast/javascript/jquery.toastmessage.js"></script>
		<link href="estilos/toast/resources/css/jquery.toastmessage.css" rel="StyleSheet" type="text/css">	
	</head>
	<body> 
		<% 
		Usuario cliente = new Usuario();
		if(request.getAttribute("usuario")!=null) {
			cliente = (Usuario)request.getAttribute("usuario"); 
		} %>
		<div class="mainContainer"> 
			<div class="header">
				<div class="controlesUsuario">
					<div>Banking App</div>
					<div style="display:flex; flex-direction:row;"> 
						<!-- <form method="post" action="irAClienteHome.html">
							<input type="submit" title="Home" value="Home" class="button btnHeader"></input>
							<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
							<input type="hidden" name="nombreCuenta" value="<%=cliente.getIdusuario()%>" >
						</form>  -->
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
					<div class="tituloPagina">Home Cliente</div>   	
					<div class="botonPrincipalContainer">
						<form method="post" action="irATransferencia.html">
				  			<input class="button btnNuevoCliente" type="submit" title="Realizar transferencia" value="Realizar transferencia"></input> 
				  			<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
				  			<input type="hidden" name="idUsuario" value="<%=cliente.getIdusuario()%>" >
				  		</form>
				  	</div> 
				</div>   
				<% if(request.getAttribute("usuario")!=null) { %>
				<div style="border: solid gray 1px; border-radius: 5px; padding:5px; height: 217px" >
					<h4>Cuentas</h4>
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
	       				<% 
							ArrayList<Cuentas> cuentasCliente = null;
						  
							if(request.getAttribute("listaCuentas")!=null)
							{
								cuentasCliente = (ArrayList<Cuentas>)request.getAttribute("listaCuentas");
							}		
						  %>
							
						<%  if(cuentasCliente!=null)
								for(Cuentas ci : cuentasCliente) { %>
							<tr> 
								<td>
									<form method="post" action="verMovimientosCuenta.html">
							  			<input class="button" type="submit" value="Ver movimientos">
							  			<input type="hidden" name="idUsuario" value="<%=cliente.getIdusuario()%>" >
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
			</div>  
			<% } %>
			<div class="footer"> 
	            <div>LAB5 UTN Grupo 8 2021</div> 
		    </div>
	    </div>
	       <%if(request.getAttribute("informarTransferenciaExitosa")!=null)
	    	{  	
	    	%>
	    <script>console.log("ENTRAMOS EN EL IF"); $().toastmessage('showSuccessToast', "Transferencia realizada con exito.");</script>
	    	<%}
	    %>
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
	    </script>
	</body>
</html>