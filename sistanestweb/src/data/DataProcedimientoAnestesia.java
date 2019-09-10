package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ApplicationException;
import entidades.ProcedimientoAnestesia;

public class DataProcedimientoAnestesia {
	
	public DataProcedimientoAnestesia(){}

	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	public boolean altaProcedimientoAnestesia(ProcedimientoAnestesia pa) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO procedimientos_anestesias (codProcedimiento, idAnestesia) VALUES (?, ?)";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, pa.getCodProcedimiento());
			stmt.setInt(2, pa.getIdAnestesia());
			
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			cerrar(stmt,null);
		}
	}
	
	public boolean bajaProcedimientoAnestesia(ProcedimientoAnestesia pa) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "DELETE FROM procedimientos_anestesias WHERE  idAnestesia = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, pa.getIdAnestesia());
			
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			cerrar(stmt,null);
		}
	}
	
	public boolean modificaProcedimientoAnestesia(ProcedimientoAnestesia pa) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE procedimientos_anestesias SET codProcedimiento = ? WHERE idAnestesia = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, pa.getCodProcedimiento());
			stmt.setInt(2, pa.getIdAnestesia());
			
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			cerrar(stmt,null);
		}
	}
	
	public ProcedimientoAnestesia consultaProcedimientoAnestesia(ProcedimientoAnestesia pa) throws ApplicationException{
		ProcedimientoAnestesia rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM procedimientos_anestesias WHERE codProcedimiento = ? OR idAnestesia = ?";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, pa.getCodProcedimiento());
			stmt.setInt(2, pa.getIdAnestesia());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new ProcedimientoAnestesia();
				rta.setCodProcedimiento(rs.getInt(1));
				rta.setIdAnestesia(rs.getInt(2));
			}
		} 
		catch (SQLException e) { e.printStackTrace();} 
		finally {
			cerrar(stmt,rs);
		}
		return rta;
	}
	
	public ArrayList<ProcedimientoAnestesia> listarProcedimientoAnestesia() throws ApplicationException{
		ArrayList<ProcedimientoAnestesia> listado = new ArrayList<>();
		ProcedimientoAnestesia pa = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM procedimientos_anestesias ORDER BY idAnestesia";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();

			if(rs != null && rs.next()){
				pa = new ProcedimientoAnestesia();
				pa.setCodProcedimiento(rs.getInt(1));
				pa.setIdAnestesia(rs.getInt(2));
				listado.add(pa);
			}
		}
		catch (SQLException e) { e.printStackTrace();}
		finally { cerrar(stmt,null); }
		return listado;
	}
	
	public ArrayList<ProcedimientoAnestesia> listarProcedimientoPorAnestesia(int id) throws ApplicationException{
		ArrayList<ProcedimientoAnestesia> listado = new ArrayList<>();
		ProcedimientoAnestesia pa = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM procedimientos_anestesias WHERE idAnestesia = ? ORDER BY codProcedimiento";
		
		try {
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();

			if(rs != null && rs.next()){
				pa = new ProcedimientoAnestesia();
				pa.setCodProcedimiento(rs.getInt(1));
				pa.setIdAnestesia(rs.getInt(2));
				listado.add(pa);
			}
		}
		catch (SQLException e) { e.printStackTrace();}
		finally { cerrar(stmt,null); }
		return listado;
	}
}
