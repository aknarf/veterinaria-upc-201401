package trasveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trasveterinaria.excepcion.DAOExcepcion;
import trasveterinaria.modelo.Citas;
import trasveterinaria.modelo.Comprobantes;
import trasveterinaria.util.ConexionBD;

public class ComprobantesDAO  extends BaseDAO {
	

	public void  insertar (Comprobantes vo) throws DAOExcepcion {
		String query = "insert into comprobantes " +
				"(NroComprobante,Correlativo,Tipo,direccion,fechaRegistro,Citas_nroCita)" +				
				"values (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getNroComprobante());
			stmt.setString(2, vo.getCorrelativo());
			stmt.setString(3, vo.getTipo());
			stmt.setString(4, vo.getDireccion());
			stmt.setString(5, vo.getFechaRegistro());
			stmt.setInt(6, vo.getNroCita());
			
			
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

}
