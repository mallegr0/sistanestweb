package data;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Programa;
import util.ApplicationException;

public class DataPrograma {
	
	public DataPrograma() {}
	
	private Conector conn = new Conector();
	
	private void cerrarConn(PreparedStatement stmt, ResultSet rs){
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}
	
	public boolean altaPrograma(Programa p) throws ApplicationException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="INSERT INTO programas (idProg, modulo, nombre) VALUES (?,?,?)";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, p.getIdProg());
			stmt.setString(2, p.getModulo());
			stmt.setString(3, p.getNombre());
			
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			
			if(rs != null && rs.next()){
				p.setIdProg(rs.getInt(1));
			}
			return true;
		} 
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally {
			cerrarConn(stmt, rs);
		}
	}

	public boolean bajaPrograma(Programa p) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql ="DELETE FROM programas WHERE idProg = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, p.getIdProg());
			
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
	
	public boolean modificaPrograma(Programa p) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql ="UPDATE programas SET modulo = ?, nombre = ? WHERE idProg = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setString(1, p.getModulo());
			stmt.setString(2, p.getNombre());
			stmt.setInt(3, p.getIdProg());
			
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
		
	public Programa consultaPrograma(Programa p) throws ApplicationException{
		Programa rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM programas WHERE idProg = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			stmt.setInt(1, p.getIdProg());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rta = new Programa();
				rta.setIdProg(rs.getInt(1));
				rta.setModulo(rs.getString(2));
				rta.setNombre(rs.getString(3));
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
	
	public ArrayList<Programa> listarPrograma() throws ApplicationException{
		ArrayList<Programa> lista = new ArrayList<>();
		Programa p = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM programas ORDER BY idProg";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				p = new Programa();
				p.setIdProg(rs.getInt(1));
				p.setModulo(rs.getString(2));
				p.setNombre(rs.getString(3));
				lista.add(p);
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
