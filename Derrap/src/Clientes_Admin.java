import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Clientes_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	
	private static Clientes_Admin frame;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		
		JButton Btn_AñadirCliente = new JButton("AñadirCliente");		//Boton de añadir clientes
		Btn_AñadirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(Btn_AñadirCliente, "2, 3");
		
		
		JComboBox CB_TipoUsuario = new JComboBox();
		CB_TipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Proveedor", "Mecanico"}));
		contentPane.add(CB_TipoUsuario, "5, 3, 2, 1, fill, default");
		
		textField = new JTextField();
		contentPane.add(textField, "8, 3, 2, 1, fill, default");
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "2, 4, 6, 2, fill, fill");
		
		table = new JTable();
		int numClientes = 10;
		
		Object[][] clientes = new Object[numClientes][5];
		ResultSet consulta = login.conexion.consulta("*","cliente","");
		int row = 0; //Para que se inserte en cada fila
		try {
			while(consulta.next()) {
				clientes[row][0]= consulta.getString("nombre_cliente")+" "+consulta.getString("primer_apellido_cliente")+" "+consulta.getString("segundo_apellido_cliente");//nombre con apellidos
				clientes[row][1] = consulta.getString("dni_cliente");
				clientes[row][2] = consulta.getString("correo_electronico_cliente");
				clientes[row][3] = consulta.getString("telefono_cliente");
				//clientes[row][4] = Añadir boton para editar;
				row++;					
			}
		}catch(Exception e) {  System.out.println(e.getLocalizedMessage());}
		
	
	
		table.setModel(new DefaultTableModel(
			clientes, //Al pasarle clientes automáticamente guarda los datos en la tabla
			new String[] {
				"Nombre", "DNI", "Correo", "Telefono", "Editar"
			}
		));
		scrollPane.setViewportView(table);
	}	

}
