package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ApplicationException;
import entidades.Anestesia;

public class DataAnestesia {
	
	public DataAnestesia() {}
	
	private void cerrar(PreparedStatement stmt, ResultSet rs){
		try {
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			Conector.getInstancia().cerrarConn();
		} catch (SQLException | ApplicationException e) { e.printStackTrace();}
	}

	public boolean altaAnestesia(Anestesia a){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO anestesias (idAnestesia, fecPrestacion, fecARA, fecRendicion, fecCarga, afiliado,"
				+ "nroAfiliado, nocturno, feriado, fds, nroTalon, nroVias, edad, usuario, idMedico, idAnestesia,"
				+ "idSanatorio, idOS, idTpoAnestesia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?)";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, a.getIdAnestesia());
			stmt.setTimestamp(2, a.getFecPrestacion());
			stmt.setDate(3, a.getFecARA());
			stmt.setDate(4, a.getFecRendicion());
			stmt.setDate(5, a.getFecCarga());
			stmt.setString(6, a.getAfiliado());
			stmt.setInt(7, a.getNroAfiliado());
			stmt.setInt(8, a.getNocturno());
			stmt.setInt(9, a.getFeriado());
			stmt.setInt(10, a.getFds());
			stmt.setInt(11, a.getNroTalon());
			stmt.setInt(12, a.getNroVias());
			stmt.setInt(13, a.getEdad());
			stmt.setString(14, a.getUsuario());
			stmt.setInt(15, a.getIdMedico());
			stmt.setInt(16, a.getIdAnestesista());
			stmt.setInt(17, a.getIdSanatorio());
			stmt.setInt(18, a.getIdOS());
			stmt.setInt(19, a.getIdTpoAnestesia());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				a.setIdAnestesia(rs.getInt(1));
			}
			return true;
		} catch (SQLException | ApplicationException e) {
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, rs);}
	}
	
	public boolean bajaAnestesia(Anestesia a){
		PreparedStatement stmt = null;
		String sql = "DELETE FROM anestesias WHERE idAnestesia = ?";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setInt(1, a.getIdAnestesia());
			stmt.execute();
			return true;
		} 
		catch (SQLException | ApplicationException e) {
			e.printStackTrace();
			return false;}
		finally{ cerrar(stmt, null);}
	}
	
	public boolean modificaAnestesia(Anestesia a){
		PreparedStatement stmt = null;
		String sql = "UPDATE anestesias SET ( fecPrestacion = ?, fecARA = ?, fecRendicion = ?, "
				+ "fecCarga = ?, afiliado = ?, nroAfiliado = ?, nocturno = ?, feriado = ?, fds = ?, "
				+ "nroTalon = ?, nroVias = ?, edad = ?, usuario = ?, idMedico = ?, idAnestesia = ?,"
				+ "idSanatorio = ?, idOS = ?, idTpoAnestesia = ?) WHERE idAnestesia = ?)";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			stmt.setTimestamp(1, a.getFecPrestacion());
			stmt.setDate(2, a.getFecARA());
			stmt.setDate(3, a.getFecRendicion());
			stmt.setDate(4, a.getFecCarga());
			stmt.setString(5, a.getAfiliado());
			stmt.setInt(6, a.getNroAfiliado());
			stmt.setInt(7, a.getNocturno());
			stmt.setInt(8, a.getFeriado());
			stmt.setInt(9, a.getFds());
			stmt.setInt(10, a.getNroTalon());
			stmt.setInt(11, a.getNroVias());
			stmt.setInt(12, a.getEdad());
			stmt.setString(13, a.getUsuario());
			stmt.setInt(14, a.getIdMedico());
			stmt.setInt(15, a.getIdAnestesista());
			stmt.setInt(16, a.getIdSanatorio());
			stmt.setInt(17, a.getIdOS());
			stmt.setInt(18, a.getIdTpoAnestesia());
			stmt.setInt(19, a.getIdAnestesia());
			stmt.execute();
		
			return true;
		} catch (SQLException | ApplicationException e) {
			e.printStackTrace();
			return false;
		}
		finally{ cerrar(stmt, null);}
	}
	
	public Anestesia consultaAnestesia(Anestesia a){
		Anestesia rta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM anestesias WHERE idAnestsia = ?";
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesia();
				rta.setIdAnestesia(rs.getInt(1));
				rta.setFecPrestacion(rs.getTimestamp(2));
				rta.setFecARA(rs.getDate(3));
				rta.setFecRendicion(rs.getDate(4));
				rta.setFecCarga(rs.getDate(5));
				rta.setAfiliado(rs.getString(6));
				rta.setNroAfiliado(rs.getInt(7));
				rta.setNocturno(rs.getInt(8));
				rta.setFeriado(rs.getInt(9));
				rta.setFds(rs.getInt(10));
				rta.setNroTalon(rs.getInt(11));
				rta.setNroVias(rs.getInt(12));
				rta.setEdad(rs.getInt(13));
				rta.setUsuario(rs.getString(14));
				rta.setIdMedico(rs.getInt(15));
				rta.setIdAnestesista(rs.getInt(16));
				rta.setIdSanatorio(rs.getInt(17));
				rta.setIdOS(rs.getInt(18));
				rta.setIdTpoAnestesia(rs.getInt(19));
			}
		}
		catch (SQLException | ApplicationException e) { e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return rta;
	}
	
	/* SE LISTAN LAS ANESTESIAS HECHAS EN UN SANATORIO DENTRO DE UNA FECHA O EL HISTORICO*/
	public ArrayList<Anestesia> listarAnestesias(Date fi, Date ff, int id){
		ArrayList<Anestesia> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia rta = null;
		String sql;
		
		if(fi != null && ff != null){
			sql = "SELECT * FROM anestesias WHERE fecPrestacion BETWEEN ? AND ? AND idSanatorio = ? "
					+ "ORDER BY fecPrestacion";
		}
		else{
			sql = "SELECT * FROM anestesias WHERE idSanatorio = ? ORDER BY fecPrestacion";
		}
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			
			if(fi != null && ff != null){
				stmt.setDate(1, fi);
				stmt.setDate(2, ff);
				stmt.setInt(3, id);
			}
			else {
				stmt.setInt(1, id);
			}
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesia();
				rta.setIdAnestesia(rs.getInt(1));
				rta.setFecPrestacion(rs.getTimestamp(2));
				rta.setFecARA(rs.getDate(3));
				rta.setFecRendicion(rs.getDate(4));
				rta.setFecCarga(rs.getDate(5));
				rta.setAfiliado(rs.getString(6));
				rta.setNroAfiliado(rs.getInt(7));
				rta.setNocturno(rs.getInt(8));
				rta.setFeriado(rs.getInt(9));
				rta.setFds(rs.getInt(10));
				rta.setNroTalon(rs.getInt(11));
				rta.setNroVias(rs.getInt(12));
				rta.setEdad(rs.getInt(13));
				rta.setUsuario(rs.getString(14));
				rta.setIdMedico(rs.getInt(15));
				rta.setIdAnestesista(rs.getInt(16));
				rta.setIdSanatorio(rs.getInt(17));
				rta.setIdOS(rs.getInt(18));
				rta.setIdTpoAnestesia(rs.getInt(19));
				listado.add(rta);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
	
	/* SE LISTAN LAS ANESTESIAS ENTREGADAS AL ARA DE UN SANATORIO DENTRO DE UNA FECHA O EL HISTORICO*/
	public ArrayList<Anestesia> listarARA(Date fi, Date ff, int id){
		ArrayList<Anestesia> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia rta = null;
		String sql;
		
		if(fi != null && ff != null){
			sql = "SELECT * FROM anestesias WHERE fecARA BETWEEN ? AND ? AND idSanatorio = ? "
					+ "ORDER BY fecARA, fecPrestacion";
		}
		else{
			sql = "SELECT * FROM anestesias WHERE idSanatorio = ? ORDER BY fecARA, fecPrestacion";
		}
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			
			if(fi != null && ff != null){
				stmt.setDate(1, fi);
				stmt.setDate(2, ff);
				stmt.setInt(3, id);
			}
			else {
				stmt.setInt(1, id);
			}
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesia();
				rta.setIdAnestesia(rs.getInt(1));
				rta.setFecPrestacion(rs.getTimestamp(2));
				rta.setFecARA(rs.getDate(3));
				rta.setFecRendicion(rs.getDate(4));
				rta.setFecCarga(rs.getDate(5));
				rta.setAfiliado(rs.getString(6));
				rta.setNroAfiliado(rs.getInt(7));
				rta.setNocturno(rs.getInt(8));
				rta.setFeriado(rs.getInt(9));
				rta.setFds(rs.getInt(10));
				rta.setNroTalon(rs.getInt(11));
				rta.setNroVias(rs.getInt(12));
				rta.setEdad(rs.getInt(13));
				rta.setUsuario(rs.getString(14));
				rta.setIdMedico(rs.getInt(15));
				rta.setIdAnestesista(rs.getInt(16));
				rta.setIdSanatorio(rs.getInt(17));
				rta.setIdOS(rs.getInt(18));
				rta.setIdTpoAnestesia(rs.getInt(19));
				listado.add(rta);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
	
	/* SE LISTAN LAS ANESTESIAS RENDIDAS DE UN SANATORIO DENTRO DE UNA FECHA O EL HISTORICO*/
	public ArrayList<Anestesia> listarRendidas(Date fi, Date ff, int id){
		ArrayList<Anestesia> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia rta = null;
		String sql;
		
		if(fi != null && ff != null){
			sql = "SELECT * FROM anestesias WHERE fecRendicion BETWEEN ? AND ? AND idSanatorio = ? "
					+ "ORDER BY fecPrestacion";
		}
		else{
			sql = "SELECT * FROM anestesias WHERE idSanatorio = ? ORDER BY fecPrestacion";
		}
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			
			if(fi != null && ff != null){
				stmt.setDate(1, fi);
				stmt.setDate(2, ff);
				stmt.setInt(3, id);
			}
			else {
				stmt.setInt(1, id);
			}
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesia();
				rta.setIdAnestesia(rs.getInt(1));
				rta.setFecPrestacion(rs.getTimestamp(2));
				rta.setFecARA(rs.getDate(3));
				rta.setFecRendicion(rs.getDate(4));
				rta.setFecCarga(rs.getDate(5));
				rta.setAfiliado(rs.getString(6));
				rta.setNroAfiliado(rs.getInt(7));
				rta.setNocturno(rs.getInt(8));
				rta.setFeriado(rs.getInt(9));
				rta.setFds(rs.getInt(10));
				rta.setNroTalon(rs.getInt(11));
				rta.setNroVias(rs.getInt(12));
				rta.setEdad(rs.getInt(13));
				rta.setUsuario(rs.getString(14));
				rta.setIdMedico(rs.getInt(15));
				rta.setIdAnestesista(rs.getInt(16));
				rta.setIdSanatorio(rs.getInt(17));
				rta.setIdOS(rs.getInt(18));
				rta.setIdTpoAnestesia(rs.getInt(19));
				listado.add(rta);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
	
	/* SE LISTAN LAS ANESTESIAS CARGADAS DE UN USUARIO PARA UN SANATORIO DENTRO DE UNA FECHA O EL HISTORICO*/
	public ArrayList<Anestesia> listarPorUsuario(Date fi, Date ff, int id, String u){
		ArrayList<Anestesia> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia rta = null;
		String sql;
		
		if(fi != null && ff != null){
			sql = "SELECT * FROM anestesias WHERE fecCarga BETWEEN ? AND ? AND idSanatorio = ? ADN usuario = ?"
					+ "ORDER BY usuario, fecPrestacion";
		}
		else{
			sql = "SELECT * FROM anestesias WHERE idSanatorio = ? AND usuario = ? "
					+ "ORDER BY usuario, fecPrestacion";
		}
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			
			if(fi != null && ff != null){
				stmt.setDate(1, fi);
				stmt.setDate(2, ff);
				stmt.setInt(3, id);
				stmt.setString(4, u);
			}
			else {
				stmt.setInt(1, id);
				stmt.setString(2, u);
			}
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesia();
				rta.setIdAnestesia(rs.getInt(1));
				rta.setFecPrestacion(rs.getTimestamp(2));
				rta.setFecARA(rs.getDate(3));
				rta.setFecRendicion(rs.getDate(4));
				rta.setFecCarga(rs.getDate(5));
				rta.setAfiliado(rs.getString(6));
				rta.setNroAfiliado(rs.getInt(7));
				rta.setNocturno(rs.getInt(8));
				rta.setFeriado(rs.getInt(9));
				rta.setFds(rs.getInt(10));
				rta.setNroTalon(rs.getInt(11));
				rta.setNroVias(rs.getInt(12));
				rta.setEdad(rs.getInt(13));
				rta.setUsuario(rs.getString(14));
				rta.setIdMedico(rs.getInt(15));
				rta.setIdAnestesista(rs.getInt(16));
				rta.setIdSanatorio(rs.getInt(17));
				rta.setIdOS(rs.getInt(18));
				rta.setIdTpoAnestesia(rs.getInt(19));
				listado.add(rta);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
	
	/* SE LISTAN LAS ANESTESIAS HECHAS POR UN ANESTESISTAS EN UN SANATORIO DENTRO DE UNA FECHA O EL HISTORICO*/
	public ArrayList<Anestesia> listarPorAnestesista(Date fi, Date ff, int is, int ia){
		ArrayList<Anestesia> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia rta = null;
		String sql;
		
		if(fi != null && ff != null){
			sql = "SELECT * FROM anestesias WHERE fecPrestacion BETWEEN ? AND ? AND idSanatorio = ?"
					+ "AND idAnestesista = ? ORDER BY fecPrestacion";
		}
		else{
			sql = "SELECT * FROM anestesias WHERE idSanatorio = ? AND idAnestesista = ? ORDER BY fecPrestacion";
		}
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			
			if(fi != null && ff != null){
				stmt.setDate(1, fi);
				stmt.setDate(2, ff);
				stmt.setInt(3, is);
				stmt.setInt(4, ia);
			}
			else {
				stmt.setInt(1, is);
				stmt.setInt(2, ia);
			}
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesia();
				rta.setIdAnestesia(rs.getInt(1));
				rta.setFecPrestacion(rs.getTimestamp(2));
				rta.setFecARA(rs.getDate(3));
				rta.setFecRendicion(rs.getDate(4));
				rta.setFecCarga(rs.getDate(5));
				rta.setAfiliado(rs.getString(6));
				rta.setNroAfiliado(rs.getInt(7));
				rta.setNocturno(rs.getInt(8));
				rta.setFeriado(rs.getInt(9));
				rta.setFds(rs.getInt(10));
				rta.setNroTalon(rs.getInt(11));
				rta.setNroVias(rs.getInt(12));
				rta.setEdad(rs.getInt(13));
				rta.setUsuario(rs.getString(14));
				rta.setIdMedico(rs.getInt(15));
				rta.setIdAnestesista(rs.getInt(16));
				rta.setIdSanatorio(rs.getInt(17));
				rta.setIdOS(rs.getInt(18));
				rta.setIdTpoAnestesia(rs.getInt(19));
				listado.add(rta);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
	
	/* SE LISTAN LAS ANESTESIAS POR OBRA SOCIAL HECHAS EN UN SANATORIO DENTRO DE UNA FECHA O EL HISTORICO*/
	public ArrayList<Anestesia> listarPorOS(Date fi, Date ff, int is, int io){
		ArrayList<Anestesia> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia rta = null;
		String sql;
		
		if(fi != null && ff != null){
			sql = "SELECT * FROM anestesias WHERE fecPrestacion BETWEEN ? AND ? AND idSanatorio = ? "
					+ "AND idOS = ? ORDER BY idOS, fecPrestacion";
		}
		else{
			sql = "SELECT * FROM anestesias WHERE idSanatorio = ? AND idOS = ? ORDER BY idOS, fecPrestacion";
		}
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			
			if(fi != null && ff != null){
				stmt.setDate(1, fi);
				stmt.setDate(2, ff);
				stmt.setInt(3, is);
				stmt.setInt(4, io);
			}
			else {
				stmt.setInt(1, is);
				stmt.setInt(2, io);
			}
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesia();
				rta.setIdAnestesia(rs.getInt(1));
				rta.setFecPrestacion(rs.getTimestamp(2));
				rta.setFecARA(rs.getDate(3));
				rta.setFecRendicion(rs.getDate(4));
				rta.setFecCarga(rs.getDate(5));
				rta.setAfiliado(rs.getString(6));
				rta.setNroAfiliado(rs.getInt(7));
				rta.setNocturno(rs.getInt(8));
				rta.setFeriado(rs.getInt(9));
				rta.setFds(rs.getInt(10));
				rta.setNroTalon(rs.getInt(11));
				rta.setNroVias(rs.getInt(12));
				rta.setEdad(rs.getInt(13));
				rta.setUsuario(rs.getString(14));
				rta.setIdMedico(rs.getInt(15));
				rta.setIdAnestesista(rs.getInt(16));
				rta.setIdSanatorio(rs.getInt(17));
				rta.setIdOS(rs.getInt(18));
				rta.setIdTpoAnestesia(rs.getInt(19));
				listado.add(rta);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
	
	/* SE LISTAN LAS ANESTESIAS A UN PACIENTE HECHAS EN UN SANATORIO DENTRO DE UNA FECHA O EL HISTORICO*/
	public ArrayList<Anestesia> listarPaciente(Date fi, Date ff, int id, String n){
		ArrayList<Anestesia> listado = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Anestesia rta = null;
		String sql;
		
			if(fi != null && ff != null){
				sql = "SELECT * FROM anestesias WHERE afiliado LIKE CONCAT( '%', ?, '%')"
						+ " AND fecPrestacion BETWEEN ? AND ? AND idSanatorio = ? "
						+ "ORDER BY afiliado, fecPrestacion";
			}
			else{
				sql = "SELECT * FROM anestesias WHERE afiliado LIKE CONCAT('%', ?, '%') "
						+ "AND idSanatorio = ? ORDER BY afiliado, fecPrestacion";
			}
		
		try{
			stmt = Conector.getInstancia().abrirConn().prepareStatement(sql);
			
			if(fi != null && ff != null){
				stmt.setString(1, n);
				stmt.setDate(2, fi);
				stmt.setDate(3, ff);
				stmt.setInt(4, id);
			}
			else {
				stmt.setString(1, n);
				stmt.setInt(2, id);
			}
			
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				rta = new Anestesia();
				rta.setIdAnestesia(rs.getInt(1));
				rta.setFecPrestacion(rs.getTimestamp(2));
				rta.setFecARA(rs.getDate(3));
				rta.setFecRendicion(rs.getDate(4));
				rta.setFecCarga(rs.getDate(5));
				rta.setAfiliado(rs.getString(6));
				rta.setNroAfiliado(rs.getInt(7));
				rta.setNocturno(rs.getInt(8));
				rta.setFeriado(rs.getInt(9));
				rta.setFds(rs.getInt(10));
				rta.setNroTalon(rs.getInt(11));
				rta.setNroVias(rs.getInt(12));
				rta.setEdad(rs.getInt(13));
				rta.setUsuario(rs.getString(14));
				rta.setIdMedico(rs.getInt(15));
				rta.setIdAnestesista(rs.getInt(16));
				rta.setIdSanatorio(rs.getInt(17));
				rta.setIdOS(rs.getInt(18));
				rta.setIdTpoAnestesia(rs.getInt(19));
				listado.add(rta);
			}
		}
		catch(SQLException | ApplicationException e){ e.printStackTrace();}
		finally{ cerrar(stmt, rs);}
		return listado;
	}
	
	
}

	