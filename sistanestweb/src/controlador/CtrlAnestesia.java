package controlador;

import entidades.Anestesia;
import entidades.ProcedimientoAnestesia;
import data.DataAnestesia;
import data.DataProcedimientoAnestesia;
import util.ApplicationException;

import java.util.ArrayList;
import java.sql.Date;

public class CtrlAnestesia {
		
	public CtrlAnestesia() {}
	
	private DataAnestesia da = null;
	private DataProcedimientoAnestesia dpa = null;
	
	private ProcedimientoAnestesia pa = null;
	
	private ArrayList<Boolean> oks = new ArrayList<>();

	
	/*	PROCEDIMIENTOS ESTANDAR DE LA CLASE */
	
	public boolean altaAnestesia(Anestesia a, ArrayList<Integer> lp) throws ApplicationException{
		da = new DataAnestesia();
		return (da.altaAnestesia(a) == true && cargaProcedimiento(a.getIdAnestesia(),lp) == true)? true:false;
	}
	
	public boolean bajaAnestesia(Anestesia a) throws ApplicationException{
		da = new DataAnestesia();
		dpa = new DataProcedimientoAnestesia();
		pa = new ProcedimientoAnestesia();
		pa.setIdAnestesia(a.getIdAnestesia());
		return (da.bajaAnestesia(a) == true && dpa.bajaProcedimientoAnestesia(pa))?true:false;
				
	}
	
	public boolean modificaAnestesia(Anestesia a, ArrayList<Integer> lp) throws ApplicationException{
		da = new DataAnestesia();
		dpa = new DataProcedimientoAnestesia();
		for(int i = 0; i<= lp.size(); i++){
			pa = new ProcedimientoAnestesia(lp.get(i), a.getIdAnestesia());
			oks.add(dpa.modificaProcedimientoAnestesia(pa));
		}
		return(da.modificaAnestesia(a) == true && oks.size() == lp.size())?true:false;
	}
	
	public Anestesia consultaAnestesia(Anestesia a) throws ApplicationException{
		da = new DataAnestesia();
		return da.consultaAnestesia(a);
	}
	
	public ArrayList<Anestesia> listarAnestesias(Date fi, Date ff, int id) throws ApplicationException{
		da = new DataAnestesia();
		return da.listarAnestesias(fi, ff, id);
	}
	
	public ArrayList<Anestesia> listarARA(Date fi, Date ff, int id) throws ApplicationException{
		da = new DataAnestesia();
		return da.listarARA(fi, ff, id);
	}
	
	public ArrayList<Anestesia> listarPaciente(Date fi, Date ff, int id, String n) throws ApplicationException{
		da = new DataAnestesia();
		return da.listarPaciente(fi, ff, id, n);
	}
	
	public ArrayList<Anestesia> listarPorAnestesista(Date fi, Date ff, int is, int ia) throws ApplicationException{
		da = new DataAnestesia();
		return da.listarPorAnestesista(fi, ff, is, ia);
	}
	
	public ArrayList<Anestesia> listarPorOS(Date fi, Date ff, int is, int io) throws ApplicationException{
		da = new DataAnestesia();
		return da.listarPorOS(fi, ff, is, io);
	}
	
	public ArrayList<Anestesia> listarPorUsuario(Date fi, Date ff, int id, String u) throws ApplicationException{
		da = new DataAnestesia();
		return da.listarPorUsuario(fi, ff, id, u);
	}
	
	public ArrayList<Anestesia> listarRendidas(Date fi, Date ff, int id) throws ApplicationException{
		da = new DataAnestesia();
		return da.listarRendidas(fi, ff, id);
	}

	/* PROCEDIMIENTOS DE CALCULO DE VARIABLES DE LA CLASE */
	
	/* ACTUALIZACIONES DE OTRAS TABLAS RELACIONADAS CON LA CLASE*/
	
	private boolean cargaProcedimiento(int id, ArrayList<Integer> lp){
		dpa = new DataProcedimientoAnestesia();
		for(int i = 0; i <= lp.size(); i++){
			pa = new ProcedimientoAnestesia(lp.get(i), id);
			oks.add(dpa.altaProcedimientoAnestesia(pa));
		}
		return (oks.size() == lp.size())?true:false;
	}
	
	
}
