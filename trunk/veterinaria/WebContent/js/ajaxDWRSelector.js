function cargaCliente(){
	DWRUtil.removeAllOptions("idDue�o");
	UbigeoService.traerClientes(muestraDataCliente);
}
function muestraDataCliente(data){
    DWRUtil.addOptions("idDue�o", data,"dni", "persona");
}

