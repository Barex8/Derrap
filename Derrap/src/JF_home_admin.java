import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JF_home_admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		System.out.println(this +"  Construct");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 72, 138, 14);
		contentPane.add(lblNewLabel);
		
		JButton Btn_AdministrarUsuarios = new JButton("Administrar usuarios");
		Btn_AdministrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Clientes_Admin frame_clientes = new Clientes_Admin();
				frame_clientes.setVisible(true);
				System.out.println(this+"  Action");
				dispose();
			}
		});
		Btn_AdministrarUsuarios.setBounds(10, 11, 212, 23);
		contentPane.add(Btn_AdministrarUsuarios);
	}
}
