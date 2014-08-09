package trasveterinaria.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Citas;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.util.ConexionBD;

public class ClienteDAO extends BaseDAO{

	public void  insertar (Cliente vo) throws DAOExcepcion {
		String query = "insert into cliente (Dni,nombre,apePaterno,apeMaterno,correoelectronico,direccion,foto,celular,telefonofijo,ruc) values (?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		FileInputStream fis = null;
		try {
			con = ConexionBD.obtenerConexion();

			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDni());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getApePaterno());
			stmt.setString(4, vo.getApeMaterno());
			stmt.setString(5, vo.getCorreoelectronico());
			stmt.setString(6, vo.getDireccion());
			
		    File file = new File("D:\\java.gif");
		    fis = new FileInputStream(file);
			stmt.setBinaryStream(7, fis, (int) file.length());
			
			stmt.setString(8, vo.getCelular());
			stmt.setString(9, vo.getTelefonofijo());
			stmt.setString(10, vo.getRuc());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public int eliminar(String dni) throws DAOExcepcion {
		Connection conn = null;
		PreparedStatement pstm = null;
		int eliminados =-1;
		try {
			String sql = "delete from cliente WHERE Dni=?";
			conn =ConexionBD.obtenerConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, dni);
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
	
	public Cliente  actualizar(Cliente vo) throws DAOExcepcion {
		String query = "update Cliente set nombre=?,apePaterno=?,apeMaterno=?,correoelectronico=?,direccion=?,foto=?,celular=?,telefonofijo=?,ruc=? where dni=?";
		Connection con = null;
		PreparedStatement stmt = null;
		FileInputStream fis = null;
		int actualizado=-1;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getApePaterno());
			stmt.setString(3, vo.getApeMaterno());
			stmt.setString(4, vo.getCorreoelectronico());
			stmt.setString(5, vo.getDireccion());
			
		    File file = new File("D:\\java.gif");
		    fis = new FileInputStream(file);
			stmt.setBinaryStream(6, fis, (int) file.length());
			
			stmt.setString(7, vo.getCelular());
			stmt.setString(8, vo.getTelefonofijo());
			stmt.setString(9, vo.getRuc());
			stmt.setString(10, vo.getDni());
			
			 actualizado = stmt.executeUpdate();
			if (actualizado != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException | FileNotFoundException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	
	public Cliente buscar(String dni) throws DAOExcepcion {
		Cliente vo = new Cliente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select dni,nombre,apePaterno,apeMaterno,correoelectronico,direccion,foto,celular,telefonofijo,ruc from cliente where dni=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setDni(rs.getString(1));
				vo.setNombre(rs.getString(2));
				vo.setApePaterno(rs.getString(3));
				vo.setApeMaterno(rs.getString(4));
				vo.setCorreoelectronico(rs.getString(5));
				vo.setDireccion(rs.getString(6));
				
				File image = new File("D:\\java.gif");
			    FileOutputStream fos = new FileOutputStream(image);
			      byte[] buffer = new byte[1];
			      InputStream is = rs.getBinaryStream(7);
			      while (is.read(buffer) > 0) {
			        fos.write(buffer);
			      }
			      fos.close();
			      
			      vo.setCelular(rs.getString(8));
			      vo.setTelefonofijo(rs.getString(9));
			      vo.setRuc(rs.getString(10));
			}
		} catch (SQLException | IOException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	
	public Collection<Cliente> listar() throws DAOExcepcion {
		Collection<Cliente> c = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ConexionBD.obtenerConexion();
			String query = "select Dni,Nombre,ApePaterno,ApeMaterno,CorreoElectronico,Direccion,Foto,Celular,TelefonoFijo,Ruc  from cliente order by Dni";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente vo = new Cliente();
				vo.setDni(rs.getString("Dni"));
				vo.setNombre(rs.getString("Nombre"));
				vo.setApePaterno(rs.getString("ApePaterno"));
				vo.setApeMaterno(rs.getString("ApeMaterno"));
				vo.setCorreoelectronico(rs.getString("CorreoElectronico"));
				vo.setDireccion(rs.getString("Direccion"));

				File image = new File("D:\\java.gif");
			    FileOutputStream fos = new FileOutputStream(image);
			      byte[] buffer = new byte[1];
			      InputStream is = rs.getBinaryStream(7);
			      while (is.read(buffer) > 0) {
			        fos.write(buffer);
			      }
			      fos.close();
			    
			    vo.setCelular(rs.getString("Celular"));
			    vo.setTelefonofijo(rs.getString("TelefonoFijo"));
			    vo.setRuc(rs.getString("Ruc"));		     
				
				c.add(vo);
			}

		} catch (SQLException | IOException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
	
	public Collection<Cliente> reporteCliente(String dni) throws DAOExcepcion {
		ArrayList<Cliente> rc = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String query = "select c.dni as dni, c.Nombre as nombre, c.ApePaterno as paterno, c.ApeMaterno as materno, count(m.idMascota) as CantidadMascotas from cliente c inner join mascota m on c.dni=m.Cliente_Dni inner join raza r on m.Raza_idRaza=r.idRaza inner join especie e on r.idEspecie=e.idEspecie where c.dni=?";
			//String query="select a.dni,a.nombre,a.apepaterno,a.apematerno from cliente a inner join  mascota b on a.dni=b.Cliente_Dni and a.Dni=? group by  nombre,apepaterno,apematerno";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				Cliente vo = new Cliente();
				vo.setDni(rs.getString("dni"));
				vo.setNombre(rs.getString("nombre"));
				vo.setApePaterno(rs.getString("paterno"));
				vo.setApeMaterno(rs.getString("materno"));
				vo.setCantMascota(rs.getInt(Integer.parseInt("CantidadMascotas")));
				
				rc.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return rc;
		}
}
