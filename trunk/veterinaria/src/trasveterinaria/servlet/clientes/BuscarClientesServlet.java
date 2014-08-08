package trasveterinaria.servlet.clientes;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.negocio.GestionCliente;

/**
 * Servlet implementation class BuscarClientesServlet
 */
@WebServlet("/BuscarClientesServlet")
public class BuscarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarClientesServlet() {
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
		
		System.out.println("Dentro de doPost del servlet Buscar Cliente");
		String x = request.getParameter("nombre");
			
		GestionCliente negocio = new GestionCliente();
		try {
			Collection<Cliente> lista = negocio.buscarPorNombre(x);
			
			// Guardar en el ambiente de request
			
			request.setAttribute("clientes", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("BuscarClientes.jsp");
			rd.forward(request, response);
			System.out.println("CORRECTO ");

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
