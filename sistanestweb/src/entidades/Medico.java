package entidades;

import java.io.Serializable;

public class Medico implements Serializable{

	/* DECLARO LAS VARIABLES*/
	
	private static final long serialVersionUID = 1L;
	private String nombreMedico, apellidoMedico;
	private int idMedico, idSanatorio;
	
	/* DECLARO LOS CONSTRUCTORES*/
	
	public Medico(){};
	
	public Medico(int im, String nm, String am, int is){
		this.idMedico = im;
		this.nombreMedico = nm;
		this.apellidoMedico = am;
		this.idSanatorio = is;
	}
	
	/* DECLARO LOS GET Y SET*/
	
	public int getIdMedico() {
		return idMedico;
	}
	
	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getApellidoMedico() {
		return apellidoMedico;
	}

	public void setApellidoMedico(String apellidoMedico) {
		this.apellidoMedico = apellidoMedico;
	}

	public int getIdSanatorio() {
		return idSanatorio;
	}

	public void setIdSanatorio(int idSanatorio) {
		this.idSanatorio = idSanatorio;
	}
	


}
