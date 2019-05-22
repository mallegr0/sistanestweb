package entidades;

import java.io.Serializable;

public class ObraSocial implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idOS, diasMax;
	private String descOS;
	
	public ObraSocial(){};
	
	public ObraSocial(int io, String dos, int dm){
		this.idOS = io;
		this.descOS = dos;
		this.diasMax = dm;
	}

	public int getIdOS() {
		return idOS;
	}

	public void setIdOS(int idOS) {
		this.idOS = idOS;
	}

	public int getDiasMax() {
		return diasMax;
	}

	public void setDiasMax(int diasMax) {
		this.diasMax = diasMax;
	}

	public String getDescOS() {
		return descOS;
	}

	public void setDescOS(String descOS) {
		this.descOS = descOS;
	}
	
}
