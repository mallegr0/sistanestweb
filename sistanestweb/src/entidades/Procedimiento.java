package entidades;

import java.io.Serializable;

public class Procedimiento implements Serializable {
	
	/* DECLARO LAS VARIABLES QUE VOY A USAR */
	//No pongo los ID, porque lo tiene que manejar la BBDD
	
	private static final long serialVersionUID = 1L;
	private int idProcedimiento, codProcedimiento, complejidad;
	private String descProcedimiento;
	
	/* DECLARO LOS CONSTRUNCTORES*/
	//Uno vacio y otro con todos los parametros.
	
	public Procedimiento(){};
	
	public Procedimiento(int ip, int cp, String dp, int c){
		this.idProcedimiento = ip;
		this.codProcedimiento = cp;
		this.descProcedimiento = dp;
		this.complejidad = c;
	}

	/* 	DECLARO LOS GET Y SET DE LA CLASE*/
	
	public int getIdProcedimiento() {
		return idProcedimiento;
	}
	
	public void setIdProcedimiento(int idProcedimiento){
		this.idProcedimiento = idProcedimiento;
	}
	
	public int getCodProcedimiento() {
		return codProcedimiento;
	}

	public void setCodProcedimiento(int codProcedimiento) {
		this.codProcedimiento = codProcedimiento;
	}

	public int getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(int complejidad) {
		this.complejidad = complejidad;
	}

	public String getDescProcedimiento() {
		return descProcedimiento;
	}

	public void setDescProcedimiento(String descProcedimiento) {
		this.descProcedimiento = descProcedimiento;
	}
	
}
