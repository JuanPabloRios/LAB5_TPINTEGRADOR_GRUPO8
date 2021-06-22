<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.entidad.Usuario" %> 
<%@page import="LAB5_TPINTEGRADOR_GRUPO8.selector.UsuarioSelector" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Buscar Cliente</title>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="StyleSheet" type="text/css"> 
        <link href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="StyleSheet" type="text/css"> 
        <link href="estilos/AdministradorHome.css" rel="StyleSheet" type="text/css">  
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css"> 
		<link href="estilos/AdministradorHome.css" rel="StyleSheet" type="text/css"> 
	</head>
	<body>
	<div class="mainContainer"> 
		<div class="header">
			<div class="controlesUsuario">
				<div>Banking App</div> 
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
				<div class="tituloPagina">Buscar Cliente a asignar</div>  
			</div>
			<% List<Usuario> clientes = UsuarioSelector.obtenerTodosLosClientes();%>
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
                    <%  if(clientes!=null)
                        for(Usuario c : clientes) { %>
                    <tr>
                          <td>
                              <form method="post" action="clienteSeleccionado.html">
                                  <input class="button" type="submit" value="Seleccionar"></input>
                                  <input type="hidden" name="idUsuario" value="<%=c.getIdusuario() %>" >
                                  <input type="hidden" name="nombreCuenta" value="${nombreCuenta}" >
                              </form>
                          </td>
                        <td><%=c.getApellido()%></td>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getDNI()%></td>
                        <td><%=c.getDireccion()%></td>
                      </tr> 
               <%  } %> 
                </tbody>
            </table>
        </div> 
        <div class="footer"> 
           <div>LAB5 UTN Grupo 8 2021</div> 
    	</div> 
		</div>
		<script type="text/javascript">
		    $(document).ready( function () {
		        $('#tablaClientes').DataTable({ 
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