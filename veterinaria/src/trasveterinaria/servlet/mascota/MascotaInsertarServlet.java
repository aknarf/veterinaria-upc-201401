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
		
		String DNIDoc = request.getParameter("txtDni");
		String Nonbre = request.getParameter("txtNombre");
		String ApePaterno = request.getParameter("txtApellidoPaterno");
		String ApeMaterno = request.getParameter("txtApellidoMaterno");
		String Email = request.getParameter("txtEmail");
		String Telefono = request.getParameter("txtTelefono");
		String Tipo = request.getParameter("txtTipo");
		String Contraseña = request.getParameter("txtPassword");
	}

}
