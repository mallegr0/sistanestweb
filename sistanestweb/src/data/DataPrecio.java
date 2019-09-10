package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ApplicationException;
import entidades.Precio;

public class DataPrecio {
	
	public DataPrecio() {}
	
	private Conector conn = new Conector();
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			conn.cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}

	public boolean altaPrecio(Precio p) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "INSERT INTO precios (fecha, idSanatorio, valor) SET (?, ?, ?)";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setDate(1, p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			stmt.setFloat(3, p.getValor());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	public boolean bajaPrecio(Precio p) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "DELETE FROM precios WHERE fecha = ? AND idSanatorio = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setDate(1, p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public boolean modificaPrecio(Precio p) throws ApplicationException{
		PreparedStatement stmt = null;
		String sql = "UPDATE precios SET valor = ? WHERE fecha = ? AND idSanatorio = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setFloat(1, p.getValor());
			stmt.setDate(2, p.getFecha());
			stmt.setInt(3, p.getIdSanatorio());
			
			stmt.execute();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	public Precio consultaPrecio(Precio p) throws ApplicationException{
		Precio rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM precios WHERE fecha = ? AND idSanatorio = ?";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setDate(1, p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Precio();
				rta.setFecha(rs.getDate(1));
				rta.setIdSanatorio(rs.getInt(2));
				rta.setValor(rs.getFloat(3));
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return rta;
	}
	
	public ArrayList<Precio> ListarPrecio(Precio p) throws ApplicationException{
		ArrayList<Precio> listado = new ArrayList<>();
		Precio rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM precios WHERE idSanatorio = ? ORDER BY fecha DESC";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, p.getIdSanatorio());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Precio();
				rta.setFecha(rs.getDate(1));
				rta.setIdSanatorio(rs.getInt(2));
				rta.setValor(rs.getFloat(3));
				listado.add(rta);
			}
		}
		catch(SQLException e){e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
	
	public Precio ultimoPrecioSanatorio (Integer id) throws ApplicationException{
		Precio rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM precios WHERE idSanatorio = ? ORDER BY fecha DESC LIMIT 1";
		
		try{
			stmt = conn.abrirConn().prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Precio();
				rta.setFecha(rs.getDate(1));
				rta.setIdSanatorio(rs.getInt(2));
				rta.setValor(rs.getFloat(3));
			}
		}
		catch(SQLException e){ e.printStackTrace();}
		finally{cerrar(stmt, rs);}
		return rta;
		}
	}

