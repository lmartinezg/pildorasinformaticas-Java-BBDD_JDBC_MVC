// Referencias:
//
// Vídeo 218 - Procedimientos almacenados

package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import modelo.*;
import vista.*;

public class ControladorBotonEjecuta implements ActionListener {

	public ControladorBotonEjecuta(Marco_Aplicacion_2 elMarco) {
		this.elMarco = elMarco;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		elMarco.vaciaResultado();
		elMarco.printHeaders("HEADER", 0);

		// Recupera valor actual de los combos
		String seleccionSeccion = (String) elMarco.secciones.getSelectedItem();
		String seleccionPais = (String) elMarco.paises.getSelectedItem();

		rs = obj.filtraBBDD(seleccionSeccion, seleccionPais);

		Productos producto = new Productos();

		int contador = 0;
		try {
			while (rs.next()) {

				String codigo_articulo;
				String nombre_articulo;
				String pais_articulo;
				String seccion_articulo;
				BigDecimal precio_articulo;
				Date fecha_articulo;

				producto.setCodigo_articulo(rs.getString("CODIGOARTICULO"));
				producto.setNombre_articulo(rs.getString("NOMBREARTICULO"));
				producto.setPais_articulo(rs.getString("PAISDEORIGEN"));
				producto.setSeccion_articulo(rs.getString("SECCION"));
				producto.setPrecio_articulo(rs.getBigDecimal("PRECIO"));
				producto.setFecha_articulo(rs.getDate("FECHA"));

				elMarco.printDet(producto);
				contador++;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elMarco.printHeaders("FOOTER", contador);

		obj.cierraRs();
		obj.cierraBBDD();

	}

	private Marco_Aplicacion_2 elMarco;
	EjecutaConsulta obj = new EjecutaConsulta();
	private ResultSet rs;
}
