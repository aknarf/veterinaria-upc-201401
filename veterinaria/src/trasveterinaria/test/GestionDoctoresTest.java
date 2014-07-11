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
		//Doctores cat= new Doctores();
		//cat.setDni(43564198);
		
		Doctores prod= new Doctores();
		//prod.setDni(cat);
		prod.setDni(43564199);
		prod.setNombre("Carmen");
		prod.setApePaterno("Casas");
		prod.setApeMaterno("Ojeda");
		prod.setEmail("asdfsd@gmail.com");
		prod.setTelefono("3356673");
		prod.setTipo("Doctora");
		prod.setContraseña("sadsada");
		
		
		GestionDoctores negocio= new GestionDoctores();
		try {
			negocio.insertar(prod);
			System.out.println("se inserto correctamente");
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

		//Doctores cat= new Doctores();
		//cat.setDni(43564198);
		int dni=43564198;
		// Doctores prod= new Doctores();				
		GestionDoctores negocio=new GestionDoctores();
		try {
			negocio.eliminar(dni);
			System.out.println("se elimino correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No inserto" + e.getMessage());
		}		
	}

	@Test
	public void listarTest() {

		GestionDoctores negocio = new GestionDoctores();
//DniDoc,Nombre,ApePaterno,ApeMaterno,Tipo 
		try {
			Collection<Doctores> listado = negocio.listar();

			System.out.println("Total de registros: "+ listado.size());
			
			for (Doctores categoria : listado) {
				System.out.println("            LISTADO DE DOCTORES");
				System.out.println("--------------------------------------------------------------------------");
				System.out.println(categoria.getDni()+"\t "+categoria.getNombre()+"\t"+categoria.getApePaterno()+"\t"+categoria.getApeMaterno()+"\t"+categoria.getTipo()+"\n");
				/*System.out.println(categoria.getNombre());
				System.out.println(categoria.getApePaterno());
				System.out.println(categoria.getApeMaterno());
				System.out.println(categoria.getTipo()); */
			}
			
			Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
}
