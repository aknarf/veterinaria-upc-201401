package trasveterinaria.negocio;

import java.sql.Date;
import java.util.Collection;

import trasveterinaria.dao.ClienteDAO;
import trasveterinaria.dao.DoctoresDAO;
import trasveterinaria.dao.MascotaDAO;
import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.modelo.Mascota;

public class GestionMascota {
	
	public void insertar(Mascota vo) throws DAOExcepcion {
		MascotaDAO dao= new MascotaDAO();
		dao.insertar(vo);
	}
	
	public int  eliminar(int vo) throws DAOExcepcion{
		MascotaDAO dao= new MascotaDAO();
		int variable;
		 variable= dao.eliminar(vo);
		 return variable;
	}
	
	public Mascota actualizar(String Nombre,String Genero,String TipoSangre, String Esterilizado,
			String Tamaño, String Actividad, int Peso,Date FechaNacimiento, String Alergia) throws DAOExcepcion {
		MascotaDAO dao = new MascotaDAO();
		Mascota vo = new Mascota();
		
		vo.setNombre(Nombre);
		vo.setGenero(Genero);
		vo.setTipoSangre(TipoSangre);
		vo.setEsterilizado(Esterilizado);
		vo.setTamaño(Tamaño);
		vo.setActividad(Actividad);
		vo.setPeso(Peso);
		vo.setFechaNacimiento(FechaNacimiento);
		vo.setAlergia(Alergia);
		
		return dao.actualizar(vo);
	}
	
	public Collection<Mascota> listar() throws DAOExcepcion {
		MascotaDAO dao = new MascotaDAO();
		return dao.listar();
	}
	
	public Collection<Mascota> buscarPorNombre(String nombre) throws DAOExcepcion {
		MascotaDAO dao = new MascotaDAO();
		return dao.listar();
	}
	
	/*
	public Mascota reporteMascota(int id) throws DAOExcepcion {
		MascotaDAO dao = new MascotaDAO();
		return dao.reporteMascota(id);	
	}
	*/
}
