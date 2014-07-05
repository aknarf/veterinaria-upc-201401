package trasveterinaria.test;

//import 

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.modelo.Doctores;
import trasveterinaria.negocio.GestionDoctores;

public class GestionDoctoresTest {
	
	
	@Test
	public void insertar(){
		//Doctores cat= new Doctores();
		//cat.setDni(43564198);
		
		Doctores prod= new Doctores();
		//prod.setDni(cat);
		prod.setDni(43564198);
		prod.setNombre("Juanito");
		prod.setApePaterno("Martines");
		prod.setApeMaterno("Rios");
		prod.setEmail("juan@gmail.com");
		prod.setTelefono("3356672");
		prod.setTipo("Administrador");
		prod.setContraseña("Hguy698");
		
		
		GestionDoctores negocio= new GestionDoctores();
		try {
			negocio.insertar(prod);
			System.out.println("se inserto correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
	}

}
