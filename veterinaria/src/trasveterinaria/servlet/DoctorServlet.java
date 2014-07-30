package trasveterinaria.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;

import trasveterinaria.modelo.Doctores;
import trasveterinaria.negocio.GestionDoctores;

/**
 * Servlet implementation class MantenimientoDoctores
 */
@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
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
		
		Doctores prod= new Doctores();
		
		int DNI = Integer.parseInt(DNIDoc);
		
		prod.setDni(DNI);
		prod.setNombre(Nonbre);
		prod.setApePaterno(ApePaterno);
		prod.setApeMaterno(ApeMaterno);
		prod.setEmail(Email);
		prod.setTelefono(Telefono);
		prod.setTipo(Tipo);
		prod.setContraseña(Contraseña);
		
		GestionDoctores negocio= new GestionDoctores();
		try {
			Doctores doc=negocio.buscar(prod.getDni());
			if(doc.getNombre()==null){
				negocio.insertar(prod);
				
				PrintWriter out = response.getWriter();
				out.println("<html><head></head><body onload=\"alert('Ingreso Correcto de Doctor')\"></body></html>");
				out.close();
				
				//response.sendRedirect("MantenimientoDoctor.jsp");
				
				RequestDispatcher rd = request.getRequestDispatcher("/MantenimientoDoctor.jsp");
				rd.forward(request, response);
				
				//request.setAttribute("MENSAJE", "Ingreso Correcto de Doctor");
				//RequestDispatcher rd = request.getRequestDispatcher("/MantenimientoDoctor.jsp");
				//rd.forward(request, response);
				
			}
			else{

				PrintWriter out = response.getWriter();
				out.println("<html><head></head><body onload=\"alert('Ingreso Incorrecto de Doctor, DNI o correo duplicado')\"></body></html>");
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
		


	}

}
