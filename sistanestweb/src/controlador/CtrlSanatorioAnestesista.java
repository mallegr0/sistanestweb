package controlador;

import java.util.ArrayList;
import entidades.SanatorioAnestesista;
import data.DataSanatorioAnestesista;
import util.ApplicationException;

public class CtrlSanatorioAnestesista {
	
	public CtrlSanatorioAnestesista(){}
		
	private DataSanatorioAnestesista dsa = null;
	
	public boolean altaSanatorioAnestesista(SanatorioAnestesista sa) throws ApplicationException{
		dsa = new DataSanatorioAnestesista();
		return dsa.altaSanatorioAnestesista(sa);
	}
	
	public boolean bajaSanatorioAnestesista(SanatorioAnestesista sa) throws ApplicationException{
		dsa = new DataSanatorioAnestesista();
		return dsa.bajaSanatorioAnestesista(sa);
	}
	
	public boolean modificaAnestesistaSanatorio(SanatorioAnestesista sa) throws ApplicationException{
		dsa = new DataSanatorioAnestesista();
		return dsa.modificaAnestesistaSanatorio(sa);
	}
	
	public boolean modificaSanatorioAnestesista(SanatorioAnestesista sa) throws ApplicationException{
		dsa = new DataSanatorioAnestesista();
		return dsa.modificaSanatorioAnestesista(sa);
	}
	
	public SanatorioAnestesista consultaSanatorioAnestesista(SanatorioAnestesista sa) throws ApplicationException{
		dsa = new DataSanatorioAnestesista();
		return dsa.ConsultaSanatorioAnestesista(sa);
	}
	
	public ArrayList<SanatorioAnestesista> listarSanatorioAnestesista() throws ApplicationException{
		dsa = new DataSanatorioAnestesista();
		return dsa.listarSanatorioAnestesista();
	}
	
}
