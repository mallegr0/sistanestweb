package data;

import java.sql.*;
import java.util.ArrayList;
import entidades.Usuario;
import util.ApplicationException;

public class DataUsuario {
	
	public DataUsuario(){};

	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
	}
	
	public boolean altaUsuario(Usuario u) throws ApplicationException{ 
		PreparedStatement stmt = null;
		String sql = "INSERT INTO usuarios (user, password, nombreUsuario, apellidoUsuario, mailUsuario, idRol)"
				+ "VALUES (?, ?, ?, ?, ?,NULL)";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, u.getUser());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getNombreUsuario());
			stmt.setString(4, u.getApellidoUsuario());
			stmt.setString(5, u.getMailUsuario());

			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null); }
	}
	
	public boolean bajaUsuario(Usuario u) throws ApplicationException{ 
		PreparedStatement stmt = null;
		String sql = "DELETE FROM usuarios WHERE user = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, u.getUser());
			stmt.execute();
			return true;
			}
		catch(SQLException e){
			e.printStackTrace();
			return false;
			}
		finally{ cerrar(stmt, null); }
	}
	
	public boolean modificaUsuario(Usuario u) throws ApplicationException{ 
		PreparedStatement stmt = null;
		String sql = "UPDATE usuarios SET password= ?, nombreUsuario = ?, apellidoUsuario = ?,"
				+ "mailUsuario = ? WHERE user = ?";
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, u.getPassword());
			stmt.setString(2, u.getNombreUsuario());
			stmt.setString(3, u.getApellidoUsuario());
			stmt.setString(4, u.getMailUsuario());
			stmt.setString(5, u.getUser());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null); }
	}
	
	public Usuario consultaUsuario(Usuario u) throws ApplicationException{ 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario res = null;
		String sql = "SELECT * FROM usuarios WHERE user = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, u.getUser());
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				res = new Usuario();
				res.setUser(rs.getString(1));
				res.setPassword(rs.getString(2));
				res.setNombreUsuario(rs.getString(3));
				res.setApellidoUsuario(rs.getString(4));
				res.setMailUsuario(rs.getString(5));
				res.setIdRol(rs.getInt(6));
			}
		}
			catch(SQLException e){ e.printStackTrace();}
			finally{ cerrar(stmt, rs); }
			return res;
		}
	
	public ArrayList<Usuario> listarUsuarios() throws ApplicationException{
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario u = null;
		ArrayList<Usuario> listado = new ArrayList<>();
		String sql = "SELECT * FROM usuarios ORDER BY user";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				u = new Usuario();
				u.setUser(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setNombreUsuario(rs.getString(3));
				u.setApellidoUsuario(rs.getString(4));
				u.setMailUsuario(rs.getString(5));
				u.setIdRol(rs.getInt(6));
				listado.add(u);
			}
		} 
		catch (SQLException e) {e.printStackTrace();} 
		finally{ cerrar(stmt, rs); }
		return listado;
	}
	
	public ArrayList<Usuario> listarPendientes() throws ApplicationException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario u = null;
		ArrayList<Usuario> pendientes = new ArrayList<>();
		String sql = "SELECT * FROM usaurios WHERE idRol IS NULL ORDER BY user";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				u = new Usuario();
				u.setUser(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setNombreUsuario(rs.getString(3));
				u.setApellidoUsuario(rs.getString(4));
				u.setMailUsuario(rs.getString(5));
				u.setIdRol(rs.getInt(6));
				pendientes.add(u);
			}
		}
		catch(SQLException e) {e.printStackTrace();}
		finally{ cerrar(stmt, rs); }
		return pendientes;}
	
	public boolean cambioContraseña(Usuario u) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE usuarios SET password = ? WHERE user = ?";
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, u.getPassword());
			stmt.setString(2, u.getUser());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null); }
	}
	
	public boolean actualizaRol(Usuario u) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE usuarios SET idRol = ? WHERE user = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, u.getIdRol());
			stmt.setString(2, u.getUser());
			stmt.execute();
			return true;
			}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null); }
	}


}
