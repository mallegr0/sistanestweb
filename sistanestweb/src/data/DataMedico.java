package data;

import java.sql.*;
import util.ApplicationException;
import entidades.Medico;
import java.util.ArrayList;

public class DataMedico {
	
	public DataMedico(){};
	
	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}
	
	public boolean altaMedico(Medico m) throws ApplicationException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO medicos (idMedico, nombreMedico, apellidoMedico, idSanatorio)"
				+ "VALUES (?,?,?,?)";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, m.getIdMedico());
			stmt.setString(2, m.getNombreMedico());
			stmt.setString(3, m.getApellidoMedico());
			stmt.setInt(4, m.getIdSanatorio());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				m.setIdMedico(rs.getInt(1));
			}
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally { cerrar(stmt, rs);}
	}
	
	public boolean bajaMedico(Medico m) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "DELETE FROM medicos WHERE idMedico = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, m.getIdMedico());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally { cerrar(stmt, null);}
	}
	
	public boolean modificaMedico(Medico m) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE medicos SET nombreMedico = ?, apellidoMedico = ?, idSanatorio = ?"
				+ "WHERE idMedico = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, m.getNombreMedico());
			stmt.setString(2, m.getApellidoMedico());
			stmt.setInt(3, m.getIdSanatorio());
			stmt.setInt(4, m.getIdMedico());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public Medico consultaMedico(Medico m) throws ApplicationException{
		Medico rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM medicos WHERE idMedico = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, m.getIdMedico());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rta = new Medico();
				rta.setIdMedico(rs.getInt(1));
				rta.setNombreMedico(rs.getString(2));
				rta.setApellidoMedico(rs.getString(3));
				rta.setIdSanatorio(rs.getInt(4));
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);} 
		return rta;
	}
	
	public ArrayList<Medico> listarMedico() throws ApplicationException{
		ArrayList<Medico> listado = new ArrayList<>();
		Medico m = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM medicos ORDER BY idMedico";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				m = new Medico();
				m.setIdMedico(rs.getInt(1));
				m.setNombreMedico(rs.getString(2));
				m.setApellidoMedico(rs.getString(3));
				m.setIdSanatorio(rs.getInt(4));
				listado.add(m);
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
}
