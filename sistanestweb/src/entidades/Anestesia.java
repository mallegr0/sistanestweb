package entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;

public class Anestesia implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idAnestesia, nroAfiliado, nocturno, feriado, fds, nroTalon, nroVias, edad, idMedico;
	private int idAnestesista, idSanatorio, idOS, idTpoAnestesia;
	private Timestamp fecPrestacion;
	private Date fecARA, fecRendicion, FecCarga;
	private String afiliado, usuario;
	
	public Anestesia() {};
	
	public Anestesia(int ia, Timestamp fp, Date fa, Date fr, Date fc, String a, int na, 
			int n, int f, int fd, int nt, int nv, int e, String u, int im, int ida, int is, int io, int ita){
		this.idAnestesia = ia;
		this.fecPrestacion = fp;
		this.fecARA = fa;
		this.fecRendicion = fr;
		this.FecCarga = fc;
		this.afiliado = a;
		this.nroAfiliado = na;
		this.nocturno = n;
		this.feriado = f;
		this.fds = fd;
		this.nroTalon = nt;
		this.nroVias = nv;
		this.edad = e;
		this.usuario = u;
		this.idMedico = im;
		this.idAnestesista = ida;
		this.idSanatorio = is;
		this.idOS = io;
		this.idTpoAnestesia = ita;
	}

	public int getIdAnestesia() {
		return idAnestesia;
	}

	public void setIdAnestesia(int idAnestesia) {
		this.idAnestesia = idAnestesia;
	}

	public int getNroAfiliado() {
		return nroAfiliado;
	}

	public void setNroAfiliado(int nroAfiliado) {
		this.nroAfiliado = nroAfiliado;
	}

	public int getNocturno() {
		return nocturno;
	}

	public void setNocturno(int nocturno) {
		this.nocturno = nocturno;
	}

	public int getFeriado() {
		return feriado;
	}

	public void setFeriado(int feriado) {
		this.feriado = feriado;
	}

	public int getFds() {
		return fds;
	}

	public void setFds(int fds) {
		this.fds = fds;
	}

	public int getNroTalon() {
		return nroTalon;
	}

	public void setNroTalon(int nroTalon) {
		this.nroTalon = nroTalon;
	}

	public int getNroVias() {
		return nroVias;
	}

	public void setNroVias(int nroVias) {
		this.nroVias = nroVias;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public int getIdAnestesista() {
		return idAnestesista;
	}

	public void setIdAnestesista(int idAnestesista) {
		this.idAnestesista = idAnestesista;
	}

	public int getIdSanatorio() {
		return idSanatorio;
	}

	public void setIdSanatorio(int idSanatorio) {
		this.idSanatorio = idSanatorio;
	}

	public int getIdOS() {
		return idOS;
	}

	public void setIdOS(int idOS) {
		this.idOS = idOS;
	}

	public Timestamp getFecPrestacion() {
		return fecPrestacion;
	}

	public void setFecPrestacion(Timestamp fecPrestacion) {
		this.fecPrestacion = fecPrestacion;
	}

	public Date getFecARA() {
		return fecARA;
	}

	public void setFecARA(Date fecARA) {
		this.fecARA = fecARA;
	}

	public Date getFecRendicion() {
		return fecRendicion;
	}

	public void setFecRendicion(Date fecRendicion) {
		this.fecRendicion = fecRendicion;
	}

	public Date getFecCarga() {
		return FecCarga;
	}

	public void setFecCarga(Date fecCarga) {
		FecCarga = fecCarga;
	}

	public String getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(String afiliado) {
		this.afiliado = afiliado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public int getIdTpoAnestesia() {
		return idTpoAnestesia;
	}

	public void setIdTpoAnestesia(int idTpoAnestesia) {
		this.idTpoAnestesia = idTpoAnestesia;
	}
	

}
