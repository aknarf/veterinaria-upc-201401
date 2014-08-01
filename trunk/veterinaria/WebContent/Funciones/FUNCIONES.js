	function linkeo(marco,pagina){
		document.frames.marco.location=pagina;
	}
	 
	function regresar(pagina){
		document.forms[0].action=pagina;
		document.forms[0].submit();	
	}

	function abrirVentanaConsulta(pagina){ 
		var miPopup 
	    miPopup = window.open(pagina,'sad',"toolbar=0,status=1,menubar=0,scrollbars=1,aling=center,resizable=0,location=0,width=420,height=200"); 
	    miPopup.focus;
	}
	