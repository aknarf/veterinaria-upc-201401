package trasveterinaria.servlet.mascota;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;
import trasveterinaria.modelo.Mascota;
import trasveterinaria.negocio.GestionMascota;

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
		
		String Nombre = request.getParameter("txtNombre");
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
		
		Mascota prod= new Mascota();
		
		int Weight = Integer.parseInt(Peso);
		int DNI = Integer.parseInt(Cliente_Dni);
		int Raza = Integer.parseInt(Raza_idRaza);
		
		prod.setNombre(Nombre);
		prod.setGenero(Genero);
		prod.setTipoSangre(TipoSangre);
		prod.setEsterilizado(Esterilizado);
		prod.setTamaño(Tamaño);
		prod.setActividad(Actividad);
		prod.setPeso(Weight);
		prod.setFechaNacimiento(FechaNacimiento);
		prod.setAlergia(Alergia);
		prod.setCliente_Dni(DNI);
		prod.setRaza_idRaza(Raza);
		
		
		GestionMascota negocio= new GestionMascota();
		try {
			Mascota masc=negocio.buscar(prod.getIdMascota());
			if(masc.getNombre()==null){
				negocio.insertar(prod);
				request.setAttribute("msg", "ok");
				RequestDispatcher rd = request.getRequestDispatcher("/mascota_nuevo.jsp");
				rd.forward(request, response);		
			}
			else{
				request.setAttribute("msg", "notok");
				RequestDispatcher rd = request.getRequestDispatcher("/mascota_nuevo.jsp");
				rd.forward(request, response);		
			}
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("No Inserto"+ e.getMessage());
		
		}
		
	}

}
