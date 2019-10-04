package controlador;

import java.util.ArrayList;

import data.DataMenu;
import entidades.Menu;
import util.ApplicationException;

public class CtrlMenu {
	
	public CtrlMenu(){}
	
	private DataMenu dm = null;
	
	public boolean altaMenu(Menu m) throws ApplicationException{
		dm = new DataMenu();
		return dm.altaMenu(m);
	}
	
	public boolean bajaMenu(Menu m) throws ApplicationException{
		dm = new DataMenu();
		return dm.bajaMenu(m);
	}
	
	public boolean modificaMenu (Menu m) throws ApplicationException{
		dm = new DataMenu();
		return dm.modificaMenu(m);
	}
	
	public Menu consultaMenu (Menu m) throws ApplicationException{
		dm = new DataMenu();
		return dm.consultaMenu(m);
	}
	
	public ArrayList<Menu> listarMenu () throws ApplicationException{
		dm = new DataMenu();
		return dm.listarMenu();
	}
}
