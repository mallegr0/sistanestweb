package data;

import java.sql.*;
import java.util.ArrayList;
import util.ApplicationException;
import entidades.Rol;


public class DataRol {
	
	public DataRol(){};
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstancia().cerrarConn();
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
	}
	
	public boolean altaRol(Rol r){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO roles (idRol, descRol) VALUES (?, ?)";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, r.getIdRol());
			stmt.setString(2, r.getDescRol());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				r.setIdRol(rs.getInt(1));
			}
			return true;
		}
		catch( SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally {
			cerrar(stmt, rs);
		}
	}
	
	public boolean bajaRol(Rol r){
		PreparedStatement stmt = null;
		String sql = "DELETE FROM roles WHERE idRol = ?";
		
		try {
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, r.getIdRol()); 
			stmt.execute();
			return true;
		} 
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null); }
	}
	
	public boolean modificaRol(Rol r){
		PreparedStatement stmt = null;
		String sql = "UPDATE roles SET descRol = ? WHERE idRol = ?";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setString(1, r.getDescRol());
			stmt.setInt(2, r.getIdRol());
			stmt.execute();
			return true;
		}
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public Rol consultarRol(Rol r){
		Rol rol = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM roles WHERE idRol = ?";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, r.getIdRol());
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rol = new Rol();
				rol.setIdRol(rs.getInt(1));
				rol.setDescRol(rs.getString(2));
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return rol;
	}
	
	public ArrayList<Rol> listarRol(){
		Rol rol = null;
		ArrayList<Rol> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM roles ORDER BY idRol";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rol = new Rol();
				rol.setIdRol(rs.getInt(1));
				rol.setDescRol(rs.getString(2));
				listado.add(rol);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}

}
