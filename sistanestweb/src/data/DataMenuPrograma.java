package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.MenuPrograma;
import util.ApplicationException;


public class DataMenuPrograma {
	
	public DataMenuPrograma() {}
	
	private Conector conn = new Conector();
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs) {
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}
	
	public boolean altaMenuPrograma(MenuPrograma mp) throws ApplicationException {
		PreparedStatement stmt = null;
		String sql = "INSER INTO menus_programas (idMenu, idProg) VALUES (?, ?)";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, mp.getIdMenu());
			stmt.setInt(2, mp.getIdProg());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			cerrarConn(stmt, null);
		}
	}
	
	public boolean bajaMenuPrograma(MenuPrograma mp) throws ApplicationException {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM menus_programas WHERE idMenu = ? AND idProg = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, mp.getIdMenu());
			stmt.setInt(2, mp.getIdProg());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			cerrarConn(stmt, null);
		}
	}
	
	public boolean modificaMenuPrograma(MenuPrograma mp) throws ApplicationException {
		PreparedStatement stmt = null;
		String sql = "UPDATE FROM menus_programas SET idProg = ? WHERE idMenu = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, mp.getIdProg());
			stmt.setInt(2, mp.getIdMenu());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			cerrarConn(stmt, null);
		}
	}
	
	public MenuPrograma consultaMenuPrograma(MenuPrograma mp) throws ApplicationException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MenuPrograma rta = null;
		String sql = "SELECT * FROM menus_programas WEHRE idMenu = ? AND idProg = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, mp.getIdMenu());
			stmt.setInt(2, mp.getIdProg());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				rta = new MenuPrograma();
				rta.setIdMenu(rs.getInt(1));
				rta.setIdProg(rs.getInt(2));
			}
			return rta;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return rta;
		}
		finally {
			cerrarConn(stmt, rs);
		}
	}
	
	public ArrayList<MenuPrograma> ListarPorMenu(int im) throws ApplicationException {
		ArrayList<MenuPrograma> lista = new ArrayList<MenuPrograma>();
		MenuPrograma mp = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM menus_programas WHERE idMenu = ? ORDER BY idProg";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, im);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				mp = new MenuPrograma();
				mp.setIdMenu(rs.getInt(1));
				mp.setIdProg(rs.getInt(2));
				lista.add(mp);
			}
			return lista;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return lista;
		}
		finally {
			cerrarConn(stmt, rs);
		}
	}
	
	public ArrayList<MenuPrograma> ListarPorPrograma(int ip) throws ApplicationException {
		ArrayList<MenuPrograma> lista = new ArrayList<MenuPrograma>();
		MenuPrograma mp = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM menus_programas WHERE idPrograma = ? ORDER BY idMenu";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, ip);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				mp = new MenuPrograma();
				mp.setIdMenu(rs.getInt(1));
				mp.setIdProg(rs.getInt(2));
				lista.add(mp);
			}
			return lista;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return lista;
		}
		finally {
			cerrarConn(stmt, rs);
		}
	}
	
}
