package entidades;

import java.io.Serializable;
import java.sql.Date;

public class Feriado implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idFeriado;
	private Date fecFeriado;
	private String descFeriado;
	
	public Feriado(){};
	
	public Feriado(int c, Date f, String d){
		this.idFeriado = c;
		this.fecFeriado = f;
		this.descFeriado = d;
	}

	public int getIdFeriado() {
		return idFeriado;
	}

	public void setIdFeriado(int idFeriado) {
		this.idFeriado = idFeriado;
	}

	public Date getFecFeriado() {
		return fecFeriado;
	}

	public void setFecFeriado(Date fecFeriado) {
		this.fecFeriado = fecFeriado;
	}

	public String getDescFeriado() {
		return descFeriado;
	}

	public void setDescFeriado(String descFeriado) {
		this.descFeriado = descFeriado;
	}
	
	

}
