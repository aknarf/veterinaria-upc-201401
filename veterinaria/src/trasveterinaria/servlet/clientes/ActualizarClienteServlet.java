package trasveterinaria.servlet.clientes;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.negocio.GestionCliente;

/**
 * Servlet implementation class ActualizarClienteServlet
 */
@WebServlet("/ActualizarClienteServlet")
public class ActualizarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarClienteServlet() {
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
		
		String dni = request.getParameter("txtDni");
		String Nonbre = request.getParameter("txtNombre");
		String ApePaterno = request.getParameter("txtApellidoPaterno");
		String ApeMaterno = request.getParameter("txtApellidoMaterno");
		String Email = request.getParameter("txtEmail");
		String Direcccion = request.getParameter("txtDireccion");
		String Celular = request.getParameter("txtCelular");
		String Telefono = request.getParameter("txtTelefono");
		String Ruc = request.getParameter("txtRuc");
		
		GestionCliente negocio = new GestionCliente();
		try {
			negocio.actualizar(Nonbre,ApePaterno,ApeMaterno,Email,Direcccion,null,Celular,Telefono,Ruc,dni);
			
				Collection<Cliente> lista = negocio.buscarPorNombre("");
				request.setAttribute("clientes", lista);
				RequestDispatcher rd = request.getRequestDispatcher("BuscarClientes.jsp");
				rd.forward(request, response);
			
		} catch (DAOExcepcion e) {
			  System.out.println(e.toString());
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	
	}

}
