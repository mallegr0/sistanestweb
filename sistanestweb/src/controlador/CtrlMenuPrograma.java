package controlador;

import java.util.ArrayList;
import entidades.MenuPrograma;
import data.DataMenuPrograma;
import util.ApplicationException;

public class CtrlMenuPrograma {
	
	public CtrlMenuPrograma() {}
	
	DataMenuPrograma dmp = null;
	
	public boolean altaMenuPrograma(MenuPrograma mp) throws ApplicationException{
		dmp = new DataMenuPrograma();
		return dmp.altaMenuPrograma(mp);
	}
	
	public boolean bajaMenuPrograma(MenuPrograma mp) throws ApplicationException{
		dmp = new DataMenuPrograma();
		return dmp.bajaMenuPrograma(mp);
	}
	
	public boolean modificaMenuPrograma(MenuPrograma mp) throws ApplicationException{
		dmp = new DataMenuPrograma();
		return dmp.modificaMenuPrograma(mp);
	}
	
	public MenuPrograma consultaMenuPrograma(MenuPrograma mp) throws ApplicationException{
		dmp = new DataMenuPrograma();
		return dmp.consultaMenuPrograma(mp);
	}
	
	public ArrayList<MenuPrograma> listarPorMenu(int im) throws ApplicationException{
		dmp = new DataMenuPrograma();
		return dmp.ListarPorMenu(im);
	}
	
	public ArrayList<MenuPrograma> listarPorPrograma(int ip) throws ApplicationException{
		dmp = new DataMenuPrograma();
		return dmp.ListarPorPrograma(ip);
	}

}
