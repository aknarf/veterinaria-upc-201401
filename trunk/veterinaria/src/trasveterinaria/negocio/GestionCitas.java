package trasveterinaria.negocio;

import java.util.Collection;

import trasveterinaria.dao.CitasDAO;
import trasveterinaria.dao.DoctoresDAO;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Citas;
import trasveterinaria.modelo.Doctores;


public class GestionCitas {
	
	public void insertar(Citas ct) throws DAOExcepcion {
		CitasDAO dao= new CitasDAO();
		dao.insertar(ct);
	}
	public Citas buscar(int idCita) throws DAOExcepcion {
		CitasDAO dao = new CitasDAO();
		return dao.buscar(idCita);	
	}

	public Collection<Citas> listarVacuna() throws DAOExcepcion {
		CitasDAO dao = new CitasDAO();
		return dao.listar();
	}


}
