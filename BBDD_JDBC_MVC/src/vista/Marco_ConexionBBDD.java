package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Marco_ConexionBBDD extends JFrame {

	public Marco_ConexionBBDD() {

		setTitle("Parámetros de conexión a Base de Datos");
		setBounds(300, 300, 600, 300);
		setLayout(new BorderLayout());

		JPanel panelEtiquetas = new JPanel(new GridLayout(0,1));
		JPanel panelValores = new JPanel(new GridLayout(0,1));

		JLabel l_db_driver = new JLabel("Driver:", JLabel.TRAILING);
		JTextField t_db_driver = new JTextField(10);
		l_db_driver.setLabelFor(t_db_driver);
		t_db_driver.setText("mysql");
		panelEtiquetas.add(l_db_driver);
		panelValores.add(t_db_driver);

		JLabel l_db_host = new JLabel("Servidor de base de datos:", JLabel.TRAILING);
		JTextField t_db_host = new JTextField(32);
		l_db_host.setLabelFor(t_db_host);
		t_db_host.setText("localhost");
		panelEtiquetas.add(l_db_host);
		panelValores.add(t_db_host);

		JLabel l_db_port = new JLabel("Puerto:", JLabel.TRAILING);
		JTextField t_db_port = new JTextField(5);
		l_db_port.setLabelFor(t_db_port);
		t_db_port.setText("3306");
		panelEtiquetas.add(l_db_port);
		panelValores.add(t_db_port);

		JLabel l_db_name = new JLabel("Nombre base de datos:", JLabel.TRAILING);
		JTextField t_db_name = new JTextField(32);
		l_db_name.setLabelFor(t_db_name);
		t_db_name.setText("pruebas");
		panelEtiquetas.add(l_db_name);
		panelValores.add(t_db_name);

		JLabel l_db_usrid = new JLabel("ID usuario:", JLabel.TRAILING);
		JTextField t_db_usrid = new JTextField(32);
		l_db_usrid.setLabelFor(t_db_usrid);
		t_db_usrid.setText("root");
		panelEtiquetas.add(l_db_usrid);
		panelValores.add(t_db_usrid);

		JLabel l_db_password = new JLabel("Password:", JLabel.TRAILING);
		JTextField t_db_password = new JPasswordField(32);
		l_db_password.setLabelFor(t_db_password);
		t_db_password.setText("");
		panelEtiquetas.add(l_db_password);
		panelValores.add(t_db_password);

		panelEtiquetas.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panelValores.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		add(panelEtiquetas, BorderLayout.LINE_START);
		add(panelValores, BorderLayout.LINE_END);

		add(panelValores);

	}

}
