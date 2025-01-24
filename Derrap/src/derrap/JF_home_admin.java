package derrap;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class JF_home_admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JF_home_admin frame = new JF_home_admin();

					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getLocalizedMessage());
				}
			}
		});
	}

	public JF_home_admin() {
		System.out.println(this + "  Construct");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 72, 138, 14);
		contentPane.add(lblNewLabel);

		JButton Btn_AdministrarClientes = new JButton("Administrar usuarios");
		Btn_AdministrarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JF_Cliente_Admin frame_clientes = new JF_Cliente_Admin();
				frame_clientes.setVisible(true);
				dispose();
			}
		});
		Btn_AdministrarClientes.setBounds(10, 11, 212, 23);
		contentPane.add(Btn_AdministrarClientes);

		JButton Btn_AdministrarVehiculos = new JButton("Administrar Vehiculos");
		Btn_AdministrarVehiculos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JF_Vehiculo_Admin frame_vehiculos = new JF_Vehiculo_Admin();
				frame_vehiculos.setVisible(true);
				dispose();
			}
		});
		Btn_AdministrarVehiculos.setBounds(232, 11, 212, 23);
		contentPane.add(Btn_AdministrarVehiculos);
	}
}
