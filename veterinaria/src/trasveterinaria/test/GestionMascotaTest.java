package trasveterinaria.test;

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.modelo.Mascota;
import trasveterinaria.negocio.GestionMascota;

public class GestionMascotaTest {
	
	@Test
	public void insertar(){
		
		Mascota prod= new Mascota();
		prod.setIdMascota(101);
		prod.setNombre("Firulais");
		prod.setGenero("Macho");
		prod.setTipoSangre("0+");
		prod.setEsterilizado("No");
		prod.setTamaño("Grande");
		prod.setActividad("Alta");
		prod.setPeso(12);
		prod.setFechaNacimiento(null);
		prod.setAlergia("Sí");
		prod.setCliente_Dni(43564198);
		prod.setEspecie_idEspecie(201);
		
		
		GestionMascota negocio= new GestionMascota();
		try {
			negocio.insertar(prod);
			System.out.println("se inserto correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
	}

}
