package derrap;

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

public class JF_Añadir_Pieza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TF_Oem;
	private JTextField TF_Nombre;
	private JTextField TF_Marca;
	private JTextField TF_Cantidad;
	private JTextField TF_Precio;
	private JTextField TF_Estado;
	private String[] datos = new String[6];

	private ArrayList<JTextField> info = new ArrayList<>();

	public JF_Añadir_Pieza(JF_Stock_Admin frame, String OEM, String tabla) { // Para modificar o eliminar
		String campo1 = "", campo2 = "", campo3 = "", campo4 = "", campo5 = "", campo6 = "", campo7 = "", campo8 = "";
		ResultSet result = null;
		result = login.conexion.consulta(
				"Select * From Derrap." + tabla + " WHERE oem_pieza_" + tabla + " = " + "'" + OEM + "'");
		System.out
				.println("Select * From Derrap." + tabla + " WHERE oem_pieza_" + tabla + " = " + "'" + OEM + "'");
		try {
			result.next();
			campo1 = result.getString("nombre_pieza_" + tabla.toLowerCase());
			campo2 = result.getString("marca_pieza_" + tabla.toLowerCase());
			campo3 = result.getString("cantidad_pieza_" + tabla.toLowerCase());
			campo4 = result.getString("precio_pieza_" + tabla.toLowerCase());
			campo5 = result.getString("estado_pieza_" + tabla.toLowerCase());
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

		JLabel lb_Oem = null;
		lb_Oem = new JLabel("Oem");

		contentPane.add(lb_Oem, "2, 4");

		TF_Oem = new JTextField();
		TF_Oem.setColumns(10);
		TF_Oem.setEditable(false);
		System.out.println(OEM);
		TF_Oem.setText(OEM);
		info.add(TF_Oem);
		contentPane.add(TF_Oem, "2, 6, fill, default");

		JLabel lb_Nombre = null;
		lb_Nombre = new JLabel("Nombre");
		contentPane.add(lb_Nombre, "2, 10");

		TF_Nombre = new JTextField();
		TF_Nombre.setColumns(10);
		TF_Nombre.setText(campo1);
		info.add(TF_Nombre);
		contentPane.add(TF_Nombre, "2, 12, fill, default");

		JLabel lb_Marca = null;
		lb_Marca = new JLabel("Modelo");

		contentPane.add(lb_Marca, "2, 16");

		TF_Marca = new JTextField();
		TF_Marca.setColumns(10);
		TF_Marca.setText(campo2);
		info.add(TF_Marca);
		contentPane.add(TF_Marca, "2, 18, fill, default");

		JLabel lb_Cantidad = null;
		lb_Cantidad = new JLabel("Cantidad");

		contentPane.add(lb_Cantidad, "2, 22");

		TF_Cantidad = new JTextField();
		TF_Cantidad.setColumns(10);
		TF_Cantidad.setText(campo3);
		info.add(TF_Cantidad);
		contentPane.add(TF_Cantidad, "2, 24, fill, default");

		JLabel lb_Precio = null;
		lb_Precio = new JLabel("Precio");
		
		contentPane.add(lb_Precio, "2, 28");

		TF_Precio = new JTextField();
		TF_Precio.setColumns(10);
		TF_Precio.setText(campo4);
		info.add(TF_Precio);
		contentPane.add(TF_Precio, "2, 30, fill, default");

		JLabel lb_Estado = null;
		lb_Estado = new JLabel("Estado");
		contentPane.add(lb_Estado, "2, 34");

		TF_Estado = new JTextField();
		TF_Estado.setColumns(10);
		TF_Estado.setText(campo5);
		info.add(TF_Estado);
		contentPane.add(TF_Estado, "2, 36, fill, default");


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
						success = false;
						break;
					}
					datos[index] = dato.getText();
					index++;
				}
				// Si todo sale bien, insertar datos en la base de datos y actualizar la tabla
				// de Clientes_Admin
				if (success) {
					login.conexion.DML("UPDATE " + tabla + " SET nombre_pieza_stock = '" + datos[1]
							+ "', marca_pieza_stock = '" + datos[2] + "' , cantidad_pieza_stock = " + datos[3]
							+ ", precio_pieza_stock = '" + datos[4] + "', estado_pieza_stock = '" + datos[5]
							+ "'  WHERE oem_pieza_stock = '" + datos[0] + "'");
					dispose();
					frame.ActualizarTabla();
				}
			}
		});
		contentPane.add(Guardar, "3, 44");

	}

	public JF_Añadir_Pieza(JF_Stock_Admin frame, String tabla) { // Se usa solo para Añadir
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
		
		JLabel lb_Oem = null;
		lb_Oem = new JLabel("Oem");
		contentPane.add(lb_Oem, "2, 4");

		TF_Oem = new JTextField();
		TF_Oem.setColumns(10);
		info.add(TF_Oem);
		contentPane.add(TF_Oem, "2, 6, fill, default");

		JLabel lb_Nombre = null;
		lb_Nombre = new JLabel("Nombre");
		contentPane.add(lb_Nombre, "2, 10");

		TF_Nombre = new JTextField();
		TF_Nombre.setColumns(10);
		info.add(TF_Nombre);
		contentPane.add(TF_Nombre, "2, 12, fill, default");

		JLabel lb_Marca = null;
		lb_Marca = new JLabel("Modelo");
		contentPane.add(lb_Marca, "2, 16");

		TF_Marca = new JTextField();
		TF_Marca.setColumns(10);
		info.add(TF_Marca);
		contentPane.add(TF_Marca, "2, 18, fill, default");

		JLabel lb_Cantidad = null;
		lb_Cantidad = new JLabel("Cantidad");
		contentPane.add(lb_Cantidad, "2, 22");

		TF_Cantidad = new JTextField();
		TF_Cantidad.setColumns(10);
		info.add(TF_Cantidad);
		contentPane.add(TF_Cantidad, "2, 24, fill, default");

		JLabel lb_Precio = null;
		lb_Precio = new JLabel("Precio");
		
		contentPane.add(lb_Precio, "2, 28");

		TF_Precio = new JTextField();
		TF_Precio.setColumns(10);
		info.add(TF_Precio);
		contentPane.add(TF_Precio, "2, 30, fill, default");

		JLabel lb_Estado = null;
		lb_Estado = new JLabel("Estado");
		contentPane.add(lb_Estado, "2, 34");

		TF_Estado = new JTextField();
		TF_Estado.setColumns(10);
		info.add(TF_Estado);
		contentPane.add(TF_Estado, "2, 36, fill, default");
		
		

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
					login.conexion.DML("INSERT INTO derrap." + tabla + " VALUES('" + datos[0] + "', '" + datos[1]
							+ "' , '" + datos[2] + "', " + datos[3] + " , '" + datos[4] + "', '" + datos[5] + "')");
					frame.ActualizarTabla();
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
	
	public JF_Añadir_Pieza(JF_Stock_Mecanico frame, String tabla) { // Se usa solo para Añadir
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
		
		JLabel lb_Oem = null;
		lb_Oem = new JLabel("Oem");
		contentPane.add(lb_Oem, "2, 4");

		TF_Oem = new JTextField();
		TF_Oem.setColumns(10);
		info.add(TF_Oem);
		contentPane.add(TF_Oem, "2, 6, fill, default");

		JLabel lb_Nombre = null;
		lb_Nombre = new JLabel("Nombre");
		contentPane.add(lb_Nombre, "2, 10");

		TF_Nombre = new JTextField();
		TF_Nombre.setColumns(10);
		info.add(TF_Nombre);
		contentPane.add(TF_Nombre, "2, 12, fill, default");

		JLabel lb_Marca = null;
		lb_Marca = new JLabel("Modelo");
		contentPane.add(lb_Marca, "2, 16");

		TF_Marca = new JTextField();
		TF_Marca.setColumns(10);
		info.add(TF_Marca);
		contentPane.add(TF_Marca, "2, 18, fill, default");

		JLabel lb_Cantidad = null;
		lb_Cantidad = new JLabel("Cantidad");
		contentPane.add(lb_Cantidad, "2, 22");

		TF_Cantidad = new JTextField();
		TF_Cantidad.setColumns(10);
		info.add(TF_Cantidad);
		contentPane.add(TF_Cantidad, "2, 24, fill, default");

		JLabel lb_Precio = null;
		lb_Precio = new JLabel("Precio");
		
		contentPane.add(lb_Precio, "2, 28");

		TF_Precio = new JTextField();
		TF_Precio.setColumns(10);
		info.add(TF_Precio);
		contentPane.add(TF_Precio, "2, 30, fill, default");

		JLabel lb_Estado = null;
		lb_Estado = new JLabel("Estado");
		contentPane.add(lb_Estado, "2, 34");

		TF_Estado = new JTextField();
		TF_Estado.setColumns(10);
		info.add(TF_Estado);
		contentPane.add(TF_Estado, "2, 36, fill, default");
		
		

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
					login.conexion.DML("INSERT INTO derrap." + tabla + " VALUES('" + datos[0] + "', '" + datos[1]
							+ "' , '" + datos[2] + "', " + datos[3] + " , '" + datos[4] + "', '" + datos[5] + "')");
					frame.ActualizarTabla();
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

