package controlador;

import data.DataPrecio;
import entidades.Precio;
import util.ApplicationException;

import java.util.ArrayList;

public class CtrlPrecio {

	public CtrlPrecio(){}
	
	private DataPrecio dp = null;
	
	public boolean bajaPrecio(Precio p) throws ApplicationException{
		dp = new DataPrecio();
		return dp.bajaPrecio(p);
	}
	
	public boolean modificaPrecio(Precio p) throws ApplicationException{
		dp = new DataPrecio();
		return dp.modificaPrecio(p);
	}
	
	public Precio consultaPrecio(Precio p) throws ApplicationException{
		dp = new DataPrecio();
		return dp.consultaPrecio(p);
	}
	
	public ArrayList<Precio> listarPrecio(Precio p) throws ApplicationException{
		dp = new DataPrecio();
		return dp.ListarPrecio(p);
	}
	
	public Precio ultimoPrecioSanatorio(Integer id) throws ApplicationException{
		dp = new DataPrecio();
		return dp.ultimoPrecioSanatorio(id);
	}
	
}
