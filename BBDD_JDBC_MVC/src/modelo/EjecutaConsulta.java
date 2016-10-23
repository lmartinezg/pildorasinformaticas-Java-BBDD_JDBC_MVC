package modelo;

import java.sql.*;

import principal.Ejecutar_MVC;

public class EjecutaConsulta {

	public void EjecutaConsulta() {
	}

	public ResultSet filtraBBDD(String seccion, String pais) {

		miConexion = new ConectaBBDD();
		c = miConexion.dameConexion();

		try {
			if (!seccion.equals("Todos") && pais.equals("Todos")) {
				// Solo se ha seleccionado la sección
				selectDetalle = c.prepareStatement(sqlDetPrefix1);
				selectDetalle.setString(1, seccion);
			} else if (seccion.equals("Todos") && !pais.equals("Todos")) {
				// Solo se ha seleccionado el país
				selectDetalle = c.prepareStatement(sqlDetPrefix2);
				selectDetalle.setString(1, pais);
			} else if (!seccion.equals("Todos") && !pais.equals("Todos")) {
				// Se ha seleccionado la sección y el país
				selectDetalle = c.prepareStatement(sqlDetPrefix3);
				selectDetalle.setString(1, seccion);
				selectDetalle.setString(2, pais);
			} else {
				// No se ha seleccionado no sección ni país
				selectDetalle = c.prepareStatement(sqlDetPrefix4);
			}

			rs = selectDetalle.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public void cierraBBDD() {
		miConexion.cierraConexion();
	}

	public void cierraRs() {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ConectaBBDD miConexion;
	private Connection c;

	private ResultSet rs;

	private final String sqlSecciones = "SELECT DISTINCT SECCION FROM PRODUCTOS WHERE SECCION IS NOT NULL ORDER BY 1";
	private final String sqlPaises = "SELECT DISTINCT PAISDEORIGEN FROM PRODUCTOS WHERE PAISDEORIGEN IS NOT NULL ORDER BY 1";

	private final String sqlDetPrefix = "SELECT CODIGOARTICULO, NOMBREARTICULO, SECCION, PRECIO, FECHA, PAISDEORIGEN FROM PRODUCTOS ";
	private final String sqlDetSuffix = " ORDER BY 1";

	private final String sqlDetPrefix1 = sqlDetPrefix + "WHERE SECCION=?" + sqlDetSuffix;
	private final String sqlDetPrefix2 = sqlDetPrefix + "WHERE PAISDEORIGEN=?" + sqlDetSuffix;
	private final String sqlDetPrefix3 = sqlDetPrefix + "WHERE SECCION=? AND PAISDEORIGEN=?" + sqlDetSuffix;
	private final String sqlDetPrefix4 = sqlDetPrefix + sqlDetSuffix;

	private PreparedStatement selectSecciones;
	private PreparedStatement selectPaises;
	private PreparedStatement selectDetalle;

}
