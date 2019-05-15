package entidades;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	/* DECLARO LAS VARIABLES*/
	
	private static final long serialVersionUID = 1L;
	private String user, password, nombreUsuario, apellidoUsuario, mailUsuario;
	private int idRol;
	
	/* DECLARO LOS CONSTRUCTORES*/
	
	public Usuario(){};
	
	public Usuario(String u, String p, String nu, String au, String mu, int ir){
		this.user = u;
		this.password = p;
		this.nombreUsuario = nu;
		this.apellidoUsuario = au;
		this.mailUsuario = mu;
		this.idRol = ir;
	}

	/* DECLARO LOS GET Y SET*/
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getMailUsuario() {
		return mailUsuario;
	}

	public void setMailUsuario(String mailUsuario) {
		this.mailUsuario = mailUsuario;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	
	

}
