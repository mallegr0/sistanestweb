package entidades;

import java.io.Serializable;

public class Menu implements Serializable {
	
	private static final long serialversionUID = 1L;
	
	private int idProg, idRol;
	private String descMenu;
	
	public Menu() {}
	
	public Menu(int ip, int ir, String dm){
		this.idProg = ip;
		this.idRol = ir;
		this.descMenu = dm;
	}

	public int getIdProg() {
		return idProg;
	}

	public void setIdProg(int idProg) {
		this.idProg = idProg;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescMenu() {
		return descMenu;
	}

	public void setDescMenu(String descMenu) {
		this.descMenu = descMenu;
	}
	
}
