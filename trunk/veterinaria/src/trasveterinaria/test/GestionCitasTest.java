package trasveterinaria.test;

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.modelo.Citas;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.negocio.GestionCitas;
import trasveterinaria.negocio.GestionDoctores;

public class GestionCitasTest {
	
	@Test
	public void insertar(){
		Citas ct= new Citas();
		ct.setFeha("20140701");
		ct.setEstado("POR ATENDER");
		ct.setCantidad("2");
		ct.setNotasMedicas("MASCOTA CON PROBLEMA ALIMENTICIOS");
		ct.setImagen("C:imagen1.jpg");
		ct.setTipo("EMERGENCIA");
		ct.setIdtarea(21);
		ct.setIdmascota(11);
		ct.setDnidoc(43532198);
		
	
		
		GestionCitas negocio= new GestionCitas();
		try {
			negocio.insertar(ct);
			System.out.println("se inserto correctamente");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
	}

}
