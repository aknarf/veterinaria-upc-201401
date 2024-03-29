<!DOCTYPE html>
<html lang="en">

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
	            </ul>
	          </li>
	          <li><a href="#">Reportes</a></li>	          
	          <li><a href="LogoutServlet">Salir</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
      
	 <div class="container"> </div>
	   
<%@page import="trasveterinaria.modelo.Cliente;"%>
<%
Cliente vo = (Cliente)request.getAttribute("vo");
%>

    <div class="container">
	     
			<div class="col-md-12">

			  <form class="form-horizontal well" method="post" action="ActualizarClienteServlet" role="form" >
				<fieldset>
				  <legend>Editar Cliente</legend>             
				  

				  				  
				  <div class="control-group">
				  		<p class="help-block">Editar los datos:</p>
				  		<div class="table-responsive">
				  		<table>
				  		<tr>
				  		<td>DNI:</td>
				  		<td><input type="text"  pattern=[0-9]{8} maxlength=8 name="txtDni"  readonly required
				  		value="<%=vo.getDni()%>" />
				  		</td>
				  		</tr>
				  		<tr>
				  		<td>Nombre:</td>
				  		<td><input type="text" name="txtNombre" required
				  		value="<%=vo.getNombre()%>"/>
				  		</td>
				  		</tr>
				  		<tr>
				  		<td>Apellido Paterno:</td>
				  		<td><input type="text" name="txtApellidoPaterno" required
				  		value="<%=vo.getApePaterno()%>"/>
				  		</td>
				  		</tr>
				  		<tr>
				  		<td>Apellido Materno:</td>
				  		<td><input type="text" name="txtApellidoMaterno" required
				  		value="<%=vo.getApeMaterno()%>"/>
				  		</td>
				  		</tr>
				  		<tr>
				  		<td>Correo:</td>
				  		<td><input id="email" type="email" name="txtEmail" required placeholder="Ingrese el correo aqui"
				  		value="<%=vo.getCorreoelectronico()%>"/>
				  		</td>
				  		</tr>
				  		<tr>
				  		<td>Direcci�n:</td>
				  		<td><input id="direccion" type="text" name="txtDireccion" required"
				  		value="<%=vo.getDireccion()%>"/>
				  		</td>
				  		</tr>
				  		<tr>
				  		<td>Celular:</td>
				  		<td><input id="phone" type="tel" maxlength=9 name="txtCelular" required
				  		value="<%=vo.getCelular()%>"/>
				  		</td>
				  		<tr>
				  		<td>Telefono:</td>
				  		<td><input id="phone" type="tel" maxlength=9 name="txtTelefono" required
				  		value="<%=vo.getTelefonofijo()%>"/>
				  		</td>
				  		</tr>
				  		<tr>
				  		<tr>
				  		<td>RUC:</td>
				  		<td><input id="ruc" type="text" name="txtRuc" required"
				  		value="<%=vo.getRuc()%>"/>
				  		</td>
				  		</tr>
				  		<td colspan="2"><button type="submit" class="btn btn-primary">Actualizar</button>
						<button type="reset" class="btn">Cancelar</button></td>
						</tr>  
						</table>
						</div>	
					 </div>	 
				</fieldset>
			  </form>

			</div>
			
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