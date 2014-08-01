package trasveterinaria.servlet.doctores;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.negocio.GestionDoctores;

/**
 * Servlet implementation class BuscarDoctorServlet
 */
@WebServlet("/BuscarDoctorServlet")
public class BuscarDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarDoctorServlet() {
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
		
		System.out.println("Dentro de doPost del servlet RolBuscarSerlvet");
		String x = request.getParameter("nombre");
			
		GestionDoctores negocio = new GestionDoctores();
		try {
			Collection<Doctores> lista = negocio.buscarPorNombre(x);
			
			// Guardar en el ambiente de request
			
			request.setAttribute("roles", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("BuscarDoctorServlet.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
