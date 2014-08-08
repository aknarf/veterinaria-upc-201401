<!DOCTYPE html>

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
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
	          <li><a href="#">Reportes</a></li>	          
	          <li><a href="LogoutServlet">Salir</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
      
<div class="container">  </div>

				  
				  
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


		<p><strong>Mantenimiento de Clientes</strong></p>
		
		<form id="form1" name="form1" method="post" action="BuscarClientesServlet" class="form-horizontal" role="form">
		<% String d = (String)request.getAttribute("msg");
				  if("ok".equals(d)){
					  out.println("<html><head></head><body onload=\"alert('Se edito el Cliente')\"></body></html>");
				  }
				  else if("notok".equals(d)){
					  out.println("<html><head></head><body onload=\"alert('Edicion Incorrecto de Cliente, DNI o correo duplicado')\"></body></html>");
				  }
				  %>
		  <p>Buscar: 
		    <label>
		    <input type="text" name="txtDni" id="txtDni" />
		    </label>
		    <label>
		    <button type="submit" name="button" id="button" >Buscar</button>
		    </label>
		    <label>
		   	<input type="button" name="button2" id="button2" value="Nuevo" onclick="window.location='IngresarClientes.jsp' "  />
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
		    <th scope="col">Email</th>
		    <th scope="col">Dirección</th>
		    <th scope="col">Celular</th>
		    <th scope="col">Telefono Fijo</th>
		    <th scope="col">Ruc</th>
		  </tr>
		
		<%@page import="java.util.*,trasveterinaria.modelo.Cliente" %>
		<%
		Collection<Cliente> arreglo = (ArrayList<Cliente>)request.getAttribute("clientes");
		if(arreglo != null) { 
		int i = 1;
		for(Cliente x : arreglo) {
		%>  
		  <tr>
		    <td><%=i++ %></td>
		    <td><% out.print(x.getDni()); %></td>
		    <td><% out.print(x.getNombre()); %></td>
		    <td><% out.print(x.getApePaterno()); %></td>
		    <td><% out.print(x.getApeMaterno()); %></td>
		    <td><% out.print(x.getCorreoelectronico()); %></td>
		    <td><% out.print(x.getDireccion()); %></td>
		    <td><% out.print(x.getCelular()); %></td>
		    <td><% out.print(x.getTelefonofijo()); %></td>
		    <td><% out.print(x.getRuc()); %></td>
		    <td><a href="<%=request.getContextPath() %>/EditarClienteServlet?dni=<%=x.getDni()%>">Editar</a> - <a href="<%=request.getContextPath()%>
		/EliminarDoctorServlet?dni=<%=x.getDni()%>" onclick="return confirm('¿Está seguro que desea eliminar');">Eliminar</a></td>
		  </tr>
		<% }  
		  } %> 
		  
		</table>
		</div>

  
	 </div> <!-- /container -->
    
    <footer>
        <p>&copy; Veterinaria Peru</p>
    </footer>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap-3.1.1.js"></script>
  </body>
</html>
