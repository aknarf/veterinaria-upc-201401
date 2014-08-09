package trasveterinaria.servlet.citas;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Citas;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.negocio.GestionCitas;
import trasveterinaria.negocio.GestionCliente;

/**
 * Servlet implementation class Historia09Servlet
 */
@WebServlet("/Historia09Servlet")
public class Historia09Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Historia09Servlet() {
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
		
		System.out.println("Dentro de doPost del servlet Historia09 Servlet");
		String x = request.getParameter("mes");
		int m = Integer.parseInt(x);
			
		GestionCitas negocio = new GestionCitas();
		try {
			Collection<Citas> lista = negocio.reporteMeses(m);
			
			// Guardar en el ambiente de request
			
			request.setAttribute("citas", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("Historia09.jsp");
			rd.forward(request, response);
			System.out.println("CORRECTO ");

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
