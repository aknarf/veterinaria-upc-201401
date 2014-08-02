package trasveterinaria.servlet.mascota;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MascotaInsertarServlet
 */
@WebServlet("/MascotaInsertarServlet")
public class MascotaInsertarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MascotaInsertarServlet() {
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
		
		String Nonbre = request.getParameter("txtNombre");
		String Genero = request.getParameter("txtGenero");
		String TipoSangre = request.getParameter("txtTipoSangre");
		String Esterilizado = request.getParameter("txtEsterilizado");
		String Tamaño = request.getParameter("txtTamaño");
		String Actividad = request.getParameter("txtActividad");
		String Peso = request.getParameter("txtPeso");
		String FechaNacimiento = request.getParameter("txtFechaNacimiento");
		String Alergia = request.getParameter("txtAlergia");
		String Cliente_Dni = request.getParameter("txtCliente_Dni");
		String Raza_idRaza = request.getParameter("txtIdRaza");
	}

}
