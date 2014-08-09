package trasveterinaria.servlet.mascota;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trasveterinaria.excepcion.DAOExcepcion;

import trasveterinaria.modelo.Mascota;

import trasveterinaria.negocio.GestionMascota;

/**
 * Servlet implementation class MascotaBuscarServlet
 */
@WebServlet("/MascotaBuscarServlet")
public class MascotaBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MascotaBuscarServlet() {
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
		
		System.out.println("Dentro de doPost del servlet Buscar Mascota Servlet");
		String x = request.getParameter("nombre");
			
		GestionMascota negocio = new GestionMascota();
		try {
			Collection<Mascota> lista = negocio.buscarPorNombre(x);
			
			// Guardar en el ambiente de request
			
			request.setAttribute("Mascotas", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("mascota_buscar.jsp");
			rd.forward(request, response);
			System.out.println("CORRECTO ");

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
	}
	}
}
