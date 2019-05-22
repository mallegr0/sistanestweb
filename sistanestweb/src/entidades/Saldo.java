package entidades;

import java.io.Serializable;

public class Saldo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idAnestesista, mes, a�o;
	private float monto;
	private String estado;
	
	public Saldo(){};
	
	public Saldo(int ia, int m, int a, float v, String e){
		this.idAnestesista = ia;
		this.mes = m;
		this.a�o = a;
		this.monto = v;
		this.estado = e;
	}

	public int getIdAnestesista() {
		return idAnestesista;
	}

	public void setIdAnestesista(int idAnestesista) {
		this.idAnestesista = idAnestesista;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
