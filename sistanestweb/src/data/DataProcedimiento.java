package data;

import java.sql.*;
import java.util.ArrayList;

import entidades.Procedimiento;
import util.ApplicationException;

public class DataProcedimiento {
	
	public DataProcedimiento() {};
	
		
	public boolean altaProcedimiento(Procedimiento p){
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO procedimientos "
				+ "(idProcedimiento,codProcedimiento, descProcedimiento, complejidad) VALUES (?,?,?,?)";
		try {
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, p.getIdProcedimiento());
			stmt.setInt(2, p.getCodProcedimiento());
			stmt.setString(3, p.getDescProcedimiento());
			stmt.setInt(4, p.getComplejidad());
			
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setIdProcedimiento(rs.getInt(1));
			}
			return true;
			
		} catch (SQLException | ApplicationException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(rs!= null )rs.close();
				if(stmt != null) stmt.close();
				Conector.getInstancia().cerrarConn();
			}
			catch(SQLException | ApplicationException e){
				e.printStackTrace();
			}
		}
	}

	public boolean modificaProcedimiento(Procedimiento p){
		
		PreparedStatement stmt = null;
		String sql = "UPDATE procedimientos SET (codProcedimiento = ?, descProcedimiento = ?, complejidad = ?)"
				+ " WHERE idProcedimiento = ?";
		
		try {
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, p.getCodProcedimiento());
			stmt.setString(2, p.getDescProcedimiento());
			stmt.setInt(3, p.getComplejidad());
			
			stmt.execute();
			return true;
			
		} 
		catch (SQLException | ApplicationException e){ 
			e.printStackTrace();
			return false;}
		finally {
			try{
				if(stmt != null) stmt.close();
				Conector.getInstancia().cerrarConn();
			}catch(SQLException | ApplicationException e) {e.printStackTrace();}
		}
	}

	public boolean bajaProcedimiento(Procedimiento p){
		
		PreparedStatement stmt = null;
		String sql = "DELETE FROM procedimientos WHERE idProcedimiento = ?";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, p.getIdProcedimiento());
			stmt.execute();
			return true;
		}
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally{
			try{
				if(stmt != null) stmt.close();
				Conector.getInstancia().cerrarConn();
			}
			catch(SQLException | ApplicationException e){ e.printStackTrace();}
		}
	}

	public Procedimiento consultaProcedimiento(Procedimiento p){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Procedimiento pro = null;
		String sql = "SELECT * FROM procedimiento WHERE idProcedimiento = ?";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, p.getIdProcedimiento());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				pro = new Procedimiento(rs.getInt("idProcedimiento"), rs.getInt("codProcedimiento"), 
						rs.getString("descProcedimiento"), rs.getInt("complejidad"));
				}
			}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{
			try{
				if(rs!= null) rs.close();
				if(stmt != null) stmt.close();
				Conector.getInstancia().cerrarConn();
			}
			catch(SQLException | ApplicationException e){e.printStackTrace();}
		}
		return pro;
	}
	
	public ArrayList<Procedimiento> listarProcedimientos(){
		ArrayList<Procedimiento> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM procedimientos ORDER BY codProcedimiento";
		try{
			stmt= Conector.getInstancia().abrirConn().prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				Procedimiento p = new Procedimiento();
				p.setIdProcedimiento(rs.getInt(1));
				p.setCodProcedimiento(rs.getInt(2));
				p.setDescProcedimiento(rs.getString(3));
				p.setComplejidad(rs.getInt(4));
				listado.add(p);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{
			try{
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
				Conector.getInstancia().cerrarConn();
			}
			catch(SQLException | ApplicationException e) {e.printStackTrace();}
		}
		return listado;
	}

}
