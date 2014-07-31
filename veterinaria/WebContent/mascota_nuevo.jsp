<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->
<title>Veterinaria Perú - Nueva mascota</title>
<!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.1.1.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<p><strong>Mantenimiento de Roles &gt; Nuevo</strong></p>
<form id="form1" name="form1" method="post" action="RolInsertarServlet" class="form-horizontal" role="form">
  <table width="300" height="104" border="1" cellpadding="0" cellspacing="0">
    <tr>
      <td>Nombre:</td>
      <td><label>
        <input type="text" name="nombre" id="nombre" />
      </label></td>
    </tr>
    <tr>
      <td>Descripción:</td>
      <td><label>
        <input type="text" name="descripcion" id="descripcion" />
      </label></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Guardar" />
        <input type="button" value="Regresar" onclick="window.location='roles_buscar.jsp' " />
      </td>
    </tr>
  </table> 
  <p>&nbsp;</p>
</form>


 <!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; RCondezo 2014 </p>
	   </div>
	   
	 </div> <!-- /container -->
    

</body>
</html>