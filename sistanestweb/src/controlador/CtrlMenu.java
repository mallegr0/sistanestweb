package controlador;

import java.util.ArrayList;
import entidades.Menu;
import data.DataMenu;
import util.ApplicationException;


public class CtrlMenu {
	
	public CtrlMenu() {}
	
	DataMenu dm = null;
	
	public boolean altaMenu(Menu m) throws ApplicationException{
		dm = new DataMenu();
		return dm.altaMenu(m);
	}
	
	public boolean bajaMenu(Menu m) throws ApplicationException{
		dm = new DataMenu();
		return dm.bajaMenu(m);
	}
	
	public boolean modificaMenu(Menu m) throws ApplicationException{
		dm = new DataMenu();
		return dm.modificaMenu(m);
	}
	
	public Menu consultaMenu(Menu m) throws ApplicationException{
		dm = new DataMenu();
		return dm.consultaMenu(m);
	}
	
	public ArrayList<Menu> ListarMenu() throws ApplicationException{
		dm = new DataMenu();
		return dm.listarMenu();
	}
}
