package controlador;

import java.util.ArrayList;

import data.DataPrograma;
import entidades.Programa;
import util.ApplicationException;

public class CtrlPrograma {
	
	public CtrlPrograma(){}
	
	private DataPrograma dp = null;
	
	public boolean altaPrograma(Programa f) throws ApplicationException{
		dp = new DataPrograma();
		return dp.altaPrograma(f);
	}
	
	public boolean bajaPrograma(Programa f) throws ApplicationException{
		dp = new DataPrograma();
		return dp.bajaPrograma(f);
	}
	
	public boolean modificaPrograma (Programa f) throws ApplicationException{
		dp = new DataPrograma();
		return dp.modificaPrograma(f);
	}
	
	public Programa consultaPrograma (Programa f) throws ApplicationException{
		dp = new DataPrograma();
		return dp.consultaPrograma(f);
	}
	
	public ArrayList<Programa> listarPrograma () throws ApplicationException{
		dp = new DataPrograma();
		return dp.listarPrograma();
	}
}
