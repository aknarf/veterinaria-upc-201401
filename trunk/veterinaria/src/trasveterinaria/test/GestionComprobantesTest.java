package trasveterinaria.test;

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.modelo.Citas;
import trasveterinaria.modelo.Comprobantes;
import trasveterinaria.negocio.GestionCitas;
import trasveterinaria.negocio.GestionComprobantes;

public class GestionComprobantesTest {
	@Test
	public void insertarComprobantes(){
		Comprobantes ct= new Comprobantes();
		/*ct.setFecha("20140701");
		ct.setEstado("POR ATENDER");
		ct.setCantidad("2");
		ct.setNotas("MASCOTA CON PROBLEMA ALIMENTICIOS");
		ct.setImagen("C:imagen1.jpg");
		ct.setTipo("EMERGENCIA");
		ct.setIdtarea(21);
		ct.setIdmascota(11);
		ct.setDnidoc(43532198);*/
		ct.setNroComprobante(00001);
		ct.setCorrelativo("11");
		ct.setTipo("FACTURA");
		ct.setDireccion("AV LIMA");
		ct.setFechaRegistro("20140601");
		ct.setNroCita(4);
		
	
		
		GestionComprobantes negocio= new GestionComprobantes();
		try {
			negocio.insertar(ct);
			System.out.println("se inserto correctamente");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
	}

}
