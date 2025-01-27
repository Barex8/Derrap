package derrap;

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

public class JF_Cliente_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	public static JF_Cliente_Admin selfFrame;

	private static JF_Cliente_Admin frame;

	/**
	 * Create the frame.
	 */
	public JF_Cliente_Admin() {
		selfFrame = this;
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px:grow"),
						ColumnSpec.decode("100px"), ColumnSpec.decode("100px"), ColumnSpec.decode("100px"),
						ColumnSpec.decode("100px"), ColumnSpec.decode("100px"), ColumnSpec.decode("100px"),
						ColumnSpec.decode("100px"), },
				new RowSpec[] { FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("40px"), RowSpec.decode("40px"),
						RowSpec.decode("311px:grow"), RowSpec.decode("200px"), }));

		JLabel JLabel_Titulo = new JLabel("Clientes");
		JLabel_Titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(JLabel_Titulo, "2, 2");
		
		JButton Btn_AñadirCliente = new JButton("Añadir"); // Boton de añadir clientes

		Btn_AñadirCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JF_Añadir_Cliente frame_añadir_clientes = new JF_Añadir_Cliente(selfFrame);
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

		ActualizarTabla();
		scrollPane.setViewportView(table);

	}

	public void ActualizarTabla() {
		String tabla = "cliente";
		int numUsers = 0;
		ResultSet consulta = null;
		// Pone los clientes, usuarios o vehiculos en la tabla (no admins)
		numUsers = login.conexion.consulta_Numero_Registros("SELECT Count(*) FROM derrap." + tabla + "");
		consulta = login.conexion.consulta("SELECT * FROM " + tabla + "");
		Object[][] clientes = new Object[0][0];

		int row = 0; // Para que se inserte en cada fila
		try {
			
			clientes = new Object[numUsers][5]; // Numero de campos, los clientes no muestran el mismo número de
												// campos que los usuarios o vehículos
			while (consulta.next()) {
				clientes[row][0] = consulta.getString("nombre_cliente") + " "
						+ consulta.getString("primer_apellido_cliente") + " "
						+ consulta.getString("segundo_apellido_cliente");// nombre con apellidos
				clientes[row][1] = consulta.getString("dni_cliente");
				clientes[row][2] = consulta.getString("correo_electronico_cliente");
				clientes[row][3] = consulta.getString("telefono_cliente");
				row++;
			}

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		table.setModel(new DefaultTableModel(clientes, new String[] { "Nombre", "DNI", "Correo", "Telefono", "Editar" }));
		
		table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
		table.getColumn("Editar").setCellEditor(new ButtonEditor(table));

	}
	// Clase para renderizar el botón

	public static class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText((value == null) ? "Editor" : value.toString());
			return this;
		}
	}

	public static class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
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
			value = table.getValueAt(selectedRow, 1);

			System.out.println(value.toString());
			JF_Añadir_Cliente frame_añadir_clientes = new JF_Añadir_Cliente(selfFrame, value.toString());
			frame_añadir_clientes.setVisible(true);
			clicked = false;
			fireEditingStopped();

		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
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
