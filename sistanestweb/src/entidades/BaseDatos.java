package entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class BaseDatos implements Serializable{
	
	/*
	 * Esta clase es la que tiene los datos de la base de datos que voy a crear automaticamente
	 */
	private static final long serialVersionUID = 1L;
	
	private String obrasSociales = "CREATE TABLE `obras_sociales` ("
			+ "`idOS` INT(4) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ "`descOS` VARCHAR(30) NOT NULL DEFAULT '0',"
			+ "`diasMax` INT(2) NOT NULL DEFAULT '0',"
			+ "PRIMARY KEY (`idOS`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	private String feriados = "CREATE TABLE `feriados` ("
			+ "`idFeriado` INT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ "`fecFeriado` DATE NOT NULL,"
			+ "`descFeriado` VARCHAR(50) NULL DEFAULT NULL,"
			+ "PRIMARY KEY (`idFeriado`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	private ArrayList<String> tablas = new ArrayList<>();
	public BaseDatos() {
		this.tablas.add("programas");
		this.tablas.add("menus");
		this.tablas.add("menus_programas");
		this.tablas.add("procedimientos");
		this.tablas.add("tpoAnestesias");
		this.tablas.add("usuarios");
		this.tablas.add("roles");
		this.tablas.add("medicos");
		this.tablas.add("sanatorios");
		this.tablas.add("sanatorios_anestesistas");
		this.tablas.add("anestesistas");
		this.tablas.add("precios");
		this.tablas.add("obras_sociales");
		this.tablas.add("saldos");
		this.tablas.add("procedimientos_anestesias");
		this.tablas.add("usuarios_sanatorios");
		this.tablas.add("feriados");
		this.tablas.add("anestesias");
		
	}

	public String getObrasSociales() {
		return obrasSociales;
	}

	public String getFeriados() {
		return feriados;
	}
	
	
}