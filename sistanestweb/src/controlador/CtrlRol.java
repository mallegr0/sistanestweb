package controlador;

import entidades.Rol;
import data.DataRol;
import util.ApplicationException;
import java.util.ArrayList;

public class CtrlRol {
	
	public CtrlRol(){}
	
	private DataRol dr = null;
	
	public boolean altaRol(Rol r) throws ApplicationException{
		dr = new DataRol();
		return dr.altaRol(r);
	}
	
	public boolean bajaRol(Rol r) throws ApplicationException{
		dr = new DataRol();
		return dr.bajaRol(r);
	}
	
	public boolean modificaRol(Rol r) throws ApplicationException{
		dr = new DataRol();
		return dr.modificaRol(r);
	}
	
	public Rol consultarRol(Rol r) throws ApplicationException{
		dr = new DataRol();
		return dr.consultarRol(r);
	}
	
	public ArrayList<Rol> listarRol() throws ApplicationException{
		dr = new DataRol();
		return dr.listarRol();
	}

}
