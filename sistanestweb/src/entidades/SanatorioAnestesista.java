package entidades;

import java.io.Serializable;

public class SanatorioAnestesista implements Serializable{

	/* VARIABLES */
	private static final long serialVersionUID = 1L;
	private int idSanatorio, idAnestesista;
	
	/* CONSTRUCTORES*/
	
	public SanatorioAnestesista(){};
	
	public SanatorioAnestesista(int is, int ia){
		this.idSanatorio = is;
		this.idAnestesista = ia;
	}
	
	/* METODOS*/

	public int getIdSanatorio() {
		return idSanatorio;
	}

	public void setIdSanatorio(int idSanatorio) {
		this.idSanatorio = idSanatorio;
	}

	public int getIdAnestesista() {
		return idAnestesista;
	}

	public void setIdAnestesista(int idAnestesista) {
		this.idAnestesista = idAnestesista;
	}
	

	
	

}
