package data;

import util.ApplicationException;
import java.sql.*;
import java.util.ArrayList;


import entidades.TipoAnestesia;

public class DataTpoAnestesia {
	
	public DataTpoAnestesia(){};
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstancia().cerrarConn();
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
	}
	
	public boolean altaTpoAnestesia(TipoAnestesia ta){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO tpoanestesias (idTipoAnestesia, descTpoAnestesia) VALUES (?,?)";
		
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
		finally { cerrar(stmt, rs); }
	}
	
	public boolean bajaTpoAnestesia(TipoAnestesia ta){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "DELETE FROM tpoanestesias WHERE idTpoAnestesia = ?";
		
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
		finally { cerrar(stmt, rs); }
		
	}

	public boolean modificaTpoAnestesia(TipoAnestesia ta){
		PreparedStatement stmt = null;
		String sql = "UPDATE tpoanestesias SET descTpoAnestesia = ? WHERE idTpoAnestesia = ?";
		
		try {
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setString(1, ta.getDescTpoAnestesia());
			stmt.setInt(2, ta.getIdTpoAnestesia());
			stmt.execute();
			return true;
			}
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally { cerrar(stmt, null); }
	}

	public TipoAnestesia consultaTpoAnestesia(TipoAnestesia ta){
		TipoAnestesia res = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tpoanestesias WHERE idTpoAnestesia = ?";
		
		try{
			stmt= Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, ta.getIdTpoAnestesia());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				res = new TipoAnestesia();
				res.setIdTpoAnestesia(rs.getInt(1));
				res.setDescTpoAnestesia(rs.getString(2));
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally { cerrar(stmt, rs); }
		return res;
	}

	public ArrayList<TipoAnestesia> listarTpoAnestesia(){
		ArrayList<TipoAnestesia> listado = new ArrayList<>();
		TipoAnestesia ta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tpoanestesias ORDER BY idTpoAnestesia";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				ta = new TipoAnestesia();
				ta.setIdTpoAnestesia(rs.getInt(1));
				ta.setDescTpoAnestesia(rs.getString(2));
				listado.add(ta);
			}
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally { cerrar(stmt, rs); }
		return listado;
	}

}
