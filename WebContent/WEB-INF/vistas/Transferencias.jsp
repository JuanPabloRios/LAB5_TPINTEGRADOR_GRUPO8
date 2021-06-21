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
		<link href="estilos/Transferencias.css" rel="StyleSheet" type="text/css"> 
		<link href="estilos/Transferencias.css" rel="StyleSheet" type="text/css">  
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
				Usuario cliente = new Usuario();
				if(request.getAttribute("cliente")!=null) {
					cliente = (Usuario)request.getAttribute("cliente"); 
				} %>
			<div class="content">
				<div class="tituloPaginaContainer">
					<div class="tituloPagina">Realizar transferencia</div>  
					
					
				  	 
				</div>
				<label for="nombreClienteGet">${cliente.getNombre()}</label> <label for="apellidoClienteGet">${cliente.getApellido()}</label>
				<% if(request.getAttribute("idUsuario")!=null) { %>
				<div style="border: solid gray 1px; border-radius: 5px; padding:5px; height: 217px" >
					<h4>Seleccionar cuenta de origen</h4>
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
									<form method="post" action="editarCuenta.html">
							  			
							  			
							  			<select name="CuentaDestino" id="CuentaDestino"><option>Seleccione cuenta origen</option></select>
							  			
							  		</form>
								</td>
							    <td><%=ci.getIdNroDeCuenta()%></td>
							    <td><%=ci.getCBU()%></td>
							    <td><%=ci.getTipoCuenta().getDescripcion()%></td>
							    <td><%=ci.getSaldo()%></td>

						  	</tr> 
					    <jsp:scriptlet>  } } </jsp:scriptlet>
						</tbody>
					</table>
				</div>
				<div style="border: solid gray 1px; border-radius: 5px; padding:5px; height: auto" >
				<h4>Seleccionar cuenta de destino</h4>
				<table id="tablaCuentas" class="table table-striped table-bordered" style="width:100%;">
						<thead>
						  <tr> 
						  	<th></th>
						    <th>Nro CUENTA</th>
						    <th>CBU</th>
						    <th>NOMBRE</th>
						  </tr>
					 	</thead>
	       				<tbody> 	
							<tr> 
								<td>
									<form method="post" action="editarCuenta.html">
							  			<select name="CuentaDestino" id="CuentaDestino"><option>Seleccione cuenta destino</option></select>
							  		</form>
								</td>
							    <td><jsp:expression></jsp:expression></td>
							    <td><jsp:expression></jsp:expression></td>
							    <td><jsp:expression></jsp:expression></td>
						  	</tr> 
						</tbody>
					</table>
				</div>
			</div><br><label for="nombreCliente">Ingrese el monto a transferir:</label>  <input type="text" id="Monto" name="Monto" value="" required="required"><br><br><input type="submit" title="RealizarTransferencia" value="Realizar transferencia" class="button btnHeader">  
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
	    </script>
	</body>
</html>