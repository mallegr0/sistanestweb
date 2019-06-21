package controlador;

import java.util.ArrayList;

import data.DataProcedimiento;
import entidades.Procedimiento;
import util.ApplicationException;

public class CtrlProcedimiento {
	
	public CtrlProcedimiento() {}
	
	private DataProcedimiento var = null;
	
	//METODOS
	public boolean altaProcedimiento(Procedimiento p) throws ApplicationException{
		var = new DataProcedimiento();
		return var.altaProcedimiento(p);
	}
	
	public boolean bajaProcedimiento(Procedimiento p) throws ApplicationException{
		var = new DataProcedimiento();
		return var.bajaProcedimiento(p);
	}
	
	public boolean modificaProcedimiento(Procedimiento p) throws ApplicationException{
		var = new DataProcedimiento();
		return var.modificaProcedimiento(p);
	}
	
	public Procedimiento consultaProcedimiento(Procedimiento p) throws ApplicationException{
		var = new DataProcedimiento();
		return var.consultaProcedimiento(p);
	}
	
	public ArrayList<Procedimiento> listarProcedimiento() throws ApplicationException{
		var = new DataProcedimiento();
		return var.listarProcedimientos();
	}
	
}
