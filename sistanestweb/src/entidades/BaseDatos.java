package entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class BaseDatos implements Serializable{
	
	/*
	 * Esta clase es la que tiene los datos de la base de datos que voy a crear automaticamente
	 */
	private static final long serialVersionUID = 1L;
	
	//1
	private String procedimientos = "CREATE TABLE `procedimientos` ("
			+ "`idProcedimiento` INT(4) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ "`codProcedimiento` INT(6) UNSIGNED ZEROFILL NOT NULL,"
			+ "`descProcedimiento` VARCHAR(50) NOT NULL,"
			+ "`complejidad` INT(1) NOT NULL,"
			+ "PRIMARY KEY (`idProcedimiento`),"
			+ "UNIQUE INDEX `codProcedimiento` (`codProcedimiento`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//2
	private String  tpoAnestesias = "CREATE TABLE `tpoAnestesias` ("
			+ " `idTpoAnestesia` INT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ " `descTpoAnestesia` VARCHAR(20) NOT NULL,"
			+ " PRIMARY KEY (`idTpoAnestesia`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//3
	private String sanatorios = "CREATE TABLE `sanatorios` ("
			+ " `idSanatorio` INT(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ " `razonSocial` VARCHAR(30) NOT NULL DEFAULT '0',"
			+ "	PRIMARY KEY (`idSanatorio`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//4
	private String obrasSociales = "CREATE TABLE `obras_sociales` ("
			+ "`idOS` INT(4) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ "`descOS` VARCHAR(30) NOT NULL DEFAULT '0',"
			+ "`diasMax` INT(2) NOT NULL DEFAULT '0',"
			+ "PRIMARY KEY (`idOS`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//5
	private String feriados = "CREATE TABLE `feriados` ("
			+ "`idFeriado` INT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ "`fecFeriado` DATE NOT NULL,"
			+ "`descFeriado` VARCHAR(50) NULL DEFAULT NULL,"
			+ "PRIMARY KEY (`idFeriado`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//6
	private String programas = "CREATE TABLE `programas` ("
			+ "`idPrograma` INT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ "`modulo` VARCHAR(50) NOT NULL,"
			+ "`nombre` VARCHAR(50) NULL DEFAULT NULL,"
			+ "PRIMARY KEY (`idPrograma`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//7
	private String menus = "CREATE TABLE `menus` ("
			+ "`idMenu` INT(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ "`descMenu` VARCHAR(50) NOT NULL,"
			+ "PRIMARY KEY (`idMenu`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//8
	private String  medicos = "CREATE TABLE `medicos` ("
			+ "	`idMedico` INT(4) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ "	`dataMedico` VARCHAR(30) NOT NULL DEFAULT '0',"
			+ " `idSanatorio` INT(3) UNSIGNED ZEROFILL NOT NULL DEFAULT '000',"
			+ "	PRIMARY KEY (`idMedico`),"
			+ "	INDEX `idSanatorio` (`idSanatorio`),"
			+ "	CONSTRAINT `idSanatorio` FOREIGN KEY (`idSanatorio`) REFERENCES `sanatorios` (`idSanatorio`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//9
	private String precios = " CREATE TABLE `precios` ("
			+ " `fecha` DATE NOT NULL,"
			+ "	`idSanatorio` INT(3) UNSIGNED ZEROFILL NOT NULL,"
			+ " `valor` FLOAT NOT NULL DEFAULT '0',"
			+ "	PRIMARY KEY (`fecha`, `idSanatorio`),"
			+ "	INDEX `nroSanatorio` (`idSanatorio`),"
			+ "	CONSTRAINT `nroSanatorio` FOREIGN KEY (`idsanatorio`) REFERENCES `sanatorios` (`idSanatorio`)"
			+ ")"
			+ "COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//10
	private String menus_programas = "CREATE TABLE `menus_programas` ("
			+ " `idMenu` INT(2) UNSIGNED ZEROFILL NOT NULL,"
			+ " `idPrograma` INT(2) UNSIGNED ZEROFILL NOT NULL,"
			+ " PRIMARY KEY (`idMenu`, `idPrograma`),"
			+ " INDEX `idPrograma` (`idPrograma`),"
			+ " CONSTRAINT `idMenu` FOREIGN KEY (`idMenu`) REFERENCES `menus` (`idMenu`),"
			+ " CONSTRAINT `idPrograma` FOREIGN KEY (`idPrograma`) REFERENCES `programas` (`idPrograma`)"
			+ ")"
			+ " COLLATE='utf8_general_ci'"
			+ " ENGINE=InnoDB";
		
	//11
	private String roles = "CREATE TABLE `roles` ("
			+ " `idRol` INT(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ "	`descRol` VARCHAR(20) NOT NULL DEFAULT '0',"
			+ " `idMenu` INT(2) UNSIGNED ZEROFILL NOT NULL,"
			+ " PRIMARY KEY (`idRol`),"
			+ " INDEX `menu` (`idMenu`),"
			+ " CONSTRAINT `menu` FOREIGN KEY (`idMenu`) REFERENCES `menus` (`idMenu`)"
			+ ")"
			+ " COLLATE='utf8_general_ci'"
			+ " ENGINE=InnoDB";
	
	//12
	private String usuarios = "CREATE TABLE `usuarios` ("
			+ " `user` VARCHAR(20) NOT NULL,"
			+ " `password` VARCHAR(20) NOT NULL,"
			+ " `nombreUsuario` VARCHAR(30) NOT NULL,"
			+ " `apellidoUsuario` VARCHAR(30) NOT NULL,"
			+ " `mailUsuario` VARCHAR(30) NOT NULL,"
			+ " `idRol` INT(2) UNSIGNED ZEROFILL NOT NULL,"
			+ " PRIMARY KEY (`user`),"
			+ " INDEX `rol` (`idRol`),"
			+ " CONSTRAINT `rol` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`)"
			+ ")"
			+ " COLLATE='utf8_general_ci'"
			+ " ENGINE=InnoDB";
		
	//13
	private String usuarios_sanatorios = "CREATE TABLE `usuarios_sanatorios` ("
			+ " `usr` VARCHAR(20) NOT NULL,"
			+ " `sanatorio` INT(3) UNSIGNED ZEROFILL NOT NULL,"
			+ " PRIMARY KEY (`usr`, `sanatorio`),"
			+ " INDEX `sanat` (`sanatorio`),"
			+ " INDEX `usr` (`usr`),"
			+ " CONSTRAINT `sanat` FOREIGN KEY (`sanatorio`) REFERENCES `sanatorios` (`idSanatorio`),"
			+ " CONSTRAINT `usr` FOREIGN KEY (`usr`) REFERENCES `usuarios` (`user`)"
			+ ")"
			+ " COLLATE='utf8_general_ci'"
			+ " ENGINE=InnoDB";
	
	//14
	private String anestesistas = "CREATE TABLE `anestesistas` ("
			+ " `idAnestesista` INT(4) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ " `nombreAnestesista` VARCHAR(30) NOT NULL DEFAULT '0',"
			+ " `apellidoAnestesista` VARCHAR(30) NOT NULL DEFAULT '0',"
			+ " `matricula` INT(5) NOT NULL DEFAULT '0',"
			+ " `grupo` INT(3) NOT NULL DEFAULT '0',"
			+ " `usuario` VARCHAR(20) NULL DEFAULT NULL,"
			+ " PRIMARY KEY (`idAnestesista`),"
			+ " INDEX `usuario` (`usuario`),"
			+ " CONSTRAINT `usuario` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`user`)"
			+ ")"
			+ " COLLATE='utf8_general_ci'"
			+ " ENGINE=InnoDB";

	//15
	private String sanatorios_anestesistas = "CREATE TABLE `sanatorios_anestesistas` ("
			+ " `idSanatorio` INT(3) UNSIGNED ZEROFILL NOT NULL,"
			+ " `idAnestesista` INT(4) UNSIGNED ZEROFILL NOT NULL,"
			+ " PRIMARY KEY (`idSanatorio`, `idAnestesista`),"
			+ " INDEX `codAnestesista` (`idAnestesista`),"
			+ " INDEX `idSanatorio` (`idSanatorio`),"
			+ " CONSTRAINT `codAnestesista` FOREIGN KEY (`idAnestesista`) REFERENCES `anestesistas` (`idAnestesista`),"
			+ "CONSTRAINT `codSanatorio` FOREIGN KEY (`idSanatorio`) REFERENCES `sanatorios` (`idSanatorio`)"
			+ ")"
			+ " COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//16
	private String saldos = "CREATE TABLE `saldos` ("
			+ " `idAnestesista` INT(4) UNSIGNED ZEROFILL NOT NULL,"
			+ " `mes` INT(2) UNSIGNED ZEROFILL NOT NULL,"
			+ " `anio` INT(4) UNSIGNED NOT NULL,"
			+ " `monto` FLOAT(6,2) UNSIGNED ZEROFILL NULL DEFAULT '000.00',"
			+ " `estado` VARCHAR(5) NULL DEFAULT NULL,"
			+ " PRIMARY KEY (`idAnestesista`, `mes`, `anio`),"
			+ " CONSTRAINT `Anestesistas` FOREIGN KEY (`idAnestesista`) REFERENCES `anestesistas` (`idAnestesista`)"
			+ ")"
			+ " COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//17 
	private String anestesias = "CREATE TABLE `anestesias` ("
			+ " `idAnestesia` INT(9) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
			+ " `fecPrestacion` DATETIME NOT NULL,"
			+ " `fecARA` DATE NOT NULL,"
			+ " `fecRendicion` DATE NOT NULL,"
			+ " `fecCarga` DATE NOT NULL,"
			+ " `afiliado` VARCHAR(30) NOT NULL DEFAULT '0',"
			+ " `nroAfiliado` INT(8) UNSIGNED ZEROFILL NOT NULL DEFAULT '00000000',"
			+ " `nocturno` TINYINT(1) NOT NULL DEFAULT '0',"
			+ " `feriado` TINYINT(1) NOT NULL DEFAULT '0',"
			+ " `fds` TINYINT(1) NOT NULL DEFAULT '0'," 
			+ " `nroTalon` INT(9) NOT NULL DEFAULT '0'," 
			+ " `nroVias` INT(1) NOT NULL DEFAULT '0',"
			+ " `edad` VARCHAR(20) NOT NULL DEFAULT '0',"
			+ " `user` VARCHAR(50) NOT NULL,"
			+ " `idMedico` INT(4) UNSIGNED ZEROFILL NOT NULL,"
			+ " `idAnestesista` INT(4) UNSIGNED ZEROFILL NOT NULL,"
			+ " `idSanatorio` INT(3) UNSIGNED ZEROFILL NOT NULL,"
			+ " `idOS` INT(4) UNSIGNED ZEROFILL NOT NULL,"
			+ " `idTpoAnestesia` INT(2) UNSIGNED ZEROFILL NOT NULL,"
			+ " PRIMARY KEY (`idAnestesia`),"
			+ " INDEX `user` (`user`),"
			+ " INDEX `idMedico` (`idMedico`),"
			+ " INDEX `idAnestesista` (`idAnestesista`),"
			+ " INDEX `idOS` (`idOS`),"
			+ " INDEX `idTpoAnestesia` (`idTpoAnestesia`),"
			+ " INDEX `idSanatorioFK` (`idSanatorio`),"
			+ " CONSTRAINT `idAnestesista` FOREIGN KEY (`idAnestesista`) REFERENCES `anestesistas` (`idAnestesista`),"
			+ " CONSTRAINT `idMedico` FOREIGN KEY (`idMedico`) REFERENCES `medicos` (`idMedico`),"
			+ " CONSTRAINT `idOS` FOREIGN KEY (`idOS`) REFERENCES `obras_sociales` (`idOS`),"
			+ " CONSTRAINT `idSanatorioFK` FOREIGN KEY (`idSanatorio`) REFERENCES `sanatorios` (`idSanatorio`),"
			+ " CONSTRAINT `idTpoAnestesia` FOREIGN KEY (`idTpoAnestesia`) REFERENCES `tpoanestesias` (`idTpoAnestesia`),"
			+ " CONSTRAINT `user` FOREIGN KEY (`user`) REFERENCES `usuarios` (`user`)"
			+ ")"
			+ " COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	//18
	private String procedimientos_anestesias = "CREATE TABLE `procedimientos_anestesias` ("
			+ " `codProcedimiento` INT(6) UNSIGNED ZEROFILL NOT NULL,"
			+ " `idAnestesia` INT(9) UNSIGNED ZEROFILL NOT NULL,"
			+ " PRIMARY KEY (`codProcedimiento`, `idAnestesia`),"
			+ " INDEX `codAnestesia` (`idAnestesia`),"
			+ " CONSTRAINT `codAnestesia` FOREIGN KEY (`idAnestesia`) REFERENCES `anestesias` (`idAnestesia`),"
			+ " CONSTRAINT `nroProcedimiento` FOREIGN KEY (`codProcedimiento`) REFERENCES `procedimientos` (`codProcedimiento`)"
			+ ")"
			+ " COLLATE='utf8_general_ci'"
			+ "ENGINE=InnoDB";
	
	private ArrayList<String> tablas = new ArrayList<>();
	

	
	public BaseDatos() {
		this.tablas.add("procedimientos");//1
		this.tablas.add("tpoAnestesias");//2
		this.tablas.add("sanatorios");//3
		this.tablas.add("obras_sociales");//4
		this.tablas.add("feriados");//5
		this.tablas.add("programas");//6
		this.tablas.add("menus");//7
		this.tablas.add("medicos");//8
		this.tablas.add("precios");//9
		this.tablas.add("menus_programas");//10
		this.tablas.add("roles");//11
		this.tablas.add("usuarios");//12
		this.tablas.add("usuarios_sanatorios");//13
		this.tablas.add("anestesistas");//14
		this.tablas.add("sanatorios_anestesistas");//15
		this.tablas.add("saldos");//16
		this.tablas.add("anestesias");//17
		this.tablas.add("procedimientos_anestesias");//18
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getProcedimientos() {
		return procedimientos;
	}



	public String getTpoAnestesias() {
		return tpoAnestesias;
	}



	public String getSanatorios() {
		return sanatorios;
	}



	public String getObrasSociales() {
		return obrasSociales;
	}



	public String getFeriados() {
		return feriados;
	}



	public String getProgramas() {
		return programas;
	}



	public String getMenus() {
		return menus;
	}



	public String getMedicos() {
		return medicos;
	}



	public String getPrecios() {
		return precios;
	}



	public String getMenus_programas() {
		return menus_programas;
	}



	public String getRoles() {
		return roles;
	}



	public String getUsuarios() {
		return usuarios;
	}



	public String getUsuarios_sanatorios() {
		return usuarios_sanatorios;
	}



	public String getAnestesistas() {
		return anestesistas;
	}



	public String getSanatorios_anestesistas() {
		return sanatorios_anestesistas;
	}



	public String getSaldos() {
		return saldos;
	}



	public String getAnestesias() {
		return anestesias;
	}



	public String getProcedimientos_anestesias() {
		return procedimientos_anestesias;
	}



	public ArrayList<String> getTablas() {
		return tablas;
	}

	
}