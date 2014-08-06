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
 * Servlet implementation class EliminarDoctorServlet
 */
@WebServlet("/EliminarDoctorServlet")
public class EliminarDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String a = request.getParameter("dni");
		String x = "";
		int dni = Integer.parseInt(a);
		
		GestionDoctores doctor = new GestionDoctores();
		try {
			doctor.eliminar(dni);
					
				Collection<Doctores> lista = doctor.buscarPorNombre(x);
				request.setAttribute("doctores", lista);
				
				RequestDispatcher rd = request.getRequestDispatcher("BuscarDoctor.jsp");
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
