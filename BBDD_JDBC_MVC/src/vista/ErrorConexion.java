package vista;

import javax.swing.JOptionPane;

public class ErrorConexion {

	public static boolean showRetryCancel() {

		boolean retry = true;
		int opcion;

		Object[] options = { "Reintentar", "Cancelar" };
		opcion = JOptionPane.showOptionDialog(null, "No se pudo conectar con la Base de Datos", "Fallo de conexión",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if (opcion != 0) {
			// e.printStackTrace();
			retry = false;
			// System.exit(0);
		}
		return retry;
	}
}
