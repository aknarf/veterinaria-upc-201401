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
	
	
	@Test
	public void listarVacunasTest() {
		GestionCitas negocio = new GestionCitas();
		try {
			Collection<Citas> listado = negocio.listarVacunas();
			System.out.println("Total de registros: "+ listado.size());
			for (Citas categoria : listado) {
				System.out.println("            LISTADO DE DOCTORES");
				System.out.println("--------------------------------------------------------------------------");
				System.out.println(categoria.getIdcita()+"\t "+categoria.getFeha()+"\t"+categoria.getEstado()+"\t"+categoria.getTarea()+"\t"+categoria.getTipo()+"\t"+categoria.getNombreMascota()+"\t"+categoria.getNombCliente()+" "+categoria.getApePatCliente()+" "+categoria.getApeMatCliente()+"\n");
			}
			Assert.assertTrue(listado.size() > 0);			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
