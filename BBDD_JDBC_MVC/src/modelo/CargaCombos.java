// Referencias:
//
// Vídeo 212 - Modelo Vista Controlador

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargaCombos {

	public CargaCombos() {
		miConexion = new ConectaBBDD();
		c = miConexion.dameConexion();
	}

	public ResultSet ejecutaConsultaSecciones() {

		PreparedStatement statement;

		final String sql = "SELECT DISTINCT SECCION FROM PRODUCTOS WHERE SECCION IS NOT NULL ORDER BY 1";

		try {
			statement = c.prepareStatement(sql);
			rsSecciones = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsSecciones;
	}

	public void cierraRsSecciones() {
		try {
			rsSecciones.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet ejecutaConsultaPaises() {

		PreparedStatement statement;

		final String sql = "SELECT DISTINCT PAISDEORIGEN FROM PRODUCTOS WHERE PAISDEORIGEN IS NOT NULL ORDER BY 1";

		try {
			statement = c.prepareStatement(sql);
			rsPaises = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsPaises;
	}

	public void cierraRsPaises() {
		try {
			rsPaises.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cierraBBDD() {
		miConexion.cierraConexion();
	}

	private ConectaBBDD miConexion;
	private Connection c;
	private ResultSet rsSecciones = null;
	private ResultSet rsPaises = null;
}
