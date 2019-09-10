package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.ObraSocial;
import util.ApplicationException;

public class DataObraSocial {

	public DataObraSocial() {}
	
	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}
	
	public boolean altaOS(ObraSocial os) throws ApplicationException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO obras_sociales (idOS, descOS, diasMax) VALUES (?, ?, ?)";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, os.getIdOS());
			stmt.setString(2, os.getDescOS());
			stmt.setInt(3, os.getDiasMax());
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				os.setIdOS(rs.getInt(1));
			}
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, rs);}
	}
	
	public boolean bajaOS(ObraSocial os) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "DELETE FROM obras_sociales WHERE idOS = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, os.getIdOS());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	public boolean modificaOS(ObraSocial os) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE obras_sociales SET descOS = ?, diasMax = ? WHERE idOS = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, os.getDescOS());
			stmt.setInt(2, os.getDiasMax());
			stmt.setInt(3, os.getIdOS());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	public ObraSocial consultaOS(ObraSocial os) throws ApplicationException{
		ObraSocial rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM obras_sociales WHERE idOS = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, os.getIdOS());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rta = new ObraSocial();
				rta.setIdOS(rs.getInt(1));
				rta.setDescOS(rs.getString(2));
				rta.setDiasMax(rs.getInt(3));
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return rta;
	}
	
	public ArrayList<ObraSocial> listarOS() throws ApplicationException{
		ArrayList<ObraSocial> listado = new ArrayList<>();
		ObraSocial rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM obras_sociales ORDER BY idOS";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new ObraSocial();
				rta.setIdOS(rs.getInt(1));
				rta.setDescOS(rs.getString(2));
				rta.setDiasMax(rs.getInt(3));
				listado.add(rta);
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
}
