package entidades;

import java.io.Serializable;

public class Menu implements Serializable {
	
	private static final long serialversionUID = 1L;
	
	private int idMenu;
	private String descMenu;
	
	public Menu() {}
	
	public Menu(int ip, int im, String dm){
		this.idMenu = im;
		this.descMenu = dm;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getDescMenu() {
		return descMenu;
	}

	public void setDescMenu(String descMenu) {
		this.descMenu = descMenu;
	}
	
}
