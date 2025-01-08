import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.AbstractCellEditor;
import javax.swing.AbstractListModel;
import java.awt.BorderLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.util.EventObject;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ItemListener;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			public void itemStateChanged(ItemEvent e) {
			System.out.println(CB_TipoUsuario.getSelectedItem().toString()+" ComboBox ha sido cambiado");
			tipoUsuario = CB_TipoUsuario.getSelectedItem().toString();
				ActualizarTabla(CB_TipoUsuario.getSelectedItem().toString());
			}
		});
		CB_TipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Proveedor", "Usuario"}));
		contentPane.add(CB_TipoUsuario, "5, 3, 2, 1, fill, default");
		tipoUsuario = "Cliente";
		
JButton Btn_AñadirCliente = new JButton("Añadir");		//Boton de añadir clientes
		
		Btn_AñadirCliente.addActionListener(new ActionListener() {
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
		if(tabla.equals("Usuario")) {
			numUsers = login.conexion.consulta_Numero_Registros("SELECT Count(*) FROM derrap."+tabla+" Where id_rol_usuario = 2");
			consulta = login.conexion.consulta("SELECT * FROM "+tabla+" Where id_rol_usuario = 2");
		}
		else {
			numUsers = login.conexion.consulta_Numero_Registros("SELECT Count(*) FROM derrap."+tabla+"");
			consulta = login.conexion.consulta("SELECT * FROM "+tabla+"");
		}
		Object[][] clientes = new Object[numUsers][5];
		
		
		int row = 0; //Para que se inserte en cada fila
		try {
			if(tabla.equals("Cliente")) {
				while(consulta.next()) {
					clientes[row][0]= consulta.getString("nombre_cliente")+" "+consulta.getString("primer_apellido_cliente")+" "+consulta.getString("segundo_apellido_cliente");//nombre con apellidos
					clientes[row][1] = consulta.getString("dni_cliente");
					clientes[row][2] = consulta.getString("correo_electronico_cliente");
					clientes[row][3] = consulta.getString("telefono_cliente");
					row++;					
				}
			}
			if(tabla.equals("Usuario")) {
				System.out.println("Ha llegado a empezar a leer usuarios");
				while(consulta.next()) {
					clientes[row][0]= consulta.getString("nombre_usuario");//nombre con apellidos
					clientes[row][1] = consulta.getString("dni_usuario");
					clientes[row][2] = consulta.getString("correo_electronico_usuario");
					clientes[row][3] = consulta.getString("telefono_usuario");
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
					clientes, //Al pasarle clientes automáticamente guarda los datos en la tabla
					new String[] {
						"Nombre", "DNI", "Correo", "Telefono", "Editar"
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
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,		//mi idea de que hace esto
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
			Object value = table.getValueAt(selectedRow, 1);
			System.out.println(value.toString());
			
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
	



