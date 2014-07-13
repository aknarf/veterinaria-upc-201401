package trasveterinaria.negocio;

import java.io.File;
import java.util.Collection;

import trasveterinaria.dao.ClienteDAO;
import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Cliente;



public class GestionCliente {

	public void insertar(Cliente vo) throws DAOExcepcion {
		ClienteDAO dao= new ClienteDAO();
		dao.insertar(vo);
	}

	public int  eliminar(int vo) throws DAOExcepcion{
		ClienteDAO dao= new ClienteDAO();
		int variable;
		 variable= dao.eliminar(vo);
		 return variable;
	}
	
	public Cliente actualizar(String nombre, String apePaterno, String apeMaterno, String correoelectronico, 
			String direccion, File foto, String celular, String telefonofijo, String ruc, int dni) throws DAOExcepcion {
		
		ClienteDAO dao = new ClienteDAO();

		Cliente vo = new Cliente();
		
		vo.setNombre(nombre);
		vo.setApePaterno(apePaterno);
		vo.setApeMaterno(apeMaterno);
		vo.setCorreoelectronico(correoelectronico);
		vo.setDireccion(direccion);
		vo.setFoto(foto);
		vo.setCelular(celular);
		vo.setTelefonofijo(telefonofijo);
		vo.setRuc(ruc);
		vo.setDni(dni);

		return dao.actualizar(vo);
	}
	
	public Cliente buscar(int dni) throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();
		System.out.println("CLIENTE");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println(dao.buscar(dni).getNombre()+"\t "+dao.buscar(dni).getApePaterno()+"\t"+dao.buscar(dni).getApeMaterno()+"\t"+dao.buscar(dni).getCorreoelectronico()+"\t"+dao.buscar(dni).getDireccion()+"\t"+dao.buscar(dni).getFoto()+"\t"+dao.buscar(dni).getCelular()+"\t"+dao.buscar(dni).getTelefonofijo()+"\t"+dao.buscar(dni).getRuc()+"\n");
		return dao.buscar(dni);	
	}
	
	public Collection<Cliente> listar() throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();
		return dao.listar();
	}
}
