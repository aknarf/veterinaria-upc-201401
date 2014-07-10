package trasveterinaria.negocio;

import trasveterinaria.dao.ClienteDAO;
import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Cliente;

public class GestionCliente {

	public void insertar(Cliente vo) throws DAOExcepcion {
		ClienteDAO dao= new ClienteDAO();
		dao.insertar(vo);
	}
}
