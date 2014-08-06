function cargaCliente(){
	DWRUtil.removeAllOptions("idDueño");
	UbigeoService.traerClientes(muestraDataCliente);
}
function muestraDataCliente(data){
    DWRUtil.addOptions("idDueño", data,"dni", "persona");
}

