package controlador;

import java.util.ArrayList;

import data.DataUsuario;
import entidades.Usuario;
import util.ApplicationException;

public class CtrlUsuario {
	
	public CtrlUsuario(){}
	
	private DataUsuario du = null;
	
	public boolean altaUsuario(Usuario u) throws ApplicationException{
		du = new DataUsuario();
		return du.altaUsuario(u);
	}
	
	public boolean bajaUsuario(Usuario u) throws ApplicationException{
		du = new DataUsuario();
		return du.bajaUsuario(u);
	}
	
	public boolean modificaUsuario (Usuario u) throws ApplicationException{
		du = new DataUsuario();
		return du.modificaUsuario(u);
	}
	
	public Usuario consultaUsuario(Usuario u) throws ApplicationException{
		du = new DataUsuario();
		return du.consultaUsuario(u);
	}
	
	public ArrayList<Usuario> listarUsuarios() throws ApplicationException{
		du = new DataUsuario();
		return du.listarUsuarios();
	}
	
	public ArrayList<Usuario> listarPendientes() throws ApplicationException{
		du = new DataUsuario();
		return du.listarPendientes();
	}
	
	public boolean actualizaRol(Usuario u) throws ApplicationException{
		du = new DataUsuario();
		return du.actualizaRol(u);
	}
	
	public boolean cambioContraseña(Usuario u) throws ApplicationException{
		du = new DataUsuario();
		return du.cambioContraseña(u);
	}
}
