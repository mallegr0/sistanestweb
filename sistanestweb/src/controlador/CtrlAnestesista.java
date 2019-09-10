package controlador;

import java.util.ArrayList;

import data.DataAnestesista;
import entidades.Anestesista;
import util.ApplicationException;

public class CtrlAnestesista {

	public CtrlAnestesista(){}
	
	private DataAnestesista da = null;
	
	public boolean altaAnestesista(Anestesista a) throws ApplicationException{
		da = new DataAnestesista();
		return da.altaAnestesista(a);
	}
	
	public boolean bajaAnestesista(Anestesista a) throws ApplicationException{
		da = new DataAnestesista();
		return da.bajaAnestesista(a);
	}

	public boolean modificaAnestesista(Anestesista a) throws ApplicationException{
		da = new DataAnestesista();
		return da.modificaAnestesista(a);
	}

	public Anestesista consultaAnestesista(Anestesista a) throws ApplicationException{
		da = new DataAnestesista();
		return da.consultaAnestesista(a);
	}

	public ArrayList<Anestesista> listarAnestesista() throws ApplicationException{
		da = new DataAnestesista();
		return da.listarAnestesista();
	}

	public Anestesista buscarNombre(Anestesista a) throws ApplicationException{
		da = new DataAnestesista();
		return da.buscaNombre(a);
	}
}
