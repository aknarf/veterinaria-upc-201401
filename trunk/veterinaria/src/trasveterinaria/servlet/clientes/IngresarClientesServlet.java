package trasveterinaria.servlet.clientes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;

import trasveterinaria.modelo.Cliente;
import trasveterinaria.negocio.GestionCliente;

/**
 * Servlet implementation class IngresarClientesServlet
 */
@WebServlet("/IngresarClientesServlet")
public class IngresarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String DNIDoc = request.getParameter("txtDni");
		String Nonbre = request.getParameter("txtNombre");
		String ApePaterno = request.getParameter("txtApellidoPaterno");
		String ApeMaterno = request.getParameter("txtApellidoMaterno");
		String Email = request.getParameter("txtEmail");
		String Direccion = request.getParameter("txtDireccion");
		String Celular = request.getParameter("txtCelular");
		String Telefono = request.getParameter("txtTelefono");
		String Ruc = request.getParameter("txtRuc");
		
		Cliente prod= new Cliente();
			
		prod.setDni(DNIDoc);
		prod.setNombre(Nonbre);
		prod.setApePaterno(ApePaterno);
		prod.setApeMaterno(ApeMaterno);
		prod.setCorreoelectronico(Email);
		prod.setDireccion(Direccion);
		prod.setFoto(null);
		prod.setCelular(Celular);
		prod.setTelefonofijo(Telefono);
		prod.setRuc(Ruc);
		
			
		GestionCliente negocio= new GestionCliente();
		
		try {
			Cliente cli = negocio.buscar(prod.getDni());
			if(cli.getNombre()==null){
				negocio.insertar(prod);
				System.out.println("se inserto correctamente");
				request.setAttribute("msg", "ok");
				RequestDispatcher rd = request.getRequestDispatcher("/IngresarClientes.jsp");
				rd.forward(request, response);	
			}
			else{
				System.out.println("DNI Repetido");
				request.setAttribute("msg", "notok");
				RequestDispatcher rd = request.getRequestDispatcher("/IngresarClientes.jsp");
				rd.forward(request, response);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
	}

}
