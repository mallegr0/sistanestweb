package entidades;

import java.io.Serializable;
import java.sql.Date;


public class Precio implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date fecha;
	private int idSanatorio, idTpoAnestesia;
	private float valor;
	
	public Precio(){};
	
	public Precio(Date f, int is, int ita, float v){
		this.fecha = f;
		this.idSanatorio = is;
		this.idTpoAnestesia = ita;
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

	public int getIdTpoAnestesia() {
		return idTpoAnestesia;
	}

	public void setIdTpoAnestesia(int idTpoAnestesia) {
		this.idTpoAnestesia = idTpoAnestesia;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
	
}
