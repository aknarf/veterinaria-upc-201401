package trasveterinaria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Mascota;
import trasveterinaria.util.ConexionBD;

public class MascotaDAO extends BaseDAO {

	public void  insertar (Mascota vo) throws DAOExcepcion {
		String query = "insert into mascota (idMascota,nombre,Genero,TipoSangre,Esterilizado,Tamaño,Actividad,Peso,FechaNacimiento,Alergia,Cliente_Dni,Especie_idEspecie) values (?,?,?,?,?,?,?,?,?,?,?,?)";
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
			stmt.setDate(9, (Date) vo.getFechaNacimiento());
			stmt.setString(10, vo.getAlergia());
			stmt.setInt(11, vo.getCliente_Dni());
			stmt.setInt(12, vo.getEspecie_idEspecie());
			
			
			
		
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