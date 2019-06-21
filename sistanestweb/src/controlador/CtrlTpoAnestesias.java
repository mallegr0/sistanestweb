package controlador;

import java.util.ArrayList;

import data.DataTpoAnestesia;
import entidades.TipoAnestesia;
import util.ApplicationException;

public class CtrlTpoAnestesias {
	
	public CtrlTpoAnestesias() {}
	
	private DataTpoAnestesia dta = null;
	
	public boolean altaTpoAnestesia(TipoAnestesia ta) throws ApplicationException{
		dta = new DataTpoAnestesia();
		return dta.altaTpoAnestesia(ta);
	}
	
	public boolean bajaTpoAnestesia(TipoAnestesia ta) throws ApplicationException{
		dta = new DataTpoAnestesia();
		return dta.bajaTpoAnestesia(ta);
	}
	
	public boolean modificaTpoAnestesia(TipoAnestesia ta) throws ApplicationException{
		dta = new DataTpoAnestesia();
		return dta.modificaTpoAnestesia(ta);
	}
	
	public TipoAnestesia consultaTpoAnestesia(TipoAnestesia ta) throws ApplicationException{
		dta = new DataTpoAnestesia();
		return dta.consultaTpoAnestesia(ta);
	}
	
	public ArrayList<TipoAnestesia> listarTpoAnestesia() throws ApplicationException{
		dta = new DataTpoAnestesia();
		return dta.listarTpoAnestesia();
	}

}
