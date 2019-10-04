package entidades;

import java.io.Serializable;

public class MenuPrograma implements Serializable {
	
	private static final long serialversionUID = 1L;
	
	private int idMenu, idProg;
	
	public MenuPrograma() {}
	
	public MenuPrograma(int im, int ip) {
		this.idMenu = im;
		this.idProg = ip;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public int getIdProg() {
		return idProg;
	}

	public void setIdProg(int idProg) {
		this.idProg = idProg;
	}
	
}
