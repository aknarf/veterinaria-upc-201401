package trasveterinaria.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Citas;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.negocio.GestionCitas;
import trasveterinaria.negocio.GestionDoctores;

public class GestionCitasTest {
	
	//@Test
	public void insertar(){
		Citas ct= new Citas();
		ct.setFecha("20140701");
		ct.setEstado("POR ATENDER");
		ct.setCantidad("2");
		ct.setNotas("MASCOTA CON PROBLEMA ALIMENTICIOS");
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
	
	
	//@Test
/*	public void listarVacunasTest() {
		GestionCitas negocio = new GestionCitas();
		try {
			Collection<Citas> listado = negocio.listarVacun();
			System.out.println("Total de registros: "+ listado.size());
			for (Citas categoria : listado) {
				System.out.println("            LISTADO DE DOCTORES");
				System.out.println("--------------------------------------------------------------------------");
				System.out.println(categoria.getFeha()+"\t"+categoria.getEstado()+"\t"+categoria.getTipo());
			}
			Assert.assertTrue(listado.size() > 0);			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}*/
	@Test
	public void listarTest() {
		GestionCitas negocio = new GestionCitas();
		try {
			Collection<Citas> listado = negocio.listarVacuna();
			System.out.println("Total de registros: "+ listado.size());
			System.out.println("                            LISTADO DE DOCTORES");
			System.out.println("--------------------------------------------------------------------------");
			
			for (Citas categoria : listado) {
				
				System.out.println(categoria.getFecha()+"\t "+categoria.getEstado()+"\t"+categoria.getNotas()+"\t"+categoria.getTipo());
			}
			Assert.assertTrue(listado.size() > 0);			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
