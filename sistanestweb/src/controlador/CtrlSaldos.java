package controlador;

import entidades.Saldo;
import data.DataSaldo;
import util.ApplicationException;

import java.util.ArrayList;

public class CtrlSaldos {
	
	public CtrlSaldos() {}
	
	private DataSaldo ds = null;
	
	public boolean altaSaldo(Saldo s) throws ApplicationException{
		ds = new DataSaldo();
		return ds.altaSaldo(s);
	}
	
	public boolean bajaSaldo(Saldo s) throws ApplicationException{
		ds = new DataSaldo();
		return ds.bajaSaldo(s);
	}
	
	public boolean modificaSaldo(Saldo s) throws ApplicationException{
		ds = new DataSaldo();
		return ds.modificaSaldo(s);
	}
	
	public Saldo consultaSaldo(Saldo s) throws ApplicationException{
		ds = new DataSaldo();
		return ds.consultaSaldo(s);
	}

	public ArrayList<Saldo> listarSaldo(Saldo s) throws ApplicationException{
		ds = new DataSaldo();	
		return ds.listarSaldo(s);
	}

}
