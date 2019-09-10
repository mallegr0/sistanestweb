package controlador;

import entidades.Anestesia;
import entidades.ProcedimientoAnestesia;
import entidades.Feriado;
import data.DataAnestesia;
import data.DataProcedimientoAnestesia;
import data.DataFeriado;
import util.ApplicationException;

import java.util.ArrayList;
import java.util.Calendar;
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
	
	/*
	 * 
	 * Calculos de Fds, feriado y nocturno
	 * 0 si es Falso
	 * 1 si es Verdadero
	 * 
	 */
	
	public boolean validaFeriado(Date fecha) throws ApplicationException{
		Feriado f = new Feriado();
		DataFeriado df = new DataFeriado();
		
		f.setFecFeriado(fecha);
		return (df.consultaFeriado(f) != null)?true:false;
	}
	
	public boolean validaNocturno(Date fecha){
		//Variable Calendario para manejar la fecha que paso como parametro
		Calendar j = Calendar.getInstance();
		//Seteo la fecha en la variable
		j.setTime(fecha);
		if(j.get(Calendar.HOUR_OF_DAY) < 7){
			return true;
		}
		else if(j.get(Calendar.HOUR_OF_DAY) > 21){
			return true;
		}
		return false;
	}
		
	//Valida si la fecha corresponde a fin de semana
	public boolean validaFDS(Date fecha){
		//Variable Calendario para manejar las fechas.
		Calendar j = Calendar.getInstance();
		//Seteo la fecha que paso como parametro
		j.setTime(fecha);
		int dia = j.get(Calendar.DAY_OF_WEEK);
		int hora = j.get(Calendar.HOUR_OF_DAY);
		//Pregunto si el dia que paso como parametro es sabado o domingo
		if(Calendar.SATURDAY == dia && 13 <= hora || Calendar.MONDAY == dia && hora <= 7 || Calendar.SUNDAY == dia ){
			return true;
		}
		else{ return false;}
	}
	
	
	
	/* CALCULOS DE VARIABLES EXTERNAS A LA CLASE */
	
	/*Calculo la cantidad de Anestesias por anestesista en un rango*/
	public Integer calculaCantidadPorAnestesista(Date fi, Date ff, Integer is, Integer ia) throws ApplicationException{
		da = new DataAnestesia();
		return da.listarPorAnestesista(fi, ff, is, ia).size();
	}
	
	
	/* ACTUALIZACIONES DE OTRAS TABLAS RELACIONADAS CON LA CLASE*/
	
	private boolean cargaProcedimiento(int id, ArrayList<Integer> lp) throws ApplicationException{
		dpa = new DataProcedimientoAnestesia();
		for(int i = 0; i <= lp.size(); i++){
			pa = new ProcedimientoAnestesia(lp.get(i), id);
			oks.add(dpa.altaProcedimientoAnestesia(pa));
		}
		return (oks.size() == lp.size())?true:false;
	}
	
	
}
