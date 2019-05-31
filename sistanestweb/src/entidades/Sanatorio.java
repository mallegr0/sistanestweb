package entidades;

import java.io.Serializable;

public class Sanatorio implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idSanatorio;
	private String razonSocial;
	
	public Sanatorio(){};
	
	public Sanatorio(int is, String rs){
		this.idSanatorio = is;
		this.razonSocial = rs;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public int getIdSanatorio() {
		return idSanatorio;
	}
	
	public void setIdSanatorio(int idSanatorio){
		this.idSanatorio = idSanatorio;
	}
	
	
}
