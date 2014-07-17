package trasveterinaria.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.modelo.Mascota;
import trasveterinaria.negocio.GestionCliente;
import trasveterinaria.negocio.GestionDoctores;
import trasveterinaria.negocio.GestionMascota;

public class GestionMascotaTest {
	
	//@Test
	public void insertar(){
		
		Mascota prod= new Mascota();
		prod.setIdMascota(47);
		prod.setNombre("Firulais");
		prod.setGenero("Macho");
		prod.setTipoSangre("0+");
		prod.setEsterilizado("No");
		prod.setTamaño("Grande");
		prod.setActividad("Alta");
		prod.setPeso(12);
		prod.setFechaNacimiento(null);
		prod.setAlergia("Sí");
		prod.setCliente_Dni(44541798);
		prod.setRaza_idRaza(13);
		
		
		GestionMascota negocio= new GestionMascota();
		try {
			negocio.insertar(prod);
			System.out.println("se inserto correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
	}
	
	//@Test
	public void eliminarTest(){
		int idMascota=47;			
		GestionMascota negocio=new GestionMascota();
		try {
			negocio.eliminar(idMascota);
			System.out.println("se elimino correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No inserto" + e.getMessage());
		}		
	}
	
	@Test
	public void listarTest() {
		GestionMascota negocio = new GestionMascota();
		try {
			Collection<Mascota> listado = negocio.listar();
			System.out.println("Total de registros: "+ listado.size());
			System.out.println("            LISTADO DE MASCOTAS");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("CODIGO"+"   \t"+"NOMBRE MASCOTA"+" \t\t"+"GENERO");
			System.out.println("--------------------------------------------------------------------------");
			for (Mascota categoria : listado) {
				System.out.println(categoria.getIdMascota()+"\t\t "+categoria.getNombre()+"\t\t\t"+categoria.getGenero()+"\n");
			}
			Assert.assertTrue(listado.size() > 0);			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	/*
	@Test
	public void reporteMascotaTest() {

		GestionMascota reporteMascota= new GestionMascota();
		try {
			Mascota dao=reporteMascota.reporteMascota(14);
			if(dao.getNombre()==null){
				System.out.println("No se encontro cliente");
			}
			else{
				System.out.println("Cliente encontrado \n");
				System.out.println("CLIENTE");
				System.out.println("--------------------------------------------------------------------------");
				System.out.println(dao.getDni()+"\t "+dao.getNombre()+"\t "+dao.getApePaterno()+"\t "+dao.getApeMaterno()+"\t"+dao.getCantMascota()+"\n");
			}
		} catch (DAOExcepcion e) {
			Assert.fail("No se encontro cliente" + e.getMessage());
		}
	}*/

}
