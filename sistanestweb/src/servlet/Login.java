package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlUsuario;
import entidades.Usuario;
import sun.nio.cs.ext.ISCII91;
import util.ApplicationException;



/*
 * Servlet que implementa la clase Login
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/* CONSTRUCTOR */
	public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/* VARIABLES */
	
	private CtrlUsuario cu = new CtrlUsuario();
	private Usuario user = new Usuario();
	
	/* METODOS */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
			String u = request.getParameter("usuario");
			String p = request.getParameter("password");
			String rta = "Hay un problema con el modulo de Login, contacte con el administrador";
			String url = "";
			
			
			user.setUser(u);
			user.setPassword(p);
			
			try {
				user = cu.consultaUsuario(user);
				if(user != null){
					if(user.getIdRol() != 0){
						switch (user.getIdRol()) {
						case 1:
							url = "/administrador.jsp";
							break;
						case 2:
							url = "/gestor.jsp";
							break; 
						case 3:
							url = "/anestesista.jsp";
							break;
						default:
							break;
						}
					}
					else { url = "/index.jsp";}
				}
					
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("rta", rta);
			
			request.getRequestDispatcher(url).forward(request, response);
	}
}
