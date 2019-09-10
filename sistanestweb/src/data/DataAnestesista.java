package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Anestesista;
import util.ApplicationException;


public class DataAnestesista {
	
	public DataAnestesista() {}
	
	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}

	public boolean altaAnestesista(Anestesista a) throws ApplicationException{
		Anestesista r = new Anestesista();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="INSERT INTO anestesistas (idAnestesista, nombreAnestesista, apellidoAnestesista, matricula"
				+ "grupo, usuario) SET (?, ?, ?, ?, ?, ?)";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, a.getIdAnestesista());
			stmt.setString(2, a.getNombreAnestesista());
			stmt.setString(3, a.getApellidoAnestesista());
			stmt.setInt(4, a.getMatricula());
			stmt.setInt(5, a.getGrupo());
			stmt.setString(6, a.getUsuario());
			
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				r.setIdAnestesista(rs.getInt(1));
			}
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally { cerrar(stmt, rs);}
		
	}
	
	public boolean bajaAnestesista(Anestesista a) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "DELETE FROM anestesistas WHERE idAnestesista = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, a.getIdAnestesista());
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public boolean modificaAnestesista(Anestesista a) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE anestesistas SET nombreAnestesista = ?, apellidoAnestesistas = ?,"
				+ "matricula = ?, grupo = ?, usuario = ? WHERE idAnestesista = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, a.getNombreAnestesista());
			stmt.setString(2, a.getApellidoAnestesista());
			stmt.setInt(3, a.getMatricula());
			stmt.setInt(4, a.getGrupo());
			stmt.setString(5, a.getUsuario());
			stmt.setInt(6, a.getIdAnestesista());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public Anestesista consultaAnestesista(Anestesista a) throws ApplicationException{
		Anestesista rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM anestesistas WHERE idAnestesista = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, a.getIdAnestesista());
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesista();
				rta.setIdAnestesista(rs.getInt(1));
				rta.setNombreAnestesista(rs.getString(2));
				rta.setApellidoAnestesista(rs.getString(3));
				rta.setMatricula(rs.getInt(4));
				rta.setGrupo(rs.getInt(5));
				rta.setUsuario(rs.getString(6));
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return rta;
	}
	
	public ArrayList<Anestesista> listarAnestesista() throws ApplicationException{
		ArrayList<Anestesista> listado = new ArrayList<>();
		Anestesista rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM anestesistas ORDER BY idAnestesista";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesista();
				rta.setIdAnestesista(rs.getInt(1));
				rta.setNombreAnestesista(rs.getString(2));
				rta.setApellidoAnestesista(rs.getString(3));
				rta.setMatricula(rs.getInt(4));
				rta.setGrupo(rs.getInt(5));
				rta.setUsuario(rs.getString(6));
				listado.add(rta);
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
	
	public Anestesista buscaNombre(Anestesista a) throws ApplicationException{
		Anestesista rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM anestesistas WHERE usuario = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setString(1, a.getUsuario());
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesista();
				rta.setIdAnestesista(rs.getInt(1));
				rta.setNombreAnestesista(rs.getString(2));
				rta.setApellidoAnestesista(rs.getString(3));
				rta.setMatricula(rs.getInt(4));
				rta.setGrupo(rs.getInt(5));
				rta.setUsuario(rs.getString(6));
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return rta;
	}

}
