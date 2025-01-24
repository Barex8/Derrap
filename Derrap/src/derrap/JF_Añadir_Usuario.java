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

public class JF_Añadir_Usuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TF_Nombre;
	private JTextField TF_DNI;
	private JTextField TF_Rol;
	private JTextField TF_Estado_Alta;
	private JTextField TF_Telefono;
	private JTextField TF_Correo;
	private JTextField TF_Especialidad;
	private JTextField TF_codigo;

	private String[] datos = new String[8];

	private ArrayList<JTextField> info = new ArrayList<>();

	public JF_Añadir_Usuario(JF_Usuario_Admin frame, String DNI) { // Para modificar o eliminar
		String tabla = "usuario";
		String campo1 = "", campo2 = "", campo3 = "", campo4 = "", campo5 = "", campo6 = "", campo7 = "", campo8 = "";
		ResultSet result = null;
		result = login.conexion.consulta("Select * From " + tabla + " WHERE dni_" + tabla + " = " + "'" + DNI + "'");
		
		try {
				campo1 = result.getString("nombre_" + tabla.toLowerCase());
				campo2 = result.getString("id_rol_" + tabla.toLowerCase());
				campo3 = result.getString("estado_alta_" + tabla.toLowerCase());
				campo4 = result.getString("correo_electronico_" + tabla.toLowerCase());
				campo5 = result.getString("telefono_" + tabla.toLowerCase());
				campo6 = result.getString("especialidad_" + tabla.toLowerCase());

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

		JLabel lb_DNI = null;	
		lb_DNI = new JLabel("DNI");
		contentPane.add(lb_DNI, "2, 4");

		TF_DNI = new JTextField();
		TF_DNI.setColumns(10);
		TF_DNI.setEditable(false);
		TF_DNI.setText(DNI);
		info.add(TF_DNI);
		contentPane.add(TF_DNI, "2, 6, fill, default");

		JLabel lb_Nombre = null;
		lb_Nombre = new JLabel("Nombre");	
		contentPane.add(lb_Nombre, "2, 10");

		TF_Nombre = new JTextField();
		TF_Nombre.setColumns(10);
		TF_Nombre.setText(campo1);
		info.add(TF_Nombre);
		contentPane.add(TF_Nombre, "2, 12, fill, default");

		JLabel lb_Rol = null;
		lb_Rol = new JLabel("Rol");

		contentPane.add(lb_Rol, "2, 16");

		TF_Rol = new JTextField();
		TF_Rol.setColumns(10);
		TF_Rol.setText(campo2);
		info.add(TF_Rol);
		contentPane.add(TF_Rol, "2, 18, fill, default");

		JLabel lb_Estado_Alta = null;
		lb_Estado_Alta = new JLabel("Estado alta");
		contentPane.add(lb_Estado_Alta, "2, 22");

		TF_Estado_Alta = new JTextField();
		TF_Estado_Alta.setColumns(10);
		TF_Estado_Alta.setText(campo3);
		info.add(TF_Estado_Alta);
		contentPane.add(TF_Estado_Alta, "2, 24, fill, default");

		JLabel lb_Correo = new JLabel("Correo electrónico");
		contentPane.add(lb_Correo, "2, 34");

		TF_Correo = new JTextField();
		TF_Correo.setColumns(10);
		TF_Correo.setText(campo4);
		info.add(TF_Correo);
		contentPane.add(TF_Correo, "2, 36, fill, default");

		JLabel lb_Telefono = null;
		lb_Telefono = new JLabel("Telefono");
		
		contentPane.add(lb_Telefono, "2, 28");

		TF_Telefono = new JTextField();
		TF_Telefono.setColumns(10);
		TF_Telefono.setText(campo5);
		info.add(TF_Telefono);
		contentPane.add(TF_Telefono, "2, 30, fill, default");

		JLabel lb_Especialidad = null;		
		lb_Especialidad = new JLabel("Especialidad");
		
		contentPane.add(lb_Especialidad, "2, 40");

		TF_Especialidad = new JTextField();
		TF_Especialidad.setColumns(10);
		TF_Especialidad.setText(campo6);
		info.add(TF_Especialidad);
		contentPane.add(TF_Especialidad, "2, 42, fill, default");
		
		JButton EliminarCliente = new JButton("Eliminar"); // ELIMINAR
		EliminarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = true;
				if (info.get(0).getText().equals("")) {
					System.out.println("El campo DNI no puede estar vacio");
					success = false;
				
					// Si todo sale bien, borrar datos en la base de datos y actualizar la tabla de Usuario
					if (success) {
						String id_orden = login.conexion.consultaCampo("id_orden_trabajo", "orden_trabajo",
								" Where dni_usuario_orden_trabajo = '" + info.get(0).getText() + "'");
						login.conexion
								.DML("DELETE From derrap.factura WHERE id_orden_trabajo =" + "'" + id_orden + "'");
						login.conexion.DML("DELETE From derrap.orden_trabajo WHERE dni_usuario_orden_trabajo ="
								+ "'" + info.get(0).getText() + "'");
						login.conexion.DML("DELETE From derrap." + tabla + " where derrap." + tabla + ".dni_"
								+ tabla + " = " + "'" + info.get(0).getText() + "'");// Hay que mirar que los usuarios tienen coches asociados y por eso no se pueden borrar
						frame.ActualizarTabla();
						dispose();
					}
				}
			}});
		contentPane.add(EliminarCliente, "3, 46");

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
						login.conexion.DML("UPDATE " + tabla + " SET nombre_usuario = '" + datos[1]
						+ "', id_rol_usuario = '" + datos[2] + "' , estado_alta_usuario = '" + datos[3]
						+ "', correo_electronico_usuario = '" + datos[4] + "', telefono_usuario = '" + datos[5]
						+ "',especialidad_usuario = '" + datos[6] + "' WHERE dni_usuario = '" + datos[0] + "'");
					dispose();
					frame.ActualizarTabla();
				}
			}
		});
		contentPane.add(Guardar, "3, 44");
	}
	
	public JF_Añadir_Usuario(JF_Usuario_Admin frame) { // Se usa solo para Añadir
		String tabla = "usuario";
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

		JLabel lb_DNI = null;	
		lb_DNI = new JLabel("DNI");
		contentPane.add(lb_DNI, "2, 4");

		TF_DNI = new JTextField();
		TF_DNI.setColumns(10);
		info.add(TF_DNI); // 0
		contentPane.add(TF_DNI, "2, 6, fill, default");

		JLabel lb_Nombre = null;
		lb_Nombre = new JLabel("Nombre");	
		contentPane.add(lb_Nombre, "2, 10");

		TF_Nombre = new JTextField();
		TF_Nombre.setColumns(10);
		info.add(TF_Nombre); // 1
		contentPane.add(TF_Nombre, "2, 12, fill, default");

		JLabel lb_Rol = null;
		lb_Rol = new JLabel("Rol");

		contentPane.add(lb_Rol, "2, 16");

		TF_Rol = new JTextField();
		TF_Rol.setColumns(10);
		info.add(TF_Rol); // 2
		contentPane.add(TF_Rol, "2, 18, fill, default");

		JLabel lb_Estado_Alta = null;
		lb_Estado_Alta = new JLabel("Estado alta");
		contentPane.add(lb_Estado_Alta, "2, 22");

		TF_Estado_Alta = new JTextField();
		TF_Estado_Alta.setColumns(10);
		info.add(TF_Estado_Alta); // 3
		contentPane.add(TF_Estado_Alta, "2, 24, fill, default");

		JLabel lb_Correo = new JLabel("Correo electrónico");
		contentPane.add(lb_Correo, "2, 34");
		
		TF_Telefono = new JTextField();
		TF_Telefono.setColumns(10);
		info.add(TF_Telefono); // 4
		contentPane.add(TF_Telefono, "2, 30, fill, default");

		JLabel lb_Telefono = null;
		lb_Telefono = new JLabel("Telefono");

		TF_Correo = new JTextField();
		TF_Correo.setColumns(10);
		info.add(TF_Correo); // 5 (4 en proveedor)
		contentPane.add(TF_Correo, "2, 36, fill, default");

		JLabel lb_Especialidad = null;		
		lb_Especialidad = new JLabel("Especialidad");
		
		contentPane.add(lb_Especialidad, "2, 40");

		TF_Especialidad = new JTextField();
		TF_Especialidad.setColumns(10);
		info.add(TF_Especialidad);
		contentPane.add(TF_Especialidad, "2, 42, fill, default");

		
		JLabel lb_Contraseña = new JLabel("Contraseña");
		contentPane.add(lb_Contraseña, "2, 46");

		TF_codigo = new JTextField();
		TF_codigo.setColumns(10);
		info.add(TF_codigo);
		contentPane.add(TF_codigo, "2, 48, fill, default");
		

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
						login.conexion.DML("INSERT INTO derrap." + tabla + " VALUES('" + datos[0] + "', '" + datos[7]
						+ "' , '" + datos[1] + "', '" + datos[5] + "', '" + datos[4] + "', '" + datos[6]);
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
