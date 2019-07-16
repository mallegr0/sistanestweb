package controlador;

import data.DataObraSocial;
import entidades.ObraSocial;
import util.ApplicationException;

import java.util.ArrayList;

public class CtrlObraSocial {
	
	public CtrlObraSocial() {}
	
	private DataObraSocial dos = null;
	
	public boolean altaOS (ObraSocial os) throws ApplicationException{
		dos = new DataObraSocial();
		return dos.altaOS(os);
	}
	
	public boolean bajaOS (ObraSocial os) throws ApplicationException{
		dos = new DataObraSocial();
		return dos.bajaOS(os);
	}
	
	public boolean modificaOS (ObraSocial os) throws ApplicationException{
		dos = new DataObraSocial();
		return dos.modificaOS(os);
	}
	
	public ObraSocial consultaOS (ObraSocial os) throws ApplicationException{
		dos = new DataObraSocial();
		return dos.consultaOS(os);
	}
	
	public ArrayList<ObraSocial> listarOS (){
		dos = new DataObraSocial();
		return dos.listarOS();
	}
}
