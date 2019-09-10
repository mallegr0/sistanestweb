package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.UsuarioSanatorio;
import util.ApplicationException;

public class DataUsuarioSanatorio {
	
	public DataUsuarioSanatorio() {}

	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
	}
	
	public boolean altaUsuarioSanatorio(UsuarioSanatorio us) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO usuarios_sanatorios (usuario, idSanatorio) VALUES (?, ?)";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, us.getUsuario());
			stmt.setInt(2, us.getIdSanatorio());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public boolean bajaUsuarioSanatorio(UsuarioSanatorio us) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "DELETE FROM usuarios_sanatorios WHERE usuario = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, us.getUsuario());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public boolean modificaUsuarioSanatorio(UsuarioSanatorio us) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE usuarios_sanatorios SET idSanatorio = ? WHERE usuario = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, us.getIdSanatorio());
			stmt.setString(2, us.getUsuario());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public UsuarioSanatorio consultaUsuarioSanatorio(UsuarioSanatorio us) throws ApplicationException{
		UsuarioSanatorio rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM usuarios_sanatorios WHERE usuario = ? AND idSanatorio = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, us.getUsuario());
			stmt.setInt(2, us.getIdSanatorio());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new UsuarioSanatorio();
				rta.setUsuario(rs.getString(1));
				rta.setIdSanatorio(rs.getInt(2));
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return rta;
	}
	
	public ArrayList<UsuarioSanatorio> listarUsuarioSanatorio() throws ApplicationException{
		ArrayList<UsuarioSanatorio> listado = new ArrayList<>();
		UsuarioSanatorio rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM usuarios_sanatorios ORDER BY usuario";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new UsuarioSanatorio();
				rta.setUsuario(rs.getString(1));
				rta.setIdSanatorio(rs.getInt(2));
				listado.add(rta);
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
}
