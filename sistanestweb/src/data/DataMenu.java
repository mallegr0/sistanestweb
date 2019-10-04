package data;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Menu;
import util.ApplicationException;

public class DataMenu {
	
	public DataMenu() {}
	
	private Conector conn = new Conector();
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}
	
	public boolean altaMenu(Menu m) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql ="INSERT INTO menus (idProg, idRol, descMenu) VALUES (?,?,?)";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, m.getIdProg());
			stmt.setInt(2, m.getIdRol());
			stmt.setString(3, m.getDescMenu());
			
			stmt.execute();
			return true;
		} 
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally {
			cerrarConn(stmt, null);
		}
	}

	public boolean bajaMenu(Menu m) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql ="DELETE FROM Menus WHERE idProg = ? AND idRol = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, m.getIdProg());
			stmt.setInt(2, m.getIdRol());
			
			stmt.execute();
			return true;
		} 
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally {
			cerrarConn(stmt, null);
		}
	}
	
	public boolean modificaMenu(Menu m) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql ="UPDATE menus SET idProg = ? WHERE idRol = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, m.getIdProg());
			stmt.setInt(2, m.getIdRol());
			
			stmt.execute();
			return true;
		} 
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally {
			cerrarConn(stmt, null);
		}
	}
		
	public Menu consultaMenu(Menu m) throws ApplicationException{
		Menu rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM Menu WHERE idProg = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, m.getIdProg());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rta = new Menu();
				rta.setIdProg(rs.getInt(1));
				rta.setIdRol(rs.getInt(2));
				rta.setDescMenu(rs.getString(3));
			}
			return rta;
		} 
		catch(SQLException e){
			e.printStackTrace();
			return rta;
		}
		finally {
			cerrarConn(stmt, rs);
		}
	}
	
	public ArrayList<Menu> listarMenu() throws ApplicationException{
		ArrayList<Menu> lista = new ArrayList<>();
		Menu m = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM menu ORDER BY idRol, idProg";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				m = new Menu();
				m.setIdProg(rs.getInt(1));
				m.setIdRol(rs.getInt(2));
				m.setDescMenu(rs.getString(3));
				lista.add(m);
			}
			return lista;
		} 
		catch(SQLException e){
			e.printStackTrace();
			return lista;
		}
		finally {
			cerrarConn(stmt, rs);
		}
	}
	
}
