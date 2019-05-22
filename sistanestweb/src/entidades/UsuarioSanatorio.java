package entidades;

import java.io.Serializable;

public class UsuarioSanatorio implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idSanatorio;
	private String usuario;
	
	public UsuarioSanatorio() {};
	
	public UsuarioSanatorio(int is, String u){
		this.idSanatorio = is;
		this.usuario = u;
	}

	public int getIdSanatorio() {
		return idSanatorio;
	}

	public void setIdSanatorio(int idSanatorio) {
		this.idSanatorio = idSanatorio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	

}
