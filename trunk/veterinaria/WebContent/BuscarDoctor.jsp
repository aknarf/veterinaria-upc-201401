<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta name="description" content="Veterinaria">
	<meta name="keywords" content="Veterinaria">
    <meta name="author" content="Veterinbaria">
	
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>Trastienda</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.1.1.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
        
   	 <div class="container"> 


		<p><strong>Mantenimiento de Doctores</strong></p>
		
		<form id="form1" name="form1" method="post" action="BuscarDoctorServlet" class="form-horizontal" role="form">
		  <p>Buscar: 
		    <label>
		    <input type="text" name="txtDni" id="txtDni" />
		    </label>
		    <label>
		    <button type="submit" name="button" id="button" >Buscar</button>
		    </label>
		    <label>
		   <!--   <input type="button" name="button2" id="button2" value="Nuevo" onclick="window.location='roles_nuevo.jsp' "  />-->
		    </label>
		  </p>
		</form>
		<div class="table-responsive">
		<table width="550" height="65" border="5" cellpadding="0" cellspacing="0" class="table table-hover">
		  <tr>
		    <th scope="col">Nro.</th>
		    <th scope="col">DNI</th>
		    <th scope="col">Nombre</th>
		    <th scope="col">Ape. Paterno</th>
		    <th scope="col">Ape. Materno</th>
		    <th scope="col">Email</th>
		    <th scope="col">Telefono</th>
		    <th scope="col">Tipo</th>
		  </tr>
		
		<%@page import="java.util.*,trasveterinaria.modelo.Doctores" %>
		<%
		Collection<Doctores> arreglo = (ArrayList<Doctores>)request.getAttribute("doctores");
		if(arreglo != null) { 
		int i = 1;
		for(Doctores x : arreglo) {
		%>  
		  <tr>
		    <td><%=i++ %></td>
		    <td><% out.print(x.getDni()); %></td>
		    <td><% out.print(x.getNombre()); %></td>
		    <td><% out.print(x.getApePaterno()); %></td>
		    <td><% out.print(x.getApeMaterno()); %></td>
		    <td><% out.print(x.getEmail()); %></td>
		    <td><% out.print(x.getTelefono()); %></td>
		    <td><% out.print(x.getTipo()); %></td>
		    <td><a href="<%=request.getContextPath() %>/EditarDoctorServlet?id=<%=x.getDni() %>">Editar</a> - <a href="<%=request.getContextPath()%>
		/EliminarDoctorServlet?id=<%=x.getDni()%>" onclick="return confirm('¿Está seguro que desea eliminar');">Eliminar</a></td>
		  </tr>
		<% }  
		  } %>
		  
		</table>
		</div>

 		<!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; RCondezo 2014 </p>
	   </div>
	   
	 </div> <!-- /container -->
    
   


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap-3.1.1.js"></script>
  </body>
</html>
