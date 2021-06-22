<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<div class="tituloPaginaContainer">
			<div class="tituloPagina">Historial de Movimientos</div>  
		</div>

		<div style="border: solid gray 1px; border-radius: 5px; padding:5px; height: auto" >
		<h4>Historial de movimientos - Cuenta Nro. ${ci.getIdNroDeCuenta()}</h4>
		<table id="tablaCuentas" class="table table-striped table-bordered" style="width:100%;">
				<thead>
				  <tr>  
				    <th>FECHA</th>
				    <th>TIPO</th>
				    <th>IMPORTE</th> 
				  </tr>
			 	</thead>
      				<tbody> 	
					<tr> 
						<td></td>
					    <td></td>
					    <td></td> 
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