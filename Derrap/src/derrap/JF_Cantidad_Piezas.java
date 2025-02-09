package derrap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JF_Cantidad_Piezas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JF_Cantidad_Piezas(String ID, String OEM) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 161);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Introduzca la cantidad");
		lbl1.setBounds(10, 11, 193, 14);
		contentPane.add(lbl1);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad = login.conexion.consulta_Numero_Registros("SELECT count(*) FROM derrap.orden_pieza;")+1;
				login.conexion.DML("INSERT INTO `derrap`.`orden_pieza` (`id_orden_pieza`, `cantidad_orden_pieza`, `id_orden_trabajo_orden_pieza`, `oem_pieza_stock_orden_pieza`) VALUES ('"+cantidad+"', '"+textField.getText()+"', '"+ID+"', '"+OEM+"');");
				int nueva_cantidad = Integer.parseInt(login.conexion.consultaCampo("cantidad_pieza_stock", "stock", "Where oem_pieza_stock = "+OEM))-Integer.parseInt(textField.getText());
				login.conexion.DML("UPDATE `derrap`.`stock` SET `cantidad_pieza_stock` = '"+nueva_cantidad+"' WHERE (`oem_pieza_stock` = '"+OEM+"');");
				dispose();
			}
		});
		btnNewButton.setBounds(241, 88, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(142, 88, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
