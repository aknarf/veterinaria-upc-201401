package trasveterinaria.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.spec.RSAPublicKeySpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Citas;
import trasveterinaria.modelo.Cliente;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.util.ConexionBD;

public class CitasDAO extends BaseDAO{
	
	public void  insertar (Citas vo) throws DAOExcepcion {
		String query = "insert into citas " +
				"(fecha,Estado,cantidad,NotasMedicas,ImagenMedica,Tipo,idTarea,idMascota,DniDoc)" +				
				"values (?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFecha());
			stmt.setString(2, vo.getEstado());
			stmt.setString(3, vo.getCantidad());
			stmt.setString(4, vo.getNotas());
			stmt.setString(5, vo.getImagen());
			stmt.setString(6, vo.getTipo());
			stmt.setInt(7, vo.getIdtarea());
			stmt.setInt(8, vo.getIdmascota());
			stmt.setString(9, vo.getDnidoc());
			
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
		
	}
	
	public Citas buscar(int idcita) throws DAOExcepcion {
		Citas vo = new Citas();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select NroCita from citas where nrocita=? ";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idcita);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdcita(rs.getInt(1));
				
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
	
	
	public Collection<Citas> listarVacunas() throws DAOExcepcion {
		Collection<Citas> c = new ArrayList<Citas>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select Fecha,estado,NotasMedicas,Tipo,b.DescripcionTarea,c.nombre,d.Dni,d.Nombre,d.ApePaterno from citas a inner join tarea b " +
					" on  a.idTarea=b.idTarea " +
					" inner join mascota  c on a.idMascota= c.idMascota inner join cliente d on " +
					" c.Cliente_Dni=d.Dni  where a.idTarea='28' order by a.NroCita asc ";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Citas ci = new Citas();
				ci.setFecha(rs.getString("Fecha"));
				ci.setEstado(rs.getString("estado"));
				ci.setNotas(rs.getString("NotasMedicas"));
				ci.setTipo(rs.getString("Tipo"));
				ci.setDescripcionTarea(rs.getString("b.DescripcionTarea"));
				ci.setNomMascota(rs.getString("c.nombre"));
				ci.setDniCliente(rs.getString("d.Dni"));
				ci.setNomCliente(rs.getString("d.Nombre"));
				ci.setApePatCliente(rs.getString("d.ApePaterno"));
				
				
				c.add(ci);
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
	
	public Collection<Citas> listarTareas() throws DAOExcepcion {
		Collection<Citas> c = new ArrayList<Citas>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select Fecha,estado,NotasMedicas,Tipo,b.DescripcionTarea,c.nombre,d.Dni,d.Nombre,d.ApePaterno from citas a inner join tarea b " +
					" on  a.idTarea=b.idTarea " +
					" inner join mascota  c on a.idMascota= c.idMascota inner join cliente d on " +
					" c.Cliente_Dni=d.Dni  where a.idTarea not in ('28') order by a.NroCita asc ";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Citas ci = new Citas();
				ci.setFecha(rs.getString("Fecha"));
				ci.setEstado(rs.getString("estado"));
				ci.setNotas(rs.getString("NotasMedicas"));
				ci.setTipo(rs.getString("Tipo"));
				ci.setDescripcionTarea(rs.getString("b.DescripcionTarea"));
				ci.setNomMascota(rs.getString("c.nombre"));
				ci.setDniCliente(rs.getString("d.Dni"));
				ci.setNomCliente(rs.getString("d.Nombre"));
				ci.setApePatCliente(rs.getString("d.ApePaterno"));
				
				
				c.add(ci);
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
	
	
	public List<Cliente> traerClientes() throws DAOExcepcion {
		List<Cliente> lista= new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBD.obtenerConexion();
			String query="SELECT distinct dni,concat_ws(' ', Nombre, Apepaterno,ApeMaterno) as persona FROM cliente ";
			stmt=con.prepareStatement(query);
			rs= stmt.executeQuery();
			while(rs.next()){
			 Cliente cli= new Cliente();
			 cli.setDni("dni");
			 cli.setNombreCompleto("persona");
			 lista.add(cli);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}finally{
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return lista;
		
	}

	

}
