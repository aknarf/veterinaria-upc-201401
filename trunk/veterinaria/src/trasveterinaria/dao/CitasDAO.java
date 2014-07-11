package trasveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Citas;
import trasveterinaria.modelo.Doctores;
import trasveterinaria.util.ConexionBD;

public class CitasDAO extends BaseDAO{
	
	public void  insertar (Citas vo) throws DAOExcepcion {
		String query = "insert into cita " +
				"(fecha,Estado,cantidad,NotasMedicas,ImagenMedica,Tipo,idTarea,idMascota,DniDoc)" +				
				"values (?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFeha());
			stmt.setString(2, vo.getEstado());
			stmt.setString(3, vo.getCantidad());
			stmt.setString(4, vo.getNotasMedicas());
			stmt.setString(5, vo.getImagen());
			stmt.setString(6, vo.getTipo());
			stmt.setInt(7, vo.getIdtarea());
			stmt.setInt(8, vo.getIdmascota());
			stmt.setInt(9, vo.getDnidoc());
			
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
	
	
	

}
