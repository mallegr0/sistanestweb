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
	ArrayList<String> l = new ArrayList<>();
	
	
	public void base(){
		if(validarBBDD() == false){
			if(crearBBDD() == true){ crearTablas(); }
			}
		else{
			System.out.println("La BBDD "+db+" ya existe!!");
			crearTablas();
		}
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
					return false;
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	private boolean validarTabla(String nombre){
		try {
			String sql = "SHOW TABLES LIKE '"+nombre+"'";
			conexion = DriverManager.getConnection(server+db, user, pass);
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
					return false;
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	private boolean crearBBDD(){
		try {
			conexion = (Connection) DriverManager.getConnection(server, user, pass);
				stmt = conexion.prepareStatement("CREATE DATABASE IF NOT EXISTS "+db+" COLLATE=`utf8_general_ci`");
			 	if(stmt.executeUpdate() == 1){
			 		System.out.println("La BBDD "+db+" fue creada!!");
			 		stmt.close();
			 		return true;
			 	}
			 	else{
			 		System.out.println("La BBDD "+db+" ya existe!!");
			 		stmt.close();
			 		return false;
			 	}
		} catch (SQLException e) {
			System.out.println("no se creo la BBDD "+db);
			e.printStackTrace();
			return false;
		}
	}
	
	private void crearTablas(){
		l=bbdd.getTablas();
		if( validarTabla(l.get(0)) == false){altaTabla(l.get(0), bbdd.getProcedimientos());}
		else { System.out.println("La tabla "+l.get(0)+" ya existe!!");}
		
		if( validarTabla(l.get(1)) == false){altaTabla(l.get(1), bbdd.getTpoAnestesias());}
		else { System.out.println("La tabla "+l.get(1)+" ya existe!!");}
		
		if( validarTabla(l.get(2)) == false){altaTabla(l.get(2), bbdd.getSanatorios());}
		else { System.out.println("La tabla "+l.get(2)+" ya existe!!");}
		
		if( validarTabla(l.get(3)) == false){altaTabla(l.get(3), bbdd.getObrasSociales());}
		else { System.out.println("La tabla "+l.get(3)+" ya existe!!");}
		
		if( validarTabla(l.get(4)) == false){altaTabla(l.get(4), bbdd.getFeriados());}
		else { System.out.println("La tabla "+l.get(4)+" ya existe!!");}
		
		if( validarTabla(l.get(5)) == false){altaTabla(l.get(5), bbdd.getProgramas());}
		else { System.out.println("La tabla "+l.get(5)+" ya existe!!");}
		
		if( validarTabla(l.get(6)) == false){altaTabla(l.get(6), bbdd.getMenus());}
		else { System.out.println("La tabla "+l.get(6)+" ya existe!!");}
		
		if( validarTabla(l.get(7)) == false){altaTabla(l.get(7), bbdd.getMedicos());}
		else { System.out.println("La tabla "+l.get(7)+" ya existe!!");}
		
		if( validarTabla(l.get(8)) == false){altaTabla(l.get(8), bbdd.getPrecios());}
		else { System.out.println("La tabla "+l.get(8)+" ya existe!!");}
		
		if( validarTabla(l.get(9)) == false){altaTabla(l.get(9), bbdd.getMenus_programas());}
		else { System.out.println("La tabla "+l.get(9)+" ya existe!!");}
		
		if( validarTabla(l.get(10)) == false){altaTabla(l.get(10), bbdd.getRoles());}
		else { System.out.println("La tabla "+l.get(10)+" ya existe!!");}
		
		if( validarTabla(l.get(11)) == false){altaTabla(l.get(11), bbdd.getUsuarios());}
		else { System.out.println("La tabla "+l.get(11)+" ya existe!!");}
		
		if( validarTabla(l.get(12)) == false){altaTabla(l.get(12), bbdd.getUsuarios_sanatorios());}
		else { System.out.println("La tabla "+l.get(12)+" ya existe!!");}
		
		if( validarTabla(l.get(13)) == false){altaTabla(l.get(13), bbdd.getAnestesistas());}
		else { System.out.println("La tabla "+l.get(13)+" ya existe!!");}
		
		if( validarTabla(l.get(14)) == false){altaTabla(l.get(14), bbdd.getSanatorios_anestesistas());}
		else { System.out.println("La tabla "+l.get(14)+" ya existe!!");}
		
		if( validarTabla(l.get(15)) == false){altaTabla(l.get(15), bbdd.getSaldos());}
		else { System.out.println("La tabla "+l.get(15)+" ya existe!!");}
		
		if( validarTabla(l.get(16)) == false){altaTabla(l.get(16), bbdd.getAnestesias());}
		else { System.out.println("La tabla "+l.get(16)+" ya existe!!");}
		
		if( validarTabla(l.get(17)) == false){altaTabla(l.get(17), bbdd.getProcedimientos_anestesias());}
		else { System.out.println("La tabla "+l.get(17)+" ya existe!!");}
		}
	
	private boolean altaTabla (String nombre, String sql){
		try {
			conexion = DriverManager.getConnection(server+db, user, pass);
			stmt = conexion.prepareStatement(sql);
			if (stmt.executeUpdate() == 0){
				System.out.println("La tabla " +nombre+" fue creada OK!");
				stmt.close();
				return true;
			}
		}
		catch(SQLException e){
			System.out.println("Fallo al crear la tabla "+nombre);
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public Conector(){
		base();
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

