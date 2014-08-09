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
	              <li><a href="IngresarClientes.jsp">Ingresar Clientes</a></li>
	              <li><a href="BuscarClientes.jsp">Buscar Clientes</a></li>
	              <li><a href="mascota_nuevo.jsp">Ingresar Paciente</a></li>
	              <li><a href="mascota_buscar.jsp">Buscar Pacientes</a></li>
	            </ul>
	          </li>
	          <li><a href="#">Reportes</a></li>	          
	          <li><a href="LogoutServlet">Salir</a></li>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>

<%@page import="trasveterinaria.modelo.Mascota;"%>
<%
Mascota vo = (Mascota)request.getAttribute("vo");
%>

<div class="container">
	     
			<div class="col-md-12">

			  <form class="form-horizontal well" method="post" action="MascotaActualizarServlet" role="form" >
				<fieldset>
				  <legend>Editar Mascotas</legend>             
				  

				  				  
				  <div class="control-group">
				  		<p class="help-block">Editar los datos:</p>
				  		<div class="table-responsive">
				  		<table>
				  		<tr>
				  		<td>ID:</td>
				  		<td><input type="text"  pattern=[0-9]{4} maxlength=4 name="txtIdMascota"  readonly required
				  		value="<%=vo.getIdMascota()%>" />
				  		</td>
				  		</tr>
				  		<tr>
				  		<td>Nombre:</td>
				  		<td><input type="text"  name="txtNombre" required
				  		value="<%=vo.getNombre()%>" /></td>
				  		</tr>
				  		<tr>
				  		<td>Genero:</td>
				  		<td><select name="txtGenero">
							<option value="MACHO" selected>Macho</option>
							<option value="HEMBRA">Hembra</option>
						</select></td>
				  		</tr>
				  		<tr>
				  		<td>Tipo Sangre:</td>
				  		<td><input type="text" name="txtTipoSangre" required
				  		value="<%=vo.getTipoSangre()%>" /></td>
				  		</tr>
				  		<tr>
				  		<td>Esterilizado:</td>
				  		<td><input type="text" name="txtEsterilizado" required
				  		value="<%=vo.getEsterilizado()%>" /></td>
				  		</tr>
				  		<tr>
				  		<td>Tamaño:</td>
				  		<td><select name="txtTamaño">
							<option value="GRANDE" selected>Grande</option>
							<option value="MEDIANO">Mediano</option>
							<option value="CHICO">Chico</option>
						</select></td>
				  		</tr>
				  		<tr>
				  		<td>Actividad:</td>
				  		<td><select name="txtActividad">
							<option value="ALTA" selected>Alta</option>
							<option value="BAJA">Baja</option>
						</select></td>
				  		</tr>
				  		<tr>
						<td>Peso: </td>
						<td><input type="text"  pattern=[0-9] maxlength=2 name="txtPeso" required
						value="<%=vo.getPeso()%>" /></td>
						</tr>
						<tr>
						<td>Fecha de Nacimiento:</td>
						<td><input type="text" id="campo_fecha1" readonly="readonly" name="txtFechaNacimiento" required/>
						<input type="button" id="lanzador1"  value="..." >
                 		<SCRIPT type=text/javascript>
	               			Calendar.setup({inputField :"campo_fecha1",ifFormat:"%Y-%m-%d",button:"lanzador1"});
                 		</SCRIPT>
             			</td>
             			</tr>
             			<tr>
             			<td>Alergia:</td>
				  		<td><input type="text" name="txtAlergia" required
				  		value="<%=vo.getAlergia()%>" /></td>
				  		</tr>
				  		<tr>
				  		<td>DNI Dueño:</td>
				  		<td><input type="text"  pattern=[0-9]{8} maxlength=8 name="txtCliente_Dni" readonly required
				  		value="<%=vo.getCliente_Dni()%>" /></td>
				  		</tr>
				  		<tr>
             			<td>Identificador Raza:</td>
				  		<td><input type="text" pattern=[0-9]{2} maxlength=2 name="txtIdRaza" required
				  		value="<%=vo.getRaza_idRaza()%>" /></td>
				  		</tr>
				  		<tr>
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