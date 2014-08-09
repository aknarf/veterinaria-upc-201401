package trasveterinaria.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.security.auth.login.LoginException;


import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.util.ConexionBD;

public class DoctoresDAO extends BaseDAO {
	
	public void  insertar (Doctores vo) throws DAOExcepcion {
		String query = "insert into doctores (DniDoc,Nombre,ApePaterno,ApeMaterno,Email,Telefono,Tipo,Contraseña) values (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDni());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getApePaterno());
			stmt.setString(4, vo.getApeMaterno());
			stmt.setString(5, vo.getEmail());
			stmt.setString(6, vo.getTelefono());
			stmt.setString(7, vo.getTipo());
			stmt.setString(8, vo.getContraseña());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public int eliminar(int id) throws DAOExcepcion {
		Connection conn = null;
		PreparedStatement pstm = null;
		int eliminados =-1;
		try {
			String sql = "delete from doctores WHERE DniDoc=?";
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
		
	public Doctores  actualizar(Doctores vo) throws DAOExcepcion {
		String query = "update Doctores set Nombre=?,ApePaterno=?,ApeMaterno=?,Email=?,Telefono=?,Tipo=?,Contraseña=? where dniDoc=?";
		Connection con = null;
		PreparedStatement stmt = null;
		int actualizado=-1;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getApePaterno());
			stmt.setString(3, vo.getApeMaterno());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5,vo.getTelefono());
			stmt.setString(6, vo.getTipo());
			stmt.setString(7, vo.getContraseña());
			stmt.setString(8, vo.getDni());
			
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

	public Collection<Doctores> listar() throws DAOExcepcion {
		Collection<Doctores> c = new ArrayList<Doctores>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select DniDoc,Nombre,ApePaterno,ApeMaterno,Email,Telefono,Tipo from doctores order by DniDoc";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Doctores vo = new Doctores();
				vo.setDni(rs.getString("DniDoc"));
				vo.setNombre(rs.getString("Nombre"));
				vo.setApePaterno(rs.getString("ApePaterno"));
				vo.setApeMaterno(rs.getString("ApeMaterno"));
				vo.setEmail(rs.getString("Email"));
				vo.setTelefono(rs.getString("Telefono"));
				vo.setTipo(rs.getString("Tipo"));

				
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

	public Doctores buscar(String dni) throws DAOExcepcion {
		Doctores vo = new Doctores();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select dnidoc,nombre,apePaterno,apeMaterno,email,telefono,tipo,contraseña from doctores where dnidoc=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setDni(rs.getString(1));
				vo.setNombre(rs.getString(2));
				vo.setApePaterno(rs.getString(3));
				vo.setApeMaterno(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setTelefono(rs.getString(6));
				vo.setTipo(rs.getString(7));
			    vo.setContraseña(rs.getString(8));
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
		
	public Doctores validar(String email, String contraseña) throws DAOExcepcion, LoginException {
			Doctores vo = new Doctores();
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				String query = "select dnidoc,nombre,apePaterno,apeMaterno,telefono,tipo from doctores where email=? and contraseña=?";
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setString(1, email);
				stmt.setString(2, contraseña);
				rs = stmt.executeQuery();
				if (rs.next()) {
					vo.setDni(rs.getString(1));
					vo.setNombre(rs.getString(2));
					vo.setApePaterno(rs.getString(3));
					vo.setApeMaterno(rs.getString(4));
					vo.setTelefono(rs.getString(5));
					vo.setTipo(rs.getString(6));
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
	

}
