package trasveterinaria.negocio;

import trasveterinaria.dao.DoctoresDAO;
import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Doctores;

public class GestionDoctores {
	
	public void insertar(Doctores vo) throws DAOExcepcion {
		DoctoresDAO dao= new DoctoresDAO();
		dao.insertar(vo);
	}
	public int  eliminar(int vo) throws DAOExcepcion{
		DoctoresDAO dao= new DoctoresDAO();
		int variable;
		 variable= dao.elimina(vo);
		 return variable;
	}
	/*public int actualizar(Doctores vo) throws  DAOExcepcion{
		DoctoresDAO dao= new DoctoresDAO();
		dao.actualizar(vo);
	}*/

}
