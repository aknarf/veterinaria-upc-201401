package trasveterinaria.servlet.citas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;
import trasveterinaria.modelo.Citas;
import trasveterinaria.negocio.GestionCitas;

/**
 * Servlet implementation class IngresarCitasServlet
 */
@WebServlet("/IngresarCitasServlet")
public class IngresarCitasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarCitasServlet() {
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
		
		String fecha = request.getParameter("txtFecha");
		String tipo = request.getParameter("cboTipo");
		String estado = request.getParameter("cboEstado");
		String mascota = request.getParameter("cboMascota");
		String doctor = request.getParameter("cboDoctor");
		String imagenMedica = request.getParameter("txtImagen");
		String notasMedicas = request.getParameter("txtSNotas");
		String atencion = request.getParameter("txtSAtencion");
		
		
		Citas cit= new Citas();
		
		cit.setFecha(fecha);
		cit.setTipo(tipo); 
		cit.setEstado(estado);
		cit.setIdmascota(Integer.parseInt(mascota));
		cit.setDnidoc(doctor);
		cit.setImagen(imagenMedica);
		cit.setNotas(notasMedicas);
		cit.setDescripcionTarea(atencion);
		
		
		GestionCitas negocio= new GestionCitas();
		
		
		try {
			negocio.insertar(cit);
			request.setAttribute("msg", "ok");
			RequestDispatcher rd= request.getRequestDispatcher("/AdministracionCitas2.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		}
		
		
		
	}

}
