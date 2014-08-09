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
	              <li><a href="mascota_nuevo.jsp">Ingresar Pacientes</a></li>
	              <li><a href="mascota_buscar.jsp">Buscar Pacientes</a></li>	
	              <li><a href="AdministracionCitas2.jsp">Citas</a></li>
	                            
	            </ul>
	          </li>
	          <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes <b class="caret"></b></a>
	          <ul class="dropdown-menu">
	          	<li><a href="Historia08.jsp">Reporte de dueños</a></li>
	          	<li><a href="#">Reporte de pacientes</a></li>
	          	<li><a href="#">Reporte de atenciones</a></li>
	          	</ul>
	          </li>	          
	          <li><a href="LogoutServlet">Salir</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>

	  <div class="container"> 

		<p><strong>Mantenimiento de Pacientes &gt; Buscar</strong></p>
		
		<form id="form1" name="form1" method="post" action="MascotaBuscarServlet" class="form-horizontal" role="form">
		  <p>Buscar: 
		    <label>
		    <input type="text" name="nombre" id="nombre" />
		    </label>
		    <label>
		    <input type="submit" name="button" id="button" value="Buscar" />
		    </label>
		    <label>
		    <input type="button" name="button2" id="button2" value="Nuevo" onclick="window.location='roles_nuevo.jsp' "  />
		    </label>
		  </p>
		</form>
		<div class="table-responsive">
		<table width="550" height="65" border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		  <tr>
		    <th width="49" scope="col">Nro.</th>
		    <th width="192" scope="col">Nombre</th>
		    <th width="107" scope="col">Dueño al que pertenece</th>
		    <th width="192" scope="col">Acciones</th>
		  </tr>
		
		<%@page import="java.util.*, trasveterinaria.modelo.Mascota" %>
		<%
		Collection<Mascota> arreglo = (ArrayList<Mascota>)request.getAttribute("Mascotas");
		if(arreglo != null) { 
		int i = 1;
		for(Mascota x : arreglo) {
		%>  
		  <tr>
		    <td><%=i++ %></td>
		    <td><% out.print(x.getNombre()); %></td>
		    <td><% out.print(x.getCliente_Dni()); %></td>
		    <td><a href="<%=request.getContextPath() %>/MascotaEditarServlet?id=<%=x.getNombre() %>">Editar</a> - <a href="<%=request.getContextPath()%>
		/MascotaEliminarServlet?id=<%=x.getNombre()%>" onclick="return confirm('¿Está seguro que desea eliminar');">Eliminar</a> - <a href="<%=request.getContextPath()%>
		/MascotaInformacionServlet?id=<%=x.getNombre()%>">Información detallada</a></td>
		  </tr>
		<% }  
		  } %>
		  
		</table>
		</div>
	
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
	