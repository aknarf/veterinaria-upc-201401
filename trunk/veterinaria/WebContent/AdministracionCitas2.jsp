<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">	
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Veterinaria">
	<meta name="keywords" content="Veterinaria">
    <meta name="author" content="Veterinbaria">
	
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

  <div>
     <div class="col-md-12">
       <form class="form-horizontal well" method="post" action="IngresarDoctorServlet" role="form" >
        <fieldset>
          <legend>Ingresar Citas</legend>
           <div class="control_group">
             <p class="help-block">Ingresar datos:</p>
				  		<div class="table-responsive">
				  		<table>
				  		<tr>
				  		<td>Nro Cita :</td>
				  		<td><input type="text"   name="txtcita" /></td>
				  		</tr>
				  		<tr>
				  		<td>Fecha de Atencion:</td>
				  		<td><input type="text" id="campo_fecha1" readonly="readonly" name="txtFecha" required /></td>
				  		 <td><input type="button" id="lanzador1"  value="..." >
                 <SCRIPT type=text/javascript>
	               Calendar.setup({inputField :"campo_fecha1",ifFormat:"%Y-%m-%d",button:"lanzador1"});
                 </SCRIPT>
             </td>
				  		</tr>
				  		<tr>
				  		<td>Tipo:</td>
				  		<td>
				  		<select name="cboTipo">
				  		<option value="EMERGENCIAS" selected="selected">EMERGENCIAS</option>
				  		<option value="CITAS">CITAS</option>
				  		
				  		</select>
				  		</td>
				  		</tr>
				  		<tr>
				  		<td>Estado:</td>
				  		<td>
                           <select name="cboEstado">
                           <option value="PENDIENTE">PENDIENTE</option>
                           <option value="ATENDIDO">ATENDIDO</option>
                           
                           </select>
</td>
				  		</tr>
				  		<tr>
				  		<td>Dueño:</td>
				  		<td><input id="dueño" type="dueño" name="txtDueño" required placeholder="Ingrese Dueño" /></td>
				  		<td><input type="button" value="..."> </td>
				  		</tr>
				  		<tr>
				  		<td>Mascota:</td>
				  		<td>
				  		<select name="cboMascota"> 
				  		<option>--selecione--</option>
				  		</select>
				  		</td>
				  		</tr>
				  		<tr>
						<td>Doctor: </td>
						<td><select name="cboDoctor">
							<option  selected>--Seleccione--</option>
							
						</select></td>
						</tr>
						<tr>
						<td>Imagen Medica:</td>
						<td><input type="Imagen" name="txtImagen" required/></td>
						<td><input type="button" value="..."> </td>		 
				  		</tr>
				  		<tr>
				  		 <td>Notas Medicas:</td>
				  		 <td><textarea name="txtSNotas"></textarea></td>
				  		</tr>
				  		<tr>
				  		<td>Atencion:</td>
				  		<td>
				  		<textarea name="txtSAtencion"></textarea>
				  		</td>
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

</body>
</html>