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
import javax.swing.DefaultComboBoxModel;

public class JF_Añadir_Orden extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField TF_Fecha_Entrada;
	private JTextField TF_Id;
	private JTextField TF_Fecha_Salida;
	private JTextField TF_Descripcion;
	private JTextField TF_DNI_mecanico;
	private JTextField TF_Piezas_Utilizadas;
	private JTextField TF_Ciudad;
	private JTextField TF_codigo;
	private JLabel lb_Servicio;
	private JLabel lb_Estado;
	private JComboBox Combo_Estado;
	private JComboBox Combo_Sevicio;
	private JLabel lb_Matricula;
	private JTextField TF_Matricula;
	private String[] datos = new String[9];

	private ArrayList<JTextField> info = new ArrayList<>();
	private JButton btnAñadirPieza;
	private JLabel lblNewLabel;
	private JLabel lbl_total;

	public JF_Añadir_Orden(JF_Ordenes_Admin frame, String ID) {			 // Para modificar o eliminar
		String fechaEntrada = "", fechaSalida = "", descripcion = "", sustitucionPieza = "", idServicio = "", idEstadoAsignacion = "", idEstadoReparacion = "", matricula = "",dniMecanico = "";
		String tabla = "orden_trabajo";
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
			dniMecanico = result.getString("dni_usuario_" + tabla.toLowerCase());
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
		info.add(TF_Id);	//0
		System.out.println(ID);
		contentPane.add(TF_Id, "2, 6, fill, default");
		
		JLabel lb_descripcion = null;
		lb_descripcion = new JLabel("Descripción");
		contentPane.add(lb_descripcion, "4, 4");
		
		TF_Descripcion = new JTextField();
		TF_Descripcion.setColumns(10);
		TF_Descripcion.setText(descripcion);
		info.add(TF_Descripcion);			//1
		contentPane.add(TF_Descripcion, "4, 6, 1, 6, fill, default");
		
		lb_Estado = new JLabel("Estado de la orden");
		contentPane.add(lb_Estado, "2, 10");
		JTextField TF_Estado = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Estado.setText(idEstadoReparacion);
		TF_Estado.setVisible(false);
		
		Combo_Estado = new JComboBox();
		Combo_Estado.setModel(new DefaultComboBoxModel(new String[] {"Sin comenzar","En diagnóstico","En reparación","Finalizada"}));
		Combo_Estado.setSelectedIndex(Integer.parseInt(idEstadoReparacion)-1);
		Combo_Estado.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Estado.setText(String.valueOf(Combo_Estado.getSelectedIndex()+1));
		    }
		});
		
		contentPane.add(Combo_Estado, "2, 12, fill, default");	
		info.add(TF_Estado);							//2
		
		JLabel lb_Piezas_Utilizadas = new JLabel("Piezas Utilizadas");
		contentPane.add(lb_Piezas_Utilizadas, "4, 14");
		
		TF_Piezas_Utilizadas = new JTextField();
		TF_Piezas_Utilizadas.setText("Pendiente");
		TF_Piezas_Utilizadas.setColumns(10);
		info.add(TF_Piezas_Utilizadas);			//3
		contentPane.add(TF_Piezas_Utilizadas, "4, 16, 1, 8, fill, default");

		JLabel lb_Fecha_Entrada = null;
		lb_Fecha_Entrada = new JLabel("Fecha entrada del vehículo");
		contentPane.add(lb_Fecha_Entrada, "2, 16");
		TF_Fecha_Entrada = new JTextField();
		TF_Fecha_Entrada.setColumns(10);
		TF_Fecha_Entrada.setText(fechaEntrada);
		info.add(TF_Fecha_Entrada);					//4
		contentPane.add(TF_Fecha_Entrada, "2, 18, fill, default");	
		
		
		JLabel lb_Fecha_Salida = null;
		lb_Fecha_Salida = new JLabel("Fecha salida del vehículo");		
		contentPane.add(lb_Fecha_Salida, "2, 22");
		TF_Fecha_Salida = new JTextField();
		TF_Fecha_Salida.setColumns(10);
		TF_Fecha_Salida.setText(fechaSalida);
		info.add(TF_Fecha_Salida);					//5
		contentPane.add(TF_Fecha_Salida, "2, 24, fill, default");		

		lb_Servicio = new JLabel("Tipo Servicio");
		contentPane.add(lb_Servicio, "2, 28");
		JTextField TF_Servicio = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Servicio.setText(idServicio);
		TF_Servicio.setVisible(false);
		
		Combo_Sevicio = new JComboBox();
		Combo_Sevicio.setModel(new DefaultComboBoxModel(new String[] {"Mecánica", "Diagnóstico", "PRE-ITV",
				"Frenos y ABS","Aceite y Filtros","Neumáticos","Revisión oficial","Matrículas","Chapa y pintura",
				"Equilibrado y alineación","Climatización","Electricidad"}));
		Combo_Sevicio.setSelectedIndex(Integer.parseInt(idServicio)-1);
		
		Combo_Sevicio.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Servicio.setText(String.valueOf(Combo_Sevicio.getSelectedIndex()+1));		    	
		    }
		});
		
		info.add(TF_Servicio);			//6
		contentPane.add(Combo_Sevicio, "2, 30, fill, default");
		

		JLabel lb_DNI_Cliente = null;
		lb_DNI_Cliente = new JLabel("DNI del mecánico");
		contentPane.add(lb_DNI_Cliente, "4, 28");
		TF_DNI_mecanico = new JTextField();
		TF_DNI_mecanico.setColumns(10);
		TF_DNI_mecanico.setText(dniMecanico);
		info.add(TF_DNI_mecanico);					//7
		contentPane.add(TF_DNI_mecanico, "4, 30, fill, default");
		
		
		lb_Matricula = new JLabel("Matrícula del vehículo");
		contentPane.add(lb_Matricula, "4, 32");
		
		TF_Matricula = new JTextField();
		TF_Matricula.setText(matricula);
		TF_Matricula.setColumns(10);
		info.add(TF_Matricula);		//8
		contentPane.add(TF_Matricula, "4, 34, fill, default");
		
		JButton Guardar = new JButton("Guardar");
		Guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // Codigo MODIFICAR Update
				boolean success = true;
				int index = 0;
				for (JTextField dato : info) {
					if (dato.getText().equals("")) {
						login.conexion.MostrarWarningPanel(contentPane, "Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
					}
					datos[index] = dato.getText();
					index++;
				}
				
				if (success) {
					//Se actualiza la tabla orden_trabajo
					login.conexion.DML("UPDATE " + tabla + " SET descripcion_orden_trabajo = '" + datos[1]
							+ "', id_estado_reparacion_orden_trabajo = '" + datos[2]
							+ "', fecha_entrada_orden_trabajo = '" + datos[4] + "', fecha_salida_orden_trabajo = '" + datos[5]
							+ "', id_servicio_orden_trabajo = '" + datos[6]+ "', dni_usuario_orden_trabajo = '" + datos[7]
							+ "', id_matricula_orden_trabajo = '" + datos[8] + "'  WHERE id_orden_trabajo = '" + datos[0] + "'");
					//Hay que atualizar tambien la tabla orden_pieza
					dispose();	
					}
			}
		});
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
	
	public JF_Añadir_Orden(JF_Ordenes_Admin frame) {			 // Para modificar o eliminar
		String fechaEntrada = "", fechaSalida = "", descripcion = "", sustitucionPieza = "", idServicio = "", idEstadoAsignacion = "", idEstadoReparacion = "", matricula = "",dniMecanico = "";
		String tabla = "orden_trabajo";
		int ID = login.conexion.consulta_Numero_Registros(
				"SELECT COUNT(*) from orden_trabajo")+1;

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
		TF_Id.setText(String.valueOf(ID));
		info.add(TF_Id);	//0
		contentPane.add(TF_Id, "2, 6, fill, default");
		
		JLabel lb_descripcion = null;
		lb_descripcion = new JLabel("Descripción");
		contentPane.add(lb_descripcion, "4, 4");
		
		TF_Descripcion = new JTextField();
		TF_Descripcion.setColumns(10);
		info.add(TF_Descripcion);			//1
		contentPane.add(TF_Descripcion, "4, 6, 1, 6, fill, default");
		
		lb_Estado = new JLabel("Estado de la orden");
		contentPane.add(lb_Estado, "2, 10");
		JTextField TF_Estado = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Estado.setVisible(false);
		
		Combo_Estado = new JComboBox();
		Combo_Estado.setModel(new DefaultComboBoxModel(new String[] {"Sin comenzar","En diagnóstico","En reparación","Finalizada"}));
		Combo_Estado.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Estado.setText(String.valueOf(Combo_Estado.getSelectedIndex()+1));
		    }
		});
		
		contentPane.add(Combo_Estado, "2, 12, fill, default");	
		info.add(TF_Estado);							//2
		
		JLabel lb_Piezas_Utilizadas = new JLabel("Piezas Utilizadas");
		contentPane.add(lb_Piezas_Utilizadas, "4, 14");
		
		TF_Piezas_Utilizadas = new JTextField();
		TF_Piezas_Utilizadas.setColumns(10);
		info.add(TF_Piezas_Utilizadas);			//3
		contentPane.add(TF_Piezas_Utilizadas, "4, 16, 1, 8, fill, default");

		JLabel lb_Fecha_Entrada = null;
		lb_Fecha_Entrada = new JLabel("Fecha entrada del vehículo");
		contentPane.add(lb_Fecha_Entrada, "2, 16");
		TF_Fecha_Entrada = new JTextField();
		TF_Fecha_Entrada.setColumns(10);
		info.add(TF_Fecha_Entrada);					//4
		contentPane.add(TF_Fecha_Entrada, "2, 18, fill, default");	
		
		
		JLabel lb_Fecha_Salida = null;
		lb_Fecha_Salida = new JLabel("Fecha salida del vehículo");		
		contentPane.add(lb_Fecha_Salida, "2, 22");
		TF_Fecha_Salida = new JTextField();
		TF_Fecha_Salida.setColumns(10);
		info.add(TF_Fecha_Salida);					//5
		contentPane.add(TF_Fecha_Salida, "2, 24, fill, default");		

		lb_Servicio = new JLabel("Tipo Servicio");
		contentPane.add(lb_Servicio, "2, 28");
		JTextField TF_Servicio = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Servicio.setVisible(false);
		
		Combo_Sevicio = new JComboBox();
		Combo_Sevicio.setModel(new DefaultComboBoxModel(new String[] {"Mecánica", "Diagnóstico", "PRE-ITV",
				"Frenos y ABS","Aceite y Filtros","Neumáticos","Revisión oficial","Matrículas","Chapa y pintura",
				"Equilibrado y alineación","Climatización","Electricidad"}));
		
		Combo_Sevicio.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Servicio.setText(String.valueOf(Combo_Sevicio.getSelectedIndex()+1));		    	
		    }
		});
		
		info.add(TF_Servicio);			//6
		contentPane.add(Combo_Sevicio, "2, 30, fill, default");
		

		JLabel lb_DNI_Cliente = null;
		lb_DNI_Cliente = new JLabel("DNI del mecánico");
		contentPane.add(lb_DNI_Cliente, "4, 28");
		TF_DNI_mecanico = new JTextField();
		TF_DNI_mecanico.setColumns(10);
		info.add(TF_DNI_mecanico);					//7
		contentPane.add(TF_DNI_mecanico, "4, 30, fill, default");
		
		
		lb_Matricula = new JLabel("Matrícula del vehículo");
		contentPane.add(lb_Matricula, "4, 32");
		
		TF_Matricula = new JTextField();
		TF_Matricula.setColumns(10);
		info.add(TF_Matricula);		//8
		contentPane.add(TF_Matricula, "4, 34, fill, default");
		
		JButton Guardar = new JButton("Guardar");
		Guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // Codigo Añadir
				boolean success = true;
				int index = 0;
				for (JTextField dato : info) {
					if (dato.getText().equals("")) {
						login.conexion.MostrarWarningPanel(contentPane, "Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
					}
					datos[index] = dato.getText();
					index++;
				}
				
				if (success) {
					//Se actualiza la tabla orden_trabajo
					login.conexion.DML("INSERT INTO derrap." + tabla + " (id_orden_trabajo, descripcion_orden_trabajo, id_estado_reparacion_orden_trabajo,"
							+ "fecha_entrada_orden_trabajo, fecha_salida_orden_trabajo, id_servicio_orden_trabajo, "
							+ "dni_usuario_orden_trabajo, id_matricula_orden_trabajo, sustitucion_pieza_orden_trabajo,id_estado_asignacion_orden_trabajo) VALUES('" + datos[0] + "', '" + datos[1]
							+ "' , '" + datos[2] + "', '" + datos[4] + "', '" + datos[5] + "', '" + datos[6]
							+ "', '" + datos[7] + "', '" + datos[8] + "', 'NO',1)");
					login.conexion.MostrarWarningPanel(frame, "Orden insertada");
					frame.dispose();
					JF_Ordenes_Admin frameAd = new JF_Ordenes_Admin();
					frameAd.setVisible(true);
					dispose();	
					}
			}
		});
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
	
	/**
	 * @wbp.parser.constructor
	 */
	public JF_Añadir_Orden(JF_ordenes frame, String ID) {			 // Para modificar o eliminar
		String fechaEntrada = "", fechaSalida = "", descripcion = "", sustitucionPieza = "", idServicio = "", idEstadoAsignacion = "", idEstadoReparacion = "", matricula = "",dniMecanico = "";
		String tabla = "orden_trabajo";
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
			dniMecanico = result.getString("dni_usuario_" + tabla.toLowerCase());
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
		info.add(TF_Id);	//0
		System.out.println(ID);
		contentPane.add(TF_Id, "2, 6, fill, default");
		
		JLabel lb_descripcion = null;
		lb_descripcion = new JLabel("Descripción");
		contentPane.add(lb_descripcion, "4, 4");
		
		TF_Descripcion = new JTextField();
		TF_Descripcion.setColumns(10);
		TF_Descripcion.setText(descripcion);
		info.add(TF_Descripcion);			//1
		contentPane.add(TF_Descripcion, "4, 6, 1, 6, fill, default");
		
		lb_Estado = new JLabel("Estado de la orden");
		contentPane.add(lb_Estado, "2, 10");
		JTextField TF_Estado = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Estado.setText(idEstadoReparacion);
		TF_Estado.setVisible(false);
		
		Combo_Estado = new JComboBox();
		Combo_Estado.setModel(new DefaultComboBoxModel(new String[] {"Sin comenzar","En diagnóstico","En reparación","Finalizada"}));
		Combo_Estado.setSelectedIndex(Integer.parseInt(idEstadoReparacion)-1);
		Combo_Estado.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Estado.setText(String.valueOf(Combo_Estado.getSelectedIndex()+1));
		    }
		});
		
		contentPane.add(Combo_Estado, "2, 12, fill, default");	
		info.add(TF_Estado);							//2
		
		JLabel lb_Piezas_Utilizadas = new JLabel("Piezas Utilizadas");
		contentPane.add(lb_Piezas_Utilizadas, "4, 14");
		
		TF_Piezas_Utilizadas = new JTextField();
		TF_Piezas_Utilizadas.setText("");
		TF_Piezas_Utilizadas.setColumns(10);
		info.add(TF_Piezas_Utilizadas);			//3
		int precio_piezas=0;
		ResultSet rs = login.conexion.consulta("SELECT * FROM orden_pieza WHERE id_orden_trabajo_orden_pieza="+ID);
		try {
			while (rs.next()) {
				String cantidad_pieza = rs.getString("cantidad_orden_pieza");
				precio_piezas += Integer.valueOf(login.conexion.consultaCampo("precio_pieza_stock", "stock", "WHERE oem_pieza_stock="+rs.getString("oem_pieza_stock_orden_pieza")))*Integer.valueOf(cantidad_pieza);
				String nombre_pieza = login.conexion.consultaCampo("nombre_pieza_stock", "stock", "WHERE oem_pieza_stock="+rs.getString("oem_pieza_stock_orden_pieza"));
				TF_Piezas_Utilizadas.setText(TF_Piezas_Utilizadas.getText()+System.lineSeparator() +nombre_pieza+" cantidad: "+cantidad_pieza);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String nombre_pieza = login.conexion.consultaCampo("nombre_pieza_stock", "stock", "WHERE oem_pieza_stock="+oem_pieza);
		//String cantidad_pieza = login.conexion.consultaCampo("cantidad_orden_pieza", "derrap.orden_pieza", "WHERE id_orden_trabajo_orden_pieza="+ID);
		
		contentPane.add(TF_Piezas_Utilizadas, "4, 16, 1, 8, fill, default");

		JLabel lb_Fecha_Entrada = null;
		lb_Fecha_Entrada = new JLabel("Fecha entrada del vehículo");
		contentPane.add(lb_Fecha_Entrada, "2, 16");
		TF_Fecha_Entrada = new JTextField();
		TF_Fecha_Entrada.setColumns(10);
		TF_Fecha_Entrada.setText(fechaEntrada);
		info.add(TF_Fecha_Entrada);					//4
		contentPane.add(TF_Fecha_Entrada, "2, 18, fill, default");	
		
		
		JLabel lb_Fecha_Salida = null;
		lb_Fecha_Salida = new JLabel("Fecha salida del vehículo");		
		contentPane.add(lb_Fecha_Salida, "2, 22");
		TF_Fecha_Salida = new JTextField();
		TF_Fecha_Salida.setColumns(10);
		TF_Fecha_Salida.setText(fechaSalida);
		info.add(TF_Fecha_Salida);					//5
		contentPane.add(TF_Fecha_Salida, "2, 24, fill, default");		
		
		btnAñadirPieza = new JButton("Añadir pieza");
		btnAñadirPieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JF_Stock_Mecanico jf_stock_mecanico = new JF_Stock_Mecanico(ID);
				jf_stock_mecanico.setVisible(true);
			}
		});
		contentPane.add(btnAñadirPieza, "4, 24");

		lb_Servicio = new JLabel("Tipo Servicio");
		contentPane.add(lb_Servicio, "2, 30");
		JTextField TF_Servicio = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Servicio.setText(idServicio);
		TF_Servicio.setVisible(false);
		
		Combo_Sevicio = new JComboBox();
		Combo_Sevicio.setModel(new DefaultComboBoxModel(new String[] {"Mecánica", "Diagnóstico", "PRE-ITV",
				"Frenos y ABS","Aceite y Filtros","Neumáticos","Revisión oficial","Matrículas","Chapa y pintura",
				"Equilibrado y alineación","Climatización","Electricidad"}));
		Combo_Sevicio.setSelectedIndex(Integer.parseInt(idServicio)-1);
		
		Combo_Sevicio.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Servicio.setText(String.valueOf(Combo_Sevicio.getSelectedIndex()+1));		    	
		    }
		});
		
		info.add(TF_Servicio);			//6
		contentPane.add(Combo_Sevicio, "2, 32, fill, default");
		

		JLabel lb_DNI_Cliente = null;
		lb_DNI_Cliente = new JLabel("DNI del mecánico");
		contentPane.add(lb_DNI_Cliente, "4, 30");
		TF_DNI_mecanico = new JTextField();
		TF_DNI_mecanico.setColumns(10);
		TF_DNI_mecanico.setText(dniMecanico);
		info.add(TF_DNI_mecanico);					//7
		contentPane.add(TF_DNI_mecanico, "4, 32, fill, default");
		
		
		lb_Matricula = new JLabel("Matrícula del vehículo");
		contentPane.add(lb_Matricula, "4, 34");
		
		lblNewLabel = new JLabel("Total:");
		contentPane.add(lblNewLabel, "2, 36");
		
		TF_Matricula = new JTextField();
		TF_Matricula.setText(matricula);
		TF_Matricula.setColumns(10);
		info.add(TF_Matricula);		//8
		contentPane.add(TF_Matricula, "4, 36, fill, default");
		
		JButton Guardar = new JButton("Guardar");
		Guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // Codigo MODIFICAR Update
				boolean success = true;
				int index = 0;
				for (JTextField dato : info) {
					if (dato.getText().equals("")) {
						login.conexion.MostrarWarningPanel(contentPane, "Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
					}
					datos[index] = dato.getText();
					index++;
				}
				
				if (success) {
					//Se actualiza la tabla orden_trabajo
					login.conexion.DML("UPDATE " + tabla + " SET descripcion_orden_trabajo = '" + datos[1]
							+ "', id_estado_reparacion_orden_trabajo = '" + datos[2]
							+ "', fecha_entrada_orden_trabajo = '" + datos[4] + "', fecha_salida_orden_trabajo = '" + datos[5]
							+ "', id_servicio_orden_trabajo = '" + datos[6]+ "', dni_usuario_orden_trabajo = '" + datos[7]
							+ "', id_matricula_orden_trabajo = '" + datos[8] + "'  WHERE id_orden_trabajo = '" + datos[0] + "'");
					//Hay que atualizar tambien la tabla orden_pieza
					dispose();	
					}
			}
		});
		
		lbl_total = new JLabel("");
		contentPane.add(lbl_total, "2, 38");
		int precio_servicio = Integer.parseInt(login.conexion.consultaCampo("precio_servicio", "servicio", "WHERE nombre_servicio='"+Combo_Sevicio.getSelectedItem()+"';"));
		int total=precio_piezas+precio_servicio;
		lbl_total.setText(String.valueOf(total));
		contentPane.add(Guardar, "4, 40");
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(Cancelar, "4, 42");
	}
	
	public JF_Añadir_Orden(JF_ordenes frame) {			 // Para modificar o eliminar
		String fechaEntrada = "", fechaSalida = "", descripcion = "", sustitucionPieza = "", idServicio = "", idEstadoAsignacion = "", idEstadoReparacion = "", matricula = "",dniMecanico = "";
		String tabla = "orden_trabajo";
		int ID = login.conexion.consulta_Numero_Registros(
				"SELECT COUNT(*) from orden_trabajo")+1;

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
		TF_Id.setText(String.valueOf(ID));
		info.add(TF_Id);	//0
		contentPane.add(TF_Id, "2, 6, fill, default");
		
		JLabel lb_descripcion = null;
		lb_descripcion = new JLabel("Descripción");
		contentPane.add(lb_descripcion, "4, 4");
		
		TF_Descripcion = new JTextField();
		TF_Descripcion.setColumns(10);
		info.add(TF_Descripcion);			//1
		contentPane.add(TF_Descripcion, "4, 6, 1, 6, fill, default");
		
		lb_Estado = new JLabel("Estado de la orden");
		contentPane.add(lb_Estado, "2, 10");
		JTextField TF_Estado = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Estado.setVisible(false);
		
		Combo_Estado = new JComboBox();
		Combo_Estado.setModel(new DefaultComboBoxModel(new String[] {"Sin comenzar","En diagnóstico","En reparación","Finalizada"}));
		Combo_Estado.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Estado.setText(String.valueOf(Combo_Estado.getSelectedIndex()+1));
		    }
		});
		
		contentPane.add(Combo_Estado, "2, 12, fill, default");	
		info.add(TF_Estado);							//2
		
		JLabel lb_Piezas_Utilizadas = new JLabel("Piezas Utilizadas");
		contentPane.add(lb_Piezas_Utilizadas, "4, 14");
		
		TF_Piezas_Utilizadas = new JTextField();
		TF_Piezas_Utilizadas.setColumns(10);
		info.add(TF_Piezas_Utilizadas);			//3
		contentPane.add(TF_Piezas_Utilizadas, "4, 16, 1, 8, fill, default");

		JLabel lb_Fecha_Entrada = null;
		lb_Fecha_Entrada = new JLabel("Fecha entrada del vehículo");
		contentPane.add(lb_Fecha_Entrada, "2, 16");
		TF_Fecha_Entrada = new JTextField();
		TF_Fecha_Entrada.setColumns(10);
		info.add(TF_Fecha_Entrada);					//4
		contentPane.add(TF_Fecha_Entrada, "2, 18, fill, default");	
		
		
		JLabel lb_Fecha_Salida = null;
		lb_Fecha_Salida = new JLabel("Fecha salida del vehículo");		
		contentPane.add(lb_Fecha_Salida, "2, 22");
		TF_Fecha_Salida = new JTextField();
		TF_Fecha_Salida.setColumns(10);
		info.add(TF_Fecha_Salida);					//5
		contentPane.add(TF_Fecha_Salida, "2, 24, fill, default");		

		lb_Servicio = new JLabel("Tipo Servicio");
		contentPane.add(lb_Servicio, "2, 28");
		JTextField TF_Servicio = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Servicio.setVisible(false);
		
		Combo_Sevicio = new JComboBox();
		Combo_Sevicio.setModel(new DefaultComboBoxModel(new String[] {"Mecánica", "Diagnóstico", "PRE-ITV",
				"Frenos y ABS","Aceite y Filtros","Neumáticos","Revisión oficial","Matrículas","Chapa y pintura",
				"Equilibrado y alineación","Climatización","Electricidad"}));
		
		Combo_Sevicio.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Servicio.setText(String.valueOf(Combo_Sevicio.getSelectedIndex()+1));		    	
		    }
		});
		
		info.add(TF_Servicio);			//6
		contentPane.add(Combo_Sevicio, "2, 30, fill, default");
		

		JLabel lb_DNI_Cliente = null;
		lb_DNI_Cliente = new JLabel("DNI del mecánico");
		contentPane.add(lb_DNI_Cliente, "4, 28");
		TF_DNI_mecanico = new JTextField();
		TF_DNI_mecanico.setColumns(10);
		info.add(TF_DNI_mecanico);					//7
		contentPane.add(TF_DNI_mecanico, "4, 30, fill, default");
		
		
		lb_Matricula = new JLabel("Matrícula del vehículo");
		contentPane.add(lb_Matricula, "4, 32");
		
		TF_Matricula = new JTextField();
		TF_Matricula.setColumns(10);
		info.add(TF_Matricula);		//8
		contentPane.add(TF_Matricula, "4, 34, fill, default");
		
		JButton Guardar = new JButton("Guardar");
		Guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // Codigo Añadir
				boolean success = true;
				int index = 0;
				for (JTextField dato : info) {
					if (dato.getText().equals("")) {
						login.conexion.MostrarWarningPanel(contentPane, "Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
					}
					datos[index] = dato.getText();
					index++;
				}
				
				if (success) {
					//Se actualiza la tabla orden_trabajo
					login.conexion.DML("INSERT INTO derrap." + tabla + " (id_orden_trabajo, descripcion_orden_trabajo, id_estado_reparacion_orden_trabajo,"
							+ "fecha_entrada_orden_trabajo, fecha_salida_orden_trabajo, id_servicio_orden_trabajo, "
							+ "dni_usuario_orden_trabajo, id_matricula_orden_trabajo, sustitucion_pieza_orden_trabajo,id_estado_asignacion_orden_trabajo) VALUES('" + datos[0] + "', '" + datos[1]
							+ "' , '" + datos[2] + "', '" + datos[4] + "', '" + datos[5] + "', '" + datos[6]
							+ "', '" + datos[7] + "', '" + datos[8] + "', 'NO',1)");
					login.conexion.MostrarWarningPanel(frame, "Orden insertada");
					frame.dispose();
					JF_Ordenes_Admin frameAd = new JF_Ordenes_Admin();
					frameAd.setVisible(true);
					dispose();	
					}
			}
		});
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
	
	public JF_Añadir_Orden(JF_home_mecanico frame, String ID) {			 // Para modificar o eliminar
		String fechaEntrada = "", fechaSalida = "", descripcion = "", sustitucionPieza = "", idServicio = "", idEstadoAsignacion = "", idEstadoReparacion = "", matricula = "",dniMecanico = "";
		String tabla = "orden_trabajo";
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
			dniMecanico = result.getString("dni_usuario_" + tabla.toLowerCase());
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
		info.add(TF_Id);	//0
		System.out.println(ID);
		contentPane.add(TF_Id, "2, 6, fill, default");
		
		JLabel lb_descripcion = null;
		lb_descripcion = new JLabel("Descripción");
		contentPane.add(lb_descripcion, "4, 4");
		
		TF_Descripcion = new JTextField();
		TF_Descripcion.setColumns(10);
		TF_Descripcion.setText(descripcion);
		info.add(TF_Descripcion);			//1
		contentPane.add(TF_Descripcion, "4, 6, 1, 6, fill, default");
		
		lb_Estado = new JLabel("Estado de la orden");
		contentPane.add(lb_Estado, "2, 10");
		JTextField TF_Estado = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Estado.setText(idEstadoReparacion);
		TF_Estado.setVisible(false);
		
		Combo_Estado = new JComboBox();
		Combo_Estado.setModel(new DefaultComboBoxModel(new String[] {"Sin comenzar","En diagnóstico","En reparación","Finalizada"}));
		Combo_Estado.setSelectedIndex(Integer.parseInt(idEstadoReparacion)-1);
		Combo_Estado.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Estado.setText(String.valueOf(Combo_Estado.getSelectedIndex()+1));
		    }
		});
		
		contentPane.add(Combo_Estado, "2, 12, fill, default");	
		info.add(TF_Estado);							//2
		
		JLabel lb_Piezas_Utilizadas = new JLabel("Piezas Utilizadas");
		contentPane.add(lb_Piezas_Utilizadas, "4, 14");
		
		TF_Piezas_Utilizadas = new JTextField();
		TF_Piezas_Utilizadas.setText("");
		TF_Piezas_Utilizadas.setColumns(10);
		info.add(TF_Piezas_Utilizadas);			//3
		int precio_piezas=0;
		ResultSet rs = login.conexion.consulta("SELECT * FROM orden_pieza WHERE id_orden_trabajo_orden_pieza="+ID);
		try {
			while (rs.next()) {
				String cantidad_pieza = rs.getString("cantidad_orden_pieza");
				precio_piezas += Integer.valueOf(login.conexion.consultaCampo("precio_pieza_stock", "stock", "WHERE oem_pieza_stock="+rs.getString("oem_pieza_stock_orden_pieza")))*Integer.valueOf(cantidad_pieza);
				String nombre_pieza = login.conexion.consultaCampo("nombre_pieza_stock", "stock", "WHERE oem_pieza_stock="+rs.getString("oem_pieza_stock_orden_pieza"));
				TF_Piezas_Utilizadas.setText(TF_Piezas_Utilizadas.getText()+System.lineSeparator() +nombre_pieza+" cantidad: "+cantidad_pieza);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String nombre_pieza = login.conexion.consultaCampo("nombre_pieza_stock", "stock", "WHERE oem_pieza_stock="+oem_pieza);
		//String cantidad_pieza = login.conexion.consultaCampo("cantidad_orden_pieza", "derrap.orden_pieza", "WHERE id_orden_trabajo_orden_pieza="+ID);
		
		contentPane.add(TF_Piezas_Utilizadas, "4, 16, 1, 8, fill, default");

		JLabel lb_Fecha_Entrada = null;
		lb_Fecha_Entrada = new JLabel("Fecha entrada del vehículo");
		contentPane.add(lb_Fecha_Entrada, "2, 16");
		TF_Fecha_Entrada = new JTextField();
		TF_Fecha_Entrada.setColumns(10);
		TF_Fecha_Entrada.setText(fechaEntrada);
		info.add(TF_Fecha_Entrada);					//4
		contentPane.add(TF_Fecha_Entrada, "2, 18, fill, default");	
		
		
		JLabel lb_Fecha_Salida = null;
		lb_Fecha_Salida = new JLabel("Fecha salida del vehículo");		
		contentPane.add(lb_Fecha_Salida, "2, 22");
		TF_Fecha_Salida = new JTextField();
		TF_Fecha_Salida.setColumns(10);
		TF_Fecha_Salida.setText(fechaSalida);
		info.add(TF_Fecha_Salida);					//5
		contentPane.add(TF_Fecha_Salida, "2, 24, fill, default");		
		
		btnAñadirPieza = new JButton("Añadir pieza");
		btnAñadirPieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JF_Stock_Mecanico jf_stock_mecanico = new JF_Stock_Mecanico(ID);
				jf_stock_mecanico.setVisible(true);
			}
		});
		contentPane.add(btnAñadirPieza, "4, 24");

		lb_Servicio = new JLabel("Tipo Servicio");
		contentPane.add(lb_Servicio, "2, 30");
		JTextField TF_Servicio = new JTextField();
		//Voy a hacer un TexField invisible para que cambiar la lógica de info.
		TF_Servicio.setText(idServicio);
		TF_Servicio.setVisible(false);
		
		Combo_Sevicio = new JComboBox();
		Combo_Sevicio.setModel(new DefaultComboBoxModel(new String[] {"Mecánica", "Diagnóstico", "PRE-ITV",
				"Frenos y ABS","Aceite y Filtros","Neumáticos","Revisión oficial","Matrículas","Chapa y pintura",
				"Equilibrado y alineación","Climatización","Electricidad"}));
		Combo_Sevicio.setSelectedIndex(Integer.parseInt(idServicio)-1);
		
		Combo_Sevicio.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	TF_Servicio.setText(String.valueOf(Combo_Sevicio.getSelectedIndex()+1));		    	
		    }
		});
		
		info.add(TF_Servicio);			//6
		contentPane.add(Combo_Sevicio, "2, 32, fill, default");
		

		JLabel lb_DNI_Cliente = null;
		lb_DNI_Cliente = new JLabel("DNI del mecánico");
		contentPane.add(lb_DNI_Cliente, "4, 30");
		TF_DNI_mecanico = new JTextField();
		TF_DNI_mecanico.setColumns(10);
		TF_DNI_mecanico.setText(dniMecanico);
		info.add(TF_DNI_mecanico);					//7
		contentPane.add(TF_DNI_mecanico, "4, 32, fill, default");
		
		
		lb_Matricula = new JLabel("Matrícula del vehículo");
		contentPane.add(lb_Matricula, "4, 34");
		
		lblNewLabel = new JLabel("Total:");
		contentPane.add(lblNewLabel, "2, 36");
		
		TF_Matricula = new JTextField();
		TF_Matricula.setText(matricula);
		TF_Matricula.setColumns(10);
		info.add(TF_Matricula);		//8
		contentPane.add(TF_Matricula, "4, 36, fill, default");
		
		JButton Guardar = new JButton("Guardar");
		Guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // Codigo MODIFICAR Update
				boolean success = true;
				int index = 0;
				for (JTextField dato : info) {
					if (dato.getText().equals("")) {
						login.conexion.MostrarWarningPanel(contentPane, "Se necesita insertar todos los datos para poder realizar la operación");
						success = false;
					}
					datos[index] = dato.getText();
					index++;
				}
				
				if (success) {
					//Se actualiza la tabla orden_trabajo
					login.conexion.DML("UPDATE " + tabla + " SET descripcion_orden_trabajo = '" + datos[1]
							+ "', id_estado_reparacion_orden_trabajo = '" + datos[2]
							+ "', fecha_entrada_orden_trabajo = '" + datos[4] + "', fecha_salida_orden_trabajo = '" + datos[5]
							+ "', id_servicio_orden_trabajo = '" + datos[6]+ "', dni_usuario_orden_trabajo = '" + datos[7]
							+ "', id_matricula_orden_trabajo = '" + datos[8] + "'  WHERE id_orden_trabajo = '" + datos[0] + "'");
					//Hay que atualizar tambien la tabla orden_pieza
					dispose();	
					}
			}
		});
		
		lbl_total = new JLabel("");
		contentPane.add(lbl_total, "2, 38");
		int precio_servicio = Integer.parseInt(login.conexion.consultaCampo("precio_servicio", "servicio", "WHERE nombre_servicio='"+Combo_Sevicio.getSelectedItem()+"';"));
		int total=precio_piezas+precio_servicio;
		lbl_total.setText(String.valueOf(total));
		contentPane.add(Guardar, "4, 40");
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(Cancelar, "4, 42");
	}

}
