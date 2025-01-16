import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class Clientes_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	public static Clientes_Admin selfFrame;

	private static Clientes_Admin frame;

	private JComboBox CB_TipoUsuario;

	public static String tipoUsuario = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					frame = new Clientes_Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Clientes_Admin() {
		selfFrame = this;
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//ActualizarTabla("Clientes");

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("100px:grow"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("40px"),
				RowSpec.decode("40px"),
				RowSpec.decode("311px:grow"),
				RowSpec.decode("200px"),}));

		JLabel JLabel_Titulo = new JLabel("Clientes");
		JLabel_Titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(JLabel_Titulo, "2, 2");

		CB_TipoUsuario = new JComboBox();
		CB_TipoUsuario.addItemListener(new ItemListener() {		//Cuando cambia el comboBox
			@Override
			public void itemStateChanged(ItemEvent e) {
			System.out.println(CB_TipoUsuario.getSelectedItem().toString()+" ComboBox ha sido cambiado");
			tipoUsuario = CB_TipoUsuario.getSelectedItem().toString();
				ActualizarTabla(CB_TipoUsuario.getSelectedItem().toString());
			}
		});
		CB_TipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Vehiculo", "Usuario"}));
		contentPane.add(CB_TipoUsuario, "5, 3, 2, 1, fill, default");
		tipoUsuario = "Cliente"; //por defecto

		JButton Btn_AñadirCliente = new JButton("Añadir");		//Boton de añadir clientes

		Btn_AñadirCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JF_AñadirCliente frame_añadir_clientes = new JF_AñadirCliente(selfFrame,tipoUsuario);
				frame_añadir_clientes.setVisible(true);
			}
		});
		contentPane.add(Btn_AñadirCliente, "2, 3");


		textField = new JTextField();
		contentPane.add(textField, "8, 3, 2, 1, fill, default");
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "2, 4, 6, 2, fill, fill");

		table = new JTable();

		ActualizarTabla(tipoUsuario);
		scrollPane.setViewportView(table);

	}

	public void ActualizarTabla(String tabla) {
		System.out.println(tabla);
		int numUsers = 0;
		ResultSet consulta = null;
		//Pone los clientes, usuarios o vehiculos en la tabla (no admins)
		if(tabla.equals("Usuario")) {
			numUsers = login.conexion.consulta_Numero_Registros("SELECT Count(*) FROM derrap."+tabla+" Where id_rol_usuario = 2");
			consulta = login.conexion.consulta("SELECT * FROM "+tabla+" Where id_rol_usuario = 2");
		}
		else {
			numUsers = login.conexion.consulta_Numero_Registros("SELECT Count(*) FROM derrap."+tabla+"");
			consulta = login.conexion.consulta("SELECT * FROM "+tabla+"");
		}
		Object[][] clientes = new Object[0][0];


		int row = 0; //Para que se inserte en cada fila
		try {
			if(tabla.equals("Cliente")) {
				clientes = new Object[numUsers][5]; //Numero de campos, los clientes no muestran el mismo número de campos que los usuarios o vehículos
				while(consulta.next()) {
					clientes[row][0]= consulta.getString("nombre_cliente")+" "+consulta.getString("primer_apellido_cliente")+" "+consulta.getString("segundo_apellido_cliente");//nombre con apellidos
					clientes[row][1] = consulta.getString("dni_cliente");
					clientes[row][2] = consulta.getString("correo_electronico_cliente");
					clientes[row][3] = consulta.getString("telefono_cliente");
					row++;
				}
			}
			if(tabla.equals("Usuario")) {
				clientes = new Object[numUsers][7];
				while(consulta.next()) {
					clientes[row][0]= consulta.getString("nombre_usuario");//nombre con apellidos
					clientes[row][1] = consulta.getString("dni_usuario");
					clientes[row][2] = consulta.getString("correo_electronico_usuario");
					clientes[row][3] = consulta.getString("telefono_usuario");
					clientes[row][4] = consulta.getString("especialidad_usuario");
					clientes[row][5] = consulta.getString("estado_alta_usuario");

					row++;
				}
			}
			if(tabla.equals("Vehiculo")) {
				clientes = new Object[numUsers][6];
				while(consulta.next()) {
					clientes[row][0]= consulta.getString("matricula_vehiculo");//nombre con apellidos
					clientes[row][1] = consulta.getString("marca_vehiculo");
					clientes[row][2] = consulta.getString("modelo_vehiculo");
					clientes[row][3] = consulta.getString("año_vehiculo");
					clientes[row][4] = consulta.getString("color_vehiculo");
					clientes[row][5] = consulta.getString("dni_cliente_vehiculo");
					row++;
				}
			}

		}catch(Exception e) {  System.out.println(e.getLocalizedMessage());}


		if(tabla.equals("Cliente")) {
			table.setModel(new DefaultTableModel(
				clientes, //Al pasarle clientes automáticamente guarda los datos en la tabla
				new String[] {
					"Nombre", "DNI", "Correo", "Telefono", "Editar"
				}
			));
		}else if(tabla.equals("Usuario")) {
			table.setModel(new DefaultTableModel(
					clientes,
					new String[] {
						"Nombre", "DNI", "Correo", "Telefono", "Especialidad","Estado","Editar"
					}
				));
		}else if(tabla.equals("Vehiculo")) {
			table.setModel(new DefaultTableModel(
					clientes,
					new String[] {
						"Matricula", "Marca", "Modelo", "Año", "Color","DNI Cliente","Editar"
					}
				));
		}

		table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
		table.getColumn("Editar").setCellEditor(new ButtonEditor(table));

	}
	//Clase para renderizar el botón

	public static class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,		//ni idea de que hace esto
				int row, int column) {
			setText((value == null) ? "Editor": value.toString());
			return this;
		}
	}

	public static class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener{
		private JButton button;
		private String label;
		private boolean clicked;
		private int selectedRow;
		private JTable table;

		public ButtonEditor(JTable table) {
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(this);
			this.table = table;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object value = null;
			if(!tipoUsuario.equals("Vehiculo")) {
				value = table.getValueAt(selectedRow, 1);
			}else {
				value = table.getValueAt(selectedRow, 0);
			}
			
			System.out.println(value.toString());

			System.out.println(tipoUsuario);
			JF_AñadirCliente frame_añadir_clientes = new JF_AñadirCliente(selfFrame,value.toString(),tipoUsuario);
			frame_añadir_clientes.setVisible(true);
			clicked = false;
			fireEditingStopped();


		}
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			label = (value == null) ? "Editor" : value.toString();
			button.setText(label);
			clicked = true;
			selectedRow = row;
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

	}

}




