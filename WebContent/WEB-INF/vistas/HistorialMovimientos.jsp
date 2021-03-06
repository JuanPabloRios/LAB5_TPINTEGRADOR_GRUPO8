<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList" %>
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario" %> 
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Cuentas" %>  
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Movimientos" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Historial de cuenta</title>
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="StyleSheet" type="text/css"> 
		<link href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="StyleSheet" type="text/css"> 
		<link href="estilos/AdministradorHome.css" rel="StyleSheet" type="text/css"> 
		<link href="estilos/ABMCliente.css" rel="StyleSheet" type="text/css">  
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
		<% 
			Cuentas cuenta = new Cuentas();
			if(request.getAttribute("cuenta")!=null) {
				cuenta = (Cuentas)request.getAttribute("cuenta"); 
			} 
		%>
		<div class="mainContainer">  
			<div class="header">
				<div class="controlesUsuario">
					<div>Banking App</div>
					<div style="display:flex; flex-direction:row;"> 
						<form method="post" action="irAClienteHome.html" onsubmit="$('#loading').show();">
							<input type="submit" title="Home" value="Home" class="button btnHeader"></input>
							<input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
							<input type="hidden" name="idUsuario" value="<%=cuenta.getUsuario().getIdusuario()%>" >
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
			<div class="content">
			<div class="tituloPaginaContainer">
				<div class="tituloPagina">Historial de Movimientos</div>  
			</div>
	
			<div style="border: solid gray 1px; border-radius: 5px; padding:5px; height: auto" >
			<h4>Historial de movimientos - Cuenta Nro. ${cuenta.getIdNroDeCuenta()}</h4>
			<table id="tablaCuentas" class="table table-striped table-bordered" style="width:100%;">
					<thead>
					  <tr>  
					    <th style="width: 146px;">FECHA</th>
					    <th>TIPO</th>
					    <th>IMPORTE</th>
					    <th>DETALLE</th>  
					  </tr>
				 	</thead>
				 		<tbody> 
        				<% 
							ArrayList<Movimientos> movimiento = null;
						  
							if(request.getAttribute("listarMovimientos")!=null)
							{
								movimiento = (ArrayList<Movimientos>)request.getAttribute("listarMovimientos");
							}		
						  %>
							
							<%  if(movimiento!=null)
								for(Movimientos m : movimiento) { %>
							<tr>
							    <td><%=m.getFecha()%></td> 
						    	<td><%=m.getTipoMovimiento().getDescripcion()%></td> 
						    	
							    <%  if(m.getTipoMovimiento().getDescripcion().equals("DEBITO")){ %> 
							    	<td>&#45; <%=m.getImporte()%></td>
							     <%  } else { %> 
							    	<td><%=m.getImporte()%></td>
							     <%  } %> 
							    <td><%=m.getDetalle()%></td>							    
						  	</tr> 
					   <%  } %> 
						</tbody>
				</table>
			</div>
			</div>
			<div class="footer"> 
		    	<div>LAB5 UTN Grupo 8 2021</div> 
			</div> 
	   	</div>
		    <script type="text/javascript">
			    $(document).ready( function () { 
			    	$('#loading').hide();
			        $('#tablaCuentas').DataTable({
			        	"searching": true,
			        	"paging": true,
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