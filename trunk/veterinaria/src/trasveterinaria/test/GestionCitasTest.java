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
	public void listarVacunasTest() {
		GestionCitas negocio = new GestionCitas();
		try {
			Collection<Citas> listado = negocio.listarVacuna();
			System.out.println("Total de registros: "+ listado.size());
			System.out.println("                            LISTADO DE VACUNACIONES");
			System.out.println("                                                                                                           ");
			System.out.println("FECHA DE REGISTRO"+"\t"+"ESTADO DE LA CITA"+"\t"+"NOTAS MEDICAS"+"\t\t"+"TIPO DE SERVICIO"+"\t"+"MASCOTA"+"\t"+"DNI CLIENTE"+"\t"+"CLIENTE");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
			for (Citas categoria : listado) {
				
				System.out.println(categoria.getFecha()+"\t "+categoria.getEstado()+
						"\t"+categoria.getNotas()+"\t"+ categoria.getDescripcionTarea()+"              "+
						categoria.getNomMascota()+"\t"+categoria.getDniCliente()+"\t"+categoria.getNomCliente()+" "+categoria.getApePatCliente());
			}
			Assert.assertTrue(listado.size() > 0);			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	//@Test
	public void listarTareasTest() {
		GestionCitas negocio = new GestionCitas();
		try {
			Collection<Citas> listado = negocio.listarTarea();
			System.out.println("Total de registros: "+ listado.size());
			System.out.println("                            LISTADO DE VACUNACIONES");
			System.out.println("                                                                                                           ");
			System.out.println("FECHA DE REGISTRO"+"\t"+"ESTADO DE LA CITA"+"\t"+"NOTAS MEDICAS"+"\t\t"+"TIPO DE SERVICIO"+"\t"+"MASCOTA"+"\t"+"DNI CLIENTE"+"\t"+"CLIENTE");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
			for (Citas categoria : listado) {
				
				System.out.println(categoria.getFecha()+"\t "+categoria.getEstado()+
						"\t"+categoria.getNotas()+"\t"+ categoria.getDescripcionTarea()+"\t"+
						categoria.getNomMascota()+"\t"+categoria.getDniCliente()+"\t"+categoria.getNomCliente()+" "+categoria.getApePatCliente()+"\n");
			}
			Assert.assertTrue(listado.size() > 0);			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
