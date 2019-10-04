package entidades;

import java.io.Serializable;

public class Rol implements Serializable{

	/* DECLARO LAS VARIABLES*/
	private static final long serialVersionUID = 1L;
	private int idRol, idMenu;
	private String descRol;

	/* DECLARO LOS CONSTRUCTORES*/
	
	public Rol(){};
	
	public Rol(int ir, String dr, int im){
		this.idRol = ir;
		this.descRol = dr;
		this.idMenu = im;
	}
	
	/*	DECLARO LOS GET Y SET*/

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescRol() {
		return descRol;
	}

	public void setDescRol(String descRol) {
		this.descRol = descRol;
	}
	
	public int getIdMenu() {
		return idMenu;
	}
	
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	
}
