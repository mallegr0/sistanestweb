package data;

import java.sql.*;
import java.util.ArrayList;

import entidades.Procedimiento;
import util.ApplicationException;

public class DataProcedimiento {
	
	public DataProcedimiento() {};
	
	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
	}
		
	public boolean altaProcedimiento(Procedimiento p) throws ApplicationException{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO procedimientos "
				+ "(idProcedimiento,codProcedimiento, descProcedimiento, complejidad) VALUES (?,?,?,?)";
		try {
			stmt = conn.abrirConn().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			
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
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally { cerrar(stmt, rs); }
	}

	public boolean modificaProcedimiento(Procedimiento p) throws ApplicationException{
		
		PreparedStatement stmt = null;
		String sql = "UPDATE procedimientos SET (codProcedimiento = ?, descProcedimiento = ?, complejidad = ?)"
				+ " WHERE idProcedimiento = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, p.getCodProcedimiento());
			stmt.setString(2, p.getDescProcedimiento());
			stmt.setInt(3, p.getComplejidad());
			
			stmt.execute();
			return true;
			
		} 
		catch (SQLException e){ 
			e.printStackTrace();
			return false;}
		finally { cerrar(stmt, null);}
	}

	public boolean bajaProcedimiento(Procedimiento p) throws ApplicationException{
		
		PreparedStatement stmt = null;
		String sql = "DELETE FROM procedimientos WHERE idProcedimiento = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, p.getIdProcedimiento());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null); }
	}

	public Procedimiento consultaProcedimiento(Procedimiento p) throws ApplicationException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Procedimiento pro = null;
		String sql = "SELECT * FROM procedimiento WHERE idProcedimiento = ?";
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, p.getIdProcedimiento());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				pro = new Procedimiento(rs.getInt("idProcedimiento"), rs.getInt("codProcedimiento"), 
						rs.getString("descProcedimiento"), rs.getInt("complejidad"));
				}
			}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return pro;
	}
	
	public ArrayList<Procedimiento> listarProcedimientos() throws ApplicationException{
		ArrayList<Procedimiento> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM procedimientos ORDER BY codProcedimiento";
		try{
			stmt= conn.abrirConn().prepareStatement(sql);
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
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs); }
		return listado;
	}

}
