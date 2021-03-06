package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ApplicationException;
import entidades.Sanatorio;

public class DataSanatorio {
	
	public DataSanatorio() {}

	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	public boolean altaSanatorio(Sanatorio s) throws ApplicationException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO sanatorios (idSanatorio, razonSocial) VALUES (?, ?)";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, s.getIdSanatorio());
			stmt.setString(2, s.getRazonSocial());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				s.setIdSanatorio(rs.getInt(1));
			}
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, rs);}
	}
	
	public boolean bajaSanatorio(Sanatorio s) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "DELETE FROM sanatorios WHERE idSanatorio = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, s.getIdSanatorio());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally { cerrar(stmt, null);}
	}
	
	public boolean modificaSanatorio(Sanatorio s) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE sanatorios SET razonSocial = ? WHERE idSanatorio = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, s.getRazonSocial());
			stmt.setInt(2, s.getIdSanatorio());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public Sanatorio consultaSanatorio(Sanatorio s) throws ApplicationException{
		Sanatorio sanatorio = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sanatorios WHERE idSanatorio = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, s.getIdSanatorio());
			rs=stmt.executeQuery();
			
			if(rs != null && rs.next()){
				sanatorio = new Sanatorio();
				sanatorio.setIdSanatorio(rs.getInt(1));
				sanatorio.setRazonSocial(rs.getString(2));
			}
		}
		catch(SQLException e){ e.printStackTrace(); }
		finally{ cerrar(stmt, rs);}
		return sanatorio;
	}
	
	public ArrayList<Sanatorio> listarSanatorio() throws ApplicationException{
		ArrayList<Sanatorio> listado = new ArrayList<>();
		Sanatorio s = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM sanatorios ORDER BY idSanatorio";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				s = new Sanatorio();
				s.setIdSanatorio(rs.getInt(1));
				s.setRazonSocial(rs.getString(2));
				listado.add(s);
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
}
