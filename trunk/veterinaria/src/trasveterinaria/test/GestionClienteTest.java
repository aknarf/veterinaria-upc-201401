package trasveterinaria.test;

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.negocio.GestionCliente;


public class GestionClienteTest {

	//@Test
	public void insertar(){

		Cliente prod= new Cliente();
		
		prod.setDni(43772652);
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

	
	//@Test
	public void eliminar(){
	
		int dni=43772652;
		GestionCliente negocio= new GestionCliente();
		
		try {
			negocio.eliminar(dni);
			System.out.println("se elimino correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No elimino" + e.getMessage());
		}
	}
	

	//@Test
	public void actualizarTest() {
		GestionCliente negocio= new GestionCliente();
			try {
				negocio.actualizar("Marleni","Samaniego", "Escobar", "horuz0305@outlook", "Oscar R Benavides 367",null, "966192823", "4209158","20501424775",43772652);
				System.out.println("Se actualizo correctamente");
			} catch (DAOExcepcion e) {
				Assert.fail("Falló la actualización: " + e.getMessage());
			}
	}

	@Test
	public void buscarTest() {
		GestionCliente negocio= new GestionCliente();
			try {
				negocio.buscar(43772652);
				} catch (DAOExcepcion e) {
				Assert.fail("No se encontro cliente" + e.getMessage());
			}
	}

}
