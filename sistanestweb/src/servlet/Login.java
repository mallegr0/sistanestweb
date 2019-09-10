package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.CtrlUsuario;
import entidades.Usuario;
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
		// TODO Auto-generated method stub
		
			String u = request.getParameter("usuario");
			String p = request.getParameter("password");
			String rta = "no funciono el login";
			
			user.setUser(u);
			user.setPassword(p);
			
			try {
				if(cu.consultaUsuario(user) == null){rta = "No existe usuario";}
				else {rta = "existe usuario";}
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("rta", rta);
			
			request.getRequestDispatcher("/exito.jsp").forward(request, response);
	}
}
