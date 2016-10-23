// Referencias:
//
// Vídeo 212 - Modelo Vista Controlador

package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.CargaCombos;
import principal.Ejecutar_MVC;
import vista.Marco_Aplicacion_2;

public class ControladorCargaCombos extends WindowAdapter {

	public ControladorCargaCombos(Marco_Aplicacion_2 elMarco) {
		this.elMarco = elMarco;
	}

	public void windowOpened(WindowEvent e) {

		ResultSet rs;

		try {
			rs = objCargaCombos.ejecutaConsultaSecciones();
			while (rs.next()) {
				elMarco.secciones.addItem(rs.getString(1));
			}
			objCargaCombos.cierraRsSecciones();

			rs = objCargaCombos.ejecutaConsultaPaises();
			while (rs.next()) {
				elMarco.paises.addItem(rs.getString(1));
			}
			objCargaCombos.cierraRsPaises();
			
			objCargaCombos.cierraBBDD();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	CargaCombos objCargaCombos = new CargaCombos();
	
	private Marco_Aplicacion_2 elMarco;
}
