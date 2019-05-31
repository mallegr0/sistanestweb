package data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Saldo;
import util.ApplicationException;

public class DataSaldo {
	
	public DataSaldo() {}
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstancia().cerrarConn();
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
	}

	public boolean altaSaldo(Saldo s){
		PreparedStatement stmt = null;
		String sql = "INSERT INTO saldos (idAnestesista, mes, año, monto, estado) VALUES"
				+ "(?, ?, ?, ?, ?)";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			stmt.setInt(3, s.getAño());
			stmt.setFloat(4, s.getMonto());
			stmt.setString(5, s.getEstado());
			stmt.execute();
			return true;
		}
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	public boolean bajaSaldo(Saldo s){
		PreparedStatement stmt = null;
		String sql = "DELETE FROM saldos Where idAnestesista = ? AND mes = ? and AÑO = ?";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			stmt.setInt(3, s.getAño());
			stmt.execute();
			return true;
		}
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public boolean modificaSaldo(Saldo s){
		PreparedStatement stmt = null;
		String sql = "UPDATE saldos SET (monto = ?, estado = ?) "
				+ "WHERE idAnestesista = ? AND mes = ? AND año = ?";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setFloat(1, s.getMonto());
			stmt.setString(2, s.getEstado());
			stmt.setInt(3, s.getIdAnestesista());
			stmt.setInt(4, s.getMes());
			stmt.setInt(5, s.getAño());
			stmt.execute();
			return true;
		}
		catch(SQLException | ApplicationException e){
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}

	public Saldo consultaSaldo(Saldo s){
		Saldo rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM saldos WHERE idAnestesia = ? AND mes = ? AND año = ?";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, s.getIdAnestesista());
			stmt.setInt(2, s.getMes());
			stmt.setInt(3, s.getAño());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Saldo();
				rta.setIdAnestesista(rs.getInt(1));
				rta.setMes(rs.getInt(2));
				rta.setAño(rs.getInt(3));
				rta.setMonto(rs.getFloat(4));
				rta.setEstado(rs.getString(5));
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, null);}
		return rta;
	}
	
	public ArrayList<Saldo> listarSaldo(Saldo s){
		ArrayList<Saldo> listado = new ArrayList<>();
		Saldo rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM saldos WHERE idAnestesia = ? ORDER BY mes DESC, año DESC";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, s.getIdAnestesista());
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Saldo();
				rta.setIdAnestesista(rs.getInt(1));
				rta.setMes(rs.getInt(2));
				rta.setAño(rs.getInt(3));
				rta.setMonto(rs.getFloat(4));
				rta.setEstado(rs.getString(5));
				listado.add(rta);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, null);}
		return listado;
	}
}
