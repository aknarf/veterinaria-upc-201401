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
 * Servlet implementation class Historia08Servlet
 */
@WebServlet("/Historia08Servlet")
public class Historia08Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Historia08Servlet() {
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
		
		System.out.println("Dentro de doPost del servlet Historia08 Servlet");
		String dni = request.getParameter("dni");
			
		GestionCliente negocio = new GestionCliente();
		try {
			Collection<Cliente> c = negocio.reporteCliente(dni);
			
			// Guardar en el ambiente de request
			
			request.setAttribute("cliente", c);
			RequestDispatcher rd = request
					.getRequestDispatcher("Historia08.jsp");
			rd.forward(request, response);
			System.out.println("CORRECTO ");

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
