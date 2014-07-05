package trasveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.util.ConexionBD;

public class DoctoresDAO extends BaseDAO {
	
	
	/*public Collection<Categoria> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select id_categoria, nombre, descripcion from categoria where nombre like ?";
		Collection<Categoria> lista = new ArrayList<Categoria>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria vo = new Categoria();
				vo.setIdCategoria(rs.getInt("id_categoria"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDescripcion(rs.getString("descripcion"));
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(lista.size());
		return lista;
	}*/

	public void  insertar (Doctores vo) throws DAOExcepcion {
		String query = "insert into doctores (DniDoc,Nombre,ApePaterno,ApeMaterno,Email,Telefono,Tipo,Contraseña) values (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getDni());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getApePaterno());
			stmt.setString(4, vo.getApeMaterno());
			stmt.setString(5, vo.getEmail());
			stmt.setString(6, vo.getTelefono());
			stmt.setString(7, vo.getTipo());
			stmt.setString(8, vo.getContraseña());
			
			//stmt.setString(2, vo.getNombre());
			
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
		//return vo;
	}

	/*public Categoria obtener(int idCategoria) throws DAOExcepcion {
		Categoria vo = new Categoria();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select id_categoria, nombre, descripcion from categoria where id_categoria=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCategoria);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdCategoria(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setDescripcion(rs.getString(3));
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

	/*public void eliminar(int idCategoria) throws DAOExcepcion {
		String query = "delete from categoria WHERE id_categoria=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCategoria);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}*/

	/*public Categoria actualizar(Categoria vo) throws DAOExcepcion {
		String query = "update categoria set nombre=?,descripcion=? where id_categoria=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDescripcion());
			stmt.setInt(3, vo.getIdCategoria());
			int i = stmt.executeUpdate();
			if (i != 1) {
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
	}*/

	/*public Collection<Categoria> listar() throws DAOExcepcion {
		Collection<Categoria> c = new ArrayList<Categoria>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select id_categoria,nombre,descripcion from categoria order by nombre";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria vo = new Categoria();
				vo.setIdCategoria(rs.getInt("id_categoria"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDescripcion(rs.getString("descripcion"));
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
	}*/


}
