package derrap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class JF_Añadir_Vehiculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TF_Marca;
	private JTextField TF_Matricula;
	private JTextField TF_Modelo;
	private JTextField TF_Año;
	private JTextField TF_DNI_Cliente;
	private JTextField TF_Color;
	private JTextField TF_Ciudad;
	private JTextField TF_codigo;

	private String[] datos = new String[8];

	private ArrayList<JTextField> info = new ArrayList<>();

	public JF_Añadir_Vehiculo(JF_Vehiculo_Admin frame, String Matricula, String tabla) {			 // Para modificar o eliminar
		String campo1 = "", campo2 = "", campo3 = "", campo4 = "", campo5 = "", campo6 = "", campo7 = "", campo8 = "";
		ResultSet result = null;
		result = login.conexion.consulta(
				"Select * From Derrap." + tabla + " WHERE matricula_" + tabla + " = " + "'" + Matricula + "'");
		System.out
				.println("Select * From Derrap." + tabla + " WHERE matricula_" + tabla + " = " + "'" + Matricula + "'");
		try {
			result.next();
			campo1 = result.getString("marca_" + tabla.toLowerCase());
			campo2 = result.getString("modelo_" + tabla.toLowerCase());
			campo3 = result.getString("año_" + tabla.toLowerCase());
			campo4 = result.getString("color_" + tabla.toLowerCase());
			campo5 = result.getString("dni_cliente_" + tabla.toLowerCase());
		} catch (SQLException e) {
			System.out.println("Fallo al leer los datos");
			System.out.println(e.getLocalizedMessage());
		}

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("max(20dlu;min)"), ColumnSpec.decode("86px:grow"),
						ColumnSpec.decode("217px"), },
				new RowSpec[] { FormSpecs.UNRELATED_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lb_Matricula = null;
		lb_Matricula = new JLabel("Matricula");

		contentPane.add(lb_Matricula, "2, 4");

		TF_Matricula = new JTextField();
		TF_Matricula.setColumns(10);
		TF_Matricula.setEditable(false);
		System.out.println(Matricula);
		TF_Matricula.setText(Matricula);
		info.add(TF_Matricula);
		contentPane.add(TF_Matricula, "2, 6, fill, default");

		JLabel lb_Marca = null;
		lb_Marca = new JLabel("Marca");
		contentPane.add(lb_Marca, "2, 10");

		TF_Marca = new JTextField();
		TF_Marca.setColumns(10);
		TF_Marca.setText(campo1);
		info.add(TF_Marca);
		contentPane.add(TF_Marca, "2, 12, fill, default");

		JLabel lb_Modelo = null;
		lb_Modelo = new JLabel("Modelo");

		contentPane.add(lb_Modelo, "2, 16");

		TF_Modelo = new JTextField();
		TF_Modelo.setColumns(10);
		TF_Modelo.setText(campo2);
		info.add(TF_Modelo);
		contentPane.add(TF_Modelo, "2, 18, fill, default");

		JLabel lb_Año = null;
		lb_Año = new JLabel("Año");

		contentPane.add(lb_Año, "2, 22");

		TF_Año = new JTextField();
		TF_Año.setColumns(10);
		TF_Año.setText(campo3);
		info.add(TF_Año);
		contentPane.add(TF_Año, "2, 24, fill, default");

		JLabel lb_Color = new JLabel("Correo electrónico");
		lb_Color = new JLabel("Color");
		contentPane.add(lb_Color, "2, 28");

		TF_Color = new JTextField();
		TF_Color.setColumns(10);
		TF_Color.setText(campo4);
		info.add(TF_Color);
		contentPane.add(TF_Color, "2, 30, fill, default");

		JLabel lb_DNI_Cliente = null;
		lb_DNI_Cliente = new JLabel("DNI del cliente del vehiculo");
		contentPane.add(lb_DNI_Cliente, "2, 34");

		TF_DNI_Cliente = new JTextField();
		TF_DNI_Cliente.setColumns(10);
		TF_DNI_Cliente.setText(campo5);
		info.add(TF_DNI_Cliente);
		contentPane.add(TF_DNI_Cliente, "2, 36, fill, default");

		JButton EliminarVehiculo = new JButton("Eliminar"); 			// ELIMINAR
		EliminarVehiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = true;
				if (info.get(0).getText().equals("")) {
					System.out.println("El campo Matricula no puede estar vacio");
					success = false;
				}
				// Si todo sale bien, borrar datos en la base de datos y actualizar la tabla de
				// Clientes_Admin

				if (success) {
					System.out.println("Borrado cita");
					login.conexion.DML("DELETE From derrap.cita WHERE matricula_vehiculo_cita =" + "'"
							+ info.get(0).getText() + "'");
					System.out.println("Consulta id_orden_trabajo");
					String id_orden = login.conexion.consultaCampo("id_orden_trabajo", "orden_trabajo",
							" Where id_matricula_orden_trabajo = '" + info.get(0).getText() + "'");
					login.conexion.DML("DELETE From derrap.factura WHERE id_orden_trabajo =" + "'" + id_orden + "'");
					System.out.println("Borrado orden");
					login.conexion.DML("DELETE From derrap.orden_trabajo WHERE id_matricula_orden_trabajo =" + "'"
							+ info.get(0).getText() + "'");
					System.out.println("DELETE From derrap.orden_trabajo WHERE id_matricula_orden_trabajo =" + "'"
							+ info.get(0).getText() + "'");

					login.conexion.DML("DELETE From derrap." + tabla + " where derrap." + tabla + ".matricula_" + tabla
							+ " = " + "'" + info.get(0).getText() + "'");

					frame.ActualizarTabla();
					dispose();
				}
			}
		});

		contentPane.add(EliminarVehiculo, "3, 46");

		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(Cancelar, "3, 42");
		JButton Guardar = new JButton("Guardar");
		Guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // Codigo MODIFICAR Update
				boolean success = true;
				int index = 0;
				for (JTextField dato : info) {
					if (dato.getText().equals("")) {
						System.out.println("Se necesita insertar todos los datos para poder realizar la operación");
						login.conexion.MostrarWarningPanel(contentPane, "Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
						//break;
					}
					datos[index] = dato.getText();
					index++;
				}
				if(!login.conexion.ComprobarExistenciaCliente(datos[5])) {
					success = false;
					login.conexion.MostrarWarningPanel(contentPane,"El DNI del usuario no existe");
				}
				// Si todo sale bien, insertar datos en la base de datos y actualizar la tabla
				// de Clientes_Admin
				if (success) {
					login.conexion.DML("UPDATE " + tabla + " SET marca_vehiculo = '" + datos[1]
							+ "', modelo_vehiculo = '" + datos[2] + "' , año_vehiculo = " + datos[3]
							+ ", color_vehiculo = '" + datos[4] + "', dni_cliente_vehiculo = '" + datos[5]
							+ "'  WHERE matricula_vehiculo = '" + datos[0] + "'");
					dispose();
					frame.ActualizarTabla();
					//login.conexion.MostrarInformationPanel(contentPane,"El DNI del usuario no existe");
				}
			}
		});
		contentPane.add(Guardar, "3, 44");

	}

	public JF_Añadir_Vehiculo(JF_Vehiculo_Admin frame, String tabla) { // Se usa solo para Añadir
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("max(20dlu;min)"), ColumnSpec.decode("86px:grow"),
						ColumnSpec.decode("217px"), },
				new RowSpec[] { FormSpecs.UNRELATED_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lb_Matricula = null;
		lb_Matricula = new JLabel("Matricula");

		contentPane.add(lb_Matricula, "2, 4");

		TF_Matricula = new JTextField();
		TF_Matricula.setColumns(10);
		info.add(TF_Matricula); // 0
		contentPane.add(TF_Matricula, "2, 6, fill, default");

		JLabel lb_Marca = null;
		lb_Marca = new JLabel("Marca");
		contentPane.add(lb_Marca, "2, 10");

		TF_Marca = new JTextField();
		TF_Marca.setColumns(10);
		info.add(TF_Marca); // 1
		contentPane.add(TF_Marca, "2, 12, fill, default");

		JLabel lb_Modelo = null;
		lb_Modelo = new JLabel("Modelo");

		contentPane.add(lb_Modelo, "2, 16");

		TF_Modelo = new JTextField();
		TF_Modelo.setColumns(10);
		info.add(TF_Modelo); // 2
		contentPane.add(TF_Modelo, "2, 18, fill, default");

		JLabel lb_Año = null;
		lb_Año = new JLabel("Año");

		contentPane.add(lb_Año, "2, 22");
		TF_Año = new JTextField();
		TF_Año.setColumns(10);
		info.add(TF_Año); // 3
		contentPane.add(TF_Año, "2, 24, fill, default");

		JLabel lb_Color = new JLabel("Correo electrónico");
		lb_Color = new JLabel("Color");
		contentPane.add(lb_Color, "2, 28");

		TF_Color = new JTextField();
		TF_Color.setColumns(10);
		info.add(TF_Color); // 5 (4 en proveedor)
		contentPane.add(TF_Color, "2, 30, fill, default");

		JLabel lb_DNI_Cliente = null;
		lb_DNI_Cliente = new JLabel("DNI del cliente del vehiculo");
		contentPane.add(lb_DNI_Cliente, "2, 34");

		TF_DNI_Cliente = new JTextField();
		TF_DNI_Cliente.setColumns(10);
		info.add(TF_DNI_Cliente); // 4
		contentPane.add(TF_DNI_Cliente, "2, 36, fill, default");

		JButton AñadirCliente = new JButton("Añadir");
		AñadirCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = true;
				int index = 0;
				for (JTextField dato : info) {
					if (dato.getText().equals("")) {
						System.out.println("Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
						break;
					}
					datos[index] = dato.getText();
					index++;
				}
				// Si todo sale bien, insertar datos en la base de datos y actualizar la tabla
				// de Clientes_Admin
				System.out.println(success);
				if (success) {
					try {
						login.conexion.DML("INSERT INTO derrap." + tabla + " VALUES('" + datos[0] + "', '" + datos[1]
								+ "' , '" + datos[2] + "', " + datos[3] + " , '" + datos[4] + "', '" + datos[5] + "')");
						frame.ActualizarTabla();
					}catch(Exception exc) {
						System.out.println(exc.getLocalizedMessage());
					}
					
					dispose();
				}
			}
		});
		contentPane.add(AñadirCliente, "3, 50");

		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(Cancelar, "3, 42");

	}

}
