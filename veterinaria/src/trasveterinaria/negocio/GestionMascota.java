package trasveterinaria.negocio;

import trasveterinaria.dao.MascotaDAO;
import trasveterinaria.excepcion.DAOExcepcion;
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
	
}
