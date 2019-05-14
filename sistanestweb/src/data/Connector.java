package data;

import java.sql.*;
import util.ApplicationException;



public class Connector {
	private String dbDriver="com.mysql.jdbc.Driver";
	private String user="root";
	private String pass="root";
	private String server="jdbc:mysql://localhost/sistanestweb/";
	private Connection conn;
	private int cantConn=0;
	
	
	private void Conexion() throws ApplicationException{
		try{
			Class.forName(dbDriver);
			conn=DriverManager.getConnection(server,user,pass);
			System.out.println("Conexion exitosa!!!");
			
		}
		catch(ClassNotFoundException | SQLException e){
			System.err.println();
			e.printStackTrace();
			
		}
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
