package derrap;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class JF_Stock_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private Color azulPrincipal = Color.decode("#96C2CD");
	private Color azulCancelar = Color.decode("#5C94A2");
	private Color azulSecundario = Color.decode("#DEF2F7");

	public static JF_Stock_Admin selfFrame;

	private static JF_Stock_Admin frame;

	public JF_Stock_Admin() {
		selfFrame = this;
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// ActualizarTabla("Clientes");

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px:grow"),
						ColumnSpec.decode("100px"), ColumnSpec.decode("100px"), ColumnSpec.decode("100px"),
						ColumnSpec.decode("100px"), ColumnSpec.decode("100px"), ColumnSpec.decode("100px"),
						ColumnSpec.decode("100px"), },
				new RowSpec[] { FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("40px"), RowSpec.decode("40px"),
						RowSpec.decode("311px:grow"), RowSpec.decode("200px"), }));

		JLabel JLabel_Titulo = new JLabel("Stock");
		JLabel_Titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(JLabel_Titulo, "2, 2");
		
		JLabel lbl_añadir = new JLabel("Añadir");
		lbl_añadir.setOpaque(true);
		lbl_añadir.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_añadir.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_añadir.setBackground(azulSecundario);
		lbl_añadir.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_añadir.setBounds(160, 189, 78, 28);
		contentPane.add(lbl_añadir, "2, 3");

		lbl_añadir.addMouseListener(new MouseAdapter() {
			// cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_añadir.setBackground(azulCancelar);
			}

			// cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_añadir.setBackground(azulSecundario);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

		});

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
		int numUsers = 0;
		ResultSet consulta = null;
		// Pone los clientes, usuarios o vehiculos en la tabla (no admins)

		numUsers = login.conexion.consulta_Numero_Registros("SELECT Count(*) FROM derrap.stock");
		consulta = login.conexion.consulta("SELECT * FROM derrap.stock");

		Object[][] stock = new Object[0][0];

		int row = 0; // Para que se inserte en cada fila

		stock = new Object[numUsers][6];
		try {
			while (consulta.next()) {
				stock[row][0] = consulta.getString("oem_pieza_stock");
				stock[row][1] = consulta.getString("nombre_pieza_stock");
				stock[row][2] = consulta.getString("marca_pieza_stock");
				stock[row][3] = consulta.getString("cantidad_pieza_stock");
				stock[row][4] = consulta.getString("precio_pieza_stock");
				stock[row][5] = consulta.getString("estado_pieza_stock");
				row++;
			}
		} catch (Exception e) {
		}

		table.setModel(new DefaultTableModel(stock,
				new String[] { "Código OEM", "Nombre", "Marca", "Cantidad", "Precio", "Estado", "Editar precio" }));

		table.getColumn("Editar precio").setCellRenderer(new ButtonRenderer());
		table.getColumn("Editar precio").setCellEditor(new ButtonEditor(table));

	}
	// Clase para renderizar el botón

	public static class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, // ni
																															// idea
																															// de
																															// que
																															// hace
																															// esto
				int row, int column) {
			setText((value == null) ? "Editar" : value.toString());
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
			Object value = table.getValueAt(selectedRow, 0);

	/*		JF_Añadir_Vehiculo frame_añadir_vehiculo = new JF_Añadir_Vehiculo(selfFrame, value.toString(), "vehiculo");
			frame_añadir_vehiculo.setVisible(true);
			clicked = false;
			fireEditingStopped();
*/
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			label = (value == null) ? "Editar" : value.toString();
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
