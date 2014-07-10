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

import trasveterinaria.excepcion.DAOExcepcion;
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
			stmt.setInt(1, vo.getDni());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getApePaterno());
			stmt.setString(4, vo.getApeMaterno());
			stmt.setString(5, vo.getCorreoelectronico());
			stmt.setString(6, vo.getDireccion());
			
		    File file = new File("E:\\java.gif");
		    fis = new FileInputStream(file);
			stmt.setBinaryStream(7, fis, (int) file.length());
			
			stmt.setString(8, vo.getCelular());
			stmt.setString(9, vo.getTelefonofijo());
			stmt.setString(10, vo.getRuc());

			
			//stmt.setString(2, vo.getNombre());
			
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
		//return vo;
	}

	public Cliente obtener(int dni) throws DAOExcepcion {
		Cliente vo = new Cliente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select dni,nombre,apePaterno,apeMaterno,correoelectronico,direccion,foto,celular,telefonofijo,ruc from cliente where dni=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, dni);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setDni(rs.getInt(1));
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
}
