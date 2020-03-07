package data;

import java.sql.*;
import java.util.ArrayList;

import entidades.BaseDatos;

public class DataBase {
	
	public DataBase() {}
	private Connection conn;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement stmt = null;
	private BaseDatos bbdd = new BaseDatos();
	private ArrayList<String> l = new ArrayList<String>();
	
	public int base(String db, String server, String usr, String psw, int fconn){
		if (fconn == 0){
		if(validarBBDD(db, server, usr, psw) == false){
			if(crearBBDD(db, server, usr, psw) == true){ crearTablas(db, server, usr, psw); }
			}
		else{
			System.out.println("La BBDD "+db+" ya existe!!");
			crearTablas(db, server, usr, psw);
		}}
		return 1;
	}
		
	
	private boolean validarBBDD(String db, String server, String user, String pass){
		try {
			String sql = "SHOW DATABASES LIKE '%"+db+"%'";
			conn = DriverManager.getConnection(server, user, pass);
			st = conn.createStatement();
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
	
	private boolean validarTabla(String nombre, String server, String db, String user, String pass){
		try {
			String sql = "SHOW TABLES LIKE '"+nombre+"'";
			conn = DriverManager.getConnection(server+db, user, pass);
			st = conn.createStatement();
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
	
	private boolean crearBBDD(String db, String server, String user, String pass){
		try {
			conn = (Connection) DriverManager.getConnection(server, user, pass);
				stmt = conn.prepareStatement("CREATE DATABASE IF NOT EXISTS "+db+" COLLATE=`utf8_general_ci`");
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
	
	private void crearTablas(String db, String server, String user, String pass){
		l=bbdd.getTablas();
		if( validarTabla(l.get(0), server, db, user, pass) == false){altaTabla(l.get(0), bbdd.getProcedimientos(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(0)+" ya existe!!");}
		
		if( validarTabla(l.get(1), server, db, user, pass) == false){altaTabla(l.get(1), bbdd.getTpoAnestesias(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(1)+" ya existe!!");}
		
		if( validarTabla(l.get(2), server, db, user, pass) == false){altaTabla(l.get(2), bbdd.getSanatorios(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(2)+" ya existe!!");}
		
		if( validarTabla(l.get(3), server, db, user, pass) == false){altaTabla(l.get(3), bbdd.getObrasSociales(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(3)+" ya existe!!");}
		
		if( validarTabla(l.get(4), server, db, user, pass) == false){altaTabla(l.get(4), bbdd.getFeriados(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(4)+" ya existe!!");}
		
		if( validarTabla(l.get(5), server, db, user, pass) == false){altaTabla(l.get(5), bbdd.getProgramas(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(5)+" ya existe!!");}
		
		if( validarTabla(l.get(6), server, db, user, pass) == false){altaTabla(l.get(6), bbdd.getMenus(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(6)+" ya existe!!");}
		
		if( validarTabla(l.get(7), server, db, user, pass) == false){altaTabla(l.get(7), bbdd.getMedicos(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(7)+" ya existe!!");}
		
		if( validarTabla(l.get(8), server, db, user, pass) == false){altaTabla(l.get(8), bbdd.getPrecios(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(8)+" ya existe!!");}
		
		if( validarTabla(l.get(9), server, db, user, pass) == false){altaTabla(l.get(9), bbdd.getMenus_programas(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(9)+" ya existe!!");}
		
		if( validarTabla(l.get(10), server, db, user, pass) == false){altaTabla(l.get(10), bbdd.getRoles(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(10)+" ya existe!!");}
		
		if( validarTabla(l.get(11), server, db, user, pass) == false){altaTabla(l.get(11), bbdd.getUsuarios(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(11)+" ya existe!!");}
		
		if( validarTabla(l.get(12), server, db, user, pass) == false){altaTabla(l.get(12), bbdd.getUsuarios_sanatorios(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(12)+" ya existe!!");}
		
		if( validarTabla(l.get(13), server, db, user, pass) == false){altaTabla(l.get(13), bbdd.getAnestesistas(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(13)+" ya existe!!");}
		
		if( validarTabla(l.get(14), server, db, user, pass) == false){altaTabla(l.get(14), bbdd.getSanatorios_anestesistas(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(14)+" ya existe!!");}
		
		if( validarTabla(l.get(15), server, db, user, pass) == false){altaTabla(l.get(15), bbdd.getSaldos(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(15)+" ya existe!!");}
		
		if( validarTabla(l.get(16), server, db, user, pass) == false){altaTabla(l.get(16), bbdd.getAnestesias(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(16)+" ya existe!!");}
		
		if( validarTabla(l.get(17), server, db, user, pass) == false){altaTabla(l.get(17), bbdd.getProcedimientos_anestesias(), server, db, user, pass);}
		else { System.out.println("La tabla "+l.get(17)+" ya existe!!");}
		}
	
	private boolean altaTabla (String nombre, String sql, String server, String db, String user, String pass){
		try {
			conn = DriverManager.getConnection(server+db, user, pass);
			stmt = conn.prepareStatement(sql);
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
	

}
