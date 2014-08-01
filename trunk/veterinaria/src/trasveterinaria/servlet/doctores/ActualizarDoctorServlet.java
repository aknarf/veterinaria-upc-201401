package trasveterinaria.servlet.doctores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.negocio.GestionDoctores;

/**
 * Servlet implementation class ActualizarDoctorServlet
 */
@WebServlet("/ActualizarDoctorServlet")
public class ActualizarDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarDoctorServlet() {
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
		int dni = Integer.parseInt(DNIDoc);
	    System.out.println(dni);
		String Nonbre = request.getParameter("txtNombre");
		String ApePaterno = request.getParameter("txtApellidoPaterno");
		String ApeMaterno = request.getParameter("txtApellidoMaterno");
		String Email = request.getParameter("txtEmail");
		String Telefono = request.getParameter("txtTelefono");
		String Tipo = request.getParameter("txtTipo");
		String Contraseña = request.getParameter("txtPassword");
		
		GestionDoctores negocio = new GestionDoctores();
		try {
			negocio.actualizar(Nonbre,ApePaterno,ApeMaterno,Email,Telefono,Tipo,Contraseña,dni);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}

}
