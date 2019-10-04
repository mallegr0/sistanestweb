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
		ResultSet rs = null;
		String sql ="INSERT INTO menus (idMenu, descMenu) VALUES (?,?)";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, m.getIdMenu());
			stmt.setString(2, m.getDescMenu());
			
			stmt.execute();
			
			rs=stmt.getGeneratedKeys();
			if(rs != null && rs.next()) {
				m.setIdMenu(rs.getInt(1));
			}
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
		String sql ="DELETE FROM Menus WHERE idMenu = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, m.getIdMenu());
			
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
		String sql ="UPDATE menus SET descMenu = ? WHERE idMenu = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setString(1, m.getDescMenu());
			stmt.setInt(2, m.getIdMenu());
			
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
		String sql ="SELECT * FROM Menu WHERE idMenu = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, m.getIdMenu());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rta = new Menu();
				rta.setIdMenu(rs.getInt(1));
				rta.setDescMenu(rs.getString(2));
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
		String sql ="SELECT * FROM menu ORDER BY idMenu";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				m = new Menu();
				m.setIdMenu(rs.getInt(1));
				m.setDescMenu(rs.getString(2));
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
