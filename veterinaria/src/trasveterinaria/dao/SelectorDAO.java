package trasveterinaria.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trasveterinaria.modelo.BeanSelector;
import trasveterinaria.util.ConexionBD;



public class SelectorDAO {
	
	public List<BeanSelector> traerCliente() throws Exception {
		List<BeanSelector> lista = new ArrayList<BeanSelector>();
		BeanSelector bean = null;
		String sql = "select dni,nombre from cliente; ";
		System.out.println("SENTENCIA SQL : " + sql);

		Connection conn = null;
		try {
			conn = ConexionBD.obtenerConexion();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new BeanSelector();
				bean.setDni(rst.getString(1));
				bean.setCliente(rst.getString(2));
				lista.add(bean);
			}

			rst.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return lista;
	}

}
