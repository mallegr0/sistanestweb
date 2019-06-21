package controlador;

import entidades.Medico;
import data.DataMedico;
import util.ApplicationException;
import java.util.ArrayList;

public class CtrlMedico {
	
	public CtrlMedico (){}
	
	private DataMedico dm = null;
	
	public boolean altaMedico(Medico m) throws ApplicationException{
		dm = new DataMedico();
		return dm.altaMedico(m);
	}
	
	public boolean bajaMedico(Medico m) throws ApplicationException{
		dm = new DataMedico();
		return dm.bajaMedico(m);
	}
	
	public boolean modificaMedico(Medico m) throws ApplicationException{
		dm = new DataMedico();
		return dm.modificaMedico(m);
	}
	
	public Medico consultaMedico(Medico m) throws ApplicationException{
		dm = new DataMedico();
		return dm.consultaMedico(m);
	}
	
	public ArrayList<Medico> altaMedico() throws ApplicationException{
		dm = new DataMedico();
		return dm.listarMedico();
	}
	
}
