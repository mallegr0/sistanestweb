package entidades;

import java.io.Serializable;

public class Programa implements Serializable {
	
	private static final long serialversionUID = 1L;
	private int idProg; 
	private String modulo, nombre; //Modulo hace referencia a ALTA, BAJA, etc.. Y nombre hacer referencia al metodo.
	
	public Programa(){}
	
	public Programa(int p, String m, String n){
		this.idProg = p;
		this.modulo = m;
		this.nombre = n;
	}

	public int getIdProg() {
		return idProg;
	}

	public void setIdProg(int idProg) {
		this.idProg = idProg;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
