<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home</title> 
		
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="StyleSheet" type="text/css"> 
		<link href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" rel="StyleSheet" type="text/css"> 
		<link href="estilos/AdministradorHome.css" rel="StyleSheet" type="text/css"> 
	</head>
	<body>
		<div class="mainContainer">
			
				<div class="header">
					<div class="controlesUsuario">
						<div>Banking App</div>
						<div><button action="" class="button btnHeader">ABM Cuentas</button></div>
					</div>
					<div class="controlesUsuario">
						<div>${nombreCuenta}</div>
						<div class="salirContainer">
							<button action="" class="button btnHeader">Salir</button>
						</div>
					</div>
				</div> 
				
				<div class="content">
					<div class="tituloPaginaContainer">
						<div class="tituloPagina">Clientes</div> 
						<div class="botonPrincipalContainer"><button class="button btnNuevoCliente" title="Nuevo Cliente" action="">Nuevo Cliente</button></div> 
					</div>
					
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
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Rios</td>
						    <td>Ezequiel Matias</td>
						    <td>35343432</td>
						    <td>Reynoso 2245, Don Torcuato, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Gomez</td>
						    <td>Maria</td>
						    <td>12312312</td>
						    <td>La Habana 2245, Don Torcuato, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Perez</td>
						    <td>Andrea</td>
						    <td>43556987</td>
						    <td>Av. Siempreviva 123, Springfield, Queensland</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Carlos</td>
						    <td>Riquelme</td>
						    <td>98345879</td>
						    <td>Cacharrito 3213, Balvanera, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Tobias</td>
						    <td>Diaz Caruso</td>
						    <td>34223569</td>
						    <td>Sucre 4265, Capital Federal, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Gutierrez</td>
						    <td>Claudia</td>
						    <td>54645434</td>
						    <td>Av. Del Libertador 123, San Isidro, Buenos Aireas</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Rios</td>
						    <td>Ezequiel Matias</td>
						    <td>35343432</td>
						    <td>Reynoso 2245, Don Torcuato, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Gomez</td>
						    <td>Maria</td>
						    <td>12312312</td>
						    <td>La Habana 2245, Don Torcuato, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Perez</td>
						    <td>Andrea</td>
						    <td>43556987</td>
						    <td>Av. Siempreviva 123, Springfield, Queensland</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Carlos</td>
						    <td>Riquelme</td>
						    <td>98345879</td>
						    <td>Cacharrito 3213, Balvanera, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Tobias</td>
						    <td>Diaz Caruso</td>
						    <td>34223569</td>
						    <td>Sucre 4265, Capital Federal, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Gutierrez</td>
						    <td>Claudia</td>
						    <td>54645434</td>
						    <td>Av. Del Libertador 123, San Isidro, Buenos Aireas</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Rios</td>
						    <td>Ezequiel Matias</td>
						    <td>35343432</td>
						    <td>Reynoso 2245, Don Torcuato, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Gomez</td>
						    <td>Maria</td>
						    <td>12312312</td>
						    <td>La Habana 2245, Don Torcuato, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Perez</td>
						    <td>Andrea</td>
						    <td>43556987</td>
						    <td>Av. Siempreviva 123, Springfield, Queensland</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Carlos</td>
						    <td>Riquelme</td>
						    <td>98345879</td>
						    <td>Cacharrito 3213, Balvanera, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Tobias</td>
						    <td>Diaz Caruso</td>
						    <td>34223569</td>
						    <td>Sucre 4265, Capital Federal, Buenos Aires</td>
						  </tr>
						  <tr>
						  	<td><button class="button" value="Editar" action="">Editar / Eliminar</button></td>
						    <td>Gutierrez</td>
						    <td>Claudia</td>
						    <td>54645434</td>
						    <td>Av. Del Libertador 123, San Isidro, Buenos Aireas</td>
						  </tr>
						  
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