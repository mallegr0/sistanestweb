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
	private static String db = "pruebaauto"; //Base de datos que quiero crear
	private static Connection conexion; //Instancia Connection para realizar la conexion. 
	private static PreparedStatement stmt = null; //Variable para crear las tablas y BD
	private static Statement st = null; //Variable para consultar si existe la BD
	private static ResultSet rs = null;	//Variable en donde obtengo la respuesta 
	private int cantConn = 0; //cantidad de conexiones a la BBDD
	
	private BaseDatos bbdd = new BaseDatos();
	
	
	public void base(){
		if(validarBBDD() == false){
			if(crearBBDD() == true){
				crearTablas();
			}
		if(validarTablas() == false){ crearTablas(); }
			}
		}
	
	
	private boolean validarTablas(){
		return true;
	}
	private boolean validarBBDD(){
		try {
			String sql = "SHOW DATABASES LIKE '%"+db+"%'";
			conexion = DriverManager.getConnection(server, user, pass);
			st = conexion.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				st.close();
				rs.close();
				return true;
				}
			else{
				st.close();
				rs.close();
				return false;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	private boolean crearBBDD(){
		try {
			conexion = (Connection) DriverManager.getConnection(server, user, pass);
				stmt = conexion.prepareStatement("CREATE DATABASE IF NOT EXISTS "+db+" COLLATE=`utf8_general_ci`");
			 	if(stmt.executeUpdate() == 1){
			 		System.out.println("BBDD creada!!");
			 		stmt.close();
			 		return true;
			 	}
			 	else{
			 		System.out.println("La BBDD ya existe!!");
			 		stmt.close();
			 		return false;
			 	}
		} catch (SQLException e) {
			System.out.println("no se creo la BBDD");
			e.printStackTrace();
			return false;
		}
	}
	
	private void crearTablas(){
		altaTabla("Obras Sociales", bbdd.getObrasSociales());
		altaTabla("Feriados", bbdd.getFeriados());
	}
	
	private boolean altaTabla (String nombre, String sql){
		try {
			conexion = DriverManager.getConnection(server+db, user, pass);
			stmt = conexion.prepareStatement(sql);
			if (stmt.executeUpdate() == 0){
				System.out.println(nombre + ".....Tabla creada");
				stmt.close();
				return true;
			}
			else{
				System.out.println(nombre+".....la tabla ya existe!!");
				return false;
			}
		}
		catch(SQLException e){
			System.out.println("Fallo al crear la tabla "+nombre);
			e.printStackTrace();
			return false;
		}
	}
	
	public Conector(){
		base();
		System.out.println("salio del metodo BASE() pero no funciono");
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

