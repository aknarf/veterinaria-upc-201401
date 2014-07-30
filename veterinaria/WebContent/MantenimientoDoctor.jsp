<!DOCTYPE html>
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
    
  </head>

  <body>
  

    <div class="container">
	     
			<div class="col-md-12">

			  <form class="form-horizontal well" method="post" action="DoctorServlet" role="form" >
				<fieldset>
				  <legend>Ingresar Doctores</legend>             
				  
				  <div class="control-group">
				  		<p class="help-block">Ingrese los datos:</p>
				  		<br/>
				  		DNI:<input type="text"  pattern=[0-9]{8} maxlength=8 name="txtDni" required/>
				  		<br/>
				  		Nombre:<input type="text" name="txtNombre" required/>
				  		<br/>
				  		Apellido Paterno:<input type="text" name="txtApellidoPaterno" required/>
				  		<br/>
				  		Apellido Materno:<input type="text" name="txtApellidoMaterno" required/>
				  		<br/>
				  		Correo:<input id="email" type="email" name="txtEmail" required placeholder="Ingrese el correo aqui" />
				  		<br/>
				  		Telefono:<input id="phone" type="tel" maxlength=9 name="txtTelefono" required/>
				  		<br/>
						Tipo:<input type="text" list="tipo" name="txtTipo" required/> 
						<datalist id="tipo">
							<option value="Doctor"/>
							<option value="Administrador"/>
						</datalist>
						<br/>
						Password:<input type="password" name="txtPassword" required/>
				  		<br/>
				  		<br/>
				  		<br/>
				  		<button type="submit" class="btn btn-primary">Guardar</button>
						<button type="reset" class="btn">Cancelar</button>  
						<br/>
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