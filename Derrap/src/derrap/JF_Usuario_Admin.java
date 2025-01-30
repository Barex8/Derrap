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

public class JF_Usuario_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private Color azulPrincipal = Color.decode("#96C2CD");
	private Color azulCancelar = Color.decode("#5C94A2");
	private Color azulSecundario = Color.decode("#DEF2F7");

	public static JF_Usuario_Admin selfFrame;

	private static JF_Usuario_Admin frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					frame = new JF_Usuario_Admin();
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
	public JF_Usuario_Admin() {
		selfFrame = this;
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(azulSecundario);

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("50dlu"),
				ColumnSpec.decode("100px:grow"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("100px"),},
			new RowSpec[] {
				RowSpec.decode("25px"),
				RowSpec.decode("40px"),
				RowSpec.decode("40px"),
				RowSpec.decode("40px"),
				RowSpec.decode("311px:grow"),
				RowSpec.decode("3px"),}));
		
		JLabel lbl_Volver = new JLabel("Volver");
		lbl_Volver.setOpaque(true);
		lbl_Volver.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Volver.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_Volver.setBackground(azulSecundario);
		lbl_Volver.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Volver.setBounds(453, 11, 212, 23);
		contentPane.add(lbl_Volver, "2, 1");
		
				lbl_Volver.addMouseListener(new MouseAdapter() {
					// cambia el color cuando el ratón se coloca encima de entrar
					@Override
					public void mouseEntered(MouseEvent e) {
						lbl_Volver.setBackground(azulCancelar);
					}
		
					// cambia el color cuando el ratón se quita de encima de entrar
					@Override
					public void mouseExited(MouseEvent e) {
						lbl_Volver.setBackground(azulSecundario);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						JF_home_admin frame_home_admin = new JF_home_admin();
						frame_home_admin.setVisible(true);
						dispose();
					}
		
				});

		JLabel JLabel_Titulo = new JLabel("Usuario");
		JLabel_Titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(JLabel_Titulo, "2, 2, 2, 1");

		JLabel lbl_AñadirUsuario = new JLabel("Añadir usuario");
		lbl_AñadirUsuario.setOpaque(true);
		lbl_AñadirUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AñadirUsuario.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_AñadirUsuario.setBackground(azulSecundario);
		lbl_AñadirUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_AñadirUsuario.setBounds(453, 11, 212, 23);
		contentPane.add(lbl_AñadirUsuario, "2, 3, 2, 1");
		
			lbl_AñadirUsuario.addMouseListener(new MouseAdapter() {
					// cambia el color cuando el ratón se coloca encima de entrar
					@Override
					public void mouseEntered(MouseEvent e) {
						lbl_AñadirUsuario.setBackground(azulCancelar);
					}
		
					// cambia el color cuando el ratón se quita de encima de entrar
					@Override
					public void mouseExited(MouseEvent e) {
						lbl_AñadirUsuario.setBackground(azulSecundario);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						JF_Añadir_Usuario frame_añadir_usuario = new JF_Añadir_Usuario(selfFrame);
						frame_añadir_usuario.setVisible(true);
					}
		
				});
		
		

		textField = new JTextField();
		contentPane.add(textField, "8, 3, 2, 1, fill, default");
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "2, 4, 6, 2, fill, fill");

		table = new JTable();
		table.setBackground(azulPrincipal);

		ActualizarTabla();
		scrollPane.setViewportView(table);

	}

	public void ActualizarTabla() {
		int numUsers = 0;
		ResultSet consulta = null;
		// Pone los clientes, usuarios o vehiculos en la tabla (no admins)
		
			numUsers = login.conexion
					.consulta_Numero_Registros("SELECT Count(*) FROM derrap.usuario Where id_rol_usuario = 2");
			consulta = login.conexion.consulta("SELECT * FROM usuario Where id_rol_usuario = 2");
		Object[][] clientes = new Object[0][0];

		int row = 0; // Para que se inserte en cada fila
		try {
			clientes = new Object[numUsers][7];
			while (consulta.next()) {
				clientes[row][0] = consulta.getString("nombre_usuario");// nombre con apellidos
				clientes[row][1] = consulta.getString("dni_usuario");
				clientes[row][2] = consulta.getString("correo_electronico_usuario");
				clientes[row][3] = consulta.getString("telefono_usuario");
				clientes[row][4] = consulta.getString("especialidad_usuario");
				clientes[row][5] = consulta.getString("estado_alta_usuario");

				row++;
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		table.setModel(new DefaultTableModel(clientes,
				new String[] { "Nombre", "DNI", "Correo", "Telefono", "Especialidad", "Estado", "Editar" }));

		table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
		table.getColumn("Editar").setCellEditor(new ButtonEditor(table));

	}
	// Clase para renderizar el botón

	public static class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, // ni
																																// esto
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
			
			value = table.getValueAt(selectedRow, 0);	
			
			JF_Añadir_Usuario frame_añadir_usuario = new JF_Añadir_Usuario(selfFrame, value.toString());
			frame_añadir_usuario.setVisible(true);
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
