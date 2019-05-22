package entidades;

import java.io.Serializable;

public class ProcedimientoAnestesia implements Serializable{

	private static final long serialVersionUID = 1L;
	private int codProcedimiento, idAnestesia;
	
	public ProcedimientoAnestesia() {};
	
	public ProcedimientoAnestesia(int cp, int ia){
		this.codProcedimiento = cp;
		this.idAnestesia = ia;
	}

	public int getCodProcedimiento() {
		return codProcedimiento;
	}

	public void setCodProcedimiento(int codProcedimiento) {
		this.codProcedimiento = codProcedimiento;
	}

	public int getIdAnestesia() {
		return idAnestesia;
	}

	public void setIdAnestesia(int idAnestesia) {
		this.idAnestesia = idAnestesia;
	}
	
	
	

}
