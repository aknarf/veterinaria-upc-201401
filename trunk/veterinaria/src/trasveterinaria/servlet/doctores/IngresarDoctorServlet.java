package trasveterinaria.servlet.doctores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;

import trasveterinaria.modelo.Doctores;
import trasveterinaria.negocio.GestionDoctores;

/**
 * Servlet implementation class IngresarDoctorServlet
 */
@WebServlet("/IngresarDoctorServlet")
public class IngresarDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarDoctorServlet() {
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
		String Contrase�a = request.getParameter("txtPassword");
		
		Doctores prod= new Doctores();
		
		int DNI = Integer.parseInt(DNIDoc);
		
		prod.setDni(DNI);
		prod.setNombre(Nonbre);
		prod.setApePaterno(ApePaterno);
		prod.setApeMaterno(ApeMaterno);
		prod.setEmail(Email);
		prod.setTelefono(Telefono);
		prod.setTipo(Tipo);
		prod.setContrase�a(Contrase�a);
		
		GestionDoctores negocio= new GestionDoctores();
		try {
			Doctores doc=negocio.buscar(prod.getDni());
			if(doc.getNombre()==null){
				negocio.insertar(prod);
				request.setAttribute("msg", "ok");
				RequestDispatcher rd = request.getRequestDispatcher("/IngresarDoctor.jsp");
				rd.forward(request, response);		
			}
			else{
				request.setAttribute("msg", "notok");
				RequestDispatcher rd = request.getRequestDispatcher("/IngresarDoctor.jsp");
				rd.forward(request, response);		
			}
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		
		}
		
	}

}
