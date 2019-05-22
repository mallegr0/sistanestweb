package entidades;

import java.io.Serializable;
import java.sql.Timestamp;


public class Precio implements Serializable{

	private static final long serialVersionUID = 1L;
	private Timestamp fecha;
	private int idSanatorio, idTpoAnestesia;
	private float valor;
	
	public Precio(){};
	
	public Precio(Timestamp f, int is, int ita, float v){
		this.fecha = f;
		this.idSanatorio = is;
		this.idTpoAnestesia = ita;
		this.valor = v;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
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
