<!DOCTYPE html>
<html lang="en">
  <head>  
	<meta charset="utf-8">	
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Veterinaria">
	<meta name="keywords" content="Veterinaria">
    <meta name="author" content="Veterinbaria - Per�">
	
    <title>Veterinaria</title>
	
	<script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap-3.1.1.js"></script>

	<link href="css/bootstrap-3.1.1.css" rel="stylesheet">	
	<link href="css/bootstrap-theme-3.1.1.css" rel="stylesheet">
	<link href="css/offcanvas.css" rel="stylesheet">	
	
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  	<LINK href="css/calendar-blue.css" type=text/css rel=stylesheet>
	<link href="css/displaytag.css" rel="stylesheet" type="text/css"><!--  //esta la importacion de la hoja de estilo del display--> 

	<SCRIPT src="js/calendar.js" type=text/javascript></SCRIPT>
	<SCRIPT src="js/calendar-es.js" type=text/javascript></SCRIPT>
	<SCRIPT src="js/calendar-setup.js" type=text/javascript></SCRIPT>  
  
  </head>

  <body>
  

    <div class="container">
	     
			<div class="col-md-12">

			  <form class="form-horizontal well" method="post" action="MascotaInsertarServlet" role="form" >
				<fieldset>
				  <legend>Ingresar Mascotas</legend>             
				  
				  <% String x = (String)request.getAttribute("msg");
				  if("ok".equals(x)){
					  out.println("<html><head></head><body onload=\"alert('Ingreso Correcto de Mascota')\"></body></html>");
				  }
				  else if("notok".equals(x)){
					  out.println("<html><head></head><body onload=\"alert('Ingreso Incorrecto de Mascota, No existe due�o')\"></body></html>");
				  }
				  %>
				  				  
				  <div class="control-group">
				  		<p class="help-block">Ingresar datos:</p>
				  		<div class="table-responsive">
				  		<table>
				  		<tr>
				  		<td>Nombre:</td>
				  		<td><input type="text"  name="txtNombre" required/></td>
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
				  		<td><input type="text" name="txtTipoSangre" required/></td>
				  		</tr>
				  		<tr>
				  		<td>Esterilizado:</td>
				  		<td><input type="text" name="txtEsterilizado" required/></td>
				  		</tr>
				  		<tr>
				  		<td>Tama�o:</td>
				  		<td><select name="txtTama�o">
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
						<td><input type="text"  pattern=[0-9]{2} maxlength=2 name="txtPeso" required/></td>
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
				  		<td><input type="text" name="txtAlergia" required/></td>
				  		</tr>
				  		<tr>
				  		<td>DNI Due�o:</td>
				  		<td><input type="text"  pattern=[0-9]{8} maxlength=8 name="txtCliente_Dni" required/></td>
				  		</tr>
				  		<tr>
             			<td>Identificador Raza:</td>
				  		<td><input type="text" pattern=[0-9]{2} maxlength=2 name="txtIdRaza" required/></td>
				  		</tr>
				  		<tr>
				  		<td colspan="2"><button type="submit" class="btn btn-primary">Guardar</button>
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



  </body>
</html>