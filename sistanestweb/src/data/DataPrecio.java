package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ApplicationException;
import entidades.Precio;

public class DataPrecio {
	
	public DataPrecio() {}
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstancia().cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}

	public boolean altaPrecio(Precio p){
		PreparedStatement stmt = null;
		String sql = "INSERT INTO precios (fecha, idSanatorio, idTpoAnestesia, valor) SET (?, ?, ?, ?)";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setDate(1, p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			stmt.setInt(3, p.getIdTpoAnestesia());
			stmt.setFloat(4, p.getValor());
			
			stmt.execute();
			return true;
		}
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	public boolean bajaPrecio(Precio p){
		PreparedStatement stmt = null;
		String sql = "DELETE FROM precios WHERE fecha = ? AND idSanatorio = ? AND idTpoAnestesia = ?";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setDate(1, p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			stmt.setInt(3, p.getIdTpoAnestesia());
			
			stmt.execute();
			return true;
		}
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public boolean modificaPrecio(Precio p){
		PreparedStatement stmt = null;
		String sql = "UPDATE precios SET valor = ? WHERE fecha = ? AND idSanatorio = ? AND idTpoAnestesia = ?";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setFloat(1, p.getValor());
			stmt.setDate(2, p.getFecha());
			stmt.setInt(3, p.getIdSanatorio());
			stmt.setInt(4, p.getIdTpoAnestesia());
			
			stmt.execute();
			return true;
		}
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	public Precio ConsultaPrecio(Precio p){
		Precio rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM precios WHERE fecha = ? AND idSanatorio = ? AND idTpoAnestesia = ?";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setDate(1, p.getFecha());
			stmt.setInt(2, p.getIdSanatorio());
			stmt.setInt(3, p.getIdTpoAnestesia());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Precio();
				rta.setFecha(rs.getDate(1));
				rta.setIdSanatorio(rs.getInt(2));
				rta.setIdTpoAnestesia(rs.getInt(3));
				rta.setValor(rs.getFloat(4));
			}
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return rta;
	}
	
	public ArrayList<Precio> ListarPrecio(Precio p){
		ArrayList<Precio> listado = new ArrayList<>();
		Precio rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM precios WHERE idSanatorio = ? ORDER BY fecha DESC, idTpoAnestesia";
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, p.getIdSanatorio());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Precio();
				rta.setFecha(rs.getDate(1));
				rta.setIdSanatorio(rs.getInt(2));
				rta.setIdTpoAnestesia(rs.getInt(3));
				rta.setValor(rs.getFloat(4));
				listado.add(rta);
			}
		}
		catch(SQLException | ApplicationException e){e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
}
