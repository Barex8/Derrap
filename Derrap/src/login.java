import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_login_user;
	private JTextField tf_login_password;
	ConectorDB_mysql conexion = new ConectorDB_mysql();
	static login frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_login_user = new JTextField();
		tf_login_user.setBounds(199, 66, 86, 20);
		contentPane.add(tf_login_user);
		tf_login_user.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(199, 41, 73, 14);
		contentPane.add(lblNewLabel);
		
		tf_login_password = new JTextField();
		tf_login_password.setBounds(199, 116, 86, 20);
		contentPane.add(tf_login_password);
		tf_login_password.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(199, 91, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btn_login_entrar = new JButton("Entrar");
		btn_login_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rol1 = conexion.InicioSesion(tf_login_user.getText(), tf_login_password.getText());
				int rol = Integer.parseInt(rol1);
				switch(rol) {
					//abre ventana admin
					case 1:
						System.out.println("Ventana admin");
						JF_home_admin frame_admin = new JF_home_admin();
						frame_admin.setVisible(true);
					break;
					//abre ventana mecanico
					case 2:
						System.out.println("Ventana mecanico Lo ha modificado Ale");
						frame.dispose();
						JF_home_mecanico frame_mecanico = new JF_home_mecanico();
						frame_mecanico.setVisible(true);
					break;
				}
			}
		});
		btn_login_entrar.setBounds(392, 274, 86, 23);
		contentPane.add(btn_login_entrar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 274, 93, 23);
		contentPane.add(btnNewButton);
	}
}
