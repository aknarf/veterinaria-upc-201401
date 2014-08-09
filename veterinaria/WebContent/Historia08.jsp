<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta name="description" content="Veterinaria">
	<meta name="keywords" content="Veterinaria">
    <meta name="author" content="Veterinbaria">
	
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>Veterinaria</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.1.1.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  <!-- Static navbar -->
	  <div class="navbar navbar-default navbar-static-top">
	    <div class="container">
	      <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="principal.jsp">Veterinaria</a>
	      </div>
	      <div class="navbar-collapse collapse">
	        <ul class="nav navbar-nav">
	          <li><a href="principal.jsp">Inicio</a></li>
	          <li class="dropdown active">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantenimientos <b class="caret"></b></a>
	            <ul class="dropdown-menu">
	              <li><a href="IngresarDoctor.jsp">Ingresar Doctores</a></li>
	              <li><a href="BuscarDoctor.jsp">Buscar Doctores</a></li>
	              <li><a href="IngresarClientes.jsp">Ingresar Clientes</a></li>
	              <li><a href="BuscarClientes.jsp">Buscar Clientes</a></li>	              
	            </ul>
	          </li>
	          <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes <b class="caret"></b></a>
	          <ul class="dropdown-menu">
	          	<li><a href="Historia08.jsp">Reporte de dueños</a></li>
	          	<li><a href="Historia09.jsp">Reporte de pacientes</a></li>
	          	<li><a href="#">Reporte de atenciones</a></li>
	          	</ul>
	          </li>       
	          <li><a href="LogoutServlet">Salir</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>

        
   	 <div class="container"> 


		<p><strong>Reporte de dueños</strong></p>
		
		<form id="form1" name="form1" method="post" action="Historia08Servlet" class="form-horizontal" role="form">
		  <p>Buscar: 
		    <label>
		    <input type="text" name="dni" id="dni" />
		    </label>
		    <label>
		    <button type="submit" name="button" id="button" >Buscar</button>
		    </label>
		   	</p>
		</form>
		<div class="table-responsive">
		<table width="550" height="65" border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		  <tr>
		  	<th scope="col">Nro.</th>
		    <th scope="col">DNI</th>
		    <th scope="col">Nombre</th>
		    <th scope="col">Ape. Paterno</th>
		    <th scope="col">Ape. Materno</th>
		    <th scope="col">Cantidad</th>
		    
		  </tr>
		
		<%@page import="java.util.*,trasveterinaria.modelo.Cliente, trasveterinaria.modelo.Mascota" %>
		<%
		ArrayList<Cliente> arreglo = (ArrayList<Cliente>)request.getAttribute("clientes");
		if(arreglo !=null){
		int i = 1;
		for (Cliente x: arreglo){
			
		%>  
		  <tr>
		  	<td><%=i++ %></td>
		    <td><% out.print(x.getDni()); %></td>
		    <td><% out.print(x.getNombre()); %></td>
		    <td><% out.print(x.getApePaterno()); %></td>
		    <td><% out.print(x.getApeMaterno()); %></td>
		    <td><% out.print(x.getCantMascota());%></td>
		    
		    
		    
		  </tr>
		<%  } 
		  } %>
		  
		</table>
		</div>

 		<!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; Veterinaria Peru </p>
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
