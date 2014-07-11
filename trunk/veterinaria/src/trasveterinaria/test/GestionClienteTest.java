package trasveterinaria.test;

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.modelo.Cliente;
import trasveterinaria.negocio.GestionCliente;

public class GestionClienteTest {

	@Test
	public void insertar(){

		Cliente prod= new Cliente();
		
		prod.setDni(43564198);
		prod.setNombre("Juanito");
		prod.setApePaterno("Martines");
		prod.setApeMaterno("Rios");
		prod.setCorreoelectronico("juan@gmail.com");
		prod.setDireccion("Oscar R. Benavides 366");
		prod.setFoto(null);
		prod.setCelular("966192822");
		prod.setTelefonofijo("4209158");
		prod.setRuc("20501424774");
			
		
		GestionCliente negocio= new GestionCliente();
		try {
			negocio.insertar(prod);
			System.out.println("se inserto correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
	}
}
