package trasveterinaria.negocio;

import trasveterinaria.dao.ClienteDAO;
import trasveterinaria.dao.MascotaDAO;
import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.modelo.Mascota;

public class GestionMascota {
	
	public void insertar(Mascota vo) throws DAOExcepcion {
		MascotaDAO dao= new MascotaDAO();
		dao.insertar(vo);
	}
	/*
	public int  eliminar(int vo) throws DAOExcepcion{
		DoctoresDAO dao= new DoctoresDAO();
		int variable;
		 variable= dao.elimina(vo);
		 return variable;
	}
	*/
	public Mascota reporteMascota(int id) throws DAOExcepcion {
		MascotaDAO dao = new MascotaDAO();
		return dao.reporteMascota(id);	
	}
}
