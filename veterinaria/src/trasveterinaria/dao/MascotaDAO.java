package trasveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import trasveterinaria.excepcion.DAOExcepcion;
//import trasveterinaria.modelo.Doctores;
//import trasveterinaria.modelo.Doctores;
//import trasveterinaria.modelo.Cliente;
import trasveterinaria.modelo.Mascota;
import trasveterinaria.util.ConexionBD;

public class MascotaDAO extends BaseDAO {

	public void  insertar (Mascota vo) throws DAOExcepcion {
		String query = "insert into mascota (idMascota,nombre,Genero,TipoSangre,Esterilizado,Tamaño,Actividad,Peso,FechaNacimiento,Alergia,Cliente_Dni,Raza_idRaza) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getIdMascota());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getGenero());
			stmt.setString(4, vo.getTipoSangre());
			stmt.setString(5, vo.getEsterilizado());
			stmt.setString(6, vo.getTamaño());
			stmt.setString(7, vo.getActividad());
			stmt.setInt(8, vo.getPeso());
			stmt.setString(9, vo.getFechaNacimiento());
			stmt.setString(10, vo.getAlergia());
			stmt.setInt(11, vo.getCliente_Dni());
			stmt.setInt(12, vo.getRaza_idRaza());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
	
		}
		
		catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}

	}
	
	public Mascota  actualizar(Mascota vo) throws DAOExcepcion {
		String query = "update mascota set Nombre=?,Genero=?,TipoSangre=?,Esterilizado=?,Tamaño=?,Actividad=?,Peso=?,FechaNacimiento=?,Alergia=?,Cliente_Dni,Raza_idRaza where idMascota=?";
		Connection con = null;
		PreparedStatement stmt = null;
		int actualizado=-1;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getGenero());
			stmt.setString(3, vo.getTipoSangre());
			stmt.setString(4, vo.getEsterilizado());
			stmt.setString(5,vo.getTamaño());
			stmt.setString(6, vo.getActividad());
			stmt.setInt(7, vo.getPeso());
			stmt.setString(8, vo.getFechaNacimiento());
			stmt.setString(9, vo.getAlergia());
			stmt.setInt(10, vo.getCliente_Dni());
			stmt.setInt(11, vo.getRaza_idRaza());
			
			
			 actualizado = stmt.executeUpdate();
			if (actualizado != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	
	public int eliminar(int id) throws DAOExcepcion {
		Connection conn = null;
		PreparedStatement pstm = null;
		int eliminados =-1;
		try {
			String sql = "delete from Mascota WHERE idMascota=?";
			conn =ConexionBD.obtenerConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int i= pstm.executeUpdate();
			if (i!=1){
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(pstm);
			this.cerrarConexion(conn);
		}
		return eliminados;
	}
	
	public Collection<Mascota> listar() throws DAOExcepcion {
		Collection<Mascota> c = new ArrayList<Mascota>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select idMascota,nombre,Genero,TipoSangre,Esterilizado,Tamaño,Actividad,Peso,FechaNacimiento,Alergia,Cliente_Dni,Raza_idRaza  from Mascota order by idMascota";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Mascota vo = new Mascota();
				vo.setIdMascota(rs.getInt("idMascota"));
				vo.setNombre(rs.getString("nombre"));
				vo.setGenero(rs.getString("Genero"));
				vo.setTipoSangre(rs.getString("TipoSangre"));
				vo.setEsterilizado(rs.getString("Esterilizado"));
				vo.setTamaño(rs.getString("Tamaño"));
				vo.setActividad(rs.getString("Actividad"));
				vo.setPeso(rs.getInt("Peso"));
				vo.setFechaNacimiento(rs.getString("FechaNacimiento"));
				vo.setAlergia(rs.getString("Alergia"));
				vo.setCliente_Dni(rs.getInt("Cliente_Dni"));
				vo.setRaza_idRaza(rs.getInt("Raza_idRaza"));
				
				c.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
	
	public Mascota buscar(int IdMascota) throws DAOExcepcion {
		Mascota vo = new Mascota();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idMascota,nombre,Genero,TipoSangre,Esterilizado,Tamaño,Actividad,Peso,FechaNacimiento,Alergia,Cliente_Dni,Raza_idRaza from mascota where idMascota=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdMascota);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdMascota(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setGenero(rs.getString(3));
				vo.setTipoSangre(rs.getString(4));
				vo.setEsterilizado(rs.getString(5));
				vo.setTamaño(rs.getString(6));
				vo.setActividad(rs.getString(7));
			    vo.setPeso(rs.getInt(8));
			    vo.setFechaNacimiento(rs.getString(9));
			    vo.setAlergia(rs.getString(10));
			    vo.setCliente_Dni(rs.getInt(11));
			    vo.setRaza_idRaza(rs.getInt(12));
			    
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	/*
	public Mascota reporteMascota(int id) throws DAOExcepcion {
		Mascota vo = new Mascota();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String query = "select m.Nombre, c.dni, c.Nombre, c.ApePaterno, c.ApeMaterno, count(ct.idMascota) as CantidadCitas from cliente c inner join mascota m on c.Dni=m.Cliente_Dni inner join citas ct on m.idMascota=ct.idMascota where m.idMascota=14 order by ct.idMascota";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				vo.setDni(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setApePaterno(rs.getString(3));
				vo.setApeMaterno(rs.getString(4));
				vo.setCantMascota(rs.getInt(5));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
		}*/
}