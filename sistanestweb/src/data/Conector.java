package data;

import java.sql.*;
import java.util.ArrayList;

import entidades.BaseDatos;
import util.ApplicationException;


public class Conector {
	
	private static String server = "jdbc:mysql://localhost/"; //Nombre del servidor
	private static String user = "root"; //Usuario de BBDD en el servidor
	private static String pass = "root"; //Contraseña de BBDD en el servidor
	private static String driver = "com.mysql.jdbc.Driver"; //Driver de conexion JDBC
	private static String db = "sistanestweb"; //Base de datos que quiero crear
	private Connection conexion;
	private int cantConn = 0; //cantidad de conexiones a la BBDD
	private DataBase data = new DataBase();
	
	
	
	public Conector(){
		data.base(db, server, user, pass);
		try{
			Class.forName(driver);
			conexion = DriverManager.getConnection(server+db, user, pass);
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println("--------");
			System.out.println("FALLO LA CONEXION !!");
			System.out.println("--------");
			e.printStackTrace();
		}
		
	}
	
	public Connection abrirConn(){
		try {
			if( conexion == null || conexion.isClosed()){
				cantConn++;
			}
		} catch (SQLException e) {
			new ApplicationException("Error al conectar a la BBDD",e);
		}
		return conexion;
	}
	
	public void cerrarConn() throws ApplicationException {
		try {
			cantConn--;
			if(cantConn == 0) conexion.close();
		} catch (SQLException e) {
			throw new ApplicationException("Error al cerrar la conexión",e);
		}
		
	}
	
}

