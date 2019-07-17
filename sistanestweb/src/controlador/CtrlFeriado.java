package controlador;

import entidades.Feriado;
import data.DataFeriado;
import util.ApplicationException;

import java.util.ArrayList;


public class CtrlFeriado {
	
public CtrlFeriado() {}
	
	private DataFeriado df = null;
	
	public boolean altaFeriado(Feriado f) throws ApplicationException{
		df = new DataFeriado();
		return df.altaFeriado(f);
	}
	
	public boolean bajaFeriado(Feriado f) throws ApplicationException{
		df = new DataFeriado();
		return df.bajaFeriado(f);
	}
	
	public boolean modificaFeriado (Feriado f) throws ApplicationException{
		df = new DataFeriado();
		return df.modificaFeriado(f);
	}
	
	public Feriado consultaFeriado (Feriado f) throws ApplicationException{
		df = new DataFeriado();
		return df.consultaFeriado(f);
	}
	
	public ArrayList<Feriado> listarFeriado () throws ApplicationException{
		df = new DataFeriado();
		return df.listarFeriado();
	}

}



	
	
