package trasveterinaria.test;

//import 

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.negocio.GestionDoctores;

public class GestionDoctoresTest {
	
	
	//@Test
	public void insertar(){
		Doctores prod= new Doctores();
		
		prod.setDni(43564190);
		prod.setNombre("Carmen");
		prod.setApePaterno("Casas");
		prod.setApeMaterno("Ojeda");
		prod.setEmail("asdfsd@gmail.com");
		prod.setTelefono("3356673");
		prod.setTipo("Doctora");
		prod.setContraseña("sadsada");
		
		GestionDoctores negocio= new GestionDoctores();
		try {
			Doctores doc=negocio.buscar(prod.getDni());
			if(doc.getNombre()==null){
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
    public void actualizarTest() {
			GestionDoctores negocio = new GestionDoctores();
			try {
				negocio.actualizar("Marleni","Samaniego", "Escobar", "horuz0305@outlook", "335668", "Administradora", "55bjhdfasj",43564198);
			} catch (DAOExcepcion e) {
				Assert.fail("Falló la actualización: " + e.getMessage());
			}
		}
	

	//@Test
	public void eliminarTest(){
		int dni=43564190;			
		GestionDoctores negocio=new GestionDoctores();
		try {
			negocio.eliminar(dni);
			System.out.println("se elimino correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No inserto" + e.getMessage());
		}		
	}

	//@Test
	public void listarTest() {
		GestionDoctores negocio = new GestionDoctores();
		try {
			Collection<Doctores> listado = negocio.listar();
			System.out.println("Total de registros: "+ listado.size());
			System.out.println("            LISTADO DE DOCTORES");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("DNI"+"      \t\t"+"DOCTOR"+"   \t\t\t\t"+"CARGO");
			System.out.println("--------------------------------------------------------------------------");
			for (Doctores categoria : listado) {
				System.out.println(categoria.getDni()+"\t "+categoria.getNombre()+" "+categoria.getApePaterno()+" "+categoria.getApeMaterno()+"\t\t\t"+categoria.getTipo()+"\n");
			}
			Assert.assertTrue(listado.size() > 0);			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	@Test
	public void buscarTest() {
		GestionDoctores negocio= new GestionDoctores();
			try {
				Doctores dao=negocio.buscar(43532198);
				if(dao.getNombre()==null){
					System.out.println("No se encontro Doctor");
				}
				else{
					System.out.println("Cliente encontrado \n");
					System.out.println("CLIENTE");
					System.out.println("--------------------------------------------------------------------------");
					System.out.println(dao.getNombre()+"\t "+dao.getApePaterno()+"\t"+dao.getApeMaterno()+"\t"+dao.getEmail()+"\t"+dao.getTelefono()+"\t"+dao.getTipo()+"\t"+dao.getContraseña()+"\n");
				}
			} catch (DAOExcepcion e) {
				Assert.fail("No se encontro cliente" + e.getMessage());
			}
	}
}
