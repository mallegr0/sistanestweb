package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Feriado;
import util.ApplicationException;

public class DataFeriado {
	
	public DataFeriado() {}
	
	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	public boolean altaFeriado(Feriado f) throws ApplicationException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO feriados (idFeriados, fecFeriado, descFeriado) VALUES (?, ?, ?)";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, f.getIdFeriado());
			stmt.setDate(2, f.getFecFeriado());
			stmt.setString(3, f.getDescFeriado());
			
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				f.setIdFeriado(rs.getInt(1));
			}
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, rs);}
	}
	
	public boolean bajaFeriado(Feriado f) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "DELETE FROM feriados WHERE idFeriado = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, f.getIdFeriado());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public boolean modificaFeriado(Feriado f) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE feriados SET fecFeriado = ?,  descFeriado = ? WHERE idFeriado = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setDate(1, f.getFecFeriado());
			stmt.setString(2, f.getDescFeriado());
			stmt.setInt(3, f.getIdFeriado());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public Feriado consultaFeriado(Feriado f) throws ApplicationException{
		Feriado rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM feriados WHERE idFeriado = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, f.getIdFeriado());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Feriado();
				rta.setIdFeriado(rs.getInt(1));
				rta.setFecFeriado(rs.getDate(2));
				rta.setDescFeriado(rs.getString(3));
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return rta;
	}
	
	public ArrayList<Feriado> listarFeriado() throws ApplicationException{
		ArrayList<Feriado> listado = new ArrayList<>();
		Feriado rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM feriados ORDER BY idFeriado";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Feriado();
				rta.setIdFeriado(rs.getInt(1));
				rta.setFecFeriado(rs.getDate(2));
				rta.setDescFeriado(rs.getString(3));
				listado.add(rta);
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
}
