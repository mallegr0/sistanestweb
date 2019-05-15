package entidades;

import java.io.Serializable;

public class TipoAnestesia implements Serializable{

	/* DECLARO LAS VARIABLES*/

	private static final long serialVersionUID = 1L;
	private int idTpoAnestesia;
	private String descTpoAnestesia;
	
	/* DECLARO LOS CONSTRUCTORES*/
	
	public TipoAnestesia(){};
	
	public TipoAnestesia(int ita, String dta){
		this.idTpoAnestesia = ita;
		this.descTpoAnestesia = dta;
	}

	/* DECLARO LOS GET Y SET*/

	public int getIdTpoAnestesia() {
		return idTpoAnestesia;
	}

	public void setIdTpoAnestesia(int idTpoAnestesia) {
		this.idTpoAnestesia = idTpoAnestesia;
	}

	public String getDescTpoAnestesia() {
		return descTpoAnestesia;
	}

	public void setDescTpoAnestesia(String descTpoAnestesia) {
		this.descTpoAnestesia = descTpoAnestesia;
	}
	
	

}
