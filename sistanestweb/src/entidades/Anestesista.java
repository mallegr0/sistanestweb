package entidades;

import java.io.Serializable;

public class Anestesista implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int idAnestesista, matricula, grupo;
	private String nombreAnestesista, apellidoAnestesista, usuario;
	
	public Anestesista(){};
	
	public Anestesista(int ia, String na, String aa, int m, int g, String u){
		this.idAnestesista = ia;
		this.nombreAnestesista = na;
		this.apellidoAnestesista = aa;
		this.matricula = m;
		this.grupo = g;
		this.usuario = u;
	}

	public int getIdAnestesista() {
		return idAnestesista;
	}

	public void setIdAnestesista(int idAnestesista) {
		this.idAnestesista = idAnestesista;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public String getNombreAnestesista() {
		return nombreAnestesista;
	}

	public void setNombreAnestesista(String nombreAnestesista) {
		this.nombreAnestesista = nombreAnestesista;
	}

	public String getApellidoAnestesista() {
		return apellidoAnestesista;
	}

	public void setApellidoAnestesista(String apellidoAnestesista) {
		this.apellidoAnestesista = apellidoAnestesista;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
