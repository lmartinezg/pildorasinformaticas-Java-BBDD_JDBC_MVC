package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.ControladorBotonEjecuta;
import controlador.ControladorCargaCombos;
import modelo.Productos;
import principal.Ejecutar_MVC;

public class Marco_Aplicacion_2 extends JFrame {

	public Marco_Aplicacion_2() {

		setTitle("Consulta BBDD");
		setBounds(200, 200, 1024, 600);
		setLayout(new BorderLayout());

		JPanel menus = new JPanel();
		menus.setLayout(new FlowLayout());

		secciones = new JComboBox();
		secciones.setEditable(false);
		secciones.addItem("Todos");

		paises = new JComboBox();
		paises.setEditable(false);
		paises.addItem("Todos");

		resultado = new JTextArea(4, 50);
		resultado.setEditable(false);
		resultado.setFont(new Font("monospaced", Font.PLAIN, resultado.getFont().getSize()));
		add(resultado);

		menus.add(new JLabel("Secciones:"));
		menus.add(secciones);

		menus.add(new JLabel("Paises:"));
		menus.add(paises);

		add(menus, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);

		laminaBoton = new JPanel();
		laminaBoton.setLayout(new FlowLayout());

		JButton botonConsulta = new JButton("Consulta");
		laminaBoton.add(botonConsulta);
		add(laminaBoton, BorderLayout.SOUTH);

		botonConsulta.addActionListener(new ControladorBotonEjecuta(this));
		addWindowListener(new ControladorCargaCombos(this));

	}

	public void vaciaResultado() {
		resultado.setText("");
	}

	public void printHeaders(String tipo, int contador) {
		String format1 = " %-10s %-30s %-30s %-10s %-11s %-30s\n";
		String s;

		if (tipo != null) {
			if (tipo.equals("HEADER")) {
				
				if (Ejecutar_MVC.modoDebug){
					System.out.println();
				}

				s = String.format(format1, "Código", "Descripción", "Sección", "Precio", "Fecha", "Procedencia");
				resultado.append(s);
				
				if (Ejecutar_MVC.modoDebug){
					System.out.print(s);
				}

			}
		}
 
		s = String.format(format1, "----------", "------------------------------", "------------------------------",
				"----------", "-----------", "------------------------------");
		resultado.append(s);
		if (Ejecutar_MVC.modoDebug)
			System.out.print(s);
		
		if(tipo.equals("FOOTER")){
			s = " Número de registros: " + contador + "\n";
			resultado.append(s);

			if (Ejecutar_MVC.modoDebug)
				System.out.print(s);
			
		}
	}

	public void printDet(Productos p) {

		DateFormat df = DateFormat.getDateInstance();

		String format2 = " %-10s %-30s %-30s %10.2f %-11s %-30s\n";
		String s;

		Date fecha_articulo = p.getFecha_articulo();

		String s_fecha_articulo = null;
		if (!(fecha_articulo == null)) {
			s_fecha_articulo = this.df.format(fecha_articulo);
		}

		s = String.format(format2, 
				p.getCodigo_articulo(), 
				p.getNombre_articulo(), 
				p.getSeccion_articulo(), 
				p.getPrecio_articulo(),
				s_fecha_articulo, 
				p.getPais_articulo());

		resultado.append(s);
		if (Ejecutar_MVC.modoDebug){
			System.out.print(s);
		}
		
	}

	public JComboBox secciones;
	public JComboBox paises;
	public JTextArea resultado;
	private JPanel laminaBoton;

	// Formato de fecha local
	static DateFormat df = DateFormat.getDateInstance();

}
