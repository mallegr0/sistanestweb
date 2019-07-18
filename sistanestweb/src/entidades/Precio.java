package entidades;

import java.io.Serializable;
import java.sql.Date;


public class Precio implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date fecha;
	private int idSanatorio;
	private float valor;
	
	public Precio(){};
	
	public Precio(Date f, int is, float v){
		this.fecha = f;
		this.idSanatorio = is;
		this.valor = v;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdSanatorio() {
		return idSanatorio;
	}

	public void setIdSanatorio(int idSanatorio) {
		this.idSanatorio = idSanatorio;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
	
}
