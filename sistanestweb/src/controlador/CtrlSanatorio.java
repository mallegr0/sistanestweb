package controlador;

import java.util.ArrayList;

import data.DataSanatorio;
import entidades.Sanatorio;
import util.ApplicationException;

public class CtrlSanatorio {
	
	public CtrlSanatorio(){}
	
	private DataSanatorio ds = null;
	
	public boolean altaSanatorio(Sanatorio s) throws ApplicationException{
		ds = new DataSanatorio();
		return ds.altaSanatorio(s);
	}
	
	public boolean bajaSanatorio(Sanatorio s) throws ApplicationException{
		ds = new DataSanatorio();
		return ds.bajaSanatorio(s);
	}
	
	public boolean modificaSanatorio(Sanatorio s) throws ApplicationException{
		ds = new DataSanatorio();
		return ds.modificaSanatorio(s);
	}
	
	public Sanatorio consultaSanatorio(Sanatorio s) throws ApplicationException{
		ds = new DataSanatorio();
		return ds.consultaSanatorio(s);
	}
	
	public ArrayList<Sanatorio> listarSanatorio(Sanatorio s) throws ApplicationException{
		ds = new DataSanatorio();
		return ds.listarSanatorio();
	}
	
}
