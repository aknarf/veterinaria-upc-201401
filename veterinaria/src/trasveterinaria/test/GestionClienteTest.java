package trasveterinaria.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.negocio.GestionCliente;



public class GestionClienteTest {

	//@Test
	public void insertar(){

		Cliente prod= new Cliente();
		
		prod.setDni("43772655");
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
			Cliente cli = negocio.buscar(prod.getDni());
			if(cli.getNombre()==null){
				negocio.insertar(prod);
				System.out.println("se inserto correctamente");
			}
			else{
				System.out.println("DNI Repetido");
			}
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
	}

	
	//@Test
	public void eliminar(){
	
		String dni="43772652";
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
				negocio.actualizar("Marleni","Samaniego", "Escobar", "horuz0305@outlook", "Oscar R Benavides 367",null, "966192823", "4209158","20501424775","43772652");
				System.out.println("Se actualizo correctamente");
			} catch (DAOExcepcion e) {
				Assert.fail("Falló la actualización: " + e.getMessage());
			}
	}

	//@Test
	public void buscarTest() {
		GestionCliente negocio= new GestionCliente();
			try {
				Cliente dao=negocio.buscar("44544398");
				if(dao.getNombre()==null){
					System.out.println("No se encontro cliente");
				}
				else{
					System.out.println("Cliente encontrado \n");
					System.out.println("CLIENTE");
					System.out.println("--------------------------------------------------------------------------");
					System.out.println(dao.getNombre()+"\t "+dao.getApePaterno()+"\t"+dao.getApeMaterno()+"\t"+dao.getCorreoelectronico()+"\t"+dao.getDireccion()+"\t"+dao.getFoto()+"\t"+dao.getCelular()+"\t"+dao.getTelefonofijo()+"\t"+dao.getRuc()+"\n");
				}
			} catch (DAOExcepcion e) {
				Assert.fail("No se encontro cliente" + e.getMessage());
			}
	}
	
	//@Test
	public void listarTest() {

		GestionCliente negocio = new GestionCliente();
		try {
			Collection<Cliente> listado = negocio.listar();

			System.out.println("Total de registros: "+ listado.size());
			System.out.println("LISTADO DE CLIENTE");
			System.out.println("--------------------------------------------------------------------------");
			for (Cliente categoria : listado) {
				System.out.println(categoria.getDni()+"\t "+categoria.getNombre()+"\t "+categoria.getApePaterno()+"\t"+categoria.getApeMaterno()+"\t"+categoria.getCorreoelectronico()+"\t"+categoria.getDireccion()+"\t"+categoria.getFoto()+"\t"+categoria.getCelular()+"\t"+categoria.getTelefonofijo()+"\t"+categoria.getRuc()+"\n");
			}
			Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}

	@Test
		public void reporteClienteTest() {

			GestionCliente reporteCliente= new GestionCliente();
			try {
				Collection<Cliente> listado = reporteCliente.reporteCliente("44544398");
				
					System.out.println("Cliente encontrado \n");
					System.out.println("CLIENTE");
					System.out.println("--------------------------------------------------------------------------");
					for (Cliente dao : listado) {
					System.out.println(dao.getDni()+"\t "+dao.getNombre()+"\t "+dao.getApePaterno()+"\t "+dao.getApeMaterno()+"\t"+dao.getCantMascota()+"\n");
				}
			} catch (DAOExcepcion e) {
				Assert.fail("No se encontro cliente" + e.getMessage());
			}
		}
}
