package controlador;

import entidades.UsuarioSanatorio;
import data.DataUsuarioSanatorio;
import util.ApplicationException;

import java.util.ArrayList;

public class CtrlUsuarioSanatorio {
	
	public CtrlUsuarioSanatorio() {}
	
	private DataUsuarioSanatorio dus = null;
	
	public boolean altaUsuarioSanatorio(UsuarioSanatorio us) throws ApplicationException{
		dus = new DataUsuarioSanatorio();
		return dus.altaUsuarioSanatorio(us);
	}
	
	public boolean bajaUsuarioSanatorio(UsuarioSanatorio us) throws ApplicationException{
		dus = new DataUsuarioSanatorio();
		return dus.bajaUsuarioSanatorio(us);
	}
	
	public boolean modificaUsuarioSanatorio (UsuarioSanatorio us) throws ApplicationException{
		dus = new DataUsuarioSanatorio();
		return dus.modificaUsuarioSanatorio(us);
	}
	
	public UsuarioSanatorio consultaUsuarioSanatorio (UsuarioSanatorio us) throws ApplicationException{
		dus = new DataUsuarioSanatorio();
		return dus.consultaUsuarioSanatorio(us);
	}
	
	public ArrayList<UsuarioSanatorio> listarUsuarioSanatorio () throws ApplicationException{
		dus = new DataUsuarioSanatorio();
		return dus.listarUsuarioSanatorio();
	}
}
