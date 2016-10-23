package principal;

import javax.swing.JFrame;

import vista.Marco_Aplicacion_2;

public class Ejecutar_MVC {

	public static void main(String[] args) {

//		Marco_ConexionBBDD l = new Marco_ConexionBBDD();
//		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		l.pack();
//		l.setVisible(true);
//
//		boolean retry = false;
//		do {
//			connection1 = (new ConectaBBDD()).getmyConnection();
//			if (connection1 == null) {
//				retry = ErrorConexion.showRetryCancel();
//				if (retry != true) {
//					System.exit(0);
//				}
//			}
//		} while (retry == true);

		Marco_Aplicacion_2 mimarco = new Marco_Aplicacion_2();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

//	static public Connection connection1 = null;
	static public boolean modoDebug = true;

}
