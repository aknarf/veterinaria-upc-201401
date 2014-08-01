<html>
<head>
<link href="Funciones/FUNCIONES.js">
<LINK href="css/calendar-blue.css" type=text/css rel=stylesheet>
<link href="css/displaytag.css" rel="stylesheet" type="text/css"><!--  //esta la importacion de la hoja de estilo del display--> 

<SCRIPT src="js/calendar.js" type=text/javascript></SCRIPT>
<SCRIPT src="js/calendar-es.js" type=text/javascript></SCRIPT>
<SCRIPT src="js/calendar-setup.js" type=text/javascript></SCRIPT>
</head>
<body>
<form action="">


		<table>

			<tr>
				<td>Cell</td>
				<td>Cell</td>
				<td>Cell</td>
			</tr>
			<tr>
				<td>Nro Cita :</td>
				<td><input type="text" name="txtCita" id="txtCita"></td>
				<td></td>
			</tr>
			<tr>
				<td>Fecha de Atencion:</td>
				<td><input type="text" name="fechaIni" id="campo_fecha1" readonly="readonly"></td>
             <td><input type="button" id="lanzador1"  value="..." >
                 <SCRIPT type=text/javascript>
	               Calendar.setup({inputField :"campo_fecha1",ifFormat:"%Y-%m-%d",button:"lanzador1"});
                 </SCRIPT>
             </td>
			</tr>
			<tr>
				<td>Tipo:</td>
				<td><select name="cboTipo">
				<option>--Seleccione--</option>
				<option value="EMERGENCIAS">EMERGENCIAS</option>
				<option value="CITAS">CITAS</option>
				
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td>Estado :</td>
				<td><select name="cboEstado">
				<option >--Seleccione--</option>
				<option value="PENDIENTE">PENDIENTE</option>
				<option value="ATENDIDO">ATENDIDO</option>
				</select></td>
				<td></td>

			</tr>
			<tr>
				<td>Dueño:</td>
				<td><input type="text" name="txtDueño" id="txtDueño"></td>
				<td><input type="button" value="..." onclick="abrirVentanaConsulta('buscarDueño.jsp')"></td>
			</tr>
			<tr>
				<td>Mascota</td>
				<td><select name="cboMascota">
				
				<option>--Seleccione--</option>
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td>Doctor</td>
				<td><select name="cboDcotor">
				<option>--Seleccione--</option>
				</select></td>
				<td><input type="submit" value="..."></td>
			</tr>
			<tr>
				<td>Imagen Medicaa:</td>
				<td><input type="text" name="txtImagen" id="txtImagen"></td>
				<td><input type="submit" value="..."></td>
			</tr>
			<tr>
				<td>Notas Medicas:</td>
				<td><textarea></textarea></td>
				<td></td>
			</tr>
			<tr>
				<td>Atencion :</td>
				<td><textarea></textarea></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Agregar" ></td>
				<td><input type="submit" value="Modificar"></td>
				<td><input type="submit" value="Eliminar"></td>
			</tr>
			
		</table>
	</form>

</body>
</html>