package data;

import java.sql.*;
import util.ApplicationException;



public class Conector {
	private String dbDriver="com.mysql.jdbc.Driver";
	private String user="root";
	private String pass="root";
	private String server="jdbc:mysql://localhost/sistanestweb/";
	private Connection conn;
	private int cantConn=0;
	
	private Conector() throws ApplicationException{
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(server, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ApplicationException("Error en el JDBC", e);
		}
	}
	
	private static Conector instancia;
	
	public static Conector getInstancia() throws ApplicationException{
		if(instancia==null){
			instancia = new Conector();
		}
		return instancia;
	}

	public Connection abrirConn(){
		try {
			if(conn== null | conn.isClosed()){
				cantConn++;
			}
		} catch (Exception e) {
			new ApplicationException("Error al Conectar a la BBDD",e);
		}
		return conn; 
	}

	public void cerrarConn() throws ApplicationException{
		try {
			cantConn--;
			if(cantConn==0){ conn.close();} 
		} catch (Exception e) {
			throw new ApplicationException("Error al desconectar la BBDD",e);
		}
		
	}
}
