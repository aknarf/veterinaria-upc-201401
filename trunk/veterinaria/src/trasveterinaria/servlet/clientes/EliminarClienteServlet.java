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
 * Servlet implementation class EliminarClienteServlet
 */
@WebServlet("/EliminarClienteServlet")
public class EliminarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Dentro de doGet del servlet Eliminar Cliente Servlet");
		
		String a = request.getParameter("dni");
		String x = "";
			
		
		GestionCliente cliente = new GestionCliente();
		try {
			cliente.eliminar(a);
					
				Collection<Cliente> lista = cliente.buscarPorNombre(x);
				request.setAttribute("clientes", lista);
				
				RequestDispatcher rd = request.getRequestDispatcher("BuscarClientes.jsp");
				rd.forward(request, response);
			
			
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
