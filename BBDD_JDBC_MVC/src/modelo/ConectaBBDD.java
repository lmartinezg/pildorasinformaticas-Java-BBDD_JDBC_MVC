package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBBDD {

	public Connection dameConexion() {
		String db_driver = "mysql";
		String db_host = "localhost";
		String db_port = "3306";
		String db_name = "pruebas";

		// String db_url = "jdbc:mysql://localhost:3306";
		String db_url = "jdbc:" + db_driver + "://" + db_host + ":" + db_port + "/" + db_name;
		String db_user = "root";
		String db_password = "";

		// boolean connected = false;
		try {
			miConexion = DriverManager.getConnection(db_url, db_user, db_password);
			// connected = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return miConexion;
	}

	public void cierraConexion() {
		try {
			miConexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Connection miConexion = null;
}