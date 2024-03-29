package trasveterinaria.servlet;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.negocio.GestionDoctores;

/**
 * Servlet implementation class for Servlet: LoginServlet
 * 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		if(usuario.length()== 0 || clave.length()==0){
			String msgVacio = "" ;
			if (usuario.length() == 0 && clave.length() == 0) {
				msgVacio += "!!Ingrese Usuario y clave";
			} else if (usuario.length() == 0) {
				msgVacio += "!!Ingrese usuario";
			} else if (clave.length() == 0) {		
				msgVacio += "!!Ingrese clave";
			}
			request.setAttribute("TEXTO", msgVacio);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/index.jsp");
			rd.forward(request, response);
			
			
			
		}else{
			GestionDoctores negocio = new GestionDoctores();

			try {
				Doctores vo = negocio.validar(usuario, clave);
				if(vo != null){
					HttpSession session = request.getSession();
					session.setAttribute("USUARIO_ACTUAL", vo);
					
					response.sendRedirect("PortadaServlet");
					//return;
				}else{
					String mensaje="!! Usuario no existe";
					request.setAttribute("TEXTO", mensaje);
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}			
				
				
			} catch (DAOExcepcion e) {
				request.setAttribute("MENSAJE", "Hubo un error al procesar la operación: " + e.getMessage());	
			} catch (LoginException e) {
				request.setAttribute("MENSAJE", "Usuario y/o clave incorrectos");
			}

		//	RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		//	rd.forward(request, response);
		}
		
		

		
	}
}