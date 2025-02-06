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
import javax.swing.JComboBox;

public class JF_Añadir_Orden extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField TF_Fecha_Entrada;
	private JTextField TF_Id;
	private JTextField TF_Fecha_Salida;
	private JTextField TF_Descripcion;
	private JTextField TF_DNI_Cliente;
	private JTextField TF_Piezas_Utilizadas;
	private JTextField TF_Ciudad;
	private JTextField TF_codigo;
	private JLabel lb_Servicio;
	private JComboBox comboBox;
	private JLabel lb_Estado;
	private JComboBox Combo_Estado;
	private JLabel lb_DNI_Cliente_1;
	private JTextField textField;
	private String[] datos = new String[8];

	private ArrayList<JTextField> info = new ArrayList<>();

	public JF_Añadir_Orden(JF_Ordenes_Admin frame, String ID) {			 // Para modificar o eliminar
		String fechaEntrada = "", fechaSalida = "", descripcion = "", sustitucionPieza = "", idServicio = "", idEstadoAsignacion = "", idEstadoReparacion = "", matricula = "",dniUsuario = "";
		String tabla = "derrap.orden_trabajo";
		ResultSet result = null;
		result = login.conexion.consulta(
				"Select * From Derrap." + tabla + " WHERE id_" + tabla + " = " + "'" + ID + "'");
		System.out.println("Select * From Derrap." + tabla + " WHERE id_" + tabla + " = " + "'" + ID + "'");
		try {
			result.next();
			fechaEntrada = result.getString("fecha_entrada_" + tabla.toLowerCase());
			fechaSalida = result.getString("fecha_salida_" + tabla.toLowerCase());
			descripcion = result.getString("descripcion_" + tabla.toLowerCase());
			sustitucionPieza = result.getString("sustitucion_pieza_" + tabla.toLowerCase());
			idServicio = result.getString("id_servicio_" + tabla.toLowerCase());
			idEstadoAsignacion = result.getString("id_estado_asignacion_" + tabla.toLowerCase());
			idEstadoReparacion = result.getString("id_estado_reparacion_" + tabla.toLowerCase());
			matricula = result.getString("id_matricula_" + tabla.toLowerCase());
			dniUsuario = result.getString("dni_usuario_" + tabla.toLowerCase());
		} catch (SQLException e) {
			System.out.println("Fallo al leer los datos");
			System.out.println(e.getLocalizedMessage());
		}

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(20px;min)"),
				ColumnSpec.decode("300px:grow"),
				ColumnSpec.decode("15px"),
				ColumnSpec.decode("300px:grow"),
				ColumnSpec.decode("20px"),},
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
				FormSpecs.RELATED_GAP_ROWSPEC,}));

		JLabel lb_Id = null;
		lb_Id = new JLabel("Id Orden");
		contentPane.add(lb_Id, "2, 4");

		TF_Id = new JTextField();
		TF_Id.setColumns(10);
		TF_Id.setEditable(false);
		TF_Id.setText(ID);
		info.add(TF_Id);
		System.out.println(ID);
		contentPane.add(TF_Id, "2, 6, fill, default");
		
		JLabel lb_descripcion = null;
		lb_descripcion = new JLabel("Descripción");
		contentPane.add(lb_descripcion, "4, 4");
		
		TF_Descripcion = new JTextField();
		TF_Descripcion.setColumns(10);
		TF_Descripcion.setText(descripcion);
		info.add(TF_Descripcion);
		contentPane.add(TF_Descripcion, "4, 6, 1, 6, fill, default");
		
		lb_Estado = new JLabel("Estado de la orden");
		contentPane.add(lb_Estado, "2, 10");
		
		Combo_Estado = new JComboBox();
		contentPane.add(Combo_Estado, "2, 12, fill, default");
		
		JLabel lb_Piezas_Utilizadas = new JLabel("Piezas Utilizadas");
		contentPane.add(lb_Piezas_Utilizadas, "4, 14");
		
		TF_Piezas_Utilizadas = new JTextField();
		TF_Piezas_Utilizadas.setText("<dynamic>");
		TF_Piezas_Utilizadas.setColumns(10);
		info.add(TF_Piezas_Utilizadas);
		contentPane.add(TF_Piezas_Utilizadas, "4, 16, 1, 8, fill, default");

		JLabel lb_Fecha_Entrada = null;
		lb_Fecha_Entrada = new JLabel("Fecha entrada del vehículo");
		contentPane.add(lb_Fecha_Entrada, "2, 16");
		TF_Fecha_Entrada = new JTextField();
		TF_Fecha_Entrada.setColumns(10);
		TF_Fecha_Entrada.setText(fechaEntrada);
		info.add(TF_Fecha_Entrada);
		contentPane.add(TF_Fecha_Entrada, "2, 18, fill, default");	
		
		
		JLabel lb_Fecha_Salida = null;
		lb_Fecha_Salida = new JLabel("Fecha salida del vehículo");		
		contentPane.add(lb_Fecha_Salida, "2, 22");
		TF_Fecha_Salida = new JTextField();
		TF_Fecha_Salida.setColumns(10);
		TF_Fecha_Salida.setText(fechaSalida);
		info.add(TF_Fecha_Salida);
		contentPane.add(TF_Fecha_Salida, "2, 24, fill, default");		

		lb_Servicio = new JLabel("Tipo Servicio");
		contentPane.add(lb_Servicio, "2, 28");
		comboBox = new JComboBox();
		contentPane.add(comboBox, "2, 30, fill, default");
		

		JLabel lb_DNI_Cliente = null;
		
		lb_DNI_Cliente = new JLabel("DNI del cliente del vehiculo");
		contentPane.add(lb_DNI_Cliente, "4, 26");
		
		
				TF_DNI_Cliente = new JTextField();
				TF_DNI_Cliente.setColumns(10);
				TF_DNI_Cliente.setText(idServicio);
				info.add(TF_DNI_Cliente);
				contentPane.add(TF_DNI_Cliente, "4, 28, fill, default");
		
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
							//login.conexion.MostrarInformationPanel(contentPane,"El DNI del usuario no existe");
						}
					}
				});
				
				lb_DNI_Cliente_1 = new JLabel("Matrícula del vehículo");
				contentPane.add(lb_DNI_Cliente_1, "4, 32");
				
				textField = new JTextField();
				textField.setText("<dynamic>");
				textField.setColumns(10);
				contentPane.add(textField, "4, 34, fill, default");
				contentPane.add(Guardar, "4, 38");
				
						JButton Cancelar = new JButton("Cancelar");
						Cancelar.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								dispose();
							}
						});
						contentPane.add(Cancelar, "4, 40");

	}

}
