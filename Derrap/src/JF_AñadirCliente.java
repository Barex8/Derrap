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

public class JF_AñadirCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TF_Nombre;
	private JTextField TF_DNI;
	private JTextField TF_Primer_Apellido;
	private JTextField TF_Segundo_Apellido;
	private JTextField TF_Telefono;
	private JTextField TF_Correo;
	private JTextField TF_Ciudad;
	private JTextField TF_codigo;

	private String[] datos = new String[8];

	private ArrayList<JTextField> info = new ArrayList<>();

	private String tipoUsuario;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JF_AñadirCliente frame = new JF_AñadirCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JF_AñadirCliente(Clientes_Admin frame,String DNI,String tabla) {										//Para modificar o eliminar
		String campo1 = "", campo2= "", campo3= "", campo4= "", campo5= "", campo6= "", campo7= "", campo8="";
		ResultSet result = null;
		if(!tabla.equals("Proveedor")) {
			result = login.conexion.consulta("Select * From "+tabla+" WHERE dni_"+tabla+" = " + "'"+DNI+"'");
		} else {
			result = login.conexion.consulta("Select * From "+tabla+" WHERE cif_"+tabla+" = " + "'"+DNI+"'");
		}

		try {
			result.next();
			if(tabla.equals("Cliente")) {
				tipoUsuario = "Cliente";
				campo1 = result.getString("nombre_"+tabla.toLowerCase());
				campo2 = result.getString("primer_apellido_"+tabla.toLowerCase());
				campo3 = result.getString("segundo_apellido_"+tabla.toLowerCase());
				campo4 = result.getString("correo_electronico_"+tabla.toLowerCase());
				campo5 = result.getString("telefono_"+tabla.toLowerCase());
				campo6 = result.getString("ciudad_"+tabla.toLowerCase());
				campo7 = result.getString("codigo_postal_"+tabla.toLowerCase());
			} else if(tabla.equals("Usuario")) {
				tipoUsuario = "Usuario";

				campo1 = result.getString("nombre_"+tabla.toLowerCase());
				campo2 = result.getString("id_rol_"+tabla.toLowerCase());
				campo3 = result.getString("estado_alta_"+tabla.toLowerCase());
				campo4 = result.getString("correo_electronico_"+tabla.toLowerCase());
				campo5 = result.getString("telefono_"+tabla.toLowerCase());
				campo6 = result.getString("especialidad_"+tabla.toLowerCase());
			}else if(tabla.equals("Proveedor")) {
				tipoUsuario = "Proveedor";
				campo1 = result.getString("nombre_"+tabla.toLowerCase());
				campo2 = result.getString("direccion_"+tabla.toLowerCase());
				campo3 = result.getString("estado_"+tabla.toLowerCase());
				campo4 = result.getString("correo_electronico_"+tabla.toLowerCase());
			}


		} catch (SQLException e) {
			System.out.println("Fallo al leer los datos");
			System.out.println(e.getLocalizedMessage());
		}

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(20dlu;min)"),
				ColumnSpec.decode("86px:grow"),
				ColumnSpec.decode("217px"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));



		JLabel lb_DNI = new JLabel("DNI");
		contentPane.add(lb_DNI, "2, 4");

		TF_DNI = new JTextField();
		TF_DNI.setColumns(10);
		TF_DNI.setEditable(false);
		TF_DNI.setText(DNI);
		info.add(TF_DNI);
		contentPane.add(TF_DNI, "2, 6, fill, default");

		JLabel lb_Nombre = new JLabel("Nombre");
		contentPane.add(lb_Nombre, "2, 10");

		TF_Nombre = new JTextField();
		TF_Nombre.setColumns(10);
		TF_Nombre.setText(campo1);
		info.add(TF_Nombre);
		contentPane.add(TF_Nombre, "2, 12, fill, default");

		JLabel lb_Primer_Apellido = null;
		if(tipoUsuario.equals("Cliente")) {
			lb_Primer_Apellido = new JLabel("Primer apellido");
		}else if (tipoUsuario.equals("Usuario")) {
			lb_Primer_Apellido = new JLabel("Rol");
		}else if(tipoUsuario.equals("Proveedor")) {
			lb_Primer_Apellido = new JLabel("Direccion");
		}

		contentPane.add(lb_Primer_Apellido, "2, 16");

		TF_Primer_Apellido = new JTextField();
		TF_Primer_Apellido.setColumns(10);
		TF_Primer_Apellido.setText(campo2);
		info.add(TF_Primer_Apellido);
		contentPane.add(TF_Primer_Apellido, "2, 18, fill, default");

		JLabel lb_Segundo_Apellido = null;
		if(tipoUsuario.equals("Cliente")) {
			lb_Segundo_Apellido = new JLabel("Segundo apellido");
		}else if (tipoUsuario.equals("Usuario")) {
			lb_Segundo_Apellido = new JLabel("Estado alta");
		}else if (tipoUsuario.equals("Proveedor")) {
			lb_Segundo_Apellido = new JLabel("Estado");
		}

		contentPane.add(lb_Segundo_Apellido, "2, 22");

		TF_Segundo_Apellido = new JTextField();
		TF_Segundo_Apellido.setColumns(10);
		TF_Segundo_Apellido.setText(campo3);
		info.add(TF_Segundo_Apellido);
		contentPane.add(TF_Segundo_Apellido, "2, 24, fill, default");


		JLabel lb_Correo = new JLabel("Correo electrónico");
		contentPane.add(lb_Correo, "2, 34");

		TF_Correo = new JTextField();
		TF_Correo.setColumns(10);
		TF_Correo.setText(campo4);
		info.add(TF_Correo);
		contentPane.add(TF_Correo, "2, 36, fill, default");

		JLabel lb_Telefono = null;
		if(!tipoUsuario.equals("Proveedor")) {
			lb_Telefono = new JLabel("Telefono");
			contentPane.add(lb_Telefono, "2, 28");

			TF_Telefono = new JTextField();
			TF_Telefono.setColumns(10);
			TF_Telefono.setText(campo5);
			info.add(TF_Telefono);
			contentPane.add(TF_Telefono, "2, 30, fill, default");
		}

		JLabel lb_Ciudad = null;

		if(!tipoUsuario.equals("Proveedor")) {
			if(tipoUsuario.equals("Cliente")) {
				lb_Ciudad = new JLabel("Segundo apellido");
			}else if (tipoUsuario.equals("Usuario")) {
				lb_Ciudad = new JLabel("Especialidad");
			}
			contentPane.add(lb_Ciudad, "2, 40");

			TF_Ciudad = new JTextField();
			TF_Ciudad.setColumns(10);
			TF_Ciudad.setText(campo6);
			info.add(TF_Ciudad);
			contentPane.add(TF_Ciudad, "2, 42, fill, default");
		}

		if(tipoUsuario.equals("Cliente")) {
		JLabel lb_Codigo = new JLabel("Código postal");
		contentPane.add(lb_Codigo, "2, 46");

		TF_codigo = new JTextField();
		TF_codigo.setColumns(10);
		TF_codigo.setText(campo7);
		info.add(TF_codigo);
		contentPane.add(TF_codigo, "2, 48, fill, default");
		}


		JButton EliminarCliente = new JButton("Eliminar");			//ELIMINAR
		EliminarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = true;
				if(info.get(0).getText().equals("")) {
					System.out.println("El campo DNI no puede estar vacio");
					success = false;
				}
				//Si todo sale bien, borrar datos en la base de datos y actualizar la tabla de Clientes_Admin

				if(success) {
					if(!tipoUsuario.equals("Proveedor")) {
						login.conexion.DML("DELETE From derrap."+tabla+" where derrap."+tabla+".dni_"+tabla+" = "+"'"+info.get(0).getText()+"'");//Hay que mirar que los usuarios tienen coches asociados y por eso no se pueden borrar
					} else { //Hay que mirar que los usuarios tienen coches asociados y por eso no se pueden borrar
						login.conexion.DML("DELETE From derrap."+tabla+" where derrap."+tabla+".cif_"+tabla+" = "+"'"+info.get(0).getText()+"'");
					}
					frame.ActualizarTabla(tabla);
					dispose();
				}
			}
		});
		contentPane.add(EliminarCliente, "3, 46");

		System.out.println(info);

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
			public void actionPerformed(ActionEvent e) {   //Codigo MODIFICAR Update
				boolean success = true;
				int index = 0;
				for(JTextField dato:info) {
					if(dato.getText().equals("")) {
						System.out.println("Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
						break;
					}
					datos[index] = dato.getText();
					index++;
				}
				//Si todo sale bien, insertar datos en la base de datos y actualizar la tabla de Clientes_Admin
				System.out.println(success);
				if(success) {
					System.out.println(datos[0]);
					if(tabla.equals("Cliente")) {
						login.conexion.DML("UPDATE "+tabla+" SET nombre_cliente = '"+datos[1]+"', primer_apellido_cliente = '"+datos[2]+"' , segundo_apellido_cliente = '"+datos[3]+"', correo_electronico_cliente = '"+datos[4]+
								"', telefono_cliente = '"+datos[5]+"',ciudad_cliente = '"+datos[6]+"',codigo_postal_cliente = '"+datos[7]+"' WHERE dni_cliente = '"+datos[0]+"'");

					}else if(tabla.equals("Usuario")) {
						login.conexion.DML("UPDATE "+tabla+" SET nombre_usuario = '"+datos[1]+"', id_rol_usuario = '"+datos[2]+"' , estado_alta_usuario = '"+datos[3]+"', correo_electronico_usuario = '"+datos[4]+
								"', telefono_usuario = '"+datos[5]+"',especialidad_usuario = '"+datos[6]+"' WHERE dni_usuario = '"+datos[0]+"'");
					}else if(tabla.equals("Proveedor")) {
						System.out.println("UPDATE "+tabla+" SET nombre_proveedor = '"+datos[1]+"', direccion_proveedor = '"+datos[2]+"' , estado_proveedor = '"+datos[3]+"', correo_electronico_proveedor = '"+datos[4]+ "'  WHERE cif_proveedor = '"+datos[0]+"'");
						login.conexion.DML("UPDATE "+tabla+" SET nombre_proveedor = '"+datos[1]+"', direccion_proveedor = '"+datos[2]+"' , estado_proveedor = '"+datos[3]+"', correo_electronico_proveedor = '"+datos[4]+ "' WHERE cif_proveedor = '"+datos[0]+"'");
					}
					dispose();
					frame.ActualizarTabla(tabla);
				}
			}
		});
		contentPane.add(Guardar, "3, 44");

	}

	public JF_AñadirCliente() {				//Para poder ver el frame en Design
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(20dlu;min)"),
				ColumnSpec.decode("86px:grow"),
				ColumnSpec.decode("217px"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lb_DNI = new JLabel("DNI");
		contentPane.add(lb_DNI, "2, 4");

		TF_DNI = new JTextField();
		TF_DNI.setColumns(10);
		info.add(TF_DNI);
		contentPane.add(TF_DNI, "2, 6, fill, default");

		JLabel lb_Nombre = new JLabel("Nombre");
		contentPane.add(lb_Nombre, "2, 10");

		TF_Nombre = new JTextField();
		TF_Nombre.setColumns(10);
		info.add(TF_Nombre);
		contentPane.add(TF_Nombre, "2, 12, fill, default");

		JLabel lb_Primer_Apellido = new JLabel("Primer apellido");
		contentPane.add(lb_Primer_Apellido, "2, 16");

		TF_Primer_Apellido = new JTextField();
		TF_Primer_Apellido.setColumns(10);
		info.add(TF_Primer_Apellido);
		contentPane.add(TF_Primer_Apellido, "2, 18, fill, default");

		JLabel lb_Segundo_Apellido = new JLabel("Segundo apellido");
		contentPane.add(lb_Segundo_Apellido, "2, 22");

		TF_Segundo_Apellido = new JTextField();
		TF_Segundo_Apellido.setColumns(10);
		info.add(TF_Segundo_Apellido);
		contentPane.add(TF_Segundo_Apellido, "2, 24, fill, default");

		JLabel lb_Telefono = new JLabel("Telefono");
		contentPane.add(lb_Telefono, "2, 28");

		TF_Telefono = new JTextField();
		TF_Telefono.setColumns(10);
		info.add(TF_Telefono);
		contentPane.add(TF_Telefono, "2, 30, fill, default");

		JLabel lb_Correo = new JLabel("Correo electrónico");
		contentPane.add(lb_Correo, "2, 34");

		TF_Correo = new JTextField();
		TF_Correo.setColumns(10);
		info.add(TF_Correo);
		contentPane.add(TF_Correo, "2, 36, fill, default");

		JLabel lb_Ciudad = new JLabel("Ciudad");
		contentPane.add(lb_Ciudad, "2, 40");

		TF_Ciudad = new JTextField();
		TF_Ciudad.setColumns(10);
		info.add(TF_Ciudad);
		contentPane.add(TF_Ciudad, "2, 42, fill, default");

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
			public void actionPerformed(ActionEvent e) {
														//Codigo modficiar Update
			}
		});
		contentPane.add(Guardar, "3, 44");

		JLabel lb_Codigo = new JLabel("Código postal");
		contentPane.add(lb_Codigo, "2, 46");

		JButton EliminarCliente = new JButton("Eliminar Cliente");
		EliminarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = true;
				if(datos[0].equals("")) {
					System.out.println("El campo DNI no puede estar vacio");
					success = false;
				}
				//Si todo sale bien, borrar datos en la base de datos y actualizar la tabla de Clientes_Admin
				System.out.println(success);
				if(success) {
					login.conexion.DML("DELETE From cliente where dni_cliente = "+datos[0]);
					dispose();
				}
			}
		});
		contentPane.add(EliminarCliente, "3, 46");

		TF_codigo = new JTextField();
		TF_codigo.setColumns(10);
		info.add(TF_codigo);
		contentPane.add(TF_codigo, "2, 48, fill, default");

		System.out.println(info);

		JButton AñadirCliente = new JButton("Añadir Cliente");
		AñadirCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = true;
				int index = 0;
				for(JTextField dato:info) {
					if(dato.getText().equals("")) {
						System.out.println("Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
						break;
					}
					datos[index] = dato.getText();
					index++;
				}
				//Si todo sale bien, insertar datos en la base de datos y actualizar la tabla de Clientes_Admin
				System.out.println(success);
				if(success) {
					login.conexion.DML("INSERT INTO derrap.cliente VALUES('"+datos[0]+"', '"+datos[1]+"' , '"+datos[2]+"', '"+datos[3]+"', '"+datos[4]+"', '"+datos[5]+"', '"+datos[6]+"', '"+datos[7]+"')");
					dispose();
				}
			}
		});
		contentPane.add(AñadirCliente, "3, 48");
	}




	public JF_AñadirCliente(Clientes_Admin frame,String tabla) {			//Se usa solo para Añadir
		tipoUsuario = tabla;
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(20dlu;min)"),
				ColumnSpec.decode("86px:grow"),
				ColumnSpec.decode("217px"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lb_DNI = new JLabel("DNI");
		contentPane.add(lb_DNI, "2, 4");

		TF_DNI = new JTextField();
		TF_DNI.setColumns(10);
		info.add(TF_DNI);		//0
		contentPane.add(TF_DNI, "2, 6, fill, default");

		JLabel lb_Nombre = new JLabel("Nombre");
		contentPane.add(lb_Nombre, "2, 10");

		TF_Nombre = new JTextField();
		TF_Nombre.setColumns(10);
		info.add(TF_Nombre);		//1
		contentPane.add(TF_Nombre, "2, 12, fill, default");

		JLabel lb_Primer_Apellido = null;
		if(tipoUsuario.equals("Cliente")) {
			lb_Primer_Apellido = new JLabel("Primer apellido");
		}else if (tipoUsuario.equals("Usuario")) {
			lb_Primer_Apellido = new JLabel("Rol");
		}else if(tipoUsuario.equals("Proveedor")) {
			lb_Primer_Apellido = new JLabel("Direccion");
		}
		contentPane.add(lb_Primer_Apellido, "2, 16");

		TF_Primer_Apellido = new JTextField();
		TF_Primer_Apellido.setColumns(10);
		info.add(TF_Primer_Apellido);		//2
		contentPane.add(TF_Primer_Apellido, "2, 18, fill, default");

		JLabel lb_Segundo_Apellido = null;
		if(tipoUsuario.equals("Cliente")) {
			lb_Segundo_Apellido = new JLabel("Segundo apellido");
		}else if (tipoUsuario.equals("Usuario")) {
			lb_Segundo_Apellido = new JLabel("Estado alta");
		}else if (tipoUsuario.equals("Proveedor")) {
			lb_Segundo_Apellido = new JLabel("Estado");
		}

		contentPane.add(lb_Segundo_Apellido, "2, 22");

		TF_Segundo_Apellido = new JTextField();
		TF_Segundo_Apellido.setColumns(10);
		info.add(TF_Segundo_Apellido);		//3
		contentPane.add(TF_Segundo_Apellido, "2, 24, fill, default");

		JLabel lb_Telefono = null;
		if(!tipoUsuario.equals("Proveedor")) {
			lb_Telefono = new JLabel("Telefono");
			contentPane.add(lb_Telefono, "2, 28");

			TF_Telefono = new JTextField();
			TF_Telefono.setColumns(10);
			info.add(TF_Telefono);	//4
			contentPane.add(TF_Telefono, "2, 30, fill, default");
		}

		JLabel lb_Correo = new JLabel("Correo electrónico");
		contentPane.add(lb_Correo, "2, 34");

		TF_Correo = new JTextField();
		TF_Correo.setColumns(10);
		info.add(TF_Correo);		//5 (4 en proveedor)
		contentPane.add(TF_Correo, "2, 36, fill, default");

		JLabel lb_Ciudad = null;

		if(!tipoUsuario.equals("Proveedor")) {
			if(tipoUsuario.equals("Cliente")) {
				lb_Ciudad = new JLabel("Segundo apellido");
			}else if (tipoUsuario.equals("Usuario")) {
				lb_Ciudad = new JLabel("Especialidad");
			}
			contentPane.add(lb_Ciudad, "2, 40");

			TF_Ciudad = new JTextField();
			TF_Ciudad.setColumns(10);
			info.add(TF_Ciudad);
			contentPane.add(TF_Ciudad, "2, 42, fill, default");
		}

		if(tipoUsuario.equals("Cliente")) {
		JLabel lb_Codigo = new JLabel("Código postal");
		contentPane.add(lb_Codigo, "2, 46");

		TF_codigo = new JTextField();
		TF_codigo.setColumns(10);
		info.add(TF_codigo);
		contentPane.add(TF_codigo, "2, 48, fill, default");
		}

		if(tipoUsuario.equals("Usuario")) {
			JLabel lb_Contraseña = new JLabel("Contraseña");
			contentPane.add(lb_Contraseña, "2, 46");

			TF_codigo = new JTextField();
			TF_codigo.setColumns(10);
			info.add(TF_codigo);
			contentPane.add(TF_codigo, "2, 48, fill, default");
			}

		JButton AñadirCliente = new JButton("Añadir");
		AñadirCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = true;
				int index = 0;
				for(JTextField dato:info) {
					if(dato.getText().equals("")) {
						System.out.println("Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
						break;
					}
					datos[index] = dato.getText();
					index++;
				}
				//Si todo sale bien, insertar datos en la base de datos y actualizar la tabla de Clientes_Admin
				System.out.println(success);
				if(success) {
					if(tipoUsuario.equals("Cliente")) {
						login.conexion.DML("INSERT INTO derrap."+tabla+" VALUES('"+datos[0]+"', '"+datos[1]+"' , '"+datos[2]+"', '"+datos[3]+"', '"+datos[4]+"', '"+datos[5]+"', '"+datos[6]+"', '"+datos[7]+"')");
					} else if(tipoUsuario.equals("Usuario")) {
						login.conexion.DML("INSERT INTO derrap."+tabla+" VALUES('"+datos[0]+"', '"+datos[7]+"' , '"+datos[1]+"', '"+datos[5]+"', '"+datos[4]+"', '"+datos[6]+"', '"+datos[3]+"', '"+datos[2]+"')");
					} else if (tipoUsuario.equals("Proveedor")) {
						login.conexion.DML("INSERT INTO derrap."+tabla+" VALUES('"+datos[0]+"', '"+datos[1]+"' , '"+datos[4]+"', '"+datos[2]+"' , '"+datos[3]+"')");
					}
					frame.ActualizarTabla(tabla);
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
