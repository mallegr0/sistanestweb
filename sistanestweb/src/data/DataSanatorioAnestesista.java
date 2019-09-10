package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ApplicationException;
import entidades.SanatorioAnestesista;

public class DataSanatorioAnestesista {
	
	public DataSanatorioAnestesista() {}

	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}

	public boolean altaSanatorioAnestesista(SanatorioAnestesista sa) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO sanatorios_anestesistas (idSanatorio, idAnestesista) VALUES (?, ?)";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, sa.getIdSanatorio());
			stmt.setInt(2, sa.getIdAnestesista());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	public boolean bajaSanatorioAnestesista(SanatorioAnestesista sa) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "DELETE FROM sanatorios_anestesistas WHERE idSanatorio = ? AND idAnestesista = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, sa.getIdSanatorio());
			stmt.setInt(2, sa.getIdAnestesista());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	//Modifica segun sanatorio
	public boolean modificaSanatorioAnestesista(SanatorioAnestesista sa) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE sanatorios_anestesistas SET idAnestesista = ? WHERE idSanatorio = ?"
				+ "ON DUPLICATE KEY UPDATE idSanatorio = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, sa.getIdAnestesista());
			stmt.setInt(2, sa.getIdSanatorio());
			stmt.setInt(3, sa.getIdSanatorio());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	//Modifica segun anestesisa
		public boolean modificaAnestesistaSanatorio(SanatorioAnestesista sa) throws ApplicationException{
			PreparedStatement stmt = null;
			String sql = "UPDATE sanatorios_anestesistas SET idSanatorio = ? WHERE idAnestesista = ?";
			
			try{
				stmt = conn.abrirConn().prepareStatement(sql);
				stmt.setInt(1, sa.getIdSanatorio());
				stmt.setInt(2, sa.getIdAnestesista());
				stmt.execute();
				return true;
			}
			catch(SQLException e){
				e.printStackTrace();
				return false;
			}
			finally{ cerrar(stmt, null);}
		}
		
	public SanatorioAnestesista ConsultaSanatorioAnestesista(SanatorioAnestesista sa) throws ApplicationException{
		SanatorioAnestesista rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sanatorios_anestesistas WHERE idSanatorio = ? AND idAnestesista = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, sa.getIdSanatorio());
			stmt.setInt(2, sa.getIdAnestesista());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				rta = new SanatorioAnestesista();
				rta.setIdSanatorio(rs.getInt(1));
				rta.setIdAnestesista(rs.getInt(2));
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		
		return rta;
	}
	
	public ArrayList<SanatorioAnestesista> listarSanatorioAnestesista() throws ApplicationException{
		ArrayList<SanatorioAnestesista> listado = new ArrayList<>();
		SanatorioAnestesista sa = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sanatorios_anestesistas ORDER BY idSanatorio";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
				sa = new SanatorioAnestesista();
				sa.setIdSanatorio(rs.getInt(1));
				sa.setIdAnestesista(rs.getInt(2));
				listado.add(sa);
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}

}
