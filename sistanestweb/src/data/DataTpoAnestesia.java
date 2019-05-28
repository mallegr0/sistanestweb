package data;

import util.ApplicationException;
import java.sql.*;
import entidades.TipoAnestesia;

public class DataTpoAnestesia {
	
	public DataTpoAnestesia(){};
	
	public boolean altaTpoAnestesia(TipoAnestesia ta){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO tpoanestesia (idTipoAnestesia, descTpoAnestesia) VALUES (?,?)";
		
		try {
			stmt=Conector.getInstancia().abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, ta.getIdTpoAnestesia());
			stmt.setString(2, ta.getDescTpoAnestesia());
			
			stmt.execute();
			
			rs=stmt.getGeneratedKeys();
			if(rs != null && rs.next() ){
				ta.setIdTpoAnestesia(rs.getInt(1));
			}
			return true;
		}
		catch(SQLException | ApplicationException e){ 
			e.printStackTrace();
			return false;
			}
		finally {
			try {
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
				Conector.getInstancia().cerrarConn();
			} catch (SQLException | ApplicationException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean bajaTpoAnestesia(TipoAnestesia ta){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "DELETE FROM tpoanestesia WHERE idTpoAnestesia = ?";
		
		try {
			stmt=Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, ta.getIdTpoAnestesia());
			stmt.execute();
			return true;
		} 
		catch (SQLException | ApplicationException e) {
			e.printStackTrace();
			return false;
		}
		finally{
			try{
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
				Conector.getInstancia().cerrarConn();
			}
			catch(SQLException | ApplicationException e) {e.printStackTrace();}
		}
		
	}
}
