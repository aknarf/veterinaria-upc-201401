function foco(){
	document.getElementById("txtCodigo").focus();
}

function limpiar(){
	document.getElementById("txtCodigo").value="";
}

function buscaVendedor(){
	var codigo = document.getElementById("txtCodigo").value;
	VendedorService.obtenerPorPK(muestraData,codigo);
}

function muestraData(data){
	document.getElementById("txtNombre").value = data.nombre;
	document.getElementById("txtEdad").value = data.edad;
	document.getElementById("txtDistrito").value = data.distrito;
	document.getElementById("txtEstado").value = data.estadoCivil;	
	limpiar();foco();
}
