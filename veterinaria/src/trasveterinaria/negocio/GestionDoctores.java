package trasveterinaria.negocio;

import java.util.Collection;

import javax.security.auth.login.LoginException;

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
		 variable= dao.eliminar(vo);
		 return variable;
	}
	
	public Doctores actualizar(String nombre,String apePaterno,String apeMaterno, String email,
			String telefono, String tipo, String contraseña,int dni) throws DAOExcepcion {
		DoctoresDAO dao = new DoctoresDAO();
		Doctores vo = new Doctores();
		
		vo.setNombre(nombre);
		vo.setApePaterno(apePaterno);
		vo.setApeMaterno(apeMaterno);
		vo.setEmail(email);
		vo.setTelefono(telefono);
		vo.setTipo(tipo);
		vo.setContraseña(contraseña);
		vo.setDni(dni);
		
		return dao.actualizar(vo);
	}

	public Collection<Doctores> listar() throws DAOExcepcion {
		DoctoresDAO dao = new DoctoresDAO();
		return dao.listar();
	}
	
	public Doctores buscar(int dni) throws DAOExcepcion {
		DoctoresDAO dao = new DoctoresDAO();
		return dao.buscar(dni);	
	}

	public Doctores validar(String email, String contraseña) throws DAOExcepcion, LoginException {
		DoctoresDAO dao = new DoctoresDAO();
		return dao.validar(email,contraseña);	
	}
}
