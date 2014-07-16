package trasveterinaria.negocio;


import trasveterinaria.dao.ComprobantesDAO;
import trasveterinaria.excepcion.DAOExcepcion;

import trasveterinaria.modelo.Comprobantes;

public class GestionComprobantes {

	public void insertar(Comprobantes ct) throws DAOExcepcion {
	ComprobantesDAO dao= new ComprobantesDAO();
		dao.insertar(ct);
	}
	
}
